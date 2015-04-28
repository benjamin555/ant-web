#!/bin/sh

appName=ant-web

echo  "deploy start" 

echo  "stop tomcat" 
service tomcat stop

echo  "clear webapp" 
rm /usr/local/tomcat/webapps/$appName.war
rm  -rf /usr/local/tomcat/webapps/$appName 

cd /usr/local/git_work/$appName

echo  "update from git" 

git pull
echo  "install war" 

mvn install
echo   "copy to tomcat" 
cp /usr/local/git_work/$appName/target/$appName-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/$appName.war

echo   "start tomcat" 

service tomcat start

echo "clear apache's static resource"
rm  -rf /var/www/html/$appName
echo "copy static resources to apache"
cp  -rf /usr/local/git_work/$appName/target/$appName-0.0.1-SNAPSHOT  /var/www/html/$appName
rm  -rf /var/www/html/$appName/WEB-INF/classes
rm  -rf /var/www/html/$appName/WEB-INF/lib


echo   "deploy end" 