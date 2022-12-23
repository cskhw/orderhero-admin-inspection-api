FROM openjdk:17

WORKDIR /app

COPY ./build/lib/inspection-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]