package Empresa;


import java.awt.Desktop;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import Excepciónes.*;


public class Empresa{

	
	private static List<Trabajador> trabajadores = new ArrayList<Trabajador>();
	
	
	public static void main(String []args){

		try {
			menu();
		}catch (ValorFueraDeRango e){
			JOptionPane.showMessageDialog(null, e.getMessage());	
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Operacion Invalida");
			finalizar();
		}
	}



	public  static void menu()throws ValorFueraDeRango{
		
		int menu;
		menu = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n"
															+ "1-Obtener la descripcion de un trabajador\n"
															+ "2-Agregar un trabajador\n"
				                                            + "3-Modificar datos del trabajador\n"
				                                            + "4-Listar trabajadores\n"
				                                            + "5-Finalizar"));
		if(menu > 0 && menu <= 5){
			switch(menu){

			case 1:
				try {
					informacionDelTrabajador(JOptionPane.showInputDialog("Ingresar DNI del trabajador"));
				}catch (TrabajadorNoEncontrado e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				finalizar();
				break;

			case 2:
				try {
					agregarTrabajador();
				}catch (ValorFueraDeRango e) {
					JOptionPane.showMessageDialog(null, e.getMessage());	
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Operacion invalida");					
				}
				finalizar();
				break;

			case 3:
				try {
					modificarTrabajador(JOptionPane.showInputDialog("Ingresar DNI del trabajador ha modificar"));
				} catch (TrabajadorNoEncontrado e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				finalizar();
				break;

			case 4:
				listarTrabajadores();
				break;

			case 5:
				finalizar();
				break;
			}
		}else{
			throw new ValorFueraDeRango("El valor ingresado es incorrecto");
		}
	}


	private static void informacionDelTrabajador(String dni)throws TrabajadorNoEncontrado{
		
		if(estaVacia() == false){
			for(Trabajador t : trabajadores){
				if(dni.equals(t.getDni())){
					System.out.print(t.toString());
				}else{
					throw new TrabajadorNoEncontrado("Trabajador no encontrado");
				}
			}
		}else{
			JOptionPane.showMessageDialog(null, "Lista vacia, no es posible buscar un Trabajador");
		}
	}
	
	
	private static void agregarTrabajador()throws ValorFueraDeRango{
			
		String nombre,dni,cuil;
		double sueldoBasico;
		
		int agregarTrabajador;
		agregarTrabajador = Integer.parseInt(JOptionPane.showInputDialog("Tipo de Trabajador:\n 1-Empleado Ejecutivo  \n 2-voluntario "
				+ "\n 3-Empleado por hora \n 4-Empleado por hora a Comision" ));

		if(agregarTrabajador > 0 && agregarTrabajador <= 4){
			switch(agregarTrabajador){
			
			case 1:

				nombre = JOptionPane.showInputDialog(" Ingresar Nombre");
				dni = JOptionPane.showInputDialog(" Ingresar DNI");
				cuil = JOptionPane.showInputDialog(" Ingresar CUIL\n (sin  guion)");
				EmpleadoEjecutivo empleado;
				try {
					empleado = new EmpleadoEjecutivo(nombre,dni,cuil);
					sueldoBasico = Double.parseDouble(JOptionPane.showInputDialog("Ingresar Sueldo Basico"));
					empleado.setSueldoBasico(sueldoBasico);
					pagarBono(empleado);
					trabajadores.add(empleado);
					JOptionPane.showMessageDialog(null, "Trabajador agregado exitosamente");
				} catch (cuilInvalido e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;

			case 2:

				nombre = JOptionPane.showInputDialog(" Ingresar Nombre");
				dni = JOptionPane.showInputDialog(" Ingresar DNI");
				cuil = JOptionPane.showInputDialog(" Ingresar CUIL\n (sin  guion)");
				Voluntario voluntario;
				try {
					voluntario = new Voluntario(nombre,dni,cuil);
					sueldoBasico = 0.0;
					voluntario.setSueldoBasico(sueldoBasico);
					trabajadores.add(voluntario);
					JOptionPane.showMessageDialog(null, "Trabajador agregado exitosamente");
				} catch (cuilInvalido e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;	

			case 3:

				nombre = JOptionPane.showInputDialog(" Ingresar Nombre");
				dni = JOptionPane.showInputDialog(" Ingresar DNI");
				cuil = JOptionPane.showInputDialog(" Ingresar CUIL\n (sin  guion)");
				EmpleadoPorHora empleadoPorHora;
				try {
					empleadoPorHora = new EmpleadoPorHora(nombre, dni, cuil);
					int totalDeHoras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total de las horas trabajadas"));
					empleadoPorHora.setHoraTrabajadas(totalDeHoras);
					double valorDeLasHoras = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de las horas"));
					empleadoPorHora.setValorPorHora(valorDeLasHoras);
					trabajadores.add(empleadoPorHora);
					JOptionPane.showMessageDialog(null, "Trabajador agregado exitosamente");
				} catch (cuilInvalido e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ErrorHorasTrabajadas e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}catch (ErrorValorPorHora e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;

			case 4:

				nombre = JOptionPane.showInputDialog(" Ingresar Nombre");
				dni = JOptionPane.showInputDialog(" Ingresar DNI");
				cuil = JOptionPane.showInputDialog(" Ingresar CUIL\n (sin  guion)");
				EmpleadoPorHoraAComision empleadoAComision;
				try {
					double porcentajeDeLaComision =  Integer.parseInt(JOptionPane.showInputDialog(" Porcentaje de comision"));
					empleadoAComision = new EmpleadoPorHoraAComision(nombre, dni, cuil, porcentajeDeLaComision);
					empleadoAComision.setPorcetajeDeComision(porcentajeDeLaComision);
					sueldoBasico = Double.parseDouble(JOptionPane.showInputDialog("Ingresar Sueldo Basico"));
					empleadoAComision.setSueldoBasico(sueldoBasico);
					int totalDeVentas = Integer.parseInt(JOptionPane.showInputDialog(" Ingresar el total de las ventas"));
					empleadoAComision.setTotalDeVentas(totalDeVentas);
					trabajadores.add(empleadoAComision);
					JOptionPane.showMessageDialog(null, "Trabajador agregado exitosamente");
				} catch (cuilInvalido e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (ErrorTotalDeVentas e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}catch(valorDeComisionInvalido e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			}
		}else{
			throw new ValorFueraDeRango("El valor ingresado es incorrecto");
		}
		finalizar();
	}

 
	private static void pagarBono(EmpleadoEjecutivo empleado){

		int choice = JOptionPane.showOptionDialog(null, "¿Desea otorgar el bono?\n", 
				"Bono", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, null, null);

		if(choice == JOptionPane.YES_OPTION){
			double bono = Double.parseDouble(JOptionPane.showInputDialog("Ingresar Bono"));
			try {
				empleado.setBono(bono);
			} catch (BonoInvalido e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	
	private static void modificarTrabajador(String dni)throws TrabajadorNoEncontrado{


		if(estaVacia() == false){

			for(Trabajador trabajador : trabajadores){
				if(dni.equals(trabajador.getDni())){

					if (trabajador instanceof Voluntario) {
						modificarVoluntario((Voluntario) trabajador);
					} else if (trabajador instanceof EmpleadoEjecutivo) {
						modificarEmpleadoEjecutivo((EmpleadoEjecutivo) trabajador);
					} else if (trabajador instanceof EmpleadoPorHora) {
						modificarEmpleadoPorHora((EmpleadoPorHora) trabajador);
					} else if (trabajador instanceof EmpleadoPorHoraAComision) {
						modificarEmpleadoPorHoraAComision((EmpleadoPorHoraAComision) trabajador);
					}		
				}else{
					throw new TrabajadorNoEncontrado("Trabajador no encontrado");
				}
			}
		}else{
			JOptionPane.showMessageDialog(null, "Lista vacia");
		}
	}


	private static void modificarVoluntario(Voluntario voluntario){
		
		String nombre=JOptionPane.showInputDialog("Modificar nombre");
		voluntario.setNombre(nombre);
	}

	private static void modificarEmpleadoEjecutivo(EmpleadoEjecutivo ejecutivo){

		int choice;
		choice = Integer.parseInt(JOptionPane.showInputDialog("Modificar: \n 1-Nombre \n 2-Bono \n 3-Sueldo Basico" ));

		switch(choice){

		case 1:
			String nombre=JOptionPane.showInputDialog("Modificar nombre");
			ejecutivo.setNombre(nombre);
			break;
			
		case 2:	
			double bono = 0;
			if(bono == 0.0){
				bono = Double.parseDouble(JOptionPane.showInputDialog("Modificar Bono"));
				try {
					ejecutivo.setBono(bono);
				} catch (BonoInvalido e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
			
			break;
			
		case 3:
			double sueldoBasico = Double.parseDouble(JOptionPane.showInputDialog("Ingresar Sueldo Basico"));
			ejecutivo.setSueldoBasico(sueldoBasico);
			break;
		}
	}

	private static void modificarEmpleadoPorHora(EmpleadoPorHora empleadoPorHora){

		int choice;
		choice = Integer.parseInt(JOptionPane.showInputDialog("Modificar: \n 1-Nombre \n 2-Valor de la hora \n 3-Horas trabajadas" ));

		switch(choice){

		case 1:
			String nombre=JOptionPane.showInputDialog("Modificar nombre");
			empleadoPorHora.setNombre(nombre);
			break;

		case 2:
			double valorPorhora= Double.parseDouble(JOptionPane.showInputDialog("Modifica el valor de las horas"));
			try {
				empleadoPorHora.setValorPorHora(valorPorhora);
			} catch (ErrorValorPorHora e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;

		case 3:
			int horasTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Modifica el valor de las horas"));
			try {
				empleadoPorHora.setHoraTrabajadas(horasTrabajadas);
			} catch (ErrorHorasTrabajadas e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		}
	}
	
	private static void modificarEmpleadoPorHoraAComision(EmpleadoPorHoraAComision empleadoPorHoraAComision ){

		int choice;
		choice = Integer.parseInt(JOptionPane.showInputDialog("Modificar: \n 1-Nombre \n 2-Porcentaje de Comision "
				+ "\n 3-TotalDeVentas \n 4- Sueldo Basico" ));

		switch(choice){

		case 1:
			String nombre=JOptionPane.showInputDialog("Modificar nombre");
			empleadoPorHoraAComision.setNombre(nombre);
			break;
			
		case 2:
			double comision= Double.parseDouble(JOptionPane.showInputDialog("Modificar Comision"));
			try {
				empleadoPorHoraAComision.setPorcetajeDeComision(comision);
			} catch (valorDeComisionInvalido e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;

		case 3:
			int ventas=Integer.parseInt(JOptionPane.showInputDialog("Modificar total de ventas realizadas"));
			try {
				empleadoPorHoraAComision.setTotalDeVentas(ventas);
			} catch (ErrorTotalDeVentas e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
			
		case 4:
			double sueldoBasico = Double.parseDouble(JOptionPane.showInputDialog("Ingresar Sueldo Basico"));
			empleadoPorHoraAComision.setSueldoBasico(sueldoBasico);
			break;
		}	
	}

	
	private static void listarTrabajadores(){


		if(estaVacia() == true){
			 JOptionPane.showMessageDialog(null, "Lista vacia");
			 finalizar();
		 }else{
			 Collections.sort(trabajadores);
			 crearArchivoConTrabajadores();
		 }
		System.exit(0);
	}

	
	private static boolean estaVacia(){
		return trabajadores.isEmpty();	
	}


	private static void finalizar(){

		int terminar;
		terminar = JOptionPane.showOptionDialog(null, "¿Desea cerrar el menu?\n","Finalizar", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		if(terminar  == JOptionPane.YES_OPTION){
			System.exit(0);
		}else{
			try {
				menu();
			} catch (ValorFueraDeRango e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}


	private static void crearArchivoConTrabajadores(){

		File archivo = new File("C:/Users/ADM/Desktop/Listar.txt");
		try {
			FileWriter escribirEnArchivo = new FileWriter(archivo);

			for(Trabajador t : trabajadores){
				escribirEnArchivo.write(t.toString() + "\r\n");
			}
			escribirEnArchivo.close();
			//abre el archivo automaticamnte
			Desktop.getDesktop().open(archivo);

		} catch (IOException e) {
			System.out.print(e);
		}
	}
}
