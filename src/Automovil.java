public class Automovil {
    // Este tipo de clase se conoce como POJO = Plain Old Java Object - objeto simple que representa datos con atributos privados con getter y setter
    // Esto es un objeto
    // entidad es la combinacion de caracteristicas y comportamientos del objeto, bases de cualqueir objeto
    // los estados de un objeto serían el valor de las variables

    // Orden:
    // Atributos
    // Constructores
    // Metodos Getter y setter
    // Metodos de operacion
    // Metodos para sobrescribir o reeplazar de la clase padre

    private int id;
    private String fabricante;
    private String modelo;
    //private String color = COLOR_GRIS;
    private Color color = Color.GRIS; // Pasamos a tipo Color, utilizando el Enumerator
    private double cilindrada;
    private int capacidadEstanque = 40;

    private static Color colorPatente = Color.NARANJO; // Lo mismo que en Color
    private static int capacidadEstanqueStatic = 30;
    private static int ultimoId;

    public static final Integer VELOCIDAD_MAX_CARRETERA = 120;
    public static final int VELOCIDAD_MAX_CIUDAD = 60;

    public static final String COLOR_ROJO = "Rojo";
    public static final String COLOR_AMARILLO = "Amarillo";
    public static final String COLOR_AZUL = "Azul";
    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_GRIS = "Gris oscuro";

    // Constructor explicito

    public Automovil() {
        this.id = ++ ultimoId;
    }

    public Automovil(String fabricante, String modelo) {
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color) {
        this(fabricante, modelo); // llama al constructor del metodo anterior: el q tiene fabricante y modelo
        this.color = color; // color es propio de este constructor
    }

    public Automovil(String fabricante, String modelo, Color color, double cilindrada) {
        this(fabricante, modelo, color); // this hace referencia a un constructor de la misma clase y pasa los parametros reutilizandolos
        this.cilindrada = cilindrada;
    }

    public Automovil(String fabricante, String modelo, Color color, double cilindrada, int capacidadEstanque) {
        this(fabricante, modelo, color, cilindrada);
        this.capacidadEstanque = capacidadEstanque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Private -> solo se puede acceder a estos atributos dentro de la misma clase

    // Metodos para leer cuando estan private
    // Crear getter and setter con click-D generate

    public String getFabricante(){
        return fabricante;
    }
    // Recibe lo que se le pasa por argumento... en el atributo guardamos lo que se pasa por argumetto
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    public String getModelo(){
        return this.modelo;
    }

    public void setModelo (String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCilindrada() {
        return this.cilindrada;
    }

    public void setCilindrada(double cilindrada){
        this.cilindrada = cilindrada;
    }

    public int getCapacidadEstanque() {
        return this.capacidadEstanque;
    }

    public void setCapacidadEstanque(int capacidadEstanque) {
        this.capacidadEstanque = capacidadEstanque;
    }

    public static int getCapacidadEstanqueStatic() {
        return capacidadEstanqueStatic;
    }

    public static void setCapacidadEstanqueStatic(int capacidadEstanqueStatic) {
        Automovil.capacidadEstanqueStatic = capacidadEstanqueStatic;
    }

    public static Color getColorPatente() {
        return colorPatente;
    }
    public static void setColorPatente(Color colorPatente) {
        Automovil.colorPatente = colorPatente;
    }

    public String verDetalle() {
        return "auto.id = " + this.id +
                "\nauto.fabricante = " + this.getFabricante() +
                "\nauto.modelo = " + getModelo() +
                "\nauto.color = " + this.color +
                "\nauto.patenteColor = " + colorPatente + // dentro de la clase, atributo estatico va sin el this... o tambien nombreclase.atributo -> Automovil.colorPatente
                "\nauto.cilindrada = " + this.cilindrada;
    }

    public String acelerar(int rpm) {
        return "El auto " + this.fabricante + " acelerando a " + rpm + " rpm";
    }

    public String frenar() {
        return this.fabricante + " " + this.modelo + " frenando";
    }

    public String acelerarFrenar (int rpm){
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }
    // sobrecarga de metodos -> usar el mismo metodo implementado distinto... con distintos tipos o parametros etc
    public float calcularConsumo (int km, float porcentajeBencina) {
        return km /(capacidadEstanque*porcentajeBencina);
    }

    public float calcularConsumo (int km, int porcentajeBencina) {
        return km /(capacidadEstanque*(porcentajeBencina/100f));
    }

    public static float calcularConsumoStatic(int km, int porcentajeBencina) { // usar contexto estatico
        return km /(Automovil.capacidadEstanqueStatic * (porcentajeBencina/100f)); // Se puede usar capacidadEstanqueStatic por estar dentro de la clase,
        // o tambien clase.atributoStatic = Automovil.capacidadEstanqueStatic
    }


    @Override
    public boolean equals(Object obj) { // obj es lo q se pasa por argumento, lo que vamos a comparar con el objeto Automovil
        if (this == obj){ // si se trata del mismo objeto, retorna true altiro, no es necesario comparar por atributos
            return true;
        }
        if (!(obj instanceof Automovil)){ // Si el objeto no es instancia de automovil o no es del mismo tipo, retorna false y salimos
            return false;
        }
        Automovil a = (Automovil) obj;
        return (this.fabricante != null && this.modelo != null
                && this.fabricante.equals(a.getFabricante())
                && this.modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {
        return this.id + ":" +
                "Automovil{" +
                "fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", cilindrada=" + cilindrada +
                ", capacidadEstanque=" + capacidadEstanque +
                '}';
    }



    //    // metodos o funciones -< comportamientos
//    public String verDetalle() { // void o String seria el retorno
//        StringBuilder sb = new StringBuilder();
//        //String modelo = "otro"; // si no usamos this, esta variable se sobrepone al atributo de la clase "modelo" al llamarlo sin el this
//        sb.append("auto.fabricante = " + this.fabricante); // this para acceder a atributos o metodos de la misma class
//        sb.append("\nauto.modelo = " + this.modelo); // this se puede omitir en algunos casos
//        sb.append("\nauto.color = " + this.color); // a noser que haya una variable por ejemplo
//        sb.append("\nauto.cilindrada = " + this.cilindrada);
//        return sb.toString();
//    }

        // Forma 2 con String y concatenado con +
//    public String verDetalle() {
//        String sb = "auto.fabricante = " + this.fabricante +
//                "\nauto.modelo = " + this.modelo +
//                "\nauto.color = " + this.color +
//                "\nauto.cilindrada = " + this.cilindrada;
//        return sb;
//    }

        // Forma 3 con el return al inicio y sin la variable, ya que no se llama en otro lado
//    public String verDetalle() {
//        return "auto.fabricante = " + this.fabricante +
//                "\nauto.modelo = " + this.modelo +
//                "\nauto.color = " + this.color +
//                "\nauto.cilindrada = " + this.cilindrada;
//
//    }
}