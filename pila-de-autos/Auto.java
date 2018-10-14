/**
* @author: Raul Guadarrama (c) 2018
* @description:
*	Clase que guarda los atributos de un automóvil.
* 	
*	Se utilizó el concepto de encapsulamiento, ya que son
*	atributos exclivos (en este caso) del Automóvil.
*	
*	Como no se requiere volver a cambiar los nombres de las variables
*	no se utilizaron métodos set.
*/
public class Auto{
	private String nombre;
	private String marca;
	private int modelo;
	private double precio;

	public Auto(String nombre, String marca, int model, double precio){
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = model;
		this.precio = precio;
	}
	
	/*---------Metodos-GET------------
	 * Devuelven el valor solicitado*/
	public String getNombre(){
		return this.nombre;
	}
	
	public String getMarca(){
		return this.marca;
	}

	public int getModelo(){
		return this.modelo;
	}

	public double getPrecio(){
		return this.precio;
	}
}