package br.com.ifg.ifeventos.utils;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class WriteLog {
	
	private static Logger log;
	//private static String file = "/opt/tomcat/logs/ifeventos.log";
	private static String file = "W:\\ifeventos.log";

	public static void log(String clazz, String msg, Throwable thrown){
		try{			
			FileHandler fileHandler = new FileHandler(file);
			fileHandler.setFormatter(new SimpleFormatter());
			log = Logger.getLogger(clazz);
			log.setLevel(Level.SEVERE);
			log.addHandler(fileHandler);
			log.log(Level.SEVERE, msg, thrown);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
