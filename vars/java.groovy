def call() {
    node {
        common.checkout()
        common.compile()
        common.CodeQuality()
        common.release()
    }

}