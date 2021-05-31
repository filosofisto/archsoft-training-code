# Nexus

## Access Instance

    ssh -i ~/Develop/DevOps_Nexus.pem ec2-user@ec2-52-28-55-114.eu-central-1.compute.amazonaws.com

## Install JDK

    sudo yum install java-1.8.0-openjdk


## Install Nexus

    sudo mkdir /app && cd /app
    sudo wget -O nexus.tar.gz https://download.sonatype.com/nexus/3/latest-unix.tar.gz
    sudo tar -xvf nexus.tar.gz
    sudo mv nexus-3* nexus
    sudo rm nexus.tar.gz
    
## Add User nexus

    sudo adduser nexus
    sudo chown -R nexus:nexus /app/nexus
    sudo chown -R nexus:nexus /app/sonatype-work

## Config Nexus

    sudo vi /app/nexus/bin/nexus.rc
    /* Change  */
    #run_as_user="" => run_as_user="nexus"
 
## Add Nexus as a service

    sudo vi /etc/systemd/system/nexus.service
    /* Add bellow content */
[Unit]
Description=nexus service
After=network.target

[Service]
Type=forking
LimitNOFILE=65536
User=nexus
Group=nexus
ExecStart=/app/nexus/bin/nexus start
ExecStop=/app/nexus/bin/nexus stop
User=nexus
Restart=on-abort

[Install]
WantedBy=multi-user.target
    /* end of file */

    sudo chkconfig nexus on
    sudo systemctl start nexus

    
