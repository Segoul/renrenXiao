package com.renren.renrenXiao.common.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 复制对象属性工具类
 * @author Segoul
 *
 */

public class CopyPropertiesUtil {

	/** 
	  * 复制对象属性 
	  * @param from 
	  * @param to 
	  * @param excludsArray 排除属性列表 
	  * @throws Exception 
	  */  
	 public static void copyPropertiesExclude(Object from, Object to, String[] excludsArray) throws Exception {  
        
		List<String> excludesList = null;  
        if(excludsArray != null && excludsArray.length > 0) {  
        	//构造列表对象  
            excludesList = Arrays.asList(excludsArray); 
        }  
        Method[] fromMethods = from.getClass().getDeclaredMethods();  
        Method[] toMethods = to.getClass().getDeclaredMethods();  
        Method fromMethod = null, toMethod = null;  
        String fromMethodName = null, toMethodName = null;  
        for (int i = 0; i < fromMethods.length; i++) {  
            fromMethod = fromMethods[i];  
            fromMethodName = fromMethod.getName();  
            if (!fromMethodName.contains("get")){
            	continue;  
            }     
            //排除列表检测  
            if(excludesList != null && excludesList.contains(fromMethodName.substring(3).toLowerCase())) {  
                continue;  
            }  
            toMethodName = "set" + fromMethodName.substring(3);  
            toMethod = findMethodByName(toMethods, toMethodName);  
            if (toMethod == null){
            	continue;  
            }       
            Object value = fromMethod.invoke(from, new Object[0]);  
            if(value == null){
            	continue; 
            }          
            //集合类判空处理  
            if(value instanceof Collection) {  
                Collection newValue = (Collection)value;  
                if(newValue.size() <= 0){
                	continue; 
                }     
            }  
            toMethod.invoke(to, new Object[] {value});  
        }  
    }  

	/** 
	 * 从方法数组中获取指定名称的方法 
     *  
     * @param methods 
     * @param name 
     * @return 
     */  
    public static Method findMethodByName(Method[] methods, String name) {  
        for (int j = 0; j < methods.length; j++) {  
            if (methods[j].getName().equals(name))  
                return methods[j];  
        }  
        return null;  
    }  
}
