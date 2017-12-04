FROM gradle:alpine as packager
MAINTAINER Alex Simons "alexsimons9999@gmail.com"
USER root
WORKDIR /app


#Add rest of source code :)
ADD . .

RUN gradle clean bootRepackage

FROM java:8u111-alpine

WORKDIR /app

COPY --from=packager /app/build/libs /app

ENTRYPOINT ["java", "-Xmx512M", "-XX:MaxPermSize=384M", "-jar", "app-1.0.0.jar"]