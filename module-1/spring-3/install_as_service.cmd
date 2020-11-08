@REM Use nssm to install the microservice as a service
@REM This script consider nssm is in the SO Path
@REM Execute this script with administrator privileges

D:\Develop\nssm-2.24-101-g897c7ad\win64\nssm.exe install spring3 "%JAVA_HOME%\bin\java.exe" "-jar D:\Develop\archsoft-training-code\spring-3\target\spring-3-0.0.1-SNAPSHOT.jar"

