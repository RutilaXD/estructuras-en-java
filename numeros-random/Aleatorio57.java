public class Aleatorio57 {
	public static void main(String[] args) {
		double num[] = new double[15];
		double x;

		System.out.println("Llenando el arreglo... ");
		for (int i = 0; i < 15; i++) {
			x = 5.0;
			x += 2*Math.random();
			num[i] = x;
		}

		System.out.println("Imprimiendo arreglo: ");
		for (int i = 0; i < 15; i++) {
			System.out.println((i+1)+".- "+num[i]);
		}

		System.out.println("Adios");
	}
}