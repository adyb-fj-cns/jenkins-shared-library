package com.fujitsu.adyfjcns;

def say(String message) {
    sh '''
        echo "Saying ${message}"'
    '''
}