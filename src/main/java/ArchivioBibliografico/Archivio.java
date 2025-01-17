package ArchivioBibliografico;

import java.util.*;
import java.util.stream.Collectors;

//In questa classe inserirò il main. Implemento l'eccezione custom e l'interfaccia funzionale
public class Archivio implements controlloISBN, filtraggio {
    private final Set<Libro> listaLibri = new HashSet<>();

    public void aggiungiLibro(long isbn) throws isbnException {
        //controllo isbn prima di aggiungere un libro
        if (listaLibri.stream().anyMatch(libro -> libro.getISBN() == isbn))
            throw new isbnException("ISBN già presente!");

        //se non c'è, chiedo i dati per inserirlo...
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il titolo del libro:");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci l'anno di pubblicazione:");
        int anno = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci il numero di pagine:");
        int numeroPagine = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci il genere:");
        String genere = scanner.nextLine();
        System.out.println("Inserisci l'autore:");
        String autore = scanner.nextLine();
        
//try/catch perché potrebbe verificarsi un'eccezione
        try {
            Libro nuovoLibro = new Libro(isbn, titolo, anno, numeroPagine, genere, autore);
            listaLibri.add(nuovoLibro);
            System.out.println("Libro aggiunto con successo!");
        } catch (Exception e) {
            System.out.println("Errore durante l'aggiunta del libro: " + e.getMessage());
        }
    }

    @Override
    public void filtra() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Che anno vuoi cercare?");
        int annoCercato = scanner.nextInt();
        scanner.nextLine(); //ho visto che consigliano di metterlo

        Set<Libro> filtroPerAnno = listaLibri.stream()
                .filter(x -> x.getAnno() == annoCercato)
                .collect(Collectors.toSet());
        System.out.println("Libri trovati per l'anno " + annoCercato + ": " + filtroPerAnno);

        System.out.println("Che autore vuoi cercare?");
        String autoreCercato = scanner.nextLine();
        List<Libro> filtroPerAutore = listaLibri.stream()
                .filter(x -> x.getAutore().equals(autoreCercato))
                .collect(Collectors.toList());
        System.out.println("Libri trovati per l'autore " + autoreCercato + ": " + filtroPerAutore);
    }

    public static void main(String[] args) throws isbnException {
        Archivio archivio = new Archivio();
        try {

            Libro book1 = new Libro(12121212, "Lettere dal carcere", 1971, 293, "Saggistica", "Antonio Gramsci");
            Libro book2 = new Libro(454545455, "La mente bicamerale e l'origine della coscienza", 1976, 554, "Saggistica", "Julian Jaynes");
            archivio.listaLibri.add(book1);
            archivio.listaLibri.add(book2);

            // Chiedo all'utente di inserire un libro
            Scanner scanner = new Scanner(System.in);
            System.out.println("Scrivi l'ISBN del libro che vuoi aggiungere");
            long isbn = scanner.nextLong();
            archivio.aggiungiLibro(isbn);

            //creo altri elementi
            Libro book3 = new Libro(951357, "L'arte di bere Coca-Cola", 2024, 20, "Saggistica", "Babbo Natale");
            Libro book4 = new Libro(82642648, "Aliens and Pizza", 1965, 369, "Saggistica", "Ashton Star");
            Rivista rivista3 = new Rivista("Mensile", 147963258, "Focus", 2003, 27);

            List<ElementoCatalogo> listaElementiCatalogo = Arrays.asList(book3, book4, rivista3);

            System.out.println("Totale articoli: " + listaElementiCatalogo.size());
            System.out.println("Numero di libri: " +
                    listaElementiCatalogo.stream().filter(e -> e instanceof Libro).count());
            System.out.println("Numero di riviste: " +
                    listaElementiCatalogo.stream().filter(e -> e instanceof Rivista).count());
            System.out.println("Media pagine: " +
                    listaElementiCatalogo.stream().mapToInt(ElementoCatalogo::getNumeroPagine).average().orElse(0.0));

            //provo il filtraggio
            archivio.filtra();

            //chiudo lo scanner
            scanner.close();
        } catch (isbnException e) {
            System.out.println("Errore ISBN: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }
}