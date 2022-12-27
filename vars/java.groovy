def call() {
   java {

    stage('Checkout Code') {
        git branch: 'main', url: "${env.REPO_URL}"
    }

            stage('Code Quality') {
                echo 'Code Quality'
                    }

            stage('Test Cases') {
                echo 'Test Cases'
                }

            stage('Publish A Release') {
                echo 'Publish A Release'
            }

        }

    }

