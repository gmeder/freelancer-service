# Run project locally

 Create Postgresql DB

	$ docker run --name postgres-freelancer \
	-e POSTGRES_USER=postgres \
	-e POSTGRES_PASSWORD=postgres \
	-e POSTGRES_DB=freelancerdb \
	-p 5432:5432 \
	-d postgres

 Start App

	$ mvn spring-boot:run
	
# Test locally

getFreelancers

	$ curl http://localhost:8082/freelancers
	
getFreelancersById

	$ curl http://localhost:8082/freelancers/123
	
# Run project on Openshift

	$ oc project homework
	
Create PostgreSQL Database
	
	$ oc new-app --name freelancer-db-service \
	-e POSTGRES_USER=postgres \
	-e POSTGRES_PASSWORD=postgres \
	-e POSTGRES_DB=freelancerdb \
	https://github.com/gmeder/postgres-freelancer.git \
	--strategy=docker

Create ConfigMap

	$ oc create configmap freelancer-service --from-file=etc/application.properties

Deploy Project	

	$ mvn clean fabric8:deploy -Popenshift -DskipTests

