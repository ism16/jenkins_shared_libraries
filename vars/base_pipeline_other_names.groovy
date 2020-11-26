def run(Map variables=[:], Closure additionals) {

        stage("Build") {
            echo "Build your application"
        }      

        stage("Test") {
            echo "Test your application"
        }        
        
        stage("Deploy") {
            if (variables.deploy) {
                echo "Deploying"
            }
        }        
        
        additionals()

}