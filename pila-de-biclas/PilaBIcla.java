/**
* @author: Raul Guadarrama (c) 2018
* @description:
* Programa que almacenará n biclas (Bicicletas) en una
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

public class PilaBIcla {
	/*
		Las siguientes variables se declararon globales puesto que se usarán
		en todo el programa.

		-> biclas[] arreglo de objetos que guardará los biclas
		-> in es la variable que permitirá leer los datos inbgresados en el teclado
		-> tam servirá para saber el tamaño del arreglo nombres[]
		-> tope nos indicará el número de cadenas en la pila
	*/
	static Bicla biclas[];
	static Scanner in;
	static int tam, tope;

	/**
	* Constructor
	*/
	public PilaBIcla (){
		tope = 0;
		tam = 0;
	}


	/*
	* Metodo para agregar datos 
	*/
	public static void push(){
		String marca, estilo, carrera;
		int rodada;
		double precio;

		// Verificamos que la pila tenga espacio disponible
		if(tope<=tam-1){
			
			System.out.print("Ingresa la marca del Bicla: ");
			marca = in.next();
			System.out.print("Ingresa el estilo del Bicla: ");
			estilo = in.next();
			System.out.print("Ingresa la carrera del Bicla: ");
			carrera = in.next();			
			System.out.print("Ingresa la rodada de la Bicla: ");
			rodada = in.nextInt();
			System.out.print("Ingresa el precio del Bicla: ");
			precio = in.nextDouble();
			
			//creamos un objeto Bicla para agregarlo al arreglo biclas[]
			Bicla bi = new Bicla(marca,estilo,carrera,rodada,precio);
			
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
					biclas[i] = biclas[tope-j];
					j++; 
				}				
			}
			
			//El nuevo dato siempre se añade al principio
			biclas[0] = bi;
			//Como se aumenta el numero de elementos en la pila, se aumenta el tope
			tope++;
			System.out.println("Bicla agregada!!");
		}else{
			System.out.println("Pila llena, ya no se pueden agregar mas biclas");
		}

	}

	/**
	* Método que elimina biclas de la pila
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
					biclas[i-1] = biclas[i];
				}

				//Se elimina el último elemento
				biclas[i-1] = null;
				//Como hay un datos menos, se reduce el tope
				tope--;								
			}else{
				biclas[0] = null;
				tope = 0;
			}
			System.out.println("Bicla eliminada");
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
		else System.out.println("Tiene "+tope+" biclas");

	}

	/*
	* Imprime los elementos de la pila
	*/
	public static void imprimir(){
		if (tope > 0) {
			for (int i = 0; i < tope; i++) {
				System.out.println("Bicla no. "+(i+1));
				System.out.println("\tMarca: "+biclas[i].getMarca());
				System.out.println("\tEstilo: "+biclas[i].getEstilo());
				System.out.println("\tCarrera: "+biclas[i].getCarrera());
				System.out.println("\tRodada: "+biclas[i].getRodada());
				System.out.println("\tPrecio: $"+biclas[i].getPrecio());
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

		System.out.print("Ingresa cuantas biclas guardaras: ");
		tam = in.nextInt();
		biclas = new Bicla[tam];

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