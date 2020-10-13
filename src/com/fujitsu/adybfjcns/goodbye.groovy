package com.fujitsu.adyfjcns;

def goodbye(String message) {
    sh '''
        echo "Saying goodbye ${message}"'
    '''
}