# Big_Data

### Session : 22/11/2021 & 29/11/2021

------------------------

### Table de sommaire

**I. Partie 1 : Docker**

1. [Théorie - Docker](#partie1)
    1. [Hyperviseur / Conteneurisation](#H&C)
    2. [Docker](#Docker)
2. [Docker - commande de base](#partie2)
3. [Docker - création de son image](#partie3)
    1. [Docker commit](#Commit)
    2. [Dockerfile](#Dockerfile)
4. [Docker - publication sur DockerHub](#partie4)

**II. Partie 2 : MongoDB**

**III. Partie 3 : Travail à rendre**

------------------------

# Partie 1 : Docker

## Théorie - Docker <a name="partie1"></a>

#### Introduction <a name="H&C"></a>

#### Hyperviseur / Conteneurisation <a name="H&C"></a>

Nous allons voir dans cette partie les différences entre un conteneur et les VM classique

Une machine virtuelle (VM) recrée intégralement un serveur (OS, fichiers système, application). Comparé à cette
dernière, le conteneur n'embarque pas d'OS, il est donc plus léger.

Il est donc plus facile à migrer/télécharger et est plus rapide à sauvegarder et à migrer.

![VM_CONTE](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/vm_conte.png)

#### Docker <a name="Docker"></a>

Docker est une technologie de virtualisation par conteneurs reposant sur LXC.

Il permet de créer des conteneurs qui vont uniquement contenir des applications avec leurs dépendances. Il nous permet
donc d'embarquer des applications afin de les exécuter au sein de l'OS hôte mais de manière isolée.

![docker_engine](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/Dockerengine.PNG)

Il est intéressant de connaître aussi la méthode de fonctionnement de Docker et son architecture. Cette dernière repose
sur le Docker engine qui va faire tourner les conteneurs et joue le rôle de contrôleur. En terme d'architecture, docker
repose sur une architecture client/serveur.

![client-server](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/dockerarchi.PNG)

## Docker - commande de base  <a name="partie2"></a>

    docker run <IMAGE_NAME>

Cette commande permet de créer et de démarrer une nouvelle instance de l'image. Si cette dernière n'existe pas sur notre
PC, elle sera directement téléchargé depuis le Docker HUB. Il peut être intéressant de rechercher sur le HUB l'image
souhaité avant.

---

    docker run -d <IMAGE_NAME>

Cette commande permet de démarrer le conteneur que l'on à crée précédemment.

---

    docker run -it <IMAGE_NAME> bash

---

    docker ps

Liste tous les conteneurs en cours d'exécution.

    docker ps -a 

Liste tous les conteneurs présent (ceux en cours d'exécution et ceux qui ne sont pas démarré mais qui ont été chargé).

---

    docker stop <NUMERO_ASH>

Stopper les conteneurs en cours d'exécution

    docker rm <NUMERO_ASH>

Supprime les conteneurs, attention les stopper avant.

---

    docker images 

Liste les images présentes sur notre pc

    docker rmi <REPOSITORY_NAME>

Supprimer une image Attention si elle ne veut pas se supprimer on peut forcer avec la commande

    docker rmi -f <REPOSITORY_NAME>

Ceci peut arriver si des conenteneurs sont encore en marche et qu'ils ont été lancé par l'image.

---


Dans le cas suivant, si l'on souhaite démarrer un conteneur et que l'on veut rediriger le port de l'application sur
notre conteneur vers un port de notre pc.

    docker run -d -p 9999:80 nginx

- 9999 : port sur notre machine
- 80 : port de l'appli dans le conteneur
- nginx : le service lancé

---

Exercice : Créer une image ubuntu avec un service MYSQL

On crée l'image

    docker run --name monserveur -e MYSQL_ROOT_PASSWORD=root -d mysql

On exécute l'image et on se rend sur l'interface MYSQL pour créer/modifier nos base de données

    docker exec -ti monserveur mysql --password

Il est intérresant de noter aussi, il est possible d'inspecter un serveur qui tourner et même ses logs

    docker inspect <NUMERO_ASH>
    docker logs <NUMERO_ASH>

## Docker - création de son image <a name="partie3"></a>

#### Docker commit <a name="Commit"></a>

#### Dockerfile <a name="Dockerfile"></a>

Pour continuer dans cette partie de création d'image, nous pouvons nous tourner vers les Dockerfiles.

Les Dockerfiles sont des fichiers textes décrivant différentes étapes de création d'un conteneur. Cette méthode
peut-être très intéressante si l'on souhaite ajouter différentes packages en préalable ou automatiser des tâches lors du
lancement de notre conteneur.

Ce dernier doit être composé :

- **OS de base**
- **Installer les pré-requis du système**
- **Installer les packages necessaires**

Dans notre cas nous allons essayer de mettre en place un dockerfile. Ce dernier devra comporter un OS Linux et devra
executer un script python lors de son lancement.

**Partie 1 : Création du Dockerfile**

    FROM ubuntu
    COPY test.py test.py
    RUN apt-get update
    RUN apt-get install python -y
    CMD ["python", "test.py"]

file python

    print("Creation Dockerfile Exercice")

**Partie 2 : Construction de l'image**

Une fois que notre Dockerfile est crée nous devons nous rendre sur le chemin ou est situé ce dernier.

Après nous pouvons executer la commande suivante pour créer notre image

    docker build -t <IMAGE_NAME> .

On peut vérifier la création de notre image grâce à la commande suivante

    docker images

**Partie 3 : Execution de l'image**

Une fois que notre image est bien crée, nous pouvons exécuter cette dernière grâce à la commande

    docker run <IMAGE_NAME>

<span style="color: #ED1414 ">Le Dockerfile utilisé lors de cet exercice est présent sur mon DockerHub - *
pauledgarvaldes*</span>

## Docker - publication sur DockerHub <a name="partie4"></a>

Docker Hub est un service fourni par Docker pour les recherches et la publication d'images de conteneurs.

On peut y trouver des images open sources ou des images privées qui sont accessibles depuis des Hub privés. Ceci
facilite la diffusion d'image au sein d'une équipe.

Pour avoir accès au Docker Hub, il faut tout d'abord s'inscrire. Me concernant l'ensemble de mes images se trouveront
sur mon Hub **pauledgarvaldes**

Ensuite nous pouvons passer à la création de notre premier repository.

- Cliquer sur **Repositories** > **Create Repository**
- Name
- On renseigne si on veut que notre repository soit privé ou public.

Une fois notre repository crée nous pourrons réaliser les actions suivantes.

Récuperer notre image et lancer le conteneur ou lier une image existante à notre repository.

*Récupérer l'image et executer le conteneur*

    docker build -t <your_username>/<name-repo> .

*Lier une image existante à notre repository*

    docker tag <IMAGE_NAME> <your_username>/<name-repo>

Pour envoyer l'image sur le Hub

    docker search <IMAGE_NAME>

# II. Partie 2 : MongoDB

# III. Partie 3 : Travail à rendre

*Consigne : Développer un micro-service qui utilise pour la persistance des données MongoDB. Pour ce faire nous passerons par une image docker MongoDB et de notre service*

Pour réaliser ce projet, j'ai décidé de scinder ce dernier en trois étapes.

Nous retrouverons tout d'abord la création et la mise en place de notre projet spring boot. Ensuite nous récupérerons une image mongoDB. Pour finir nous allons lier l'image de notre service avec notre image MongoDB pour assurer la persistance des données.

- **Micro-Service** : projet spring boot

Lors de la création de mon projet j'ai tout d'abord installer les instances suivantes : 

> *Lombok*

>*Spring web*

> Spring Data MongoDB

Une fois le projet crée, j'ai pu commencer à développer la partie microservice.

Pour commencer j'ai crée une classe *Animaux*, cette dernière représentera l'ensemble des champs présent dans ma table Animaux de ma futur base de données. 

![animal-classe](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/class_animaux.PNG)

Une fois que ma classe est crée, je peux passer à la création de mon repository.

**Cette repository va me permettre d'encapsuler les données, de permettre la récupération et la recherche de ces dernières**

![repository](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/repository.PNG)

Après avoir réalisé ces deux étapes nous pouvons déclarer notre repository et mettre en place différentes requêtes qui permettront de visualiser au mieux le bon fonctionnement du projet. 

Pour ça j'ai opté pour deux types de requêtes :

- **GET** afficher le contenu de la table animaux.
- **POST** enregistrer un nouvel animal. 

![micro](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/micro_post_get.PNG)

Pour la suite du tp j'ai opté pour une solution un peu différente que celle vue en cours. 

Je crée dans le dossier *src/main/resources* un fichier *application.yml*. Ceci permet de renseigner le nom de ma future base de données, son host et le port.

    spring:
        data:
          mongodb:
            database: Animaux
            host; mongoValdes
            port: 27017

J'apporte ensuite les modifications au *pom.xml* comme vu en cours.

Enfin je crée à la racine du projet Spring notre Dockerfile

    FROM openjdk:8
    ADD target/springboot-mongo-docker.jar app.jar
    ENTRYPOINT ["java","-jar","app.jar"]

Je peux ensuite clean et install le projet

- **Docker**

Dans cette seconde partie nous allons nous tourner vers la création de nos images et la mise en route de nos conteneurs. 

Comme expliqué précédemment, nous aurons besoin d'une image Mongo et de l'image de notre projet spring. 

Pour récupérer la derniere image de Mongodb 

    docker pull mongo:latest

On lance notre conteneur mongo à partir de l'image téléchargée précédemment.

    docker run -d -p 27017:27017 --name mongoValdes mongo:latest

Ensuite on crée l'image de notre projet spring. Pour ça nous devons nous rendre à la racine du projet et exécuter la commande suivante

    docker build -t springboot:1.0 .

Nous pouvons ensuite lancer le conteneur de notre application depuis notre nouvelle image.

**Attention** la commande suivante permettra de lancer le conteneur de notre image spring mais aussi de la lier à notre conteneur mongo déja en route.

    docker run -p 8080:8080 --name springboot-mongodb --link mongoValdes:mongo -d springboot:1.0

Grâce au commande *docker images* et *docker ps* on peut vérifier que nos images on bien été installé et que les conteneurs sont bien lancés

![check](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/check.PNG)

On peut aussi vérifier que Mongo est bien lancé depuis un navigateur avec l'url "*localhost:27017*"
On peut aussi vérifier l'état de notre microservice depuis les logs.


    docker logs springboot-mongodb


- **Test du micro-service**

Pour tester le bon fonctionnement de notre micro-service, nous allons commencé par réaliser des requêtes depuis Postman. 

*Requête GET* 

![get](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/GET-Postman.PNG)

*Requête POST*

![post](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/POST-Postman.PNG)

On peut voir que l'ensemble de ces requêtes ont abouti. On peut vérifier le résultat directement depuis notre base de données Mongo.

Pour ce faire nous ouvrons un nouveau terminal et on exécute la commande suivante :

    docker exec -ti mongoValdes bash

Cette commande permet d'ouvrir un terminal de notre conteneur, ici notre conteneur Mongo

Une fois sur l'invite bash, nous pouvons entrer dans mongo à partir de la commande **mongo**

Lorsque nous sommes dans mongo, nous pouvons tout d'abord vérifier si notre base de données a bien été crée.

![check-mongo-2](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/check-in-mongo-2.PNG)

On peut ensuite nous rendre dans notre base données Animaux et dans la collection Animaux.

![check-mongo-3](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/check-in-mongo-3.PNG)

Enfin on peut afficher le contenu de la collection pour vérifier si nos requêtes ont bien aboutie

![check-mongo-4](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/check-in-mongo-4.PNG)

- **Partie supplémentaire : mise en place d'un docker-compose**

Un Docker Compose est un outil qui permet de décrire et de gérer plusieurs conteneurs comme un ensemble de services inter-connectés. 

Nous concernant le but de ce Docker Compose est de lier notre futur conteneur Mongo avec notre projet Spring. 

Pour ce faire, j'ai crée un un fichier *docker-compose.yml*.
Ce dernier peut se situer n'importe ou, me concernant je l'ai placé dans le répertoire *src/main/resources*

On retrouvera ci-dessous le contenu de mon docker compose. 

    version: "3.8"
    services:
        api-database:
            image: mongo:latest
            container_name: "api-database"
            ports: 
                -27017:27017
        api: 
            image: springboot:1.0
            container_name: "springboot-mongodb"
            ports:
                - 8081:8080
            links:
                - api-database

A ce moment, une fois que le docker compose est crée nous pouvons ouvrir un invite de commande à l'emplacement du docker file et on lance le docker compose avec la commande suivante :

    docker-compose up

Le point intéressant avec le docker compose c'est qu'il va chercher les images présentes dans le docker compose, si ces dernières ne sont pas sur notre pc il va essayer de les chercher sur le docker hub. 

Une fois que les images sont récupérées il va lancer les conteneurs et faire liens demandés.

![conteneurs-compose](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/conteneurs-compose.PNG)


- **Docker HUB**

Comme j'ai pu l'expliquer ci-dessus, le docker compose va chercher les images manquantes sur le Hub. 

Cependant notre image relative à notre microservice n'est pas encore présente sur le hub. 

Pour ce faire nous devons exécuter les commandes suivantes:

    docker login
    docker tag springboot:1.0 pauledgarvaldes/syoucef-mongoservice
    docker push pauledgarvaldes/syoucef-mongoservice

Vous pourrez retrouver mon image grâce au lien ci-dessous. 

https://hub.docker.com/repository/docker/pauledgarvaldes/syoucef-mongoservice


# Bilan du cours 

Me concernant, ce cours m'a permis d'apprendre énormément de notion sur la conteneurisation et sur Docker.

J'ai pu aussi me familiariser avec l'univers de MongoDB.

Enfin ce cours m'a également permit de mieux appréhender la notion de microservice et de leurs impacts.
