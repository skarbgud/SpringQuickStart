package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
//	@Before("allPointcut()")
	@Before("PointcutCommon.getPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();	//JoinPoint의 getSignature() 메소드를 이용하여 클라이언트가 호출한 메소드 이름을 출력할 수 있다.
		Object[] args = jp.getArgs();	// getArgs() 메소드를 통해 인자 목록을 Object 배열로 얻을수 있다.
		
		System.out.println("[사전 처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
	}
}
