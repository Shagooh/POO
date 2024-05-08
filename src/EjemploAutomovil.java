import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {
        // TIP: ocultar estado (atributos) de la clase

        Motor motorSubaru = new Motor(2.0, TipoMotor.BENCINA);
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setMotor(motorSubaru);
        subaru.setEstanque(new Estanque()); // 40 por defecto en clase estanque
        subaru.setColor(Color.BLANCO);

        Motor motorMazda = new Motor(3.0, TipoMotor.DIESEL);
        Automovil mazda = new Automovil("Mazda", "BT", Color.ROJO, motorMazda);
        mazda.setEstanque(new Estanque(45));
        System.out.println("mazda.fabricante = " + mazda.getFabricante());

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS,
                new Motor(4.0, TipoMotor.DIESEL), new Estanque(50));

        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.GRIS,
                new Motor(3.5, TipoMotor.BENCINA), new Estanque(50));

        Automovil auto = new Automovil();
        Date fecha = new Date();

        System.out.println("son iguales ?= "+ (nissan == nissan2));
        System.out.println("son iguaasdles utilizando equals custom override= "+ (nissan.equals(nissan2)));
        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());

        System.out.println(auto.equals(nissan));
        System.out.println(auto.equals(fecha)); // comparando distintos tipos
        //System.out.println(auto.equals(new String ("hola"))); // comparando distintos tipos
        System.out.println(nissan); // por debajo hace el toString
        System.out.println(nissan.toString());

        System.out.println(subaru.acelerar(3000));
        System.out.println(subaru.frenar());

        System.out.println(mazda.acelerarFrenar(4000));

        System.out.println("Kilometros por litro: "+ subaru.calcularConsumo(300,0.6f));
        System.out.println("Kilometros por litro: "+ subaru.calcularConsumo(300,60));
        System.out.println("Kilometros por litro: "+ nissan.calcularConsumo(300,60));

    // Principio de ocultacion => private, protected, public
    // Encapsulamiento => implementacion que tiene el objeto en cada uno de sus metodos.. un objeto que utiliza otro objeto no sabe como esta implementado, solo lo utiliza
    // Polimorfismo => mismo comportamiento pero implementado de otra forma ... diferente forma de hacer lo mismo
}

   /* private static Automovil getAutomovil() {
        Automovil subaru = new Automovil();  // Se crea la instancia e inicializa el objeto, se asigna en memoria,
        // y la variable almacena la referencia hacia el objeto
        // () sería el constructor
        subaru.setFabricante("Subaru");
        subaru.setModelo("Impreza");
        subaru.setCilindrada(2.0);
        subaru.setColor("Azul");
        return subaru;
    }*/
}