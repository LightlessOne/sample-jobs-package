package com.lightlessone.jenkins.samplejobs

class Context {

    def job
    def data

    Context(job) {
        this.job = job
        this.data = [:]
    }

    def getData() {
        return data
    }
}