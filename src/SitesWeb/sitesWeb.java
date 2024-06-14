import java.util.*;

public class sitesWeb {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tamanho = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha após o inteiro

        Lista<WebSites> sites = new Lista<>(tamanho);

        for (int i = 0; i < tamanho; i++) {
            String linha = scanner.nextLine();
            String[] partes = linha.split(" - ");
            String nome = partes[0];
            String endereco = partes[1];
            WebSites site = new WebSites(nome, endereco);
            sites.inserir(site, i);
        }

        String entrada;
        while (!(entrada = scanner.nextLine()).equals("FIM")) {
            WebSites site = new WebSites(entrada, "");
            sites.search(site);
        }

        sites.imprimir();
    }
}

class Lista<E> {

    private final E[] lista;
    private int ultimo;

    @SuppressWarnings("unchecked")
    public Lista(int tamanho) {
        lista = (E[]) new Object[tamanho];
        this.ultimo = 0;
    }

    public boolean vazia() {
        return (this.ultimo == 0);
    }

    public boolean cheia() {
        return (this.ultimo == this.lista.length);
    }

    public void inserir(E novo, int posicao) {
        if (cheia()) {
            throw new IllegalStateException("Não foi possível inserir o item na lista: a lista está cheia!");
        }

        if ((posicao < 0) || (posicao > this.ultimo)) {
            throw new IndexOutOfBoundsException(
                    "Não foi possível inserir o item na lista: a posição informada é inválida!");
        }

        for (int i = this.ultimo; i > posicao; i--) {
            lista[i] = lista[i - 1];
        }

        lista[posicao] = novo;
        this.ultimo++;
    }

    public E remover(int posicao) {
        if (vazia()) {
            throw new IllegalStateException("Não foi possível remover o item da lista: a lista está vazia!");
        }

        if ((posicao < 0) || (posicao >= this.ultimo)) {
            throw new IndexOutOfBoundsException(
                    "Não foi possível remover o item da lista: a posição informada é inválida!");
        }

        E removido = lista[posicao];
        for (int i = posicao; i < this.ultimo - 1; i++) {
            lista[i] = lista[i + 1];
        }

        lista[--this.ultimo] = null;
        return removido;
    }

    public void moverParaInicio(int posicao) {
        if (vazia()) {
            throw new IllegalStateException("Erro ao movimentar item: a lista está vazia!");
        }

        if ((posicao < 0) || (posicao >= this.ultimo)) {
            throw new IndexOutOfBoundsException("Erro ao movimentar item: posição inválida!");
        }

        E item = lista[posicao];
        for (int i = posicao; i > 0; i--) {
            lista[i] = lista[i - 1];
        }

        lista[0] = item;
    }

    public void search(E item) {
        if (vazia()) {
            System.out.println("O item procurado nao foi encontrado!");
            return;
        }

        for (int i = 0; i < this.ultimo; i++) {
            WebSites webSites = (WebSites) lista[i];

            if (webSites.getUrl().equals(((WebSites) item).getUrl())) {
                webSites.countMais();
                moverParaInicio(i);
                System.out.println(webSites.getLink());
                return;
            }
        }
        System.out.println("O item procurado nao foi encontrado!");
    }

    public void imprimir() {
        for (int i = 0; i < this.ultimo; i++) {
            WebSites webSites = (WebSites) lista[i];
            System.out.println("Nome: [" + webSites.getUrl() + "]");
            System.out.println("Endereco: [" + webSites.getLink() + "]");
            System.out.println("Numero de acessos: " + webSites.count());
        }
    }
}

class WebSites {
    private final String url;
    private final String link;
    private int count;

    public WebSites(String url, String link) {
        this.url = url;
        this.link = link;
        this.count = 0;
    }

    public String getUrl() {
        return url;
    }

    public String getLink() {
        return link;
    }

    public int count() {
        return count;
    }

    public void countMais() {
        count++;
    }
}
