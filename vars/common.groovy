def checkout(){
    stage('Checkout Code'){
        cleanWs()
        git branch: 'main', url: "${env.REPO_URL}"
    }
}
def compile(appType){

    stage('compile code'){
        if(appType == "java"){
            sh 'mvn clean compile'
        }
 if(appType == "golang"){
     sh 'go mod init'
 }
    }
}

def Code Quality(){
    stage('Code Quality'){
        echo 'Code Quality'
    }
}
def Release(){
    stage('Publish A Release'){
        echo 'Publish A Release'
    }

}