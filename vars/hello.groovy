//vars//hello.groovy

def call(String message = 'World'){
    echo "Hello ${message}"
}

def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}