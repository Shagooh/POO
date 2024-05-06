import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {
        // TIP: ocultar estado (atributos) de la clase
        // Se puede, si es que es necesario, implementar o no metodos para leer o modificar los atributos
        // Leer -> get ... modificar -> set

        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setCilindrada(2.0);
        subaru.setColor("Azul y lo mas bonito");

        Automovil mazda = new Automovil("Mazda", "BT", "Rojo");
        mazda.setCilindrada(3.0);

        Automovil nissan = new Automovil("Nissan", "Navara", "Gris", 5.0, 50);
        Automovil nissan2 = new Automovil("Nissan", "Navara", "Gris", 5.0, 50);

        Automovil auto = new Automovil();
        Date fecha = new Date();

        System.out.println("son iguales ?= "+ (nissan == nissan2));
        System.out.println("son iguales utilizando equals custom override= "+ (nissan.equals(nissan2)));
        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());

        System.out.println(auto.equals(nissan));
        System.out.println(auto.equals(fecha)); // comparando distintos tipos
        //System.out.println(auto.equals(new String ("hola"))); // comparando distintos tipos

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