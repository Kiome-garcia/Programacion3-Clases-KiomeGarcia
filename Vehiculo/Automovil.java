public class Automovil extends Vehiculo {

    private int cantidadPuertas;

    public Automovil(String codigo, String marca, String modelo, int año, int cantidadPuertas) {
        super(codigo, marca, modelo, año, cantidadPuertas);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        if (cantidadPuertas > 0) {
            this.cantidadPuertas = cantidadPuertas;
        }
    }

    @Override
    public Void conducir() {
        setVelocidadACtual(60);
        System.out.println("El automóvil " + getModelo() + " avanza por la carretera a "
                + getVelocidadActual() + " km/h.");
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " | Puertas: " + cantidadPuertas;
    }
}