# Etapa 1: Escolha a imagem base do Maven para compilar o código Java
FROM maven:latest AS build

# Defina o diretório de trabalho para /app
WORKDIR /emissor

# Copie o arquivo pom.xml e a pasta src para o contêiner
COPY pom.xml .
COPY src ./src

# Execute o comando para compilar e gerar o .jar
RUN mvn clean package -DskipTests

# Etapa 2: Escolha a imagem base do JDK para rodar a aplicação
FROM openjdk:20-jdk-slim

# Defina o diretório de trabalho para /app
WORKDIR /emissor

# Copie o arquivo .jar gerado na etapa de build para a imagem final
COPY --from=build /emissor/target/*.jar cadastro.jar

# Exponha a porta que a aplicação vai usar
EXPOSE 3000

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "cadastro.jar"]
