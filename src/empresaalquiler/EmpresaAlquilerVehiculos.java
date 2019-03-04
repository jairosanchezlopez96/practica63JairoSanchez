/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaalquiler;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jairo
 */
public class EmpresaAlquilerVehiculos {
	// Atributos de la empresa

	private String cif;
	private String nombre;
	private String paginaWeb;

	public String getCif() {
    	return cif;
	}

	public void setCif(String cif) {
    	this.cif = cif;
	}

	public String getNombre() {
    	return nombre;
	}

	public void setNombre(String nombre) {
    	this.nombre = nombre;
	}

	public String getPaginaWeb() {
    	return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
    	this.paginaWeb = paginaWeb;
	}

	public int getTotalClientes() {
    	return totalClientes;
	}

	public void setTotalClientes(int totalClientes) {
    	this.totalClientes = totalClientes;
	}

	public ArrayList<Cliente> getClientes() {
    	return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
    	this.clientes = clientes;
	}

	public int getTotalVehiculos() {
    	return totalVehiculos;
	}

	public void setTotalVehiculos(int totalVehiculos) {
    	this.totalVehiculos = totalVehiculos;
	}

	public ArrayList<Vehiculo> getVehiculos() {
    	return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
    	this.vehiculos = vehiculos;
	}

	public int getTotalAlquileres() {
    	return totalAlquileres;
	}

	public void setTotalAlquileres(int totalAlquileres) {
    	this.totalAlquileres = totalAlquileres;
	}

	public ArrayList<VehiculoAlquilado> getAlquileres() {
    	return alquileres;
	}

	/* Atributos para controlar el total de clientes que tiene la
	empresa y array de almacenamiento para los objetos Cliente */
	public void setAlquileres(ArrayList<VehiculoAlquilado> alquileres) {
    	this.alquileres = alquileres;
	}
// cambiamos a arraylist  en vez de array
	private int totalClientes;
	private ArrayList<Cliente> clientes;
	/* Atributos para controlar el total de vehiculos disponibles en
alquiler que tiene la empresa y array de almacenamiento para los objetos
Vehiculo */
	private int totalVehiculos;
	private ArrayList<Vehiculo> vehiculos;
	/* Atributos para controlar el histórico de alquileres: total de
alquileres realizados y array de almacenamiento para los objetos

8
VehiculoAlquilado */
	private int totalAlquileres;
	private ArrayList<VehiculoAlquilado> alquileres;
// se omiten los métodos ‘get’ y ‘set’ de la clase
/* Constructor parametrizado donde se establece que el total de clientes
será 50, igual que el total de vehiculos disponibles. El histórico de
vehiculos puede contener hasta 100 elementos */
	EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
    	this.cif = cif;
    	this.nombre = nombre;
    	this.paginaWeb = paginaWeb;
// Incialmente no hay clientes creados en la empresa
    	this.totalClientes = 0;
    	this.clientes = new ArrayList<Cliente>(25); // apuntan a null
// Incialmente no hay vehiculos creados en la empresa
    	this.totalVehiculos = 0;
    	this.vehiculos = new ArrayList<Vehiculo>(25); // apuntan a null
// Incialmente no hay histórico de alquileres en la empresa
    	this.totalAlquileres = 0;
    	this.alquileres = new ArrayList<VehiculoAlquilado>(25); // apuntan a null
	}

	// Metodo que añade un cliente a la lista de clientes
	public void registrarCliente(Cliente nuevo) {
    	this.clientes.add(nuevo);
    	this.totalClientes++;
	}

	// Metodo que añade un vehiculo a la lista de vehiculos
	public void registrarVehiculo(Vehiculo nuevo) {

      	this.vehiculos.add(nuevo);
    	this.totalVehiculos++;
	}

	/*imprimirClientes(). Muestra la relación de clientes de la empresa. Este
método recorre el array clientes y va mostrando los datos de cada
cliente.*/
	public void imprimirClientes() {
    	System.out.println("NIF cliente\tNombre\n");
    	for (int i = 0; i < this.totalClientes; i++) {
        	System.out.println(this.clientes.get(i));
    	}
	}
	/*imprimirVehiculos(). Muestra el catálogo de vehículos de la empresa,
recorriendo el array vehiculos y llamando al método getAtributos() de cada
uno .*/
public void imprimirVehiculos() {

for (int i=0; i<this.totalVehiculos; i++)
System.out.println(this.vehiculos.get(i));
}

	public static int diaHoy() {

    	return LocalDate.now().getDayOfMonth();

	}

	public static Month mesHoy() {
    	return LocalDate.now().getMonth();

	}

	public static int añoHoy() {

    	return LocalDate.now().getYear();
	}

	/*alquilarVehiculo(String matricula,String nif,int dias). Modifica
la disponibilidad del vehículo para indicar que está alquilado y añade un objeto
de tipo VehiculoAlquilado al array de vehículos alquilados. Para
registrar el alquiler de un vehículo por un cliente se usa estel método. El
método getCliente(String nif) busca la referencia del cliente con el NIF
dado en el array clientes. De forma similar, el método getVehiculo(String
matricula) busca la referencia del vehículo con la matrícula dada en el
array vehiculos. Una vez encontrado el vehículo con la matrícula indicada,
se verifica si está disponible para alquilar y se modifica su
disponibilidad. A continuación, almacena un objeto de tipo
VehiculoAlquilado en el array alquileres.Este objeto relaciona un
cliente, un vehículo, la fecha actual y los días de alquiler.
El método getCliente(String nif).*/
	private Cliente getCliente(String nif) {
    	for (int i = 0; i < this.getTotalClientes(); i++) {
        	if (this.clientes.get(i).getNif().equals(nif)) {
            	return this.clientes.get(i);
        	}

    	}
    	return null;
	}
//El método getVehiculo(String matricula).Dado una matricula te da el coche con esa matricula

	private Vehiculo getVehiculo(String matricula) {
    	for (int i = 0; i < this.getTotalVehiculos(); i++) {
        	if (this.vehiculos.get(i).getMatricula().equals(matricula)) {
            	return this.vehiculos.get(i);
        	}
    	}
    	return null;
	}

	/*El método alquilarVehiculo(String matricula, String
nif, int dias).*/
	public void alquilarVehiculo(String matricula, String nif, int dias) {
    	Cliente cliente = getCliente(nif);
    	Vehiculo vehiculo = getVehiculo(matricula);
// busca el cliente con el NIF dado en el array
// clientes y el vehículo con la matrícula dada en el
// array vehiculos, si el vehículo está disponible se
// alquila con la fecha actual, que se obtiene
// ejecutando los métodos diaHoy(), mesHoy() y
// añoHoy(), cuya declaración no se incluye
    	if (vehiculo.getDisponible()) {
        	vehiculo.setDisponible(false);
        	this.alquileres.add( new VehiculoAlquilado(cliente, vehiculo,
                        	diaHoy(), mesHoy(), añoHoy(), dias));
               	 

        	this.totalAlquileres++;
    	}
	}
	public void rellenarClientes(){
	int clientesExistentes = this.totalClientes;
	for (int i = 0 ; i < 25 - clientesExistentes; i++){
   	 
	registrarCliente(Cliente.clienteAleatorio());
	}
	}
	public void rellenarVehiculos(){
	int vehiculosExistentes = this.totalVehiculos;
	for (int i = 0 ; i < 25-vehiculosExistentes; i++){
	registrarVehiculo(Vehiculo.vehiculoAleatorio());
	}
	}
 	public void ordenarClientes() {  
 	 
    	Cliente temp;  
     	for(int i=0; i < clientes.size()-1; i++){  
             	for(int j= i+1; j < clientes.size(); j++){  
                      	if(clientes.get(i).getNif().compareToIgnoreCase(clientes.get(j).getNif())> 0){  
                             	//y ahora cambiamos los elementos  
                             	temp = clientes.get(i);
                             	clientes.set(i, clientes.get(j));  
                             	clientes.set(j,temp);  
                     	}  
                     	 
             	}  
     	}  

}       	public void ordenarVehiculos( ){
            	Vehiculo temp;  
     	for(int i=0; i < vehiculos.size()-1; i++){  
             	for(int j= i+1; j < vehiculos.size(); j++){  
                      	if(vehiculos.get(i).getMatricula().compareToIgnoreCase(vehiculos.get(j).getMatricula())> 0){  
                             	//swap elements  
                             	temp = vehiculos.get(i);  
                             	vehiculos.set(i,vehiculos.get(j));  
                             	vehiculos.set(j,temp);  
                     	}  
                     	 
             	}  
     	}
    	}
        	public int buscarCliente( String buscado){
        	int mitad; int izquierda = 0; int derecha = clientes.size()- 1;
         	boolean encontrado = false;
    	while ((izquierda<=derecha)&& (!encontrado)){
	mitad = (izquierda + derecha) / 2;
	if (clientes.get(mitad).getNif().compareTo(buscado) == 0){
            	encontrado = true;
             	System.out.println("Lo ha encontrado en la posicion: " + mitad);
        	return mitad;
    	} else if (clientes.get(mitad).getNif().compareTo(buscado) >0){
    	derecha = mitad - 1;} //buscar en el trozo izquierdo
    	else if (clientes.get(mitad).getNif().compareTo(buscado  ) < 0){
    	izquierda = mitad + 1; // buscar en el trozo derecho
	}
}
return -1;
  	 

        	}
                      	public int buscarVehiculos( String buscado){
        	int mitad; int izquierda = 0; int derecha = clientes.size() - 1;
         	boolean encontrado = false;
    	while ((izquierda<=derecha)&& (!encontrado)){
	mitad = (izquierda + derecha) / 2;
	if (vehiculos.get(mitad).getMatricula().compareTo(buscado) == 0){
            	encontrado = true;
             	System.out.println("Lo ha encontrado en la posicion: " + mitad);
        	return mitad;
    	} else if (vehiculos.get(mitad).getMatricula().compareTo(buscado) >0){
    	derecha = mitad - 1;} //buscar en el trozo izquierdo
    	else if (vehiculos.get(mitad).getMatricula().compareTo(buscado  ) < 0){
    	izquierda = mitad + 1; // buscar en el trozo derecho
	}
}
return -1;
  	 

        	}



   }

