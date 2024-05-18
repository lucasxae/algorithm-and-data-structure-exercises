package SitesWeb;

public class sitesWeb {

    private int tamanho = 100;

    public static void main(String[] args) {
        readLinks("Coursera - https://www.coursera.org");
    }

    public String saveLinks(String link) {
        int posicao = 0;
        Lista<String> links = new Lista<>(tamanho);
        if (posicao > tamanho)
            return "Lista Lotada!";

        links.inserir(link, posicao);
        posicao++;

        return "";
    }

    public static String readLinks(String links) {
        String[] url = links.split(" - ");
        String urlValue = url[2];

        return urlValue;
    }
}