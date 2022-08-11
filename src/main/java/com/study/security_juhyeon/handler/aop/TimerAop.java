package com.study.security_juhyeon.handler.aop;

import java.lang.reflect.Parameter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
   
   private final Logger LOGGER =LoggerFactory.getLogger(getClass());
   
   //..*RestController.*(..)) <=하위의 모든 폴더중에 RestController에 모두 적용 만약 signup이라고 입력하면 signup에만 적용댐
   @Pointcut("execution(* com.study.security_juhyeon.web.controller..*.*(..))")
   private void pointCut() {}
   
   @Pointcut("@annotation(com.study.security_juhyeon.handler.aop.annotation.Timer)")
   private void enableTimer() {}
   
   @Around("pointCut()&&enableTimer()")
   public Object arount(ProceedingJoinPoint joinPoint) throws Throwable{
      StopWatch stopWatch = new StopWatch();
      stopWatch.start();
      
      Object result = joinPoint.proceed();
      
      
      for(Object arg: joinPoint.getArgs()) {
    	  LOGGER.info("arg:{}",arg);
      }
      
      stopWatch.stop();
      
      LOGGER.info(">>>> {}({}) 메소드 실행 시간: {}ms",
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(),
            result,
            stopWatch.getTotalTimeSeconds());
      
      return result;
   }
      
   
}