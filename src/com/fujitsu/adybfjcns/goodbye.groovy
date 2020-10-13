package com.fujitsu.adyfjcns;

def goodbye(String message) {
    sh '''
        echo "Goodbye ${message}"'
    '''
}