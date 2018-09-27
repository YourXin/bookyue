package com.bookyue.util;

import java.util.UUID;

public class UUIDUtil {
	public static String getUUIDStr() {
		String str = UUID.randomUUID().toString();
		return str.replace("-", "");
	}
}
