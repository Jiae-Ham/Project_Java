package com.jsp.servlet.front;

public class StrMainpulation {

	public static void main(String[] args) {
		
		
		String uri = "/MyWeb/write.board";
		String conPath = "/MyWeb";
		String pattern = ".board";
		
		String result = uri.substring(conPath.length()+1, uri.length() - pattern.length());
		String result2 = uri.substring(conPath.length()+1, uri.lastIndexOf("."));
		//System.out.println(result);
		//System.out.println(result2);

	}

}
