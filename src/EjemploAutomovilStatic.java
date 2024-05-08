public class EjemploAutomovilStatic {
    public static void main(String[] args) {

        Automovil.setCapacidadEstanqueStatic(45);
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        //subaru.setColor(Automovil.COLOR_BLANCO); // usando solo atributo final
        subaru.setColor(Color.BLANCO); // Utilizando Enumerator ... enum.opcion => Color.BLANCO
        subaru.setEstanque(new Estanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda = new Automovil("Mazda", "BT", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        mazda.setTipo(TipoAutomovil.PICKUP);
        //mazda.setEstanque(new Estanque()); // solucion para nullpointerexception al no poner el estanque a mazda
        System.out.println("mazda fabricante = " + mazda.getFabricante());

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS,
                new Motor(4.0, TipoMotor.DIESEL), new Estanque(50));
        nissan.setTipo(TipoAutomovil.PICKUP);

        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS,
                new Motor(3.5, TipoMotor.BENCINA), new Estanque(50));
        nissan2.setTipo(TipoAutomovil.PICKUP);

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

        TipoAutomovil tipoSubaru = subaru.getTipo();
        System.out.println("tipoSubaru.getNombre() = " + tipoSubaru.getNombre());
        System.out.println("tipoSubaru.getDescripcion() = " + tipoSubaru.getDescripcion());

        System.out.println(mazda.calcularConsumo(300, 70));
    }
}