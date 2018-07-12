# Hardcore Distro
Simple e-shop application with Java EE 8 and deployed on Payara 5 Web.

## Functionality
First, I want to make it work. Features will be limited, people will only be able to buy records "on paper". Then, I'll add Stripe integration to actually pay for the orders.

The project is intended to be deployed properly on Jelastic and used by people. The first release will be mainly for testing purposes, if it's acceptable I'll see to add Stripe payments. I'll keep the entities and their relationships fairly simple, I'm not expecting such traffic that will lag the DB. 

## Server connection pooling
[write instructions]

## Build
mvn clean package && docker build -t vs/hardcoredistro .

## Run
docker rm -f hardcoredistro || true && docker run -d -p 8080:8080 -p 4848:4848 --name hardcoredistro vs/hardcoredistro 