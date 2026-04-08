FROM openjdk:27-ea-trixie
WORKDIR /app
COPY  target/buildexpenseanalyzer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","app.jar" ]