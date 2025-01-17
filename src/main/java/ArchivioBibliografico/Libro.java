package ArchivioBibliografico;

public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;

    //costruttore
    public Libro(long ISBN, String titolo, int anno, int numeroPagine, String genere, String autore) {
        super(ISBN, titolo, anno, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    //metodi get
    public String getAutore() {
        return this.autore;
    }

    //metodi set
    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return this.genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    //toString
    @Override
    public String toString() {
        return "Titolo del libro: " + titolo
                + "\nAutore: " + autore
                + "\nAnno di pubblicazione: " + anno
                + "\nGenere: " + genere
                + "\nNumero di pagine: " + numeroPagine
                + "\nISBN: " + ISBN + "\n";
    }
}
