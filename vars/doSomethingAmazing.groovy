//vars//doSomethingAmazing.groovy

def call(body){
    def config = [:];
    body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
    body()

    stage("${config.name}"){
        sh "echo ${config.message}"
    }
}