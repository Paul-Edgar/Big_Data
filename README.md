# Big_Data

### 1er session : 22/11/2021

------------------------

### Table de sommaire 

1. [Théorie - Docker](#partie1)
    1. [Hyperviseur / Conteneurisation](#H&C)
    2. [Docker](#Docker)

2. [Docker - création de son image](#partie2)
    1. [Docker commit](#Commit)
    2. [Dockerfile](#Dockerfile)
3. [Docker - publication sur DockerHub](#partie3)

------------------------

## Théorie - Docker <a name="partie1"></a>

#### Introduction <a name="H&C"></a>

#### Hyperviseur / Conteneurisation <a name="H&C"></a>

Nous allons voir dans cette partie les différences entre un conteneur et les VM classique

Une machine virtuelle (VM) recrée intégralement un serveur (OS, fichiers système, application). Comparé à cette dernière, le conteneur n'embarque pas d'OS, il est donc plus léger.

Il est donc plus facile à migrer/télécharger et est plus rapide à sauvegarder et à migrer. 

<center>PHOTO du prof</center>

#### Docker <a name="Docker"></a>

Docker est une technologie de virtualisation par conteneurs reposant sur LXC.

Il permet de créer des conteneurs qui vont uniquement contenir des applications avec leurs dépendances. Il nous permet donc d'embarquer des applications afin de les exécuter au sein de l'OS hôte mais de manière isolée.

Il est intéressant de connaître aussi la méthode de fonctionnement de Docker et son architecture.
Cette dernière repose sur le Docker engine qui va faire tourner les conteneurs et joue le rôle de contrôleur.
En terme d'architecture, docker repose sur une architecture client/serveur.

## Docker - création de son image <a name="partie2"></a>

#### Docker commit <a name="Commit"></a>

#### Dockerfile <a name="Dockerfile"></a>

Pour continuer dans cette partie de création d'image, nous pouvons nous tourner vers les Dockerfiles.

Les Dockerfiles sont des fichiers textes décrivant différentes étapes de création d'un conteneur. Cette méthode peut-être très intéressante si l'on souhaite ajouter différentes packages en préalable ou automatiser des tâches lors du lancement de notre conteneur.

Ce dernier doit être composé :

- **OS de base**
- **Installer les pré-requis du système**
- **Installer les packages necessaires**

Dans notre cas nous allons essayer de mettre en place un dockerfile. Ce dernier devra comporter un OS Linux et devra executer un script python lors de son lancement.

**Partie 1 : Création du Dockerfile**

**Partie 2 : Construction de l'image**

Une fois que notre Dockerfile est crée nous devons nous rendre sur le chemin ou est situé ce dernier.

Après nous pouvons executer la commande suivante pour créer notre image

    docker build -t <IMAGE_NAME> .

On peut vérifier la création de notre image grâce à la commande suivante 

    docker images


**Partie 3 : Execution de l'image**

Une fois que notre image est bien crée, nous pouvons exécuter cette dernière grâce à la commande 

    docker run <IMAGE_NAME>

<span style="color: #ED1414 ">Le Dockerfile utilisé lors de cet exercice est présent sur mon DockerHub - *pauledgarvaldes*</span> 

## Docker - publication sur DockerHub <a name="partie3"></a>

