# 💻 TP3 — Serveur Multi-threads et Sockets TCP

<p align="center">
  <img src="https://img.shields.io/badge/Java-JDK%208%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Protocol-TCP-2563EB?style=for-the-badge" alt="TCP"/>
  <img src="https://img.shields.io/badge/Architecture-Client--Serveur-7C3AED?style=for-the-badge" alt="Client Server"/>
  <img src="https://img.shields.io/badge/Multithreading-Threads-0891B2?style=for-the-badge" alt="Multithreading"/>
  <img src="https://img.shields.io/badge/Status-Completed-16A34A?style=for-the-badge" alt="Project status"/>
</p>

<p align="center">
  <strong>Travaux pratiques de Développement d'applications réparties</strong>
  <br/>
  <em>Conception et réalisation d'un serveur TCP multithread capable de gérer plusieurs clients et d'assurer des échanges de données en Java.</em>
</p>

<p align="center">
  <a href="#-présentation">Présentation</a> •
  <a href="#-objectifs-pédagogiques">Objectifs</a> •
  <a href="#-activités">Activités</a> •
  <a href="#-technologies-utilisées">Technologies</a> •
  <a href="#-structure-du-projet">Structure</a> •
  <a href="#-exécution">Exécution</a> •
  <a href="#-ressources">Ressources</a>
</p>

---

## 📌 Présentation

Ce dépôt regroupe les deux activités du **TP3 de Développement d'applications réparties (DAR)**, réalisées en Java dans le cadre de la formation en Licence 3 Sciences de l'Informatique à la Faculté des Sciences de Sfax.

Ce TP porte sur la mise en œuvre d'un **serveur multithread utilisant les sockets TCP**. Il permet d'étudier la gestion de plusieurs connexions clientes, le traitement indépendant des requêtes et la communication par échange d'objets Java.

Les deux activités suivent une progression : la première introduit le traitement multithread des connexions TCP, tandis que la seconde enrichit cette architecture par l'intégration d'une calculatrice distribuée et d'un compteur global partagé.

## 🎯 Objectifs pédagogiques

- Comprendre le fonctionnement des sockets en mode connecté TCP.
- Mettre en œuvre un serveur capable d'accepter plusieurs connexions clientes.
- Utiliser les threads pour traiter indépendamment les clients.
- Comprendre la sérialisation et la désérialisation des objets Java.
- Réaliser une communication client-serveur basée sur l'échange d'objets.
- Partager une donnée globale entre plusieurs threads.
- Synchroniser l'accès à une ressource partagée à l'aide de `synchronized`.
- Tester et documenter une application répartie.

---

## 🚀 Activités

<table>
  <thead>
    <tr>
      <th>Activité</th>
      <th>Description</th>
      <th>Code source</th>
      <th>Compte rendu</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>A3.1</strong></td>
      <td>Serveur TCP multithread : acceptation et gestion de plusieurs clients.</td>
      <td><a href="src/act1/">📂 Consulter</a></td>
      <td><a href="reports/dev%20app%20rep%20tp3%20a3.1.pdf">📄 PDF</a></td>
    </tr>
    <tr>
      <td><strong>A3.2</strong></td>
      <td>Amélioration de la calculatrice : échange d'objets Java, traitement multithread et compteur global synchronisé.</td>
      <td><a href="src/act2/">📂 Consulter</a></td>
      <td><a href="reports/dev%20app%20rep%20tp3%20a3.2.pdf">📄 PDF</a></td>
    </tr>
  </tbody>
</table>

### 🌐 Activité 3.1 — Acceptation de plusieurs clients

Cette activité consiste à développer un serveur TCP multithread capable d'accepter plusieurs connexions clientes.

Lorsqu'un client se connecte, le serveur accepte sa connexion et crée un thread indépendant pour assurer son traitement. Le serveur peut ainsi continuer à accepter de nouvelles connexions sans attendre la fin du traitement du client précédent.

**Fonctionnalités principales :**

- Écoute des connexions sur le port TCP `1234`.
- Acceptation des connexions avec `ServerSocket.accept()`.
- Identification des clients connectés.
- Récupération de l'adresse distante avec `getRemoteSocketAddress()`.
- Création d'un thread pour chaque client.
- Envoi du numéro d'ordre attribué à chaque client.

**Notions abordées :**

- `ServerSocket` et `Socket`.
- Protocole TCP.
- `Thread` et `Runnable`.
- Méthodes `start()` et `run()`.
- Communication client-serveur avec les flux Java.

**Code source :** [`src/act1/`](src/act1/)

### 🧮 Activité 3.2 — Amélioration de la calculatrice

Cette activité consiste à enrichir l'application client-serveur par l'échange d'objets Java et l'intégration d'un service de calcul dans une architecture multithread.

Le client crée un objet `Operation` contenant les deux opérandes et l'opérateur mathématique, puis le transmet au serveur. Celui-ci reçoit l'objet, effectue le calcul et renvoie le résultat au client sous forme textuelle.

