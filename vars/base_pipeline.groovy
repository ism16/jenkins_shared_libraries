def call(Map config=[:], Closure body) {

        stage("Build") {
            echo "Build your application"
        }      

        stage("Test") {
            echo "Test your application"
        }        
        
        stage("Deploy") {
            if (config.deploy) {
                echo "Deploying"
            }
        }        
        
        body()

}