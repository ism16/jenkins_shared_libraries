package org.mycheckout;


def mycheckout(Map config=[:]) {
    if (config.credentialsId) {
        git branch: config.branch, 
            credentialsId: config.credentials, 
            url: config.repo
    } else {
        git branch: config.branch, 
            url: config.repo  
    }
}
