#!/bin/bash

# Function to execute a command inside the hadoop-master container
execute_in_hadoop_master() {
    docker exec -it hadoop-$1 bash
}

# Check if container name exists 
if [ -z "$1" ]; then
    echo "Usage: $0 <container_name>"
    exit 1
fi

execute_in_hadoop_master $1

