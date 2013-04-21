package com.att.phutungoto.tools;

public class Util {

	public static String convertToLowCase(String text) {
		if (text != null && text != "") {
			return text.replaceAll("\\s+", " ").toLowerCase();
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println(convertToLowCase(""));
	}
}
