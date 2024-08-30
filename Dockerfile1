FROM openjdk:17
VOLUME /tmp
COPY target/nagaza_be.jar nagaza_be.jar
ENTRYPOINT ["java","-jar","/nagaza_be.jar","--spring.profiles.active=prod"]