package countOperations;

public class CountOperations2 {

    public String secondFor(int n) {
        long startTime = System.nanoTime();
        int a = 0;
        int count = 0;

        for (int i = n + 1; i > 0; i /= 2) {
            a *= 2;
            count++;
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        long micros = elapsedTime / 1000;
        long nanos = elapsedTime;
        long picos = elapsedTime * 1000;

        return "Tempo de execução: " +
                "Microssegundos: " + micros +
                ", Nanossegundos: " + nanos +
                ", Picossegundos: " + picos +
                ", Count: " + count;

    }

    public static void main(String[] args) {
        CountOperations2 countOperations = new CountOperations2();
        System.out.println(countOperations.secondFor(999999979));
    }
}
