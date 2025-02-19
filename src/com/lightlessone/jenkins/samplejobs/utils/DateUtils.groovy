package com.lightlessone.jenkins.samplejobs.utils

import com.cloudbees.groovy.cps.NonCPS

class DateUtils {

    private static final def DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS"
    private static final def DATE_TIME_TIMEZONE = "UTC"

    @NonCPS
    static String getDateTime() {
        return new Date().format(DATE_TIME_FORMAT, TimeZone.getTimeZone(DATE_TIME_TIMEZONE))
    }
}
