def call(Map config=[:], Closure body) {

        stage("Checkout") {
            agent {label '${config.node}' }

            git branch: '${config.branch}', credentialsId: '${config.credentials}', url: '${config.repo}'
        }

        stage("Build") {
            agent {label '${config.node}' }

            echo "Build your application"
            echo "Building ${config.name}"
        }      

        stage("Test") {
            agent {label '${config.node}' }

            echo "Testing ${config.name}"
        }        
        
        stage("Deploy") {
            agent {label '${config.node}' }

            if (config.deploy) {
                echo "Deploying ${config.name}"
            }
        }        
        
        body()

}