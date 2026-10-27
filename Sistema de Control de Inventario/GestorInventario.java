import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorInventario {
    private static final String ARCHIVO_TXT = "inventario.txt";
    private static final String ARCHIVO_DAT = "inventario.dat";

    public List<Producto> leerProductos() {
        List<Producto> lista = new ArrayList<>();
        File archivo = new File(ARCHIVO_TXT);
        if (!archivo.exists()) {
            return lista;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";");
                if (p.length == 4) {
                    lista.add(new Producto(p[0], p[1],
                            Double.parseDouble(p[2]),
                            Integer.parseInt(p[3])));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lista;
    }

    public Producto buscar(String codigo) {
        for (Producto p : leerProductos()) {
            if (p.getcodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public boolean registrar(Producto producto) {
        if (buscar(producto.getcodigo()) != null) {
            return false;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_TXT, true))) {
            bw.write(producto.toLinea());
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
            return false;
        }
    }

    public double calcularValorInventario() {
        double total = 0;
        for (Producto p : leerProductos()) {
            total += p.getvalorTotal();
        }
        return total;
    }

    public void crearCopia() {
        List<Producto> lista = leerProductos();
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO_DAT))) {
            oos.writeObject(lista);
            System.out.println("Copia creada: " + lista.size() + " producto(s).");
        } catch (IOException e) {
            System.out.println("Error al crear la copia: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void recuperarCopia() {
        File archivo = new File(ARCHIVO_DAT);
        if (!archivo.exists()) {
            System.out.println("No existe ninguna copia de seguridad.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivo))) {
            List<Producto> lista = (List<Producto>) ois.readObject();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_TXT))) {
                for (Producto p : lista) {
                    bw.write(p.toLinea());
                    bw.newLine();
                }
            }

            System.out.println("Copia recuperada: " + lista.size() + " producto(s).");
            for (Producto p : lista) {
                System.out.println(p);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar la copia: " + e.getMessage());
        }
    }
}