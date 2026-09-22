public class CuentaBancaria {

    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(String cliente, double monto) throws DepositoInvalidoException {
        if (cliente == null || cliente.trim().isEmpty()) {
            throw new DepositoInvalidoException("Cliente sin nombre");
        }
        if (monto <= 0) {
            throw new DepositoInvalidoException("Monto invalido: " + monto);
        }

        saldo += monto;
        System.out.printf("[Cajero]  Deposito OK  | %-6s | $%.2f | Saldo: $%.2f%n",
                cliente, monto, saldo);
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}