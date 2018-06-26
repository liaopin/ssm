package com.lp.ssm.commons.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lp.ssm.commons.LogManager;

public class LogTest {
	protected final Logger    logger = LoggerFactory.getLogger(getClass()); 
	
	@Test
	public void testLogback(){
		String sid = LogManager.getSid();
		logger.debug("获取sid:{}",sid);
		logger.info("隐射诊断上下文有参数测试日志打印");
		//LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory(); 
		//StatusPrinter.print(lc);
	}
}
