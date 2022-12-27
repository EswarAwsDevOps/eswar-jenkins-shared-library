def call() {
    node {
        common.checkout()
        common.CodeQuality()
        common.release()
    }

}