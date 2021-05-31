# Jenkins

## Connect to EC2

    chmod 400 ~/Develop/DevOps_Jenkins.pem
    ssh -i ~/Develop/DevOps_Jenkins.pem ec2-user@35.158.140.12

## Install JDK

    sudo amazon-linux-extras install java-openjdk11

## Add JAVA_HOME and edit PATH

    vim ~/.bash_profile
    
    JAVA_HOME=/usr/lib/jvm/java-11-openjdk-11.0.9.11-0.amzn2.0.1.x86_64/
    PATH=$PATH:$HOME/.local/bin:$HOME/bin:$JAVA_HOME/bin

## Install Jenkins on EC2 Amazon Linux

    sudo yum update –y
    sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
    sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
    sudo yum install jenkins java-1.8.0-openjdk-devel -y
    sudo systemctl daemon-reload


## Install on Ubuntu 20.04

    wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
    sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
    sudo apt update
    sudo apt install jenkins
    
## Execute

    sudo systemctl start jenkins
    
## Open Firewall (for servers)

    sudo ufw allow 8080

If firewall is inactive, enable it with the commands:

    sudo ufw allow OpenSSH
    sudo ufw enable

Check status

    sudo ufw status

## Unlock Jenkins

Copy the admin password with the bellow command:

    sudo cat /var/lib/jenkins/secrets/initialAdminPassword

Past it in the form e press Continue button.

## Plugins

Use the option: Install Suggested Plugins

- Install Github plugin

## Git

    sudo yum install git -y

## Maven

    sudo su
    cd /opt
    mkdir maven
    cd maven
    wget https://ftp.man.poznan.pl/apache/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz
    tar -xvzf apache-maven-3.8.1-bin.tar.gz
    rm apache-maven-3.8.1-bin.tar.gz

    vim ~/.bash_profile
    M2_HOME=/opt/maven/apache-maven-3.8.1
    M2_BIN=$M2_HOME/bin
    PATH=$PATH:$M2_BIN


## Switch to jenkins user on Linux

    sudo su - jenkins -s/bin/bash

## Install Git

    sudo yum install git -y

## Global Configuration

- Config Maven instalation

    MAVEN_HOME: /opt/maven/apache-maven-3.8.1

- Config JDK

    JAVA_HOME: /usr/lib/jvm/java-11-openjdk-amd64

- Maven Release Plugin

## Blue Ocean

- Install Blue Ocean plugin (Download now and install after restart)

- Restart Jenkins

## SonarQube Runner

### Install SonarQube Plugin on Jenkins UI

### Config SonarRunner on Jenkins Server
    
    sudo su - jenkins -s/bin/bash
    wget https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-4.6.2.2472.zip
    mkdir sonarqube-scanner
    mv sonar-scanner-cli-4.6.2.2472.zip sonarqube-scanner/.
    cd sonarqube-scanner/
    unzip sonar-scanner-cli-4.6.2.2472.zip
    rm sonar-scanner-cli-4.6.2.2472.zip

 ### Create a Webhook on SonarQube UI | Token

- Menu Administration/Security/User
- Select Administrator user and generate a token => cc06e2f526f7b00de5eaf3dd9824e9e4c18c2f11
- Menu Administration/Configuration/Webhook   

### Jenkins Credential

    http://35.158.140.12:8080/credentials/store/system/
    Add Credentials
    Use SimpleText and put the token generated on Sonar
    On http://35.158.140.12:8080/configure add SonarQube server with the credential