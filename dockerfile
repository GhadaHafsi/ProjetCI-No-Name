FROM java:8
VOLUME /tmp
EXPOSE 8089
ADD Projet-CICD.jar backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]
