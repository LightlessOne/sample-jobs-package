import com.lightlessone.jenkins.samplejobs.Context

def getContext(job) {
    def ctx = new Context(job)
    ctx.data += [jobName: job.env.JOB_NAME, test_var: "qwe"]
    return ctx
}