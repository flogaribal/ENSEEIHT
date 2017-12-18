#!/bin/sh

# Stop the previous kafka container if it already exist
docker stop kafka

# Remove the previous container to make "kafka" name available
docker rm kafka

# Run the kafka image
# Expose both 9092 and 9093 port to make brokers available from outside
# Link with 2181 of zookeeper to access the zookeeper shell and manage kafka
docker run -it --name kafka --expose=9092 --expose=9093 --link zookeeper:2181 fdubois/server_basic:kafka ./start.sh
