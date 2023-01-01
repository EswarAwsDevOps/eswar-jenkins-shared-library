def call() {
    if (!env.SONAR_OPTS) {
        env.SONAR_OPTS = ""
    }
    node {
        try {
            common.checkout()
            common.CodeQuality()
            common.testCases("nodejs")
            if (env.TAG_NAME ==~ ".*") {
                common.release("nodejs")
            }
        } catch (e) {

        }
    }

}