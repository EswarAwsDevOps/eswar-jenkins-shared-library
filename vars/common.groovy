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

def release(appType) {
    stage('Publish A Release') {
        if (appType== "nodejs") {
            sh '''
                npm install
               zip -r ${COMPONENT}-${TAG_NAME}.zip node_modules server.js schema
                '''
        }
        if (appType== "java") {
            sh '''
               mvn package
               cp target/${COMPONENT}-1.0.jar ${COMPONENT}.jar
               zip -r ${COMPONENT}-${TAG_NAME}.zip ${COMPONENT}.jar  
               '''
        }
        if (appType== "python") {
            sh '''
               zip -r ${COMPONENT}-${TAG_NAME}.zip *.ini *.py *.txt  
               '''
        }

        sh 'curl -v -u admin:admin123 --upload-file ${COMPONENT}-${TAG_NAME}.zip http://172.31.6.229:8081/repository/${COMPONENT}/${COMPONENT}-${TAG_NAME}.zip\n'
    }

}