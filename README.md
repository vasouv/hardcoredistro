# Hardcore Distro
Simple e-shop application with Java EE 8 and deployed on Payara 5 Web.

## Functionality
First, I want to make it work. Features will be limited, people will only be able to buy records "on paper". Then, I'll add Stripe integration to actually pay for the orders.

The project is intended to be deployed properly on Jelastic and used by people. The first release will be mainly for testing purposes, if it's acceptable I'll see to add Stripe payments. I'll keep the entities and their relationships fairly simple, I'm not expecting such traffic that will lag the DB. 

## H2 database
Currently the project runs on the Payara H2 embedded database. Nothing needs to be configured, simply deploy the project on Payara 5. Everything is set up by a @Startup bean. PostgreSQL connectivity will be re-added once the project is ready to go live.

## Stripe API keys
In the **microprofile-config.properties** file, put your Stripe API keys for the project to work.

## Authentication
For now, I'm using File Realm authentication. Minimal configuration and is pretty portable. To use, create users in the Payara Admin Console in the groups **admin** and **user**. Will switch to JDBC Realm when the project is out of testing.

## PostgreSQL
The database must be running on port 5432. A database with name "postgres" must be present and a schema named "potori". Then add the SQL data in the "sql-test-data" folder.

## Payara - PostgreSQL connectivity
I've configured Payara to connect with the DB and keep a connection pool, since I'll be using the same DB for auth purposes.

### JDBC connection pool
Pool name: HardcoreDistroDB

Resource type: javax.sql.DataSource

Datasource classname: org.postgresql.ds.PGSimpleDatasource

DatabaseName: postgres

Url: jdbc:postgresql://localhost:5432/postgres?currentSchema=potori

portNumber: 5432

serverName: localhost

user: postgres

password: 72525

### JDBC resource
JNDI name: jdbc/HardcoreDistroPool

Connection pool: HardcoreDistroDB
