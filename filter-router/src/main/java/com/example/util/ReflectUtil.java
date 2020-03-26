package com.example.util;

import java.lang.reflect.Method;

/**
 * 根据方法名 参数类型 反射获取方法
 */
public class ReflectUtil {

	public static Method getMethod (Class<?> clazz,String methodName,Class<?> type) {
		Method method = null;
		try {
			method = clazz.getMethod(methodName, type);
		} catch (Exception e) {
			method = null;
		}
		
		return method;
	}
	
	public static Method getMethod (Class<?> clazz,String methodName,Class<?> []type) {
		Method method = null;
		try {
			method = clazz.getMethod(methodName, type);
		} catch (Exception e) {
			method = null;
		}
		
		return method;
	}
	
	public static Method getMethod (Class<?> clazz,String methodName) {
		Method method = null;
		try {
			method = clazz.getMethod(methodName);
		} catch (Exception e) {
			method = null;
		}
		
		return method;
	}
}
