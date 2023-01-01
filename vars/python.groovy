def call() {
    node {
        common.checkout()
        common.CodeQuality()
        common.testCases("python")
        common.release()
        }
}