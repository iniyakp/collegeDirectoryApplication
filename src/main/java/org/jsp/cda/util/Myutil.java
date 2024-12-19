package org.jsp.cda.util;

public class Myutil {
//	public static void main(String[] args) {
//		for(int i=0;i<=100;i++) {
//			System.out.println(getOtp());
//		}
//		
//	}
	
	public static int getOtp() {
		double otp = 0;
		while (otp < 1000) {
			double random = Math.random();
			otp = random * 10000;
		}
		return (int) otp;
		
	}
}
