public class Main {
    public static void main(String[] args) throws InterruptedException {

        CuentaBancaria cuenta = new CuentaBancaria("Cliente Principal", 0.0);

        Cajero cajero = new Cajero(cuenta);
        Auditor auditor = new Auditor(cuenta, cajero);

        cajero.start();
        auditor.start();

        // Main espera a que el Cajero termine todos los depósitos
        cajero.join();

        System.out.println("================================");
        System.out.printf("Saldo final: $%.2f%n", cuenta.getSaldo());
        System.out.println("================================");
    }
}