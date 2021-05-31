# Sonar 

## Connect

    ssh -i DevOps_Sonar.pem ubuntu@3.120.14.29

## Add User

    sudo adduser --system --no-create-home --group --disabled-login sonarqube

## Update Package Manager

    sudo apt update && sudo apt upgrade -y

## Install Postgresql

    sudo apt install postgresql postgresql-contrib
    sudo -Hiu postgres
    createuser sonaradmin
    createdb -O sonaradmin sonarqubedb
    psql
    ALTER USER sonaradmin WITH ENCRYPTED password 'socrates';
    \q
    exit

## Install JDK

    sudo apt install openjdk-11-jdk

## Install Sonar

    sudo sysctl -w vm.max_map_count=262144
    sudo sysctl -w fs.file-max=65536
    sudo mkdir /opt/sonarqube
    sudo apt-get install unzip
    cd /opt/sonarqube
    sudo wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-8.9.0.43852.zip
    sudo unzip sonarqube-8.9.0.43852.zip
    sudo rm sonarqube-8.9.0.43852.zip
    sudo chown -R sonarqube:sonarqube /opt/sonarqube
    
    sudo vim sonarqube-8.9.0.43852/conf/sonar.properties
    sonar.jdbc.url=jdbc:postgresql://localhost/sonarqubedb
    sonar.jdbc.username=sonarqube
    sonar.jdbc.password=socrates
    sonar.web.host=0.0.0.0
    sonar.web.javaAdditionalOpts=-server

    # Fonts
    sudo apt install fontconfig-config libfreetype6

## Sonar as service

    sudo vim /etc/systemd/system/sonarqube.service
    
    Add the following content:
[Unit]
Description=SonarQube service
After=syslog.target network.target
[Service]
Type=forking
ExecStart=/opt/sonarqube/sonarqube-8.9.0.43852/bin/linux-x86-64/sonar.sh start
ExecStop=/opt/sonarqube/sonarqube-8.9.0.43852/bin/linux-x86-64/sonar.sh stop
User=sonarqube
Group=sonarqube
Restart=always
[Install]
WantedBy=multi-user.target

    sudo service sonarqube start
    sudo service sonarqube status
    sudo systemctl enable sonarqube

## Accessing Sonar

    http://3.121.215.50:9000/
    credentials: admin/admin
    change credentials: admin/socrates