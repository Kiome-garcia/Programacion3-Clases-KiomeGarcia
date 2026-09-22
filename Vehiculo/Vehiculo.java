public abstract class Vehiculo{
    private String codigo;
    private String marca;
    private String modelo;
    private int anio;
    private double VelocidadActual;


    public Vehiculo (String codigo, String marca, String modelo, int anio, double VelocidadActual){

        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.VelocidadActual = VelocidadActual;

    }
    public String getcodigo(){
        return codigo;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getAño() {
        return anio;
    }
    public double getVelocidadActual() {
        return VelocidadActual;
    }
    
    protected Void setVelocidadACtual( double  VelocidadActual){
        if(VelocidadActual < 0){
            this.VelocidadActual = 0;
        } else{
            this.VelocidadActual = VelocidadActual;
        }
        return null;
        }

    
    public abstract Void conducir();
    @Override 
    public String toString(){

        return "codigo:" +codigo+
            "|marca:" +marca+
            "|año:" +anio+
            "|VelocidadActual:" +VelocidadActual+ "km/h";
}
}