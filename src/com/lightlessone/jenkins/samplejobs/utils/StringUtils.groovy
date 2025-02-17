package com.lightlessone.jenkins.samplejobs.utils

import com.cloudbees.groovy.cps.NonCPS

class StringUtils {

    static def encodeURL(url) {
        return URLEncoder.encode(url, "UTF-8")
    }

    @NonCPS
    static boolean isNullOrEmpty(value) {
        return value == null || value.isEmpty()
    }

    static boolean toBoolean(value) {
        return value != null && (value == "true" || value == "True")
    }

    static boolean isAnyParamMissing(String... values) {
        for (v in values) {
            if (isNullOrEmpty(v)) {
                return true
            }
        }
        return false
    }

    static boolean containsAny(String str, String... searchStrs) {
        for (searchStr in searchStrs) {
            if (str.contains(searchStr)) {
                return true
            }
        }
        return false
    }
}
