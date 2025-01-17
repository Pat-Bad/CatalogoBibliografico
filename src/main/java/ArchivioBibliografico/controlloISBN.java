package ArchivioBibliografico;

import java.util.List;
import java.util.Scanner;

public interface controlloISBN {
    static void checkISBN(List<ElementoCatalogo> pubblicazioni) throws isbnException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'ISBN da cercare");
        long ISBN = scanner.nextLong();

        for (ElementoCatalogo pubblicazione : pubblicazioni) {
            if (pubblicazione.getISBN() == ISBN) {
                throw new isbnException("ISBN già presente");
            } else {
                System.out.println("ISBN non trovato, scegli se aggiungere un libro o una rivista");
                String scelta = scanner.nextLine();
                if (scelta.equals("libro")) {
                    System.out.println("Torna al menu principale per aggiungere un libro");
                } else if (scelta.equals("rivista")) {
                    System.out.println("Torna al menu principale per aggiungere una rivista");
                }
            }
        }
    }
}