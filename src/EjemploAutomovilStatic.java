public class EjemploAutomovilStatic {
    public static void main(String[] args) {

        Automovil.setCapacidadEstanqueStatic(45);
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setCilindrada(2.0);
        //subaru.setColor(Automovil.COLOR_BLANCO); // usando solo atributo final
        subaru.setColor(Color.BLANCO); // Utilizando Enumerator ... enum.opcion => Color.BLANCO


        Automovil mazda = new Automovil("Mazda", "BT", Color.ROJO);
        mazda.setCilindrada(3.0);

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, 5.0, 50);
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS, 5.0, 50);

        nissan2.setColor(Color.AMARILLO);
        //Automovil.colorPatente = "Verde"; // cambiando al atributo estatico, se cambia en todos, ya que pertenece a la class
        Automovil.setColorPatente(Color.AZUL); // Se creo un get y set static para poder usarlo
        
        Automovil auto = new Automovil();

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());
        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());
        System.out.println("km por litro = " + Automovil.calcularConsumoStatic(300, 60)); // al ser estatico, es el mismo para todas las clases automovil
        System.out.println("VELOCIDAD_MAX_CARRETERA: " + Automovil.VELOCIDAD_MAX_CARRETERA);
        System.out.println("VELOCIDAD_MAX_CIUDAD: " + Automovil.VELOCIDAD_MAX_CIUDAD);
    }
}