# Jenkins

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