Un compteur global est également partagé entre les différents traitements clients. Son accès est synchronisé afin d'éviter les conflits lors des accès concurrents.

**Fonctionnalités principales :**

- Création d'un objet `Operation` sérialisable.
- Envoi de l'objet avec `ObjectOutputStream.writeObject()`.
- Réception et désérialisation avec `ObjectInputStream.readObject()`.
- Exécution des opérations mathématiques : addition, soustraction, multiplication et division.
- Retour du résultat sous forme de texte avec `PrintWriter.println()`.
- Lecture du résultat avec `BufferedReader.readLine()`.
- Gestion d'un compteur global partagé entre les threads.
- Synchronisation de l'incrémentation du compteur avec `synchronized`.

**Notions abordées :**

- Interface `Serializable`.
- Sérialisation et désérialisation.
- `ObjectOutputStream` et `ObjectInputStream`.
- Serveur multithread.
- Variables et méthodes `static`.
- Synchronisation des threads.

**Code source :** [`src/act2/`](src/act2/)

---

## 🛠️ Technologies utilisées

| Technologie / Outil | Utilisation |
|---|---|
| **Java (JDK 8+)** | Langage de programmation |
| **TCP Sockets** | Communication client-serveur |
| **Java I/O** | Échange de données et gestion des flux |
| **Java Serialization** | Échange d'objets Java |
| **Multithreading** | Traitement indépendant des clients |
| **IntelliJ IDEA** | Environnement de développement |
| **Git** | Gestion des versions |
| **GitHub** | Hébergement du code source |

---

## 📁 Structure du projet

```text
TP3-DAR2026/
│
├── src/
│   │
│   ├── act1/
│   │   ├── server/
│   │   │   ├── Serveur.java
│   │   │   └── ClientProcess.java
│   │   │
│   │   └── client/
│   │       └── Client.java
│   │
│   └── act2/
│       ├── client/
│       │   └── ClientObjet.java
│       │
│       ├── op/
│       │   └── Operation.java
│       │
│       └── serveur/
│           ├── ServeurObjet.java
│           └── ClientProcess.java
│
├── Resources/
│   ├── dev app rep tp3 a3.1.pdf
│   └── dev app rep tp3 a3.2.pdf
│
└── README.md
```

---

## ▶️ Exécution

### Prérequis

- Installer un JDK Java version 8 ou supérieure.
- Disposer d'un environnement de développement tel qu'IntelliJ IDEA.
- Ouvrir le projet `TP3-DAR2026`.

### Activité 3.1 — Serveur multithread

1. Ouvrir le projet dans IntelliJ IDEA.
2. Exécuter la classe `Serveur` du package `act1.server`.
3. Vérifier que le serveur écoute sur le port `1234`.
4. Exécuter la classe `Client` du package `act1.client`.
5. Lancer plusieurs instances du client pour tester les connexions simultanées.
6. Observer les messages affichés dans les consoles du serveur et des clients.

### Activité 3.2 — Calculatrice par échange d'objets

1. Exécuter la classe `ServeurObjet` du package `act2.serveur`.
2. Vérifier que le serveur est démarré et en attente de connexions.
3. Exécuter la classe `ClientObjet` du package `act2.client`.
4. Saisir les deux opérandes et l'opérateur mathématique.
5. Observer le résultat retourné par le serveur.
6. Lancer plusieurs instances de `ClientObjet` pour tester le traitement simultané.
7. Vérifier l'incrémentation du compteur global dans la console du serveur.

> **Remarque :** pour exécuter plusieurs clients simultanément dans IntelliJ IDEA, activer l'option `Allow multiple instances` dans la configuration d'exécution de la classe cliente.

> **Communication sur réseau local :** pour effectuer un test entre plusieurs machines, adapter l'adresse IP utilisée par le client afin qu'elle corresponde à celle de la machine hébergeant le serveur. Les machines doivent pouvoir communiquer sur le réseau et le port TCP utilisé doit être accessible.

---

## 📚 Ressources

Les comptes rendus des deux activités sont disponibles au format PDF dans le dossier [`Resources/`](Resources/).

| Document | Description |
|---|---|
| [Compte rendu — Activité 3-1 (PDF)](reports/dev%20app%20rep%20tp3%20a3.1.pdf) | Réalisation et tests du serveur TCP multithread. |
| [Compte rendu — Activité 3-2 (PDF)](reports/dev%20app%20rep%20tp3%20a3.2.pdf) | Amélioration de la calculatrice et échange d'objets Java. |

---

## 👩‍💻 Auteur

**Eya Chikhaoui**  
Licence 3 — Sciences de l'Informatique (LSI 3)  
Faculté des Sciences de Sfax

---

<p align="center">
  <strong>TP3 — Développement d'applications réparties</strong>
  <br/>
  <sub>Java • TCP Sockets • Multithreading • Sérialisation • Synchronisation • GitHub</sub>
</p>
