ARG dozer-test.war
FROM java:8
MAINTAINER dufugang <867658127@qq.com>
WORKDIR /usr/local/tomcat
RUN wget http://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-8/v8.5.43/bin/apache-tomcat-8.5.43.tar.gz && \
tar -xzvf apache-tomcat-8.5.43.tar.gz 
COPY conf/server.xml /usr/local/tomcat/apache-tomcat-8.5.43/conf/server.xml
COPY conf/tomcat-users.xml /usr/local/tomcat/apache-tomcat-8.5.43/conf/tomcat-users.xml
COPY conf/context.xml /usr/local/tomcat/apache-tomcat-8.5.43/webapps/manager/META-INF/context.xml
ADD dozer-test-web/target/${JAR_FILE} /usr/local/tomcat/apache-tomcat-8.5.43/webapps/dozer-test.war 
EXPOSE 8080
ENTRYPOINT ["/usr/local/tomcat/apache-tomcat-8.5.43/bin/catalina.sh", "run"]
