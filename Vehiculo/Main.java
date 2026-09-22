public class Main {
    public static void main(String[] args) {

        Vehiculo[] vehiculos = new Vehiculo[5];
        vehiculos[0] = new Automovil("A01", "Toyota", "Camry", 2022, 4);
        vehiculos[1] = new Motocicleta("M01", "Yamaha", "MT-07", 2023, 689);
        vehiculos[2] = new Camion("C01", "Volvo", "FH16", 2021, 5000);
        vehiculos[3] = new Automovil("A02", "Mazda", "RX7", 2020, 4);
        vehiculos[4] = new Camion("C02", "Freightliner", "Cascadia", 2019, 8000);

        System.out.println("===== INFORMACIÓN Y CONDUCCIÓN DE CADA VEHÍCULO =====\n");

        for (Vehiculo v : vehiculos) {
            System.out.println(v);
            System.out.println("Tipo real (getClass): " + v.getClass().getSimpleName());
            v.conducir();

            if (v instanceof Cargable) {
                System.out.println(">> Este vehículo puede cargar/descargar (implementa Cargable).");
            } else {
                System.out.println(">> Este vehículo NO implementa Cargable.");
            }

            System.out.println("--------------------------------------------------");
        }

        System.out.println("\n===== OPERACIÓN DE CARGA Y DESCARGA SOBRE UN CAMIÓN =====\n");

        for (Vehiculo v : vehiculos) {
            if (v instanceof Camion) {
                Camion camion = (Camion) v;
                camion.cargar(3000);
                camion.cargar(4000);
                camion.descargar();
                break;
            }
        }
    }
}