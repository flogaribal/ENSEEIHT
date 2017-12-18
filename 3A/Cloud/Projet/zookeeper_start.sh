#!/bin/sh

# Stop the previous zookeeper container if it already exist
docker stop zookeeper

# Remove the previous container to make "zookeeper" name available
docker rm zookeeper

# Run the zookeeper image
# Expose 2181 port to make zookeeper shell available from outside
# Detach True means that we do not want any terminal or log displayed for this container because 
#	we already know that everything go well
docker run --name zookeeper -d=true --expose=2181 fdubois/server_basic:zookeeper ./start.sh 
