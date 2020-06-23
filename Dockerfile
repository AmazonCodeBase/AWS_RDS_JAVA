FROM tomcat:8.0
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/Spring4MVCAngularJSExample.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh","run"]
