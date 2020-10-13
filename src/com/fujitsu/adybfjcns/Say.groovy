// src/com/fujitsu/adybfjcns/Say.groovy

package com.fujitsu.adybfjcns;

class Say {
    def say(String message = 'World') {
        return "Saying ${message}"
    }

    def whisper(String message = 'World') {
        return "Whispering ${message}"
    }
}