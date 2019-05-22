package com.sample.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {

	private static final Logger logger = LoggerFactory.getLogger(LoggingUtil.class);

	public static void logHeadersInfo(HttpServletRequest request) {

		Enumeration<String> headerNames = request.getHeaderNames();
        
		while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            logger.info("header [{} : {}]", key, value);
        }
    }
}
