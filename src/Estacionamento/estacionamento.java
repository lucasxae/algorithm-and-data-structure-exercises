// Considere um estacionamento que contém uma única alameda onde veículos são estacionados. 
// Os carros entram pela extremidade sul do estacionamento e saem pela extremidade norte. 
// Se chegar um cliente para retirar seu veículo, e esse não estiver estacionado na posição do extremo-norte, 
// todos os carros ao norte do veículo desejado serão deslocados para fora do estacionamento, o veículo desejado 
// sairá do estacionamento e os outros carros voltarão à mesma posição relativa em que se encontravam anteriormente estacionados.
//  Sempre que um carro deixa o estacionamento, todos os carros ao sul são deslocados para frente de modo que, o tempo inteiro, 
//  todas as vagas desocupadas estão sempre na parte sul do estacionamento.
// Em uma classe Estacionamento, em Java, escreva um programa que leia uma sequência de comandos da entrada padrão e processe-os. 
// Cada linha da entrada padrão deve conter um ‘C’, de chegada; ou um ‘P’, de partida. Considere que, em cada linha, após um ‘C’ ou um ‘P’,
//  será sempre informado o número da placa do veículo ao qual a operação de chegada ou partida refere-se. Presume-se que os carros chegarão
//   ou partirão na ordem especificada pela entrada padrão. A última linha da entrada padrão corresponde à palavra ‘FIM’.

// Sua classe Estacionamento deve resolver o problema descrito anteriormente empregando, obrigatoriamente, 
// filas implementadas por meio de células auto-referenciadas.

// Seu programa deve emitir uma mensagem toda vez que um veículo chegar ou partir do estacionamento. 
// Quando um carro partir do estacionamento, a mensagem deverá incluir o número de vezes que o veículo foi manobrado
// no estacionamento para permitir a saída de outros carros. Caso seja solicitada a retirada do estacionamento de um veículo 
// que não foi estacionado anteriormente, ou que já saiu do estacionamento, uma mensagem também deve ser emitida. 
// Ao final, devem ser impressas as placas dos veículos que permaneceram no estacionamento.

// Observe a saída padrão fornecida nesse exercício para a impressão das mensagens adequadas.

 package Estacionamento;

import java.util.Scanner;

public class estacionamento {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String placaDoCarroComando = scanner.nextLine();

        while (!placaDoCarroComando.equals("FIM")) {
            controleEstacionamento(placaDoCarroComando);
            placaDoCarroComando = scanner.nextLine();
        }
        if (placaDoCarroComando.equals("FIM")) {
            while (!fila.vazia()) {
                System.out.println(fila.desenfileirar().placa);
            }
        }
    }

    private static int contador = 0;

    private static Fila<Carro> fila = new Fila<>();

    public static void controleEstacionamento(String placaDoCarroComando) {
        String[] funcao = placaDoCarroComando.split(" ");
        String placaCarro = funcao[1] + " " + funcao[2];

        if (funcao[0].equals("C")) {
            Estacionar(placaCarro);
        } else if (funcao[0].equals("P")) {
            Partir(placaCarro);
        }
    }

    public static void Estacionar(String placaDoCarro) {
        Carro car = new Carro(placaDoCarro);
        fila.enfileirar(car);
        System.out.println("Carro de placa " + placaDoCarro + " entrou no estacionamento.");
    }

    public static void Partir(String placaDoCarro) {
        Carro[] saveCar = new Carro[200];
        int i = 0;
        int j = 0;
        boolean entrou = false;

        if (!fila.consultarPrimeiro().getPlaca().equals(placaDoCarro)) {
            while (fila.consultarPrimeiro() != null) {
                if (fila.consultarPrimeiro().getPlaca().equals(placaDoCarro)) {
                    j++;
                    entrou = true;
                    System.out.println("Carro de placa " + placaDoCarro + " saiu do estacionamento.");
                    System.out.println("Esse carro foi manobrado " + fila.desenfileirar().manobrado + " vezes.");
                } else if (!entrou) {
                    fila.consultarPrimeiro().manobrou();
                    saveCar[i] = fila.desenfileirar();
                    i++;
                } else {
                    saveCar[i] = fila.desenfileirar();
                    i++;
                }
            }

        }

        if (fila.consultarPrimeiro() != null) {
            System.out.println("Carro de placa " + placaDoCarro + " saiu do estacionamento.");
            System.out.println("Esse carro foi manobrado " + fila.desenfileirar().getManobrado() + " vezes.");
            j++;
        }

        i = 0;
        if (j == 0) {
            System.out.println("Carro nao encontrado!");
        }

        while (saveCar[i] != null) {
            fila.enfileirar(saveCar[i]);
            i++;
        }
    }

    public static class Carro {

        private String placa;
        private boolean estacionado;
        private int manobrado;

        public Carro(String placa) {
            this.placa = placa;
            estacionado = true;
            manobrado = 0;
        }

        public String getPlaca() {
            return placa;
        }

        public int getManobrado() {
            return manobrado;
        }

        public void setEstacionado(boolean estacionado) {
            this.estacionado = estacionado;
        }

        public void manobrou() {
            manobrado++;
        }

    }

 
}
