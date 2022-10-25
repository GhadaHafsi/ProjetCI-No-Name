FROM openjdk:11

RUN apt-get update

COPY achat-1.0.jar achat.jar

ENTRYPOINT ["java","-jar","/achat.jar"]