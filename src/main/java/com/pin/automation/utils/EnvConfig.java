package com.pin.automation.utils;

public class EnvConfig {
	private static String environment;

	public static void setEnvironment(String env) {
		if (env != null && !env.trim().isEmpty()) {
			environment = env;
		}
	}

	public static String getEnvironment() {
		return environment;
	}

}