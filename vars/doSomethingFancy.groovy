//vars//doSomethingFancy.groovy

def call(Map config){
    node {
        sh "name: ${config.name}"
        sh "ref: ${config.ref}"
    }
}