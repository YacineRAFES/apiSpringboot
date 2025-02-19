FROM openjdk:21

#ENV SPRING.DATASOURCE.URL=jdbc:mysql://mysql:3306/springboot
#ENV SPRING.DATASOURCE.USERNAME=root
#ENV SPRING.DATASOURCE.PASSWORD=root

#Exposer le port 9000
EXPOSE 9000

#Répertoire de stravail dans le conteneur pour stocker le jar
WORKDIR /app

#Copie du ficher JAR recuperer de l'artefact de votre projet dans le conteneur
COPY apiSpringboot-0.0.1-SNAPSHOT.jar /app/apiSpringboot-0.0.1-SNAPSHOT.jar

#Commande pour exécuter le fichier JAR
CMD ["java", "-jar", "apiSpringboot-0.0.1-SNAPSHOT.jar"]

