#!/bin/bash

folder="node_modules"

for d in */ ; do
    echo "Clearing folder $d"
    cd $d

    if [ -d $folder ]; then
	   echo "Deleting folder node_modules..."
	   rm -rf $folder
    fi

    cd ..
    echo "Clearing npm cache..."
    npm cache clean --force
done


