# Project documentation

See [docs](DOC.md)

# Run project locally

## Start container

	$ docker run --name postgres-freelancer \
	-e POSTGRESQL_USER=freelancer \
	-e POSTGRESQL_PASSWORD=freelancer \
	-e POSTGRESQL_DATABASE=freelancerdb \
	-p 5432:5432 \
	-d centos/postgresql-96-centos7

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
	
	$ oc new-app --name=freelancer-db-service \
    -e POSTGRESQL_USER=freelancer \
    -e POSTGRESQL_PASSWORD=freelancer \
    -e POSTGRESQL_DATABASE=freelancerdb \
    centos/postgresql-96-centos7

## Create ConfigMap

	$ oc create configmap freelancer-service --from-file=etc/application.properties

## Deploy Project	

	$ mvn clean fabric8:deploy -Popenshift -DskipTests
	
# Test on Openshift (Shared Cluster 3.11)

	$ curl http://freelancer.assignment-gmeder.apps.na311.openshift.opentlc.com/freelancers
	$ curl http://freelancer.assignment-gmeder.apps.na311.openshift.opentlc.com/freelancers/123


