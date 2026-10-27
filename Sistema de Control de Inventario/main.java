import java.util.List;
import java.util.Scanner;

public class main {
    private static Scanner sc = new Scanner(System.in);
    private static GestorInventario gestor = new GestorInventario();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("");
            switch (opcion) {
                case 1: registrarProducto(); break;
                case 2: mostrarInventario(); break;
                case 3: buscarProducto(); break;
                case 4: calcularValor(); break;
                case 5: gestor.crearCopia(); break;
                case 6: gestor.recuperarCopia(); break;
                case 7: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n========== TECHSTORE ==========");
        System.out.println("     SISTEMA DE INVENTARIO");
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar inventario");
        System.out.println("3. Buscar producto");
        System.out.println("4. Calcular valor del inventario");
        System.out.println("5. Crear copia de seguridad");
        System.out.println("6. Recuperar copia de seguridad");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarProducto() {
        System.out.print("Código: ");
        String codigo = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || codigo.contains(";") || nombre.contains(";")) {
            System.out.println("Código y nombre no pueden estar vacíos ni contener ';'.");
            return;
        }

        double precio = leerDouble("Precio (RD$): ");
        int cantidad = leerEntero("Cantidad: ");

        if (precio < 0 || cantidad < 0) {
            System.out.println("El precio y la cantidad no pueden ser negativos.");
            return;
        }

        Producto p = new Producto(codigo, nombre, precio, cantidad);
        if (gestor.registrar(p)) {
            System.out.println("Producto registrado correctamente.");
        } else {
            System.out.println("Ya existe un producto con ese código.");
        }
    }

    private static void mostrarInventario() {
        List<Producto> lista = gestor.leerProductos();
        if (lista.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.printf("%-8s %-20s %15s %6s%n", "CÓDIGO", "NOMBRE", "PRECIO", "CANT.");
        for (Producto p : lista) {
            System.out.println(p);
        }
    }

    private static void buscarProducto() {
        System.out.print("Código a buscar: ");
        String codigo = sc.nextLine().trim();
        Producto p = gestor.buscar(codigo);
        if (p == null) {
            System.out.println("Producto no encontrado en el inventario");
        } else {
            System.out.println(p);
        }
    }

    private static void calcularValor() {
        double total = gestor.calcularValorInventario();
        System.out.printf("Valor total del inventario: RD$%,.2f%n", total);
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        try {
            return Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}