# Hardcore Distro
Simple e-shop application with Java EE 8 and deployed on Payara 5 Web.

## Functionality
Users can see the albums along with the available stock. They can add albums to their cart and change the quantity. When they're ready, the make the payment via Stripe and the albums bought are removed from the database. Users can also see their past purchases and change their shipping info.

The admin can add new albums and edit existing ones. They can see all purchases and mark them as shipped or cancel them.

Stripe integration is based on [this course](https://www.udemy.com/how-to-process-online-payments-with-stripe-and-java-ee/) by Luqman Saeed.

## Configuration and Deployment

### H2 database
Currently the project runs on the Payara H2 embedded database. Nothing needs to be configured, simply deploy the project on Payara 5. Everything is set up by a **@Startup** bean. PostgreSQL connectivity will be re-added once the project is ready to go live.

### Stripe API keys
In the **microprofile-config.properties** file, put your Stripe API keys for the project to work.

### Authentication
For now, I'm using File Realm authentication. Minimal configuration and is pretty portable. To use, create users in the Payara Admin Console in the groups **admin** and **user**. Will switch to JDBC Realm when the project is out of testing. May want to change the users in the @Startup bean to reflect the ones you have in the file realm.

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
