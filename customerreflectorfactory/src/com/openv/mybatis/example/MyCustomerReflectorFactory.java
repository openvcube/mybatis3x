/**
 * Copyright(c) http://www.open-v.com
 */
package com.openv.mybatis.example;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;

/**
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class MyCustomerReflectorFactory implements ReflectorFactory {
	private static final Log log = LogFactory.getLog(MyCustomerReflectorFactory.class);
	 private boolean classCacheEnabled = false;
	 private final ConcurrentMap<Class<?>, Reflector> cacheMap = new ConcurrentHashMap<Class<?>, Reflector>();

	@Override
	public boolean isClassCacheEnabled() {
		// 判断是否开始缓存
		return classCacheEnabled;
	}

	@Override
	public void setClassCacheEnabled(boolean classCacheEnabled) {
		// 设置缓存
		this.classCacheEnabled = classCacheEnabled;
	}

	@Override
	public Reflector findForClass(Class<?> type) {
	    if (classCacheEnabled) {//判断是否缓存起来
	      Reflector cached = cacheMap.get(type);
	      if (cached == null) {
	        cached = new Reflector(type);
	        cacheMap.put(type, cached);
	      }else{
	    	log.info("读取缓存对象!");
	      }
	      return cached;
	    } else {
	      return new Reflector(type);
	    }
	  
	}

}
