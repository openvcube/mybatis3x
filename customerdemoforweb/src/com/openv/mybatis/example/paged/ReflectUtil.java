package com.openv.mybatis.example.paged;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReflectUtil {

	private static final Log log = LogFactory.getLog(ReflectUtil.class);

	private static Object operate(Object obj, String fieldName,
			Object fieldVal, String type) {
		Object ret = null;
		try {
			// 获得对象类型
			Class<? extends Object> classType = obj.getClass();
			// 获得对象的所有属性
			Field fields[] = classType.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if (field.getName().equals(fieldName)) {
					String firstLetter = toUpperCase(fieldName.substring(0, 1)); // 获得和属性对应的getXXX()方法的名字
					if ("set".equals(type)) {
						String setMethodName = "set" + firstLetter
								+ fieldName.substring(1); // 获得和属性对应的getXXX()方法
						Method setMethod = classType.getMethod(setMethodName,
								new Class[] { field.getType() }); // 调用原对象的getXXX()方法
						ret = setMethod.invoke(obj, new Object[] { fieldVal });
					}
					if ("get".equals(type)) {
						String getMethodName = "get" + firstLetter
								+ fieldName.substring(1); // 获得和属性对应的setXXX()方法的名字
						Method getMethod = classType.getMethod(getMethodName,
								new Class[] {});
						ret = getMethod.invoke(obj, new Object[] {});
					}
					return ret;
				}
			}
		} catch (Exception e) {
			log.warn("reflect error:" + fieldName, e);
		}
		return ret;
	}
	
	private static String toUpperCase(String str) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase();
	}

	/**
	 * 获取val。
	 * 
	 * @param obj
	 *            Object
	 * @param fieldName
	 *            String
	 * 
	 * @return Object
	 */
	public static Object getVal(Object obj, String fieldName) {
		return operate(obj, fieldName, null, "get");
	}

	/**
	 * 设置val。
	 * 
	 * @param obj
	 *            Object
	 * @param fieldName
	 *            String
	 * @param fieldVal
	 *            Object
	 */
	public static void setVal(Object obj, String fieldName, Object fieldVal) {
		operate(obj, fieldName, fieldVal, "set");
	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredMethod。
	 * 
	 * @param object
	 *            Object
	 * @param methodName
	 *            String
	 * @param parameterTypes
	 *            Class<?>[]
	 * 
	 * @return Method
	 */
	private static Method getDeclaredMethod(Object object, String methodName,
			Class<?>[] parameterTypes) {
		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				// superClass.getMethod(methodName, parameterTypes);
				return superClass.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException e) {
				// Method 不在当前类定义, 继续向上转型
				log.warn("", e);
			}
		}

		return null;
	}

	/**
	 * 使 filed 变为可访问。
	 * 
	 * @param field
	 *            Field
	 */
	private static void makeAccessible(Field field) {
		if (!Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
		}
	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredField。
	 * 
	 * @param object
	 *            Object
	 * @param filedName
	 *            String
	 * @return Field
	 */
	private static Field getDeclaredField(Object object, String filedName) {
		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(filedName);
			} catch (NoSuchFieldException e) {
				// Field 不在当前类定义, 继续向上转型
				// log.warn("", e);
			}
		}
		return null;
	}

	/**
	 * 直接调用对象方法, 而忽略修饰符(private, protected)。
	 * 
	 * @param object
	 *            Object
	 * @param methodName
	 *            String
	 * @param parameterTypes
	 *            Class<?>[]
	 * @param parameters
	 *            Object[]
	 * 
	 * @return Object
	 * 
	 * @throws InvocationTargetException
	 *             InvocationTargetException异常
	 */
	public static Object invokeMethod(Object object, String methodName,
			Class<?>[] parameterTypes, Object[] parameters)
			throws InvocationTargetException {
		Method method = getDeclaredMethod(object, methodName, parameterTypes);

		if (method == null) {
			throw new IllegalArgumentException("Could not find method ["
					+ methodName + "] on target [" + object + "]");
		}

		method.setAccessible(true);

		try {
			return method.invoke(object, parameters);
		} catch (IllegalAccessException e) {
			log.warn("", e);
		}

		return null;
	}

	/**
	 * 直接设置对象属性值, 忽略 private/protected 修饰符, 也不经过 setter。
	 * 
	 * @param object
	 *            Object
	 * @param fieldName
	 *            String
	 * @param value
	 *            Object
	 */
	public static void setFieldValue(Object object, String fieldName,
			Object value) {
		Field field = getDeclaredField(object, fieldName);

		if (field == null) {
			throw new IllegalArgumentException("Could not find field ["
					+ fieldName + "] on target [" + object + "]");
		}

		makeAccessible(field);

		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			log.error("", e);
		}
	}

	/**
	 * 直接读取对象的属性值, 忽略 private/protected 修饰符, 也不经过 getter。
	 * 
	 * @param object
	 *            Object
	 * @param fieldName
	 *            String
	 * @return Object
	 */
	public static Object getFieldValue(Object object, String fieldName) {
		Field field = getDeclaredField(object, fieldName);
		if (field == null) {
			throw new IllegalArgumentException("Could not find field ["
					+ fieldName + "] on target [" + object + "]");
		}

		makeAccessible(field);

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			log.error("", e);
		}

		return result;
	}

}