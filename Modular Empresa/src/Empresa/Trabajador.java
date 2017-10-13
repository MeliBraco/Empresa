package Empresa;


import Excepciónes.*;

public class Trabajador implements Comparable<Trabajador>{
	
	private String nombre;
	private final String dni;
	private String cuil;
	private double sueldoBasico;
	private int nuevoDni;
	
	public Trabajador(String nombre, String dni, String cuil)throws cuilInvalido{
		
		this.nombre = nombre;
		this.dni = dni;
		this.cuil= cuil;

		validarCuil();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getSueldoBasico()  {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		
		this.sueldoBasico = sueldoBasico;
	}
	
	public void setCuil(String cuil){
		this.cuil = cuil;
	}

	public String getCuil() {
		return this.cuil;
	}
	
	private boolean validarCuil()throws cuilInvalido{

		String aux = this.cuil.substring(2,10);
		boolean esValido;
		if(this.dni.equals(aux)){
			esValido = true;
		}else{
			esValido = false;
			throw new cuilInvalido("El Cuil ingresado no es valido");
		}
		return esValido;
	}

	public String generarCuil(Genero genero){
		Cuil cuil = new Cuil(this.dni, genero);
		cuil.setCuil();
		return cuil.getCuil();
	}
	
	
	public String toString(){
		return "NOMBRE: " + getNombre() + " DNI:" + getDni()  + " CUIL: " + this.cuil +
				" SUELDO BASICO: " + getSueldoBasico();
	}	

	@Override
	public int compareTo(Trabajador o) {

		 nuevoDni = Integer.parseInt(dni);

		int resultado=0;
        if (this.getSueldoBasico()<o.getSueldoBasico()) {   resultado = -1;      }
        else if (this.getSueldoBasico()>o.getSueldoBasico()) {    resultado = 1;      }
        else {
        	if (this.nuevoDni < o.nuevoDni) {  resultado = -1;    }
        	else if (this.nuevoDni>o.nuevoDni) {   resultado = 1;   }
        	else {   resultado = 0;   }
        }
        return resultado;

	}
}

