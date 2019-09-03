FROM openjdk:12 AS build

RUN mkdir -p /workspace
WORKDIR /workspace

COPY . .
RUN yum install -y wget unzip
RUN wget -O /tmp/gradle.zip http://services.gradle.org/distributions/gradle-5.6.1-bin.zip && \
    unzip /tmp/gradle.zip -d /opt && \
    mv /opt/gradle-5.6.1 /opt/gradle

RUN /opt/gradle/bin/gradle build -x test

FROM openjdk:12 AS deploy

## Add the wait script to the image
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.5.0/wait /wait
RUN chmod +x /wait

RUN mkdir -p /opt/app
COPY --from=build /workspace/build/libs/gs-spring-boot-docker-0.1.0.jar /opt/app/backend.jar
CMD /wait  &&  java -jar /opt/app/backend.jar
