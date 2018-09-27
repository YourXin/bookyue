package com.bookyue.util;

import java.util.Random;

public class VertifyCodeUtil {

	private static final int[] codes = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static String getCode() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			Random r = new Random();
			sb.append(codes[r.nextInt(9)]);
		}
		return sb.toString();
	}

	public static boolean SendVertifyCode(String code) {

		// 调用发送验证码接口

		return true;
	}
}
