package Empresa;

public class Cuil {

	private String dni; 
	private Genero genero;
	private String cuil;


	public Cuil (String dni, Genero genero){
		this.dni = dni;	
		this.genero = genero;
	}

	public void setCuil(){
		cuil =  numeroAleatorio(genero) + "-" + numeroDeDniMasCeros() + "-" + numeroVerificador();		
	}

	public String getCuil(){
		return this.cuil;
	}

	private int numeroAleatorio(Genero genero){

		int numeroAleatorio = 0;

		switch(genero){
		case F:
			numeroAleatorio = 27;
			break;
		case M:
			numeroAleatorio = 20;
			break;
		case I:
			numeroAleatorio = 23;
			break;
		case E:
			numeroAleatorio = 30;
			break;
		case O:
			numeroAleatorio = 24;
			break;
		}
		return numeroAleatorio;

	}
	
	private String numeroDeDniMasCeros(){

		String [] dniVector = dni.split("");
		int aux = 8 - dniVector.length;
		
		if(aux == 0){
			return this.dni;
		}
		if(dniVector.length < 8){
			String cero = "0";
			for(int i = 0; i < aux; i++){
				dni = cero +this.dni;
			}
		}
		return dni;
	}
		
	private int numeroVerificador(){
		
		String aux = numeroAleatorio(genero) + numeroDeDniMasCeros();

		String [] dniVector = aux.split("");
		int [] pasaje = new int [dniVector.length];

		try{
			for(int i =0; i<dniVector.length;i++){
				pasaje[i] = Integer.parseInt(dniVector[i]);
			}
		}catch(NumberFormatException e){
			System.out.print("formato Invalido");
		}

		int [] resultado = new int [dniVector.length];
		int [] multiplicidad = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
		for(int i =0; i<dniVector.length;i++){
			resultado[i] = multiplicidad[i] * pasaje[i];
		}

		int acumulador = 0;
		for(int i =0; i<dniVector.length;i++){
			acumulador+= resultado[i];
		}

		int restoDeLaDivision = acumulador%11;
		int numeroVerificador = 11-restoDeLaDivision;
		return numeroVerificador;
	}


}
