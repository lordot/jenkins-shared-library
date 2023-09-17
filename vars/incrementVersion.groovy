#! /usr/bin/env groovy

def call(String Path) {
    env.CURRENT_VERSION = sh(script: "cat ${Path}/Dockerfile | grep \"LABEL version\" | cut -d \"=\" -f2", returnStdout: true).trim()
    echo "Old version from Dockerfile: ${env.CURRENT_VERSION}"

    def changeType = 'patch'
    if (BRANCH_NAME == 'main') {
        changeType = 'minor'
    } else {
        changeType = 'patch'
    }

    if (changeType == 'minor') {
        def versionParts = env.CURRENT_VERSION.tokenize('.')
        def newMinorVersion = versionParts[1].toInteger() + 1
        env.CURRENT_VERSION = "${versionParts[0]}.${newMinorVersion}.${versionParts[2]}"
    } else if (changeType == 'patch') {
        def versionParts = env.CURRENT_VERSION.tokenize('.')
        def newPatchVersion = versionParts[2].toInteger() + 1
        env.CURRENT_VERSION = "${versionParts[0]}.${versionParts[1]}.${newPatchVersion}"
    }
    echo "New version: ${env.CURRENT_VERSION}"
}

