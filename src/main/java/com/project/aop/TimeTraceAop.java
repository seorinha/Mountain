package com.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect //부가기능을 정의(advice) + 어디에 적용(pointcut)할 것인지 
@Component
public class TimeTraceAop { //singleton

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Around("execution(* com.project..*(..))") //1. 패키지 범위를 어디에 적용시킬것인가?(pointcut)
	@Around("@annotation(TimeTrace)") //어느 어노테이션이 붙어있을 때 사용할것인가?
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟이 적용하는 메소드 - joinPoint (어느 메소드에 꺼넣을 것인가?)
		
		//시간 측정
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object proceedObj = joinPoint.proceed(); //원래 할일 수행(회원가입)
		
		stopWatch.stop();
		logger.info("### 실행 시간(ms): " + stopWatch.getTotalTimeMillis());
		logger.info(stopWatch.prettyPrint());
		
		return proceedObj;
	}
	
}
