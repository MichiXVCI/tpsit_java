public class Libro {
        private String titolo;
        private String isbn;
        private Autore autore;
        private int prestiti;

        public Libro(String titolo, String isbn, Autore autore) {
            this.titolo = titolo;
            this.isbn = isbn;
            this.autore = autore;
        }

        public String getTitolo() {
            return titolo;
        }

        public void setTitolo(String titolo) {
            this.titolo = titolo;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public Autore getAutore() {
            return autore;
        }

        public void setAutore(Autore autore) {
            this.autore = autore;
        }

        @Override
        public String toString() {
            return "Libro{" +
                    "titolo='" + titolo + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", autore=" + autore.getNome() + " " + autore.getCognome() +
                    '}';
        }
}
