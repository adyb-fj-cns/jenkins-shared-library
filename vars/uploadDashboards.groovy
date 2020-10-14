//vars//uploadDashboards.groovy

def call(body){
    def config = [:];
    body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
    body()

    stage('upload'){
        container('grafonnet') {
            withCredentials([usernamePassword(
            credentialsId: "${config.credentialsId}", 
            usernameVariable: 'GRAFANA_USERNAME', 
            passwordVariable: 'GRAFANA_PASSWORD')]) {

            sh "echo ${config.grafanaUrl} > grafanaUrl"
            sh "echo ${config.sourceDir} > /sourceDir"

            sh "echo $(cat /grafanaUrl)"

            sh '''
                SCRIPT_PATH="$(cat /sourceDir)"; \
                GRAFANA_URL="$(cat /grafanaUrl)"; \
                for file in $SCRIPT_PATH/*.json; \
                do \
                DASHBOARD=$(jq . $file); \
                curl -X POST \
                    -H 'Content-Type: application/json' \
                    -d "{\\\"dashboard\\\": $DASHBOARD, \\\"overwrite\\\": true}" \
                    "http://$GRAFANA_USERNAME:$GRAFANA_PASSWORD@$GRAFANA_URL/api/dashboards/db";
                done
                '''
                
            }
        }
    }
}