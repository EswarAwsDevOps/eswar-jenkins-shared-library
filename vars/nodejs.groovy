def call() {
    node {
        common.checkout()
        common.CodeQuality()
        common.testCases("nodejs")
        common.release()
    }

}