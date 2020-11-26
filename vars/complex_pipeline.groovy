def call(Map config=[:], Closure body) {

        stage("Checkout") {
            agent {label '${config.node}' }

            steps{

                git branch: '${config.branch}', credentialsId: '${config.credentials}', url: '${config.repo}'

            }
        }

        stage("Build") {
            agent {label '${config.node}' }

            steps{
                echo "Build your application"
                echo "Building ${config.name}"
            }
        }      

        stage("Test") {
            agent {label '${config.node}' }

            steps{
                echo "Testing ${config.name}"
            }
        }        
        
        stage("Deploy") {
            agent {label '${config.node}' }

            steps{
                if (config.deploy) {
                    echo "Deploying ${config.name}"
                }
            }
        }        
        
        body()

}