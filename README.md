# Big_Data

### 1er session : 22/11/2021

------------------------

### Table de sommaire 

1. [Théorie - Docker](#partie1)
    1. [Hyperviseur / Conteneurisation](#H&C)
    2. [Docker](#Docker)
2. [Docker - commande de base](#partie2)
3. [Docker - création de son image](#partie3)
    1. [Docker commit](#Commit)
    2. [Dockerfile](#Dockerfile)
4. [Docker - publication sur DockerHub](#partie4)

------------------------

## Théorie - Docker <a name="partie1"></a>

#### Introduction <a name="H&C"></a>

#### Hyperviseur / Conteneurisation <a name="H&C"></a>

Nous allons voir dans cette partie les différences entre un conteneur et les VM classique

Une machine virtuelle (VM) recrée intégralement un serveur (OS, fichiers système, application). Comparé à cette dernière, le conteneur n'embarque pas d'OS, il est donc plus léger.

Il est donc plus facile à migrer/télécharger et est plus rapide à sauvegarder et à migrer. 

![VM_CONTE](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/vm_conte.png)

#### Docker <a name="Docker"></a>

Docker est une technologie de virtualisation par conteneurs reposant sur LXC.

Il permet de créer des conteneurs qui vont uniquement contenir des applications avec leurs dépendances. Il nous permet donc d'embarquer des applications afin de les exécuter au sein de l'OS hôte mais de manière isolée.

![docker_engine](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/Dockerengine.PNG)

Il est intéressant de connaître aussi la méthode de fonctionnement de Docker et son architecture.
Cette dernière repose sur le Docker engine qui va faire tourner les conteneurs et joue le rôle de contrôleur.
En terme d'architecture, docker repose sur une architecture client/serveur.

![client-server](https://github.com/Paul-Edgar/Big_Data/blob/main/photo/dockerarchi.PNG)

## Docker - commande de base  <a name="partie2"></a>


    docker run <IMAGE_NAME>

Cette commande permet de créer et de démarrer une nouvelle instance de l'image.
Si cette dernière n'existe pas sur notre PC, elle sera directement téléchargé depuis le Docker HUB.
Il peut être intéressant de rechercher sur le HUB l'image souhaité avant. 

- - -

    docker run -d <IMAGE_NAME>

Cette commande permet de démarrer le conteneur que l'on à crée précédemment.

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

Supprimer une image
Attention si elle ne veut pas se supprimer on peut forcer avec la commande 

    docker rmi -f <REPOSITORY_NAME>

Ceci peut arriver si des conenteneurs sont encore en marche et qu'ils ont été lancé par l'image. 

---

Dans le cas suivant, si l'on souhaite démarrer un conteneur et que l'on veut rediriger le port de l'applicatio sur notre conteneur vers un port de notre pc.

    docker run -d -p 9999:80 nginx

- 9999 : port sur notre machine
- 80 : port de l'appli dans le conteneur 
- nginx : le service lancé



## Docker - création de son image <a name="partie3"></a>

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

## Docker - publication sur DockerHub <a name="partie4"></a>

Docker Hub est un service fourni par Docker pour les recherches et la publication d'images de conteneurs.

On peut y trouver des images open sources ou des images privées qui sont accessibles depuis des Hub privés. Ceci facilite la diffusion d'image au sein d'une équipe. 

Pour avoir accès au Docker Hub, il faut tout d'abord s'inscrire. Me concernant l'ensemble de mes images se trouveront sur mon Hub **pauledgarvaldes**

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

