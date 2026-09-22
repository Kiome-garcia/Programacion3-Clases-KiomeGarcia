public class Cajero extends Thread {

    private CuentaBancaria cuenta;

    private String[] clientes = { "Ana", "Luis", "Carlos", "", "Maria" };
    private double[] montos = { 1500.00, -200.00, 800.00, 500.00, 3000.00 };

    public Cajero(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        for (int i = 0; i < clientes.length; i++) {
            try {
                cuenta.depositar(clientes[i], montos[i]);
            } catch (DepositoInvalidoException e) {
                System.out.printf("[Cajero]  ERROR        | %-6s | %s%n", clientes[i], e.getMessage());
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}