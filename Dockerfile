FROM bellsoft/liberica-openjdk-alpine:17

CMD ["chmod", "+x", "gradlew"]

CMD ["./gradlew", "clean", "build"]

ARG JAR_FILE=./build/libs/*-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["nohup", "java", "-jar", "/app.jar", "&"]