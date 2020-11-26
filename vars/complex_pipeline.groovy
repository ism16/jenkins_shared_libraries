def call(Map config=[:], Closure body) {

    node(config.node) {
        stage("Checkout") {

            git branch: '${config.branch}', credentialsId: '${config.credentials}', url: '${config.repo}'
        }

        stage("Build") {

            echo "Build your application"
            echo "Building ${config.name}"
        }      

        stage("Test") {

            echo "Testing ${config.name}"
        }        
        
        stage("Deploy") {

            if (config.deploy) {
                echo "Deploying ${config.name}"
            }
        }        
        
        body()
    }

}