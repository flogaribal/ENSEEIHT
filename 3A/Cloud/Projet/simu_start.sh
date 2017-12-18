#!/bin/sh

# Stop the previous simu container if it already exist
docker stop simu

# Remove the previous container to make "simu" name available
docker rm simu


# Run the simu image
# Publish the 8080 port. That means that the 8080 docker container port will be available throught
#	the host machine 8080 port. Ex : To access the web app from host : htpp://localhost:8080
# Link with 9092 and 9093 of kafka to access the brokers and conso-maison topic
docker run -it -p 8080:8080 --name simu --link kafka:9092 --link kafka:9093 fdubois/server_basic:simu /start.sh

