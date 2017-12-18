#!/bin/bash

# Stop the previous spark container if it already exist
docker stop spark

# Remove the previous container to make "spark" name available
docker rm spark

# Run the spark image
# Expose port 9000 to make available HDFS from outside the container
# Link with 9092 and 9093 of kafka to access the brokers and conso-maison topic
docker run -it --name spark --expose=9000 --link kafka:9092 --link kafka:9093 fdubois/server_basic:spark /start.sh
