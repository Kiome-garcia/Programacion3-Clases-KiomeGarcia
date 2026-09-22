public class Auditor extends Thread {

    private CuentaBancaria cuenta;
    private Thread cajero;

    public Auditor(CuentaBancaria cuenta, Thread cajero) {
        this.cuenta = cuenta;
        this.cajero = cajero;
    }

    @Override
    public void run() {
        // Audita mientras el Cajero siga trabajando
        while (cajero.isAlive()) {
            System.out.printf("[Auditor] Saldo actual : $%.2f%n", cuenta.getSaldo());
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}