/**
 * 
 */
package org.spring.springboot.base.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**ApplicationContextSpring.java
 * @author zjx
 * bean获取
 * 2017年8月23日
 */
@Component
public class ApplicationContextSpring implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	
	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		if(applicationContext == null){
			this.applicationContext = ctx;
		}
		
	}
	
	public static void setAppctx(ApplicationContext ctx){
		if(applicationContext == null){
			applicationContext = ctx;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanId){
		T obj = null;
		if(applicationContext != null){
			obj = (T)applicationContext.getBean(beanId);
		}
		
		return obj;
	}
	
	public static <T> T getBean (Class<T> clazz) {
		T obj = null;
		
		if(applicationContext != null){
			obj = applicationContext.getBean(clazz);
		}
		
		return obj;
	}
	
	public static <T> T getBean (String beanName, Class<T> clazz) {
		T obj = null;
		
		if(applicationContext != null){
			obj = applicationContext.getBean(beanName, clazz);
		}
		
		return obj;
	}

}
