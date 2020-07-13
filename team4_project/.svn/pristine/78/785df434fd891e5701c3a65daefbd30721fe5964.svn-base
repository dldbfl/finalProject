package com.dlms.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Slatter {

	
	public static List<String> imgSlatter(String text) {
		 List<String>tagList = new ArrayList<String>();
	      Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
	      Matcher matcher = pattern.matcher(text);
	        while(matcher.find()){
	            tagList.add(matcher.group(1));
	        
	        }
	       
	     return tagList;
	
	}
	
	public static String conSlatter(String text) {
		  List<String>tagList = new ArrayList<String>(); 
	      Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");//내용만 자르기
	      Matcher matcher = pattern.matcher(text);
	        
	      while(matcher.find()){
	    	  
	    	  tagList.add(matcher.group(0));
	        }      
	      
	       for(int i =0; i<tagList.size(); i++) {
	    	   String a = tagList.get(i);
	    	   text = text.replace(a, "");
	    	   
	       }
	     return text;
	
	}
}
