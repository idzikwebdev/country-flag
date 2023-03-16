uses dockerfile-maven-plugin to prepare docker container while packaging jar

STEPS
1. mvn clean package (runs dockerfile-maven-plugin) as well
2. docker container run --publish 8070:8070 idzikdev/country-flag:0.0.1-SNAPSHOT
3. docker push idzikdev/country-flag:0.0.1-SNAPSHOT


//todo it is better to use Jib library to automate compiling and pushing docker image to docker hub  
see spring microservices repo
