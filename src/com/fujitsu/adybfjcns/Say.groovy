package com.fujitsu.adybfjcns;

def say(String message) {
    sh '''
        echo "Saying ${message}"'
    '''
}