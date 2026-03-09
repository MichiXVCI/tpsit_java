import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    private String nome;
    private String indirizzo;

    HashMap<Libro, Integer> libri = new HashMap();

    public void newLibro(String titolo, String isbn, String nomeAutore, String cognomeAutore) {
        Libro libro = new Libro(titolo, isbn, new Autore(nomeAutore, cognomeAutore));
        libri.put(libro, 0);
    }
    public String prestito(String nomeLibro) {
        for (Libro libro : libri.keySet()) {
            if (libro.getTitolo().equals(nomeLibro)) {
                int prestiti = libri.get(libro);
                libri.put(libro, prestiti + 1);
                return "Prestito effettuato per il libro: " + nomeLibro;
            }
        }
        return "Libro non trovato: " + nomeLibro;
    }
    public String prestitiPiuAlto() {
        int maxPrestiti = 0;
        Libro libroPiuPrestato = null;
        for (Libro libro : libri.keySet()) {
            if (libri.get(libro) > maxPrestiti) {
                maxPrestiti = libri.get(libro);
                libroPiuPrestato = libro;
            }
        }
        if (libroPiuPrestato != null) {
            return "Il libro più prestato è: " + libroPiuPrestato.getTitolo() + " con " + maxPrestiti + " prestiti.";
        } else {
            return "Non ci sono libri prestati.";
        }
    }
    public String LibriScrittiDaAutore(String nomeAutore, String cognomeAutore) {
        ArrayList<Libro> libriDellAutore = new ArrayList<>();
        for (Libro libro : libri.keySet()) {
            if (libro.getAutore().getNome().equals(nomeAutore) && libro.getAutore().getCognome().equals(cognomeAutore)) {
                libriDellAutore.add(libro);
            }
        }
        if (!libriDellAutore.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Libri scritti da ").append(nomeAutore).append(" ").append(cognomeAutore).append(":\n");
            for (Libro libro : libriDellAutore) {
                sb.append("- ").append(libro.getTitolo()).append("\n");
            }
            return sb.toString();
        } else {
            return "Nessun libro trovato per l'autore: " + nomeAutore + " " + cognomeAutore;
        }
    }
    public String AutoreConPiuPrestiti() {
        HashMap<Autore, Integer> prestitiPerAutore = new HashMap<>();
        for (Libro libro : libri.keySet()) {
            Autore autore = libro.getAutore();
            int prestiti = libri.get(libro);
            prestitiPerAutore.put(autore, prestitiPerAutore.getOrDefault(autore, 0) + prestiti);
        }
        Autore autorePiuPrestato = null;
        int maxPrestiti = 0;
        for (Autore autore : prestitiPerAutore.keySet()) {
            if (prestitiPerAutore.get(autore) > maxPrestiti) {
                maxPrestiti = prestitiPerAutore.get(autore);
                autorePiuPrestato = autore;
            }
        }
        if (autorePiuPrestato != null) {
            return "L'autore con più prestiti è: " + autorePiuPrestato.getNome() + " " + autorePiuPrestato.getCognome() + " con " + maxPrestiti + " prestiti.";
        } else {
            return "Non ci sono autori con prestiti.";
        }
    }
    public Biblioteca(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String ListaLibri() {
        StringBuilder sb = new StringBuilder();
        for (Libro libro : libri.keySet()) {
            sb.append(libro.getTitolo()).append(" - Prestiti: ").append(libri.get(libro)).append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
        }

}
