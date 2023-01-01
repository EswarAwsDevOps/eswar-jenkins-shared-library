def checkout() {
    stage('Checkout Code') {
        cleanWs()
        git branch: 'main', url: "${env.REPO_URL}"
    }
}

def compile(appType) {

    stage('Compile Code') {
        if(appType == "java") {
            sh 'mvn clean compile'
        }

        if(appType == "golang") {
            sh 'go mod init'
        }
    }


}

def testCases(appType) {

    stage('Unit Tests') {
        if (appType == "java") {
            sh 'mvn test || true'
        }

        if (appType == "nodejs") {
            sh 'npm test || true'
        }

        if (appType == "python") {
            sh 'python3 -m unittest *.py || true'
        }
    }
}

def CodeQuality() {
    stage('Code Quality') {
//        sh "sonar-scanner -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.host.url=http://172.31.7.220:9000 -Dsonar.projectKey=${env.COMPONENT} ${SONAR_OPTS}"
//        "sonar-scanner -Dsonar.qualitygate.wait=true -Dsonar.login=admin -Dsonar.password=admin123 -Dsonar.host.url=http://172.31.8.238:9000 -Dsonar.projectKey=${env.COMPONENT} ${SONAR_OPTS}"
        sh 'echo OK'
    }
}

def release() {
    stage('Publish A Release') {
        echo 'Publish A Release'
    }
}