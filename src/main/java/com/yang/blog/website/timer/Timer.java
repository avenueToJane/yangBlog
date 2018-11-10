package com.yang.blog.website.timer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>
 * Title: Timer
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: xxx
 * </p>
 * 
 * @author Mr.yang
 * @date 2018年11月3日 下午3:03:57
 */
@Component
@Configurable
@EnableScheduling
public class Timer {
	private static final Logger logger = Logger.getLogger(Timer.class);

	// 每五分钟执行一次
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void reportCurrentByCron() {
		logger.info("定时器开始执行begin");

		logger.info("定时器开始执行end");
	}

}
