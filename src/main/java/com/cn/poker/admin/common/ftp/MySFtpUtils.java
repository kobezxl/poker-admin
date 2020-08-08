

package com.cn.poker.admin.common.ftp;

import com.jcraft.jsch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



@Repository
public class MySFtpUtils {
	
	@Autowired
    private MySFTPConfiguration sftpConfiguration;

	public static final String NO_FILE = "No such file";

	private ChannelSftp sftp = null;
	private Session sshSession = null;
	
	/**
	 * 连接sftp服务器
	 * 
	 * @return ChannelSftp sftp类型
	 * @throws GoPayException
	 */
	public ChannelSftp connect() {
		JSch jsch = new JSch();
		try {
//			jsch.getSession(username, host, port);
//			sshSession = jsch.getSession(username, host, port);
//			sshSession.setPassword(password);
			
			jsch.getSession(sftpConfiguration.getUser(), sftpConfiguration.getServer(), sftpConfiguration.getPort());
			sshSession = jsch.getSession(sftpConfiguration.getUser(), sftpConfiguration.getServer(), sftpConfiguration.getPort());
			sshSession.setPassword(sftpConfiguration.getPassword());
			
			Properties properties = new Properties();
			properties.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(properties);
			sshSession.connect();
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
		} catch (JSchException e) {
			e.printStackTrace();
		}
		return sftp;
	}

	/**
	 * 上传单个文件
	 * 
	 * @param directory
	 *            ：远程下载目录(以路径符号结束)
	 * @param uploadFilePath
	 *            要上传的文件 如：D:\\test\\xxx.txt
	 * @param fileName
	 *            FTP服务器文件名称 如：xxx.txt ||xxx.txt.zip
	 * @throws SftpException 
	 * @throws GoPayException
	 */
	public boolean uploadFile(String basePath,String directory,String fileName,InputStream input) throws SftpException {
		boolean result = false;
		FileInputStream in = null;
		connect();
		try {     
			sftp.cd(basePath);
			sftp.cd(directory);
		} catch (SftpException e) {
			// 目录不存在，则创建文件夹
			String[] dirs = directory.split("/");
			String tempPath = basePath;
			for (String dir : dirs) {
				if (null == dir || "".equals(dir)) {
					continue;
				}
				tempPath += "/" + dir;
				try {
					sftp.cd(tempPath);
				} catch (SftpException ex) {
					sftp.mkdir(tempPath);
					sftp.cd(tempPath);
				}
			}
			sftp.put(input, fileName); // 上传文件
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			disconnect();
		}
		return result;  
	}
	
	/**
	 * 批量上传文件
	 * 
	 * @param directory
	 *            ：远程下载目录(以路径符号结束)
	 * @param uploadFilePath
	 *            要上传的文件 如：D:\\test\\xxx.txt
	 * @param fileName
	 *            FTP服务器文件名称 如：xxx.txt ||xxx.txt.zip
	 * @throws SftpException 
	 * @throws GoPayException
	 */
	public boolean bacthUploadFile(String basePath,String directory,String fileName,InputStream input) throws SftpException{
		try {
			File file = new File(basePath);
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile() && files[i].getName().indexOf("bak") == -1) {
					synchronized (basePath) {
						if (this.uploadFile(basePath, directory,files[i].getName(),input)) {
							deleteFile(directory + files[i].getName());
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.disconnect();
		}
		return false;  
	}
	
	/**
	 * 删除文件
	 * 
	 * @param filePath
	 * @return
	 */
	public boolean deleteFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			return false;
		}
		if (!file.isFile()) {
			return false;
		}
		return file.delete();
	}

	/**
	 * 关闭连接
	 */
	public void disconnect() {
		if (this.sftp != null) {
			if (this.sftp.isConnected()) {
				this.sftp.disconnect();
				this.sftp = null;
			}
		}
		if (this.sshSession != null) {
			if (this.sshSession.isConnected()) {
				this.sshSession.disconnect();
				this.sshSession = null;
			}
		}
	}

}
