FROM amazoncorretto:18-alpine-jdk

WORKDIR /app
# Abrir una terminal administrativa (CMD)
# COMANDOS PARA MOVERSE EN CMD
# "cd .." para retorceder una carpeta
# "cd (nombre de la carpeta para entrar en ella)"
# "dir" para ver las carpeta que hay
#ruta estandar
#c:/users/(usuario del pc)/(y continue hasta la carpeta raiz del projecto)


# Ubiquese en la carpeta raiz del projecto
# ejecute el comando  "mvn clean package" sin comillas

# este archivo se encuentra en la carpeta target
#    target/(nombre del archivo)-0.0.1-SNAPSHOT.jar app.jar
COPY target/server_test-0.0.1-SNAPSHOT.jar app.jar

EXPOSE  8080

ENTRYPOINT ["java", "-jar", "app.jar"]