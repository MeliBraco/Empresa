package Principal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Empresa.*;
import Excepciónes.*;

public class EmpresaTest {

	// Principal clase trabajador
	@Test
	public void creaTrabajador() throws cuilInvalido {

		Trabajador trabajadorUno = new Trabajador("julian", "40305999", "20403059995");
		assertEquals("julian", trabajadorUno.getNombre());
		assertEquals("40305999", trabajadorUno.getDni());
		assertEquals("20403059995", trabajadorUno.getCuil());
	}

	@Test
	public void obtenerCuil() throws cuilInvalido {
		Trabajador trabajadorUno = new Trabajador("julian", "40305999", "20403059995");
		assertEquals("20403059995", trabajadorUno.getCuil());
	}

	@Test(expected = cuilInvalido.class)
	public void crearTrabajadorConCuilInvalido() throws cuilInvalido {
		@SuppressWarnings("unused")
		Trabajador trabajadorUno = new Trabajador("julian", "40555777", "20111111115");
	}

	@Test
	public void obtenerDNI() throws cuilInvalido {
		Trabajador trabajadorUno = new Trabajador("julian", "40305999", "20403059995");
		assertEquals("40305999", trabajadorUno.getDni());
	}

	@Test
	public void comprobarSueldo() throws cuilInvalido {
		Trabajador trabajadorUno = new Trabajador("julian", "40305999", "20403059995");
		trabajadorUno.setSueldoBasico(12000);
		assertEquals(12000, trabajadorUno.getSueldoBasico(), 0.0);
	}

	// Principal clase Cuil
	@Test
	public void generarCuilGeneroFemenino() throws cuilInvalido {
		Cuil c = new Cuil("36901352", Genero.F);
		c.setCuil();
		assertEquals("27-36901352-7", c.getCuil());
	}

	@Test
	public void generarCuilGeneroMasculino() throws cuilInvalido {
		Cuil c = new Cuil("40305999", Genero.M);
		c.setCuil();
		assertEquals("20-40305999-5", c.getCuil());
	}

	@Test
	public void generarCuilEmpresa() throws cuilInvalido {
		Cuil c = new Cuil("39878279", Genero.E);
		c.setCuil();
		;
		assertEquals("30-39878279-4", c.getCuil());
	}

	@Test
	public void generarCuilGeneroIndefinido() throws cuilInvalido {
		Cuil c = new Cuil("39878279", Genero.I);
		c.setCuil();
		;
		assertEquals("23-39878279-8", c.getCuil());
	}

	@Test
	public void generarCuilOtro() throws cuilInvalido {
		Cuil c = new Cuil("39878279", Genero.O);
		c.setCuil();
		;
		assertEquals("24-39878279-4", c.getCuil());
	}

	// Principal de la clase EmpleadoEjecutivo
	@Test
	public void crearEmpleadoEjecutivo() throws cuilInvalido {
		EmpleadoEjecutivo empleadoUno = new EmpleadoEjecutivo("julian", "40305999", "20403059995");
		assertEquals("julian", empleadoUno.getNombre());
		assertEquals("40305999", empleadoUno.getDni());
	}

	@Test
	public void obtenerSueldo() throws cuilInvalido, BonoInvalido {
		EmpleadoEjecutivo empleadoUno = new EmpleadoEjecutivo("julian", "40305999", "20403059995");
		empleadoUno.setSueldoBasico(500);
		assertEquals(500, empleadoUno.getSueldoBasico(), 0.0);
	}

	@Test
	public void obtenerSueldoMasBono() throws cuilInvalido, BonoInvalido {
		EmpleadoEjecutivo empleadoUno = new EmpleadoEjecutivo("julian", "40305999", "20403059995");
		empleadoUno.setSueldoBasico(500);
		empleadoUno.setBono(100.5);
		assertEquals(600.5, empleadoUno.getSueldoBasico(), 0.0);
	}

	@Test(expected = BonoInvalido.class)
	public void otorgarBonoMasDeUnaVez() throws BonoInvalido, cuilInvalido {
		EmpleadoEjecutivo empleadoUno = new EmpleadoEjecutivo("julian", "40305999", "20403059995");
		empleadoUno.setSueldoBasico(500);
		empleadoUno.setBono(200);
		empleadoUno.setBono(300);

	}

	// Principal de la clase EmpleadoPorHora

	@Test
	public void crearEmpleadoPorHora() throws cuilInvalido {
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40305999", "20403059995");
		assertEquals("julian", empleado.getNombre());
		assertEquals("40305999", empleado.getDni());
		assertEquals("20403059995", empleado.getCuil());
	}

