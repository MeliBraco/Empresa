package Empresa;

import java.awt.Desktop;
import java.io.*;
import java.util.*;


public class EmpresaNueva {

	
	private  List<Trabajador> trabajadores = new ArrayList<Trabajador>();
	
	
	public void agregarEmpleado(Trabajador trabajador){
		this.trabajadores.add(trabajador);	
	}
	
	public void listarEmpleadosEnTXT(){

		if(estaVacia() == true){
			 System.out.print("LISTA VACIA");
		 }else{
			 Collections.sort(trabajadores);
			 crearArchivoConTrabajadores();
		 }
	}
	
	private  boolean estaVacia(){
		return trabajadores.isEmpty();	
	}

	private  void crearArchivoConTrabajadores(){

		File archivo = new File("C:/Users/ADM/Desktop/Listar.txt");
		try {
			FileWriter escribirEnArchivo = new FileWriter(archivo);

			Iterator<Trabajador> iterador = this.trabajadores.iterator();
			while(iterador.hasNext()){
				Trabajador aux = iterador.next();
				escribirEnArchivo.write(aux.toString() + "\r\n");
			}
			escribirEnArchivo.close();
			Desktop.getDesktop().open(archivo);

		} catch (IOException e) {
			System.out.print(e);
		}
	}

	public void informacionDelTrabajador(String dni){
		

		if(estaVacia() == false){
			
			Iterator<Trabajador> iterador = this.trabajadores.iterator();
			while(iterador.hasNext()){
				Trabajador aux = iterador.next();

				if(dni.equals(aux.getDni())){
					System.out.print(aux.toString());
				}
			}
		}else{
			System.out.print("Lista vacia");
		}
	}

	public double obtenerSueldoSegunTrabajador(Trabajador trabajador){

		double sueldo = 0;
		Iterator<Trabajador> iterador = this.trabajadores.iterator();
		while(iterador.hasNext()){
			Trabajador aux = iterador.next();
			if(trabajador.getDni().equals(aux.getDni())){
				sueldo = trabajador.getSueldoBasico();
			}
		}
		return sueldo;
	}
}