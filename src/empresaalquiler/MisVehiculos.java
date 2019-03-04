/*
 *En la clase que contenga el método main() se debe:
Crear una empresa de alquiler con los datos que tú quieras.
Se llenarán los arraylist de clientes y vehículos de forma aleatoria usando los métodos pertinentes. 
Una vez cargados los 25 clientes y 25 vehículos aleatorios, se mostrarán usando la consola.
El programa solicitará por teclado el nif de un cliente, la matrícula de un vehículo y el número de días que se quiere alquilar.
El sistema registrará, usando el método apropiado, el alquiler anterior.
Se debe mostrar por consola el alquiler registrado.
Posteriormente, se ordenarán los clientes y los vehículos usando los métodos apropiados. 
Se volverá a buscar otro cliente y otro vehículo, solicitando los datos al usuario, usando búsqueda binaria. Todos los resultados se deben mostrar por consola, comprobando que el comportamiento de los métodos es el correcto.

 */
 /*Penalización en la nota de dos puntos por no tabular el código*/
package empresaalquiler;

import java.util.Scanner;

/**
 *
 * @author jairo
 */
public class MisVehiculos {

    public static void main(String[] args) {
        /*
 *En la clase que contenga el método main() se debe:
Crear una empresa de alquiler con los datos que tú quieras.
Se llenarán los arraylist de clientes y vehículos de forma aleatoria usando los métodos pertinentes. 
Una vez cargados los 25 clientes y 25 vehículos aleatorios, se mostrarán usando la consola.
El programa solicitará por teclado el nif de un cliente, la matrícula de un vehículo y el número de días que se quiere alquilar.
El sistema registrará, usando el método apropiado, el alquiler anterior.
Se debe mostrar por consola el alquiler registrado.
Posteriormente, se ordenarán los clientes y los vehículos usando los métodos apropiados. 
Se volverá a buscar otro cliente y otro vehículo, solicitando los datos al usuario, usando búsqueda binaria. Todos los resultados se deben mostrar por consola, comprobando que el comportamiento de los métodos es el correcto.

 */
        // la instancia easydrive de la clase EmpresaAlquilerVehiculos
        EmpresaAlquilerVehiculos easydrive = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive",
                "www.easydrive.com");
        // rellenamos clientes
    easydrive.rellenarClientes();
    // rellenamos vehiculos e imprimimos
    easydrive.rellenarVehiculos();
// imprime la relación de clientes de easydrive
        easydrive.imprimirClientes();
// imprime el catálogo de vehículos de easydrive
        easydrive.imprimirVehiculos();
        
     // creamos alquiler  pidiendo datos
      Scanner tc = new Scanner(System.in);
        System.out.println("Vamos a crear un alquiler nuevo");
        System.out.println("Dime matricula");
        String matricula = tc.nextLine();
        tc.nextLine();
        System.out.println("Dime nif");
        String nif = tc.nextLine();
        tc.nextLine();
        System.out.println("Dime los dias de alquiler");
        int dias = tc.nextInt();
        tc.nextLine();
        easydrive.alquilarVehiculo(matricula, nif, dias);
        // imprimimos
        easydrive.imprimirAlquiler();
       
        
    

     
        // ordenamos vehiculos y clientes como se nos pide
        easydrive.ordenarClientes();
        easydrive.ordenarVehiculos();

       
       
        System.out.println("¿Que cliente quieres buscar segun el nif?");
        String z = tc.nextLine();
        tc.nextLine();
        easydrive.buscarCliente(z);
        System.out.println("¿Que coche quieres buscar segun la matricula?");
        String b = tc.nextLine();
        tc.nextLine();
        easydrive.buscarVehiculos(b);

    }

}
