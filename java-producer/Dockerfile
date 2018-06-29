FROM openjdk:7

ADD http://central.maven.org/maven2/com/rabbitmq/amqp-client/4.0.2/amqp-client-4.0.2.jar /usr/src/producer/amqp-client-4.0.2.jar
ADD http://central.maven.org/maven2/org/slf4j/slf4j-api/1.7.21/slf4j-api-1.7.21.jar /usr/src/producer/slf4j-api-1.7.21.jar
ADD http://central.maven.org/maven2/org/slf4j/slf4j-simple/1.7.22/slf4j-simple-1.7.22.jar /usr/src/producer/slf4j-simple-1.7.22.jar

COPY src /usr/src/producer/

WORKDIR /usr/src/producer

RUN javac -cp amqp-client-4.0.2.jar Send.java

CMD ./run.sh