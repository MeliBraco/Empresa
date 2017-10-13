package Empresa;

import Excepciónes.*;

public class EmpleadoPorHora extends Empleado{

	private double valorPorHora;
	private int horasTrabajadas;
	
	public EmpleadoPorHora(String nombre, String dni,String cuil)throws cuilInvalido{
		super(nombre,dni,cuil);
	}
	
	public void setValorPorHora(double valorPorHora)throws ErrorValorPorHora {
		
		if(valorPorHora >= 0){
			this.valorPorHora = valorPorHora;
		}else{
			throw new ErrorValorPorHora("El valor por hora es incorrecto");
		}
	}
	
	public double getValorDeLaHora(){
		return this.valorPorHora;
	}
	
	public void setHoraTrabajadas(int horasTrabajadas)throws ErrorHorasTrabajadas{
		
		if(horasTrabajadas >= 0){
			this.horasTrabajadas = horasTrabajadas;
		}else{
			throw new ErrorHorasTrabajadas("La cantidad de horas trabajadas es incorrecta");
		}
	}
	
	public double getHorasTrabajadas(){
		return this.horasTrabajadas;
	}
	
	public double getSueldoBasico(){
		
		double sueldoPorHora =  (this.horasTrabajadas *  this.valorPorHora);
		return sueldoPorHora;
	}
}
