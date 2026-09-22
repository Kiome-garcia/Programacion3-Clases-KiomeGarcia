
public class Camion extends Vehiculo implements Cargable {

    private double capacidadMaxima;
    private double cargaActual;

    public Camion(String codigo, String marca, String modelo, int anio, double capacidadMaxima) {
        super(codigo, marca, modelo, anio, capacidadMaxima);
        this.capacidadMaxima = capacidadMaxima;
        this.cargaActual = 0.0;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    @Override
    public Void conducir() {
        setVelocidadACtual(50);
        System.out.println("El camión " + getModelo() + " circula con cuidado a "
                + getVelocidadActual() + " km/h llevando " + cargaActual + " kg.");
        return null;
    }

    public void cargar(double peso) {
        if (peso <= 0) {
            System.out.println("El peso a cargar debe ser positivo.");
            return;
        }
        if (cargaActual + peso > capacidadMaxima) {
            System.out.println("No se puede cargar " + peso + " kg: excede la capacidad máxima ("
                    + capacidadMaxima + " kg).");
            return;
        }
        cargaActual += peso;
        System.out.println("Se cargaron " + peso + " kg. Carga actual: " + cargaActual + " kg.");
    }

    @Override
    public Void descargar() {
        System.out.println("Se descargaron " + cargaActual + " kg del camión " + getModelo() + ".");
        cargaActual = 0.0;
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " | Capacidad máxima: " + capacidadMaxima
                + " kg | Carga actual: " + cargaActual + " kg";
    }

    @Override
    public Void Cargar(double peso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Cargar'");
    }
}