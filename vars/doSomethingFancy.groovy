//vars//doSomethingFancy.groovy

def call(Map config){
    node {
        sh "echo ${config.name}"
        sh "echo ${config.ref}"
    }
}