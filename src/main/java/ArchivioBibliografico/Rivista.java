package ArchivioBibliografico;

public class Rivista extends ElementoCatalogo {
    private String periodicita;

    //costruttore
    public Rivista(String periodicita, long isbn, String titolo, int anno, int numeroPagine) {
        super(isbn, titolo, anno, numeroPagine);
        this.periodicita = periodicita;
    }

    //metodo GET
    public String getPeriodicita() {
        return this.periodicita;
    }

    //metodo SET
    public void setPeriodicita(String periodicita) {
        this.periodicita = periodicita;
    }

    //toString
    @Override
    public String toString() {
        return "La rivista " + titolo + " è stata pubblicata nel " + anno
                + " e ha una pubblicazione " + periodicita
                + ". Le pagine della rivista sono " + numeroPagine
                + "\nIl suo ISBN è " + ISBN + "\n";

    }

}
