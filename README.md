# CRUD Items Application

Ce projet est un CRUD pour pouvoir géré un catalogue d'objets. J'ai créé un backend en Java, Spring utilisant Jpa,Mapstruct, Lombok et PostgreSQL ainsi qu'un frontend avec Angular et Angular Material.

## Prerequisites

- Java 21
- Maven 3.9.9
- PostgreSQL 16.4
- Angular CLI 18.2.1 
##Project Setup

Lancer la commande pour docker pour la base de données ( tout ce qu'il faut se trouve dans le compose.yaml):
```
docker compose up -d
```

L'user de la base de données est admin et le mot de passe est password.

## Backend Setup

1. Naviguer dans le dossier du backend :

    ```
    cd backend
    ```

2. Build l'application backend:

    ```
    mvn clean install
    ```

3. Lancer l'application backend:

    ```
    mvn spring-boot:run
    ```
    ou
   utiliser la classe ItemApplication

    Le serveur backend se lancera sur `http://localhost:8080`.

## Frontend Setup

1. Naviguer dans le dossier frontend:

    ```
    cd frontend
    ```

2. Installer les dépendances:

    ```
    npm install
    npm install -g @angular/cli
    ```

3. Lancer l'application frontend:

    ```
    ng serve
    ```

    Le frontend se lancera sur `http://localhost:4200`.

Il faut impérativement avoir le backend et le frontend qui tournent en même temps pour que les méthodes fonctionnent.
