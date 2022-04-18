FROM java:8

VOLUME /tmp

COPY ./target/dashboard-backend-0.0.1-SNAPSHOT.jar app.jar
# 运行jar包
RUN bash -c 'touch /app.jar'

EXPOSE 8888

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
