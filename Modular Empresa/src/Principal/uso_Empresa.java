package Principal;

import Empresa.*;
import Excepciónes.*;



public class uso_Empresa {

	
	public static void main(String []args){ 

		/*
		EmpresaNueva e1 = new EmpresaNueva();
		
		
		try {
			EmpleadoEjecutivo emp1= new EmpleadoEjecutivo("Romina Ejecutiva","83456789","21834567890");
			EmpleadoEjecutivo emp2= new EmpleadoEjecutivo("Carlos Ejecutivo","12345678","21123456789");
			EmpleadoPorHora emp3 = new EmpleadoPorHora("Pepe PorHora","13456789","20134567895");
			EmpleadoPorHoraAComision emp4 = new EmpleadoPorHoraAComision("Juan Acomision", "71234567", "20712345678", 10.0);
			Voluntario emp5 = new Voluntario("Ariel Voluntario", "13356789","20133567890");
			
			emp1.setSueldoBasico(5000.0);
			emp2.setSueldoBasico(4000.0);
			emp3.setSueldoBasico(3000.0);
			emp3.setHoraTrabajadas(20);
			emp3.setValorPorHora(2);
			emp4.setSueldoBasico(6000.0);
			emp4.setTotalDeVentas(100);
			emp4.setPorcetajeDeComision(2);
			emp5.setSueldoBasico(5000.0);
			emp1.setBono(12.5);

			e1.agregarEmpleado(emp1);
			e1.agregarEmpleado(emp2);
			e1.agregarEmpleado(emp3);
			e1.agregarEmpleado(emp4);
			e1.agregarEmpleado(emp5);

			System.out.print(e1.obtenerSueldoSegunTrabajador(emp1));
			
		} catch (cuilInvalido e) {
			System.out.print(e);
		} catch (ErrorHorasTrabajadas e) {
			System.out.print(e);
		} catch (ErrorTotalDeVentas e) {
			System.out.print(e);
		} catch (ErrorValorPorHora e) {
			System.out.print(e);
		}catch (valorDeComisionInvalido e) {
			System.out.print(e);
		}catch (BonoInvalido e) {
			System.out.print(e);
		}
*/
		Cuil c = new Cuil("20860395",Genero.F);
		c.setCuil();
		System.out.println(c.getCuil());
		Cuil c1 = new Cuil("16204423",Genero.M);
		c1.setCuil();
		System.out.print(c1.getCuil());
		
		
		//e1.listarEmpleados();
	}
}
