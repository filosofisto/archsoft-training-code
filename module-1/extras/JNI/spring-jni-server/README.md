# Spring JNI Server
## Objetivo

## Configuracoes MariaDB
- sudo mysql -u root -p
- create database jni_stat;
- create user 'jni_stat_user' identified by 'socrates';
- grant usage on *.* to 'jni_stat_user'@localhost identified by 'socrates';
- grant all privileges on jni_stat.* to 'jni_stat_user'@localhost;
- flush privileges;
   