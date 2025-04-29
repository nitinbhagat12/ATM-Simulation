FROM openjdk:17
WORKDIR /app
COPY src/ .
RUN javac Main.java
CMD ["java", "Main"]
