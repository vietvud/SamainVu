package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://www.senscritique.com/liste/top_des_mangas_les_plus_vendus_au_monde/1458868";
        Document document = Jsoup.connect(url).get();

        // Titre
        List<Element> title = document.getElementsByClass("sc-e6f263fc-0 sc-a0949da7-1 cTitej eGjRhz sc-4495ecbb-3 hCRsTs");

        // Auteur
        List<Element> author = document.getElementsByClass("sc-e6f263fc-0 sc-4495ecbb-4 iZcnfI bJSVfr");

        // Date de sortie
        List<Element> releaseDate = document.getElementsByClass("sc-e6f263fc-0 sc-4495ecbb-10 GItpw gQNAqO");

        // Note/Rating
        List<Element> rating = document.getElementsByClass("sc-8251ce8c-5 bVyLNx globalRating");

        // Créer un objet FileWriter pour écrire dans le fichier CSV
        FileWriter csvWriter = new FileWriter("output.csv");

        // Écrire la ligne d'en-tête dans le fichier CSV
        csvWriter.append("Title,Author,Release Date,Rating\n");

        // Trouver la longueur minimale des listes pour éviter IndexOutOfBoundsException
        int minLength = Math.min(Math.min(title.size(), author.size()), Math.min(releaseDate.size(), rating.size()));

        // Boucle pour itérer à travers chaque élément manga et écrire les informations dans le fichier CSV
        for (int i = 0; i < minLength; i++) {
            String mangaTitle = title.get(i).text();
            String mangaAuthor = author.get(i).text();
            String mangaReleaseDate = releaseDate.get(i).text();
            String mangaRating = rating.get(i).text();

            // Écrire les informations du manga dans le fichier CSV
            csvWriter.append(mangaTitle)
                    .append(",")
                    .append(mangaAuthor)
                    .append(",")
                    .append(mangaReleaseDate)
                    .append(",")
                    .append(mangaRating)
                    .append("\n");
        }

        // Fermer le FileWriter
        csvWriter.close();
    }
}
