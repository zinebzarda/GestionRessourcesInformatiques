# Système de Gestion des Ressources Informatiques

## Contexte du Projet
En tant que développeur full stack Java/Angular chez ITSolutions, vous êtes chargé de concevoir et de développer un système de gestion des équipements informatiques. Ce système permet la gestion des équipements, le suivi des pannes, la gestion des tickets de support et la génération de rapports et statistiques.

## Fonctionnalités

### Gestion des Équipements Informatiques
- **Ajouter des équipements** : Permet à l'administrateur IT d'ajouter de nouveaux équipements pour suivre leur état et leur utilisation.
- **Modifier des équipements** : Permet à l'administrateur IT de mettre à jour les informations des équipements existants.
- **Supprimer des équipements** : Permet à l'administrateur IT de supprimer des équipements obsolètes ou hors service.
- **Liste des équipements** : Affiche une liste de tous les équipements avec leur état actuel.

### Suivi des Pannes
- **Signaler une panne** : Permet à l'utilisateur de signaler une panne sur un équipement.
- **Enregistrer les pannes** : Permet à l'administrateur IT d'enregistrer les pannes détectées.
- **Suivi des réparations** : Permet à l'administrateur IT de suivre l'état des réparations pour chaque panne signalée.
- **Historique des pannes** : Permet à l'administrateur IT de consulter l'historique des pannes pour chaque équipement.

### Gestion des Tickets de Support
- **Créer un ticket de support** : Permet à l'utilisateur de créer un ticket pour signaler un problème technique.
- **Attribuer les tickets** : Permet à l'administrateur IT d'attribuer les tickets aux techniciens disponibles.
- **Voir les tickets attribués** : Permet au technicien IT de voir les tickets qui lui sont attribués.
- **Suivre l'état du ticket** : Permet à l'utilisateur de suivre l'état de son ticket de support.

### Rapports et Statistiques (Bonus)
- **Notifications des tickets en attente** : Permet à l'administrateur IT de recevoir des notifications pour les tickets en attente.
- **Statistiques des pannes** : Permet à l'administrateur IT de voir des statistiques sur les pannes.
- **Rapports sur l'état des équipements** : Permet à l'administrateur IT de générer des rapports sur l'état des équipements.
- **Rapports sur les performances du support** : Permet à l'administrateur IT de générer des rapports sur les performances du service de support.

## Fonctionnement
- **Équipements et Pannes** : Un équipement peut être associé à plusieurs pannes. Chaque panne est enregistrée dans l'entité Panne, liée à l'équipement concerné.
- **Historique des Pannes** : Conserve un enregistrement détaillé de toutes les pannes passées pour chaque équipement.
- **Tickets de Support** : Créés par les utilisateurs lorsqu'ils rencontrent des problèmes avec les équipements. Chaque ticket est lié à un utilisateur spécifique.
- **Attribution des Tickets** : Les tickets de support sont attribués à des techniciens pour résolution.
- **Génération des Rapports** : Inclut des informations sur les équipements, les pannes, et les tickets de support.

## Technologies Utilisées
- **Backend** : Spring Boot, Spring Data JPA, Spring Security
- **Frontend** : Angular 16
- **Base de données** : PostgreSQL / MySQL
- **Test unitaire** : JUnit
- **Conteneurisation** : Docker

## Installation et Déploiement

### Prérequis
- Java 11+
- Node.js
- Angular CLI
- Docker
- PostgreSQL / MySQL

### Backend
1. Clonez le repository :
   ```bash
   git clone https://github.com/votre-utilisateur/gestion-ressources-informatiques.git
   cd gestion-ressources-informatiques/backend
### Configurez votre base de données dans le fichier application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/votre_base_de_donnees
spring.datasource.username=VotreNomUtilisateur
spring.datasource.password=VotreMotDePasse
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
### Lancez l'application Spring Boot 
./mvnw spring-boot:run
### Installez les dépendances
npm install
### Lancez l'application Angular
ng serve
### Construisez et lancez les conteneurs Docker
docker-compose up --build
### Utilisation
Accédez à l'application via http://localhost:4200 pour l'interface utilisateur.
L'API backend est accessible via http://localhost:8080.
### Auteurs
Zarda Zineb - Développeur Full Stack - ITSolutions
