//vars//buildAndDeploy.groovy

def call(){
    stages {
        stage("build"){
            steps {
                echo "Building"
            }
        }
        stage("deploy"){
            steps {
                echo "Deploying"
            }
        }
    }
}