package com.wisedu.crowd.common.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RockMqLogger {

	  private static  Logger DEBUG_LOGGER = null;        
	  private static  Logger INFO_LOGGER = null;  
	  private static  Logger ERROR_LOGGER = null;
	  
	  static {  
	        loadLogger();  
	    }  
	  
	  static void loadLogger() {  
		  DEBUG_LOGGER = LoggerFactory.getLogger("RockMqLogger_DEBUG");
		  INFO_LOGGER = LoggerFactory.getLogger("RockMqLogger_INFO");  
		  ERROR_LOGGER = LoggerFactory.getLogger("RockMqLogger_ERROR");  
	    }  
	  /** 
	    * @param msg: error级别的错误信息 
	 */  
	   public static void error(String msg) {  
		   ERROR_LOGGER.error(msg);  
	   }  
	  
	   /** 
	    * @param e: error级别的异常信息 
	 */  
	   public static void error(Exception e) {  
		   ERROR_LOGGER.error(getExceptionTrace(e));  
	   }  
	  
	   /** 
	    * @param e: error级别的异常信息 
	    * @param msg: error级别的错误信息 
	 */  
	   public static void error(Exception e, String msg) {  
		   ERROR_LOGGER.error(msg + "\n" + getExceptionTrace(e));  
	   }  
	  
	/** 
	    * @param msg: debug级别的错误信息 
	 */  
	   public static void debug(String msg) {  
		   DEBUG_LOGGER.debug(msg);  
	   }  
	  
	   /** 
	    * @param e: debug级别的异常信息 
	 */  
	   public static void debug(Exception e) {  
		   DEBUG_LOGGER.debug(getExceptionTrace(e));  
	   }  
	  
	   /** 
	    * @param e: debug级别的异常信息 
	    * @param msg: debug级别的错误信息 
	 */  
	   public static void debug(Exception e, String msg) {  
		   DEBUG_LOGGER.debug(msg + "\n" + getExceptionTrace(e));  
	   }  
	  
	   /** 
	    * @param msg: info级别的错误信息 
	 */  
	   public static void info(String msg) {  
		   INFO_LOGGER.info(msg);  
	   }  
	  
	/** 
	    * @param e: info级别的异常信息 
	 */  
	   public static void info(Exception e) {  
		   INFO_LOGGER.info(getExceptionTrace(e));  
	   }  
	  
	   /** 
	    * @param e: debug级别的异常信息 
	    * @param msg: debug级别的错误信息 
	 */  
	   public static void info(Exception e, Object msg) {  
		   INFO_LOGGER.info(msg + "\n" + getExceptionTrace(e));  
	   }  
	  
	   /** 
	    * @param e: 异常信息输出 
	 */  
	   public static void exOut(Exception e) {  
	       String print = getExceptionTrace(e);  
	       DEBUG_LOGGER.error(print);  
	   }  
	  
	   /** 
	    * @param e: debug级别的异常信息 
	    * @param msg: debug级别的错误信息 
	 */  
	   private static String getExceptionTrace(Exception e) {  
	       String print = null;  
	       ByteArrayOutputStream bout = new ByteArrayOutputStream();  
	       PrintWriter wrt = new PrintWriter(bout);  
	       e.printStackTrace(wrt);  
	       wrt.close();  
	       print = bout.toString();  
	       return print;  
	   }
}
