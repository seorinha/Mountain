package com.project.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class TestBO {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	public void test() {
		logger.trace("로그를 출력한다.");
        logger.debug("로그를 출력한다.");
        logger.info("로그를 출력한다.");
        logger.warn("로그를 출력한다.");
        logger.error("로그를 출력한다.");
    }
	
}
