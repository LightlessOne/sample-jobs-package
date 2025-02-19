package com.lightlessone.jenkins.samplejobs

import com.lightlessone.jenkins.samplejobs.utils.DateUtils

class Context {

    def job
    def data

    Context(job) {
        this.job = job
        this.data = [createdAt: DateUtils.getDateTime()]
    }

    def getData() {
        return data
    }
}