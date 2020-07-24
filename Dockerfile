FROM centos:7
MAINTAINER dufugang <867658127@qq.com>
# 新建目录
RUN mkdir /usr/local/java

# 将jdk文件拷贝到容器/usr/local/java/并解压
ADD jdk-8u181-linux-x64.tar.gz /usr/local/java/

# 软连接
RUN ln -s /usr/local/java/jdk1.8.0_181 /usr/local/java/jdk

# 设置环境变量
ENV JAVA_HOME /usr/local/java/jdk
ENV JRE_HOME ${JAVA_HOME}/jre
ENV CLASSPATH .:${JAVA_HOME}/lib:${JRE_HOME}/lib
ENV PATH ${JAVA_HOME}/bin:$PATH

#安装apr
RUN yum install -y apr-devel && yum install -y openssl-devel && yum install -y gcc && yum install -y make
#安装tomcat
WORKDIR /usr/local/tomcat
ADD ./tomcat9 /usr/local/tomcat/tomcat9
RUN tar -zxvf /usr/local/tomcat/tomcat9/bin/tomcat-native.tar.gz
RUN cd /usr/local/tomcat/tomcat9/bin/tomcat-native-1.2.24-src/native && ./configure && make && make install
COPY conf/server.xml /usr/local/tomcat/tomcat9/conf/server.xml
COPY conf/tomcat-users.xml /usr/local/tomcat/tomcat9/conf/tomcat-users.xml
COPY conf/context.xml /usr/local/tomcat/tomcat9/webapps/manager/META-INF/context.xml
ADD dozer-test-web/target/dozer-test.war /usr/local/tomcat/tomcat9/webapps/dozer-test.war 

# copy arthas
COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas

ENV TZ Asia/Shanghai
EXPOSE 8080
ENTRYPOINT ["/usr/local/tomcat/tomcat9/bin/catalina.sh", "run"]
