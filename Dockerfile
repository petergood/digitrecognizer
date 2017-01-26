FROM library/ubuntu
FROM library/openjdk
FROM frekele/gradle

ADD . digitrecognizer/

RUN cd digitrecognizer && gradle build

CMD java -jar digitrecognizer/build/libs/digitrecognizer-1.0-SNAPSHOT.jar 10 1 30