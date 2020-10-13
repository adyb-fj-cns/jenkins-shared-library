//vars//buildAndDeploy.groovy

def call(body){
    def config = [:];
    body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
    body()

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