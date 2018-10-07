/**
* @author: Raul Guadarrama (c) 2018
* @description:
* Programa que almacenará n cadenas de caracteres en una
* pila.
*
* La pila es una estructura de datos PEPS (Primeras Entradas | Primeras Salidas)
* Para ingresar un dato, se utiliza un método llamado Push
* Para eliminar un dato, se utiliza un método llamado Pop
*
* Contacto:
* 	-> mail: raul.guadarrama5102@gmail.com
*
*
* Si deseas saber más de mi, visita: 
*		* Github: github.com/RutilaXD
*		* IG, FB, TW: @SoyRuloGM
*/
import java.util.Scanner;

public class PilaNombres {
	/*
		Las siguientes variables se declararon globales puesto que se usarán
		en todo el programa.

		-> nombres[] guardará las cadenas de caracteres
		-> in es la variable que permitirá leer los datos inbgresados en el teclado
		-> tam servirá para saber el tamaño del arreglo nombres[]
		-> tope nos indicará el número de cadenas en la pila
	*/
	static String nombres[];
	static Scanner in;
	static int tam, tope;

	/**
	* Constructor
	*/
	public PilaNombres (){
		tope = 0;
		tam = 0;
	}


	/*
	* Metodo para agregar datos 
	*/
	public static void push(){
		// Verificamos que la pila tenga espacio disponible
		if(tope<=tam-1){
			System.out.print("Ingresa el nombre: ");
			
			
			/*
				En caso de que la pila tenga más de un elemento,
				al ingresar un nuevo dato, se tiene que mover a la
				posición siguiente los demás elementos.

				-> j es una variable que va a ayudar a saber la posición
				anterior, para con ello, mover el elemento a la siguiente
				posición.

				-> i es una variable que permitirá mover los elementos
				de lugar, puesto que con ella se sabe la posición siguiente
				a la cual mover los elementos en la pila
			*/
			if(tope != 0){
				int j = 1;
				for (int i = tope; i >= 1; i--) {
					nombres[i] = nombres[tope-j];
					j++; 
				}				
			}
			
			//El nuevo dato siempre se añade al principio
			nombres[0] = in.next();
			//Como se aumenta el numero de elementos en la pila, se aumenta el tope
			tope++;
			System.out.println("Dato agregado!!");
		}else{
			System.out.println("Pila llena, ya no se pueden agregar mas datos");
		}

	}

	/**
	* Método que elimina datos de la pila
	*/
	public static void 	pop(){
		//Verificamos si hay elementos para eliminar
		if (tope > 0) {
			/*
				En esta sección se recorre todo el arreglo, pero si
				sólo tiene un elemento, no tiene caso recorrerlo.
				Por ello se evalua si el tope es mayor a uno.

			*/
			if (tope > 1) {
				int i = 0;

				//Recorre los elementos a la posición anterior.
				for (i = 1; i < tope; i++) {
					nombres[i-1] = nombres[i];
				}

				//Se elimina el último elemento
				nombres[i-1] = null;
				//Como hay un datos menos, se reduce el tope
				tope--;								
			}else{
				nombres[0] = null;
				tope = 0;
			}
			System.out.println("Dato eliminado");
		}else{
			System.out.println("La pila esta vacia!!");
		}
	}	

	/*
	* Regresa el tamaño de la pila
	* Verificando primero si está vacía.
	*/
	public static void tamanio(){
		if(tope==0) System.out.println("Pila vacia");
		else System.out.println("Tiene "+tope+" Datos");

	}

	/*
	* Imprime los elementos de la pila
	*/
	public static void imprimir(){
		if (tope > 0) {
			for (int i = 0; i < tope; i++) {
				System.out.println((i+1)+".- "+nombres[i]);
			}
		}else{
			System.out.println("No hay elementos para imprimir!!"); 	
		}
	}

	/*
	* Programa principal.
	* 
	* Se utilizará un menú para poder realizar operaciónes push y pop en la pila
	* cuantas veces el usuario lo requiera, para ello se utilizan las siguientes variables
	* 
	* -> opc: para inidicar al programa qué operación hacer con la pila
	* -> seguir: para preguntar al usuario si desea permanecer en el programa
	*
	* Se utiliza un arreglo, el cual, por definición, ya tiene un tamaño establecido,
	* por este motivo se pregunta al usuario, al inicio del programa, que indique cuántos
	* elementos agregará.
	*/
	public static void main(String[] args) {
		int opc = 0;
		in = new Scanner(System.in);
		char seguir = 's';

		System.out.print("Ingresa cuantos nombres guardaras: ");
		tam = in.nextInt();
		nombres = new String[tam];

		do {
			System.out.println("Que accion quieres hacer?");
			System.out.println("\t1. Push\n\t2. Pop");
			System.out.println("\t3. Comprobar tamanio\n\t4. Imprimir Pila");
			opc = in.nextInt();

			switch (opc) {
				case 1: push();
					break;
				case 2: pop();
					break;
				case 3: tamanio(); 
					break;
				case 4: imprimir();
					break;

			}

			System.out.print("Seguir? s/n ");
			seguir = in.next().charAt(0);

		}while(seguir=='s' || seguir=='S');
		System.out.println("Nos vemos pronto! ;)");
	}
}
