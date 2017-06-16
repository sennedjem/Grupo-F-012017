package aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggerAspect {

	final static Logger logger = Logger.getLogger(LoggerAspect.class);

	@Pointcut("execution(* servicesRest.*.*(..))")
	public void inProductClass() {}
	
	@Before("inProductClass()")
	     public void logMethodCall(JoinPoint jp){
			logger.info("Method intercepted in " + jp.getTarget().getClass().getName());
			logger.info("Starting logging...");
			logger.info("Entering in Method :  " + jp.getSignature().getName());
			logger.info("With arguments: " + jp.getArgs());
			logger.info("Ending logging...");
	     }	
	
}
