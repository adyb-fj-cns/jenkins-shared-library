//vars//buildAndDeploy.groovy

def call(body){
    def config = [:];
    body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
    body()

    stage("build"){
        echo "Building"
    }
    stage("deploy"){
        echo "Deploying"
    }
}