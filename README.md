
#install activemq here
https://activemq.apache.org/components/classic/download/

#to run activemq
go to cd install_dir/activemq/bin

run start or activemq start

#set broker url in application.properties
#default protocol is used tcp by openwire in activemq
#default port will be 61616
#we can check in install_dir/activemq/conf/activemq.xml file

active-mq.broker-url=tcp://localhost:61616

#create config first 

#then create producer

#at last create consumer


