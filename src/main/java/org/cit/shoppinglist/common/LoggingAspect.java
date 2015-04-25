package org.cit.shoppinglist.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;

@Aspect
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass());
	
	/**
	 * The following example will execute before every method available in the
	 * classes under the package org.cit.shoppinglist.service
	 * 
	 * @param point
	 */
	// @Before("execution(* org.cit.shoppinglist.service.*.*(..))")
	@Before("execution(* org.cit.shoppinglist.service.UserService.*(..))")
	public void traceSave(JoinPoint point) {
		String name = point.getSignature().getName();
		logger.info("method " + name + " called of class " + point.getTarget());
	}

	@Before("serviceMethod()")
	public void monitorBusinessLogicLayer(){
		logger.info("A business method has been accessed.");
	}
	
	// The following example defines a pointcut named 'daoMethod' 
	// that will match the execution of every method available in the classes under the package
	// name contains dao
//	@Before("daoMethod()")
//	public void monitorDataAccessLayer(){
//		logger.info("A data access layer method has accessed.");
//	}
	
	@Before("presentationMethod()")
	public void monitorPresentationLayer(){
		logger.info("A controller method has been accessed.");
	}
	
	@Pointcut("execution(* *..service.*.*(..))")
	public void serviceMethod(){
	}
	
//	@Pointcut("execution(* *..dao.*.*(..))")
//	public void daoMethod(){
//	}
	
	@Pointcut("execution(* *..controller.*.*(..))")
	public void presentationMethod(){
	}
	
}
