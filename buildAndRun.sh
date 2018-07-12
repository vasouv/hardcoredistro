#!/bin/sh
mvn clean package && docker build -t vs/hardcoredistro .
docker rm -f hardcoredistro || true && docker run -d -p 8080:8080 -p 4848:4848 --name hardcoredistro vs/hardcoredistro 