	@Test(expected = cuilInvalido.class)
	public void crearEmpleadoConCuilInvalido() throws cuilInvalido {
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40355999", "20403059995");
		assertEquals("20403059995", empleado.getCuil());
	}

	@Test
	public void setValorDeLaHora() throws cuilInvalido, ErrorValorPorHora {
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40305999", "20403059995");
		empleado.setValorPorHora(12.5);
		assertEquals(12.5, empleado.getValorDeLaHora(), 0.0);
	}

	@Test(expected = ErrorValorPorHora.class)
	public void setValorHoraInvalida() throws cuilInvalido, ErrorValorPorHora {
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40305999", "20403059995");
		empleado.setValorPorHora(-12.5);
	}

	@Test(expected = ErrorValorPorHora.class)
	public void setValorHoraCero() throws cuilInvalido, ErrorValorPorHora {
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40305999", "20403059995");
		empleado.setValorPorHora(0);
	}

	@Test
	public void setCantidadDeHoras() throws cuilInvalido, ErrorHorasTrabajadas {
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40305999", "20403059995");
		empleado.setHoraTrabajadas(10);
		assertEquals(10, empleado.getHorasTrabajadas(), 0.0);
	}

	@Test(expected = ErrorHorasTrabajadas.class)
	public void setCantidadDeHorasInvalidas() throws cuilInvalido, ErrorHorasTrabajadas {
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40305999", "20403059995");
		empleado.setHoraTrabajadas(-10);
	}

	@Test(expected = ErrorHorasTrabajadas.class)
	public void setCantidadDeHorasIgualACero() throws cuilInvalido, ErrorHorasTrabajadas {
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40305999", "20403059995");
		empleado.setHoraTrabajadas(0);
	}

	// Principal de EmpleadoPorHoraAComision

