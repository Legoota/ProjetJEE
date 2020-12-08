# JavaGraph<img align="right" width="200" height="100" src="https://github.com/Legoota/ProjetJEE/blob/master/logo.png" alt="Logo Polymon">
---
### Summary

4<sup>th</sup> year project at the Polytech Nancy's Engineering School.
The main goal was to realise a JEE application about fighting monsters.

---
### Features

###### TBA:
* Add healing system
* Add dodge probability
* Redo image storage
* Add other parcours
* Add the possibility to change attacks

###### Working:
* Account creation
* Account logging
* NoSQL database storage
* List of *Attaque* for each *Polymons*
* Create *Parcours* choices
* Create *Parcours* system
* Create Duel system
* User page (choice of Polymon, new game, continue, ...)

---
### Installation

###### Java project:
* Clone the repository
* Run the project using the server configuration
* Call the *http://localhost:8080/Projet-1.0/admin* endpoint to fill database

###### Server settings:
* Download and install the latest version of [Wildfly](https://www.wildfly.org/)
* Create a new Run configuration with JBoss local settings
* Deploy both artifacts

###### RavenDB settings:
* Download and install *RavenDB v5*
* Configure *RavenDB* on port 8888
* Create a *jee* database
---
### Authors
* Léo Boulard
* Léo Krebs
###### Dependencies:
* [RavenDB](https://ravendb.net/)

---
### UML diagram
![UML](https://github.com/Legoota/ProjetJEE/blob/master/UML.png?raw=true)
