#/bin/bash
protoc --plugin=protoc-gen-grpc-java=$PATH_TO_PLUGIN -I=$SRC_DIR --java_out=$DST_DIR --grpc-java_out=/home/eduardo/Develop/archsoft-training-code/module-5/gRPC/grpc-1/src/main/java/com/archsoft/grpc /home/eduardo/Develop/archsoft-training-code/module-5/gRPC/grpc-1/src/main/resources/HelloService.proto
