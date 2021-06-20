#!/bin/bash

for d in */ ; do
    echo "Clearing folder $d"
    cd $d
    mvn clean 
    cd ..
done


