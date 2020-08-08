package com.cn.poker.admin.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @date 2017/7/10
 */
@Configuration
@ConfigurationProperties(prefix = "sftp.config")
public class SFTPConfiguration {

	Logger logger = LoggerFactory.getLogger(SFTPConfiguration.class);

	private String server;
	private int port = 22;
	private String user;
	private String password;

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
