def call() {
    node {
        common.checkout()
        common.CodeQuality()
        common.testCases("python")
        if (env.TAG_NAME ==~ ".*") {
        common.release()
        }
    }
}