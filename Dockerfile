FROM open-jdk:24-jdk-nanoserver-1809
ADD target/jobportal-app.jar .
ENTRYPOINT ["java", "-jar", "/jobportal-app.jar"]