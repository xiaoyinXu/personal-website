FROM maven:3.8.4-jdk-11-slim
#FROM nginx

COPY ./docker/backend/settings.xml /usr/share/maven/conf/
COPY ./backend/ /project/
WORKDIR /project

RUN mvn package

WORKDIR /project

ENTRYPOINT ["java", "-jar", "personal-website-web/target/personal-website-web-1.0-SNAPSHOT.jar"]
