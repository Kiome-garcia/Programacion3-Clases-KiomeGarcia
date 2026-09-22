public class Motocicleta extends Vehiculo {

    private double cilindrada;

    public Motocicleta(String codigo, String marca, String modelo, int anio, double cilindrada) {
        super(codigo, marca, modelo, anio, cilindrada);
        this.cilindrada = cilindrada;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        if (cilindrada > 0) {
            this.cilindrada = cilindrada;
        }
    }

    @Override
    public Void conducir() {
        setVelocidadACtual(90);
        System.out.println("La motocicleta " + getModelo() + " acelera ágilmente a "
                + getVelocidadActual() + " km/h.");
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " | Cilindrada: " + cilindrada + "cc";
    }
}