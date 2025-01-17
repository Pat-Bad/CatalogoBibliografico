package ArchivioBibliografico;

import java.util.Random;

public abstract class ElementoCatalogo implements controlloISBN {
    protected long ISBN;
    protected String titolo;
    protected int anno;
    protected int numeroPagine;

    //costruttore
    public ElementoCatalogo(long isbn, String titolo, int anno, int numeroPagine) {
        this.ISBN = isbn;
        this.titolo = titolo;
        this.anno = anno;
        this.numeroPagine = numeroPagine;
    }


    //metodi GET
    public long getISBN() {
        return this.ISBN;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return this.anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getNumeroPagine() {
        return this.numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    //metodi SET
    public void setISBN() {
        long isbn = new Random().nextLong();
        this.ISBN = isbn;
    }

    //metodo toString
    @Override
    public String toString() {
        return "L'elemento " + titolo + "è stato pubblicato " + anno
                + ".\n" + "Conta " + numeroPagine + "pagine." + "\n Il suo ISBN è " + ISBN;
    }

    //metodi astratti, comuni a libri e riviste
    public void searchISBN() {
    }

    public void searchYear() {
    }

    public void updatedElement() {
    }

    public void stampaTotale() {
    }

}
