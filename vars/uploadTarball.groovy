//vars//uploadTarball.groovy

def call(body){
    def config = [:];
    body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
    body()

    stage("${config.stageName}"){
        container("${config.containerName}") {
            sh "echo ${config.sourceDir} > /sourceDir"
            sh '''
                SCRIPT_PATH="$(cat /sourceDir)"; \
                echo "Creating tarball"; \
                tar -czvf dashboards.tar.gz $SCRIPT_PATH/
            '''

            sh '''
                set +x; \
                echo "Pushing tarball to staging"; \
                tar -ztvf dashboards.tar.gz
            '''
        }
    }
}