//vars//uploadDashboards.groovy

def call(body){
    def config = [:];
    body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
    body()

    stage('upload'){
        container('grafonnet') {
            withCredentials([usernamePassword(
            credentialsId: 'grafana', 
            usernameVariable: 'GRAFANA_USERNAME', 
            passwordVariable: 'GRAFANA_PASSWORD')]) {

            sh '''
                SCRIPT_PATH="dashboards-jsonnet"; \
                for file in $SCRIPT_PATH/*.json; \
                do \
                DASHBOARD=$(jq . $file); \
                curl -X POST \
                    -H 'Content-Type: application/json' \
                    -d "{\\\"dashboard\\\": $DASHBOARD, \\\"overwrite\\\": true}" \
                    "http://$GRAFANA_USERNAME:$GRAFANA_PASSWORD@grafana-ui:3000/api/dashboards/db";
                done
                '''
                
            }
        }
    }
}