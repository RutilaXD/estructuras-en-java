/**
* @author: Raul Guadarrama (c) 2018
* @description:
*	Clase que guarda los atributos de unas bicicletas.
* 	
*	Se utilizó el concepto de encapsulamiento, ya que son
*	atributos exclivos (en este caso) de la bicicleta.
*	
*	Como no se requiere volver a cambiar los nombres de las variables
*	no se utilizaron métodos set.
*/
public class Bicla{
	private String marca;
	private String estilo;
	private String carrera;
	private int rodada;
	private double precio;

	public Bicla(String marca, String estilo, String carrera, int rodada, double precio){
		this.marca = marca;
		this.estilo = estilo;
		this.carrera = carrera;
		this.rodada = rodada;
		this.precio = precio;
	}


 	/*---------Metodos-GET------------
	 * Devuelven el valor solicitado*/	
 	public String getMarca(){
		return this.marca;
	}
	public String getEstilo(){
		return this.estilo;
	}

	public String getCarrera(){
		return this.carrera;
	}

	public int getRodada(){
		return this.rodada;
	}

	public double getPrecio(){
		return this.precio;
	}
}