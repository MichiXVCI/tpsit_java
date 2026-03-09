// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Comunale", "Via Roma 1");
        biblioteca.newLibro("Il Signore degli Anelli", "978-0544003415","J.R.R.", "Tolkien");
        biblioteca.prestito("Il Signore degli Anelli");
        biblioteca.newLibro("Il Signore degli Anelli2", "978-0544003415","J.R.R.", "Tolkien");
        System.out.println(biblioteca.ListaLibri());
        System.out.println(biblioteca.prestitiPiuAlto());
        System.out.println(biblioteca.AutoreConPiuPrestiti());
        System.out.println(biblioteca.LibriScrittiDaAutore("J.R.R.", "Tolkien"));
    }
}