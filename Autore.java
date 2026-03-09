public class Autore {
    private String nome;
    private String cognome;
    private int libriScritti = 0;

    public Autore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        libriScritti++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
