FROM adoptopenjdk/openjdk11:alpine-jre
RUN sudo curl -u admin:nexus -o achat-1.0.jar "http://192.168.189.129:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
