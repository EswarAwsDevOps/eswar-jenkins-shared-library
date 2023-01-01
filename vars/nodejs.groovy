def call() {
    node {
            common.checkout()
            common.CodeQuality()
            common.testCases("nodejs")
            if (env.TAG_NAME ==~ ".*") {

                common.release()
            }

        }
    }