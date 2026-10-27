import java.io.Serializable;

public class Producto implements Serializable{
    private static final long SerialVersionUID = 1L;
    
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto (String codigo,String nombre,double precio,int cantidad){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getcodigo() { return codigo; }
    public String getnombre() { return nombre; }
    public double getprecio() { return precio; }
    public int  getcantidad() { return cantidad;}

    public double getvalorTotal(){
        return precio * cantidad;
    }
    public  String toLinea(){
        return codigo + ";" + nombre + ";" + precio + ";" + cantidad;
    }
    @Override
        public String toString(){
            return String.format("%-8s %-20s RD$%,12.2f %6d", codigo,nombre,precio,cantidad);
        }
}