def call() {
    if (!env.SONAR_OPTS) {
        env.SONAR_OPTS = ""
    }
    node {
        common.checkout()
        common.CodeQuality()
        common.testCases("python")
        common.release(python)
        }
}