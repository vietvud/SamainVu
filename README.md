
# Scraper de Manga

Ce projet Java utilise la bibliothèque JSoup pour extraire des informations à partir de la page Web de SensCritique, qui répertorie les mangas les plus vendus au monde.

## Prérequis
- Java (version 8 ou supérieure)
- Maven

## Configuration du projet
1. Clonez le référentiel Git :
   ```bash
   git clone https://url-du-referentiel.git
Accédez au répertoire du projet :

bash
Copy code
cd nom-du-repertoire
Exécutez le projet à l'aide de Maven :

bash
Copy code
mvn clean install
Exécution du scraper
Exécutez la classe principale depuis la ligne de commande :

bash
Copy code
java -cp target/nom-du-jar.jar org.example.Main
Assurez-vous de remplacer nom-du-jar.jar par le nom réel du fichier JAR généré.

Le scraper récupérera les informations depuis la page web et les affichera dans la console.

Exportation vers un fichier CSV
Le programme exportera les données dans un fichier CSV nommé output.csv dans le répertoire du projet.
Note : Assurez-vous que les dépendances Maven sont correctement téléchargées et configurées avant d'exécuter le projet.
