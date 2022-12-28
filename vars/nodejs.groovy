def call() {
    node {
        try {
            common.checkout()
            common.CodeQuality()
            common.release()
        } catch (e) {
        }

    }
}