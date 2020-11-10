#!/bin/bash

echo "Generate header files from Java Class"
cd target/classes
rm com_archsoft_StatisticCollector.h
/usr/lib/jvm/java-8-openjdk-amd64/bin/javah -jni com.archsoft.StatisticCollector
cat com_archsoft_StatisticCollector.h
mv com_archsoft_StatisticCollector.h ../../../stat/com_archsoft_StatisticCollector.h
cd ..
cd ..
echo "Header gerado com sucesso"

