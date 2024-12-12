package com.pinsystem.utils;

import org.apache.logging.log4j.core.config.Configurator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log4jConfig {
    public static void configureLogger() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String logFileName = "logs/log-" + timestamp + ".log";
        System.setProperty("filename", logFileName);

        // Reload the configuration to apply the file name
        Configurator.reconfigure();
    }
}
