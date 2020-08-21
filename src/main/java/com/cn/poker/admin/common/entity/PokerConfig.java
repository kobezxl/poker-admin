package com.cn.poker.admin.common.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
    @Component
    @ConfigurationProperties(prefix="poker")
    public class PokerConfig {
        private String start;

        private int daycount;

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public int getDaycount() {
            return daycount;
        }

        public void setDaycount(int daycount) {
            this.daycount = daycount;
        }
    }

