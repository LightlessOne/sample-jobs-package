package com.lightlessone.jenkins.samplejobs.utils

class DateUtils {

    private static final def DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS"
    private static final def DATE_TIME_TIMEZONE = "UTC"

    static String getDateTime() {
        return new Date().format(DATE_TIME_FORMAT, TimeZone.getTimeZone(DATE_TIME_TIMEZONE))
    }
}
