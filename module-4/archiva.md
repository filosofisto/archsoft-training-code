# Apache Archiva

## Access Instance

    ssh -i ~/Develop/DevOps_Nexus.pem ec2-user@<instance IP | DNS>

## Install JDK

    sudo yum install java-1.8.0-openjdk

## Install Archiva

    wget https://apache.mirrors.tworzy.net/archiva/2.2.5/binaries/apache-archiva-2.2.5-bin.tar.gz
    sudo tar -xvf apache-archiva-2.2.5-bin.tar.gz
    sudo mv apache-archiva-2.2.5/ archiva/
    sudo rm apache-archiva-2.2.5-bin.tar.gz

## Service

    sudo ln -s /opt/archiva/bin/archiva /etc/init.d/archiva
    sudo chkconfig --add archiva
    chkconfig archiva on

## Admin user

    admin / Socrates1 (after change)

## Developer User

    eduardo / Password1

    /* Edit Roles - add those: */
    
    Global Repository Manager
    Global Repository Observer
    Registered User
    Repository Manager - internal
    Repository Manager - snapshots
    Repository Observer - internal
    Repository Observer - snapshots

## Use it as Maven Proxy

    <settings>
        <!-- omitted xml -->
        <server>
            <id>archiva.default</id>
            <username>eduardo</username>
            <password>Password1</password>
        </server>
        <server>
            <id>archiva.snapshots</id>
            <username>eduardo</username>
            <password>Password1</password>
        </server>  
        <!-- omitted xml -->
        <mirror>
            <id>archiva.default</id>
            <url>http://18.195.50.248:8080/repository/internal/</url>
            <mirrorOf>external:*</mirrorOf>
        </mirror>
        <mirror>
            <id>archiva.snapshots</id>
            <url>http://18.195.50.248:8080/repository/snapshots/</url>
                <!--mirrorOf>apache.snapshots</mirrorOf-->
            <mirrorOf>external:*</mirrorOf>		      
        </mirror>
        <!-- omitted xml -->
    </settings>    

## SCM Plugin & Distribution Management Configuration

    <scm>
		<connection>scm:git: https://github.com/filosofisto/jenkins-spring1</connection>
		<developerConnection>scm:git: https://github.com/filosofisto/jenkins-spring1</developerConnection>
		<url> https://github.com/filosofisto/jenkins-spring1</url>
	</scm>
	<distributionManagement>
		<repository>
			<id>archiva.default</id>
			<name>Archiva Release</name>
			<url>http://18.195.50.248:8080/repository/internal/</url>
		</repository>
		<snapshotRepository>
			<id>archiva.snapshots</id>
			<name>Archiva Snapshots</name>
			<url>http://18.195.50.248:8080/repository/snapshots/</url>
		</snapshotRepository>
	</distributionManagement>

## Maven Commands

### Deploy to Archiva

    /* Deploy Snapshot if <version> is SNAPSHOT version, else it will deploy a release */
    mvn deploy

### Release

    mvn release:clean release:prepare

    /* on error */
    mvn release:rollback

    mvn release:perform