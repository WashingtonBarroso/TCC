package br.com.ifg.ifeventos.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HashUtils {
	
	public static long hash(String str) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		str = dateFormat.format(date)+str;
		long h = 1125899906842597L; // primo
		int len = str.length();
		for (int i = 0; i < len; i++) {
			h = 31 * h + str.charAt(i);
		}
		return h;
	}
}