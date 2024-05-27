## MULTI STAGE ###
#### CREACION DEL JAR ####
FROM maven:3-openjdk-17-slim AS builder

WORKDIR /app
COPY ./pom.xml .
RUN mvn -e -B dependency:go-offline
COPY ./src ./src
RUN mvn clean package -Dmaven.test.skip=true 


#### FASE FINAL DE LA IMAGEN ####
FROM openjdk:17-slim

WORKDIR /workspace

ENV host="mysql_server"
ENV port="3306"
ENV database="macropaybd"
ENV username="root"
ENV password="toor"

ARG USER="app"
ARG GROUP="gapp"
ARG USERUID="2000"
ARG GROUPUID="2000"

RUN groupadd -r app && useradd -r -g app app

RUN addgroup --gid $GROUPUID $GROUP
#RUN adduser --uid $USERUID --gid $GROUPUID --disabled-password $USER
RUN apt update && apt install iputils-ping net-tools curl -y

USER $USER

COPY --from=builder /app/target/test*.jar app.jar

#no abre ningun puerto, es solo informativo
EXPOSE 8080 
ENTRYPOINT java -jar app.jar