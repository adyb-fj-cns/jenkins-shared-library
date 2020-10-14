//vars//convertDashboards.groovy

def call(body){
    def config = [:];
    body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
    body()

    stage('convert'){
        container('grafonnet') {
            sh "echo ${config.sourceDir} > /sourceDir"
            sh 'echo $(cat /sourceDir)'
            sh '''
                SCRIPT_PATH="dashboards-jsonnet"; \
                for file in $SCRIPT_PATH/*.jsonnet; \
                do \
                    input=$(basename -- $file); \
                    output=$SCRIPT_PATH/${input%.*}.json; \
                    echo "Converting $file into $output"; \
                    jsonnet $file > $output; \
                done
            '''
        }
    }
}



