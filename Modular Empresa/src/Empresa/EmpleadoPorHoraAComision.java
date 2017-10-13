package Empresa;

import Excepciónes.*;

public class EmpleadoPorHoraAComision extends Trabajador {

	private int totalDeVentas;
	private double porcentajeDeComision;

	public EmpleadoPorHoraAComision(String nombre, String dni, String cuil, double porcentajeDeComision)
			throws cuilInvalido {
		super(nombre, dni, cuil);
		this.porcentajeDeComision = porcentajeDeComision;
	}

	public void setPorcetajeDeComision(double porcentajeDeComision) throws valorDeComisionInvalido {
		if (porcentajeDeComision >= 0) {
			this.porcentajeDeComision = porcentajeDeComision;
		} else {
			throw new valorDeComisionInvalido("El valor de la comision es incorrecta");
		}
	}

	public double getPorcentajeDeComision() {
		return this.porcentajeDeComision;
	}

	public void setTotalDeVentas(int totalDeVentas) throws ErrorTotalDeVentas {

		if (totalDeVentas >= 0) {
			this.totalDeVentas = totalDeVentas;
		} else {
			throw new ErrorTotalDeVentas("La cantidad de ventas ingresadas deben ser mayor a cero");
		}
	}

	public int getTotalDeVentas() {
		return this.totalDeVentas;
	}

	public double getSueldoBasico() {

		double sueldoTotal = super.getSueldoBasico() + ((this.totalDeVentas * this.porcentajeDeComision) / 100);
		return sueldoTotal;
	}
}
