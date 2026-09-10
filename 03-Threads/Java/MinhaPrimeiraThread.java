package Threads.Java;

public class MinhaPrimeiraThread extends Thread {
    private int quantidade;

    public MinhaPrimeiraThread(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Executando a primeira thread: " + i);
        }
    }

    static class MinhaSegundaThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Executando a segunda thread: " + i);
            }
        }
    }

    public static void main(String[] args) {
    MinhaPrimeiraThread t1 = new MinhaPrimeiraThread(10);
    MinhaSegundaThread t2 = new MinhaSegundaThread();

    t1.start();
    t2.start();
}
}
