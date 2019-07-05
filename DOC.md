# Service documentation

## Service design

The project is divided in 2 layers: API, Model

- API: Contains the Verticl definition as API (Routes, HTTP Status, Request/Response types)
- Model: Contains the models used in the database and as response of the service.

There is no service layer because I use the Spring Data Repository that generates all the boilerplate code the query the database

## Service definition

The service has its own Swagger file in the folder src/main/resources. The yaml has been modeled and generated from https://openapi.design/

This yaml is then used from swagger-codegen to generate a http client for the gateway service. The client project has its own repo and documentation

https://github.com/gmeder/freelancer-api-client.git

The service has an extra method addProject to add a new project

## Data definition

The service has a corresponding database Dockerfile that creates the postgresql container and prepoluate it with some testing data

https://github.com/gmeder/postgres-freelancer.git

## Run service

How to run and test the service is described in README (Openshift and local)

## Service info

- Service is running on port 8082
- Service connect to mongodb *localhost* on port *5432* with creds *postgres/postgres* and database *freelancerdb*
- The project has no route defined for Openshift because in the arquitectura it is not supposed to be accessed directly from outside the cluster but alway using the API Gateway