	@Test
	public void crearEmpleadoPorHoraAComision() throws cuilInvalido {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 10);
		assertEquals("julian", empleado.getNombre());
		assertEquals("40305999", empleado.getDni());
		assertEquals("20403059995", empleado.getCuil());
	}

	@Test(expected = cuilInvalido.class)
	public void crearEmpleadoPorHoraAComisionConCuilInvalido() throws cuilInvalido {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40355999", "20403059995", 14);
		assertEquals("20403059995", empleado.getCuil());

	}

	@Test
	public void modificarValorDeLaComision() throws cuilInvalido, valorDeComisionInvalido {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 20);
		assertEquals(20, empleado.getPorcentajeDeComision(), 0.0);
		empleado.setPorcetajeDeComision(15);
		assertEquals(15, empleado.getPorcentajeDeComision(), 0.0);
	}

	@Test(expected = valorDeComisionInvalido.class)
	public void modificarComisionIgualACero() throws cuilInvalido, valorDeComisionInvalido {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 20);
		assertEquals(20, empleado.getPorcentajeDeComision(), 0.0);
		empleado.setPorcetajeDeComision(0);
		assertEquals(0, empleado.getPorcentajeDeComision(), 0.0);
	}

	@Test(expected = valorDeComisionInvalido.class)
	public void modificarComisionValorNegativo() throws cuilInvalido, valorDeComisionInvalido {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 20);
		assertEquals(20, empleado.getPorcentajeDeComision(), 0.0);
		empleado.setPorcetajeDeComision(-23);
		assertEquals(-23, empleado.getPorcentajeDeComision(), 0.0);
	}

	@Test
	public void indicarVentas() throws cuilInvalido, ErrorTotalDeVentas {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 20);
		empleado.setTotalDeVentas(100);
		assertEquals(100, empleado.getTotalDeVentas());
	}

	@Test
	public void indicarVentasIgualACero() throws cuilInvalido, ErrorTotalDeVentas {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 20);
		empleado.setTotalDeVentas(0);
		assertEquals(0, empleado.getTotalDeVentas());
	}

	@Test(expected = ErrorTotalDeVentas.class)
	public void indicarVentasConValorNegativo() throws cuilInvalido, ErrorTotalDeVentas {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 20);
		empleado.setTotalDeVentas(-13);
		assertEquals(-13, empleado.getTotalDeVentas());
	}

	@Test
	public void empleadoPorHoraAComision_obtenerSueldo() throws cuilInvalido, ErrorTotalDeVentas {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 10);
		empleado.setSueldoBasico(1000);
		empleado.setTotalDeVentas(100);
		assertEquals(1010, empleado.getSueldoBasico(), 0.5);
	}

	@Test(expected = ErrorTotalDeVentas.class)
	public void empleadoPorHoraAComision_obtenerSueldoInvalido() throws cuilInvalido, ErrorTotalDeVentas {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 10);
		empleado.setSueldoBasico(1000);
		empleado.setTotalDeVentas(-100);

	}

	// Principal de la Clase voluntario

	@Test
	public void crearVoluntario() throws cuilInvalido {
		Voluntario voluntario = new Voluntario("julian", "40305999", "20403059995");
		assertEquals("julian", voluntario.getNombre());
		assertEquals("40305999", voluntario.getDni());
		assertEquals("20403059995", voluntario.getCuil());
	}

	@Test(expected = cuilInvalido.class)
	public void crearVoluntarioConCuilInvalido() throws cuilInvalido {
		Voluntario voluntario = new Voluntario("julian", "40355999", "20403059995");
		assertEquals("julian", voluntario.getNombre());
		assertEquals("20403059995", voluntario.getCuil());
	}

	// Principal de la clase Empresa

	@Test
	public void agregarEmpleadoEjecutivo_ALaEmpresa() throws cuilInvalido {
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		EmpleadoEjecutivo empleado = new EmpleadoEjecutivo("julian", "40305999", "20403059995");
		empleado.setSueldoBasico(400);
		trabajadores.add(empleado);
		assertEquals(1, trabajadores.size());
	}

	@Test
	public void agregarEmpleadoPorHora_ALaLista() throws cuilInvalido {
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40305999", "20403059995");
		trabajadores.add(empleado);
		assertEquals(1, trabajadores.size());
	}

	@Test
	public void agregarEmpleadoPorHoraAComision_ALaLista() throws cuilInvalido {
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 10);
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores.add(empleado);
		assertEquals(1, trabajadores.size());

	}

	@Test
	public void agregarVoluntario_ALaLista() throws cuilInvalido {
		Voluntario voluntario = new Voluntario("julian", "40305999", "20403059995");
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores.add(voluntario);
		assertEquals(1, trabajadores.size());

	}

	@Test
	public void obtenerInformacionDe_EmpleadoEjecutivo() throws cuilInvalido {
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		Trabajador empleado = new EmpleadoEjecutivo("julian", "40305999", "20403059995");
		empleado.setSueldoBasico(20000);
		trabajadores.add(empleado);
		for (Trabajador t : trabajadores) {
			if (empleado.getDni().equals(t.getDni())) {
				assertEquals(empleado.getDni(), t.getDni());
				assertEquals(empleado.getNombre(), t.getNombre());
				assertEquals(empleado.getSueldoBasico(), t.getSueldoBasico(), 0.0);
				assertEquals(empleado.getCuil(), t.getCuil());
			}
		}
	}

	@Test
	public void obtenerInformacionDe_EmpleadoPorHora() throws cuilInvalido, ErrorHorasTrabajadas, ErrorValorPorHora {
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		EmpleadoPorHora empleado = new EmpleadoPorHora("julian", "40305999", "20403059995");
		empleado.setValorPorHora(10);
		empleado.setHoraTrabajadas(10);
		trabajadores.add(empleado);
		for (Trabajador t : trabajadores) {
			if (empleado.getDni().equals(t.getDni())) {
				assertEquals(empleado.getDni(), t.getDni());
				assertEquals(empleado.getNombre(), t.getNombre());
				assertEquals(empleado.getSueldoBasico(), t.getSueldoBasico(), 0.0);
				assertEquals(empleado.getCuil(), t.getCuil());
			}
		}

	}

	@Test
	public void obetenerInformacionDe_EmpleadoPorHoraAComision() throws cuilInvalido {
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		EmpleadoPorHoraAComision empleado = new EmpleadoPorHoraAComision("julian", "40305999", "20403059995", 10);
		empleado.setSueldoBasico(3000);
		trabajadores.add(empleado);
		for (Trabajador t : trabajadores) {
			if (empleado.getDni().equals(t.getDni())) {
				assertEquals(empleado.getDni(), t.getDni());
				assertEquals(empleado.getNombre(), t.getNombre());
				assertEquals(empleado.getSueldoBasico(), t.getSueldoBasico(), 0.0);
				assertEquals(empleado.getCuil(), t.getCuil());

			}
		}
	}

	@Test
	public void obtenerInformacionDe_Voluntario() throws cuilInvalido {
		List<Trabajador> trabajadores = new ArrayList<Trabajador>();
		Voluntario empleado = new Voluntario("julian", "40305999", "20403059995");
		trabajadores.add(empleado);
		for (Trabajador t : trabajadores) {
			if (empleado.getDni().equals(t.getDni())) {
				assertEquals(empleado.getDni(), t.getDni());
				assertEquals(empleado.getNombre(), t.getNombre());
				assertEquals(empleado.getCuil(), t.getCuil());

			}
		}

	}

}
