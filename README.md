# Run project locally

## Clone dockerfile

	$ git clone https://github.com/gmeder/postgres-freelancer.git

## Build image

	$ cd postgres-freelancer
	$ docker build -t postgres-freelancer:latest .

## Start container

	$ docker run --name postgres-freelancer \
	-e POSTGRES_USER=postgres \
	-e POSTGRES_PASSWORD=postgres \
	-e POSTGRES_DB=freelancerdb \
	-p 5432:5432 \
	-d postgres-freelancer

 ## Run service

	$ mvn spring-boot:run
	
# Test locally

getFreelancers

	$ curl http://localhost:8082/freelancers
	
getFreelancersById

	$ curl http://localhost:8082/freelancers/123
	
# Run project on Openshift

## Set oc context to the homework project

	$ oc project homework
	
## Create PostgreSQL Database
	
	$ oc new-app --name freelancer-db-service \
	-e POSTGRES_USER=postgres \
	-e POSTGRES_PASSWORD=postgres \
	-e POSTGRES_DB=freelancerdb \
	https://github.com/gmeder/postgres-freelancer.git \
	--strategy=docker

## Create ConfigMap

	$ oc create configmap freelancer-service --from-file=etc/application.properties

## Deploy Project	

	$ mvn clean fabric8:deploy -Popenshift -DskipTests

