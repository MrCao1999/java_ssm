package com.java.spring.look.web.util;

import java.util.Objects;
import java.util.UUID;

public class CommonUtil {
	/**
	 * 
	 * @return
	 */
	public static String uuid(){
		return Objects.toString(UUID.randomUUID()).replace("-", "");
	}
}
