public class Aleatorio129 {
	public static void main(String[] args) {
		double num[] = new double[25];
		double x;

		System.out.println("Llenando el arreglo... ");
		for (int i = 0; i < 25; i++) {
			x = 129*Math.random();
			num[i] = x;
		}

		System.out.println("Imprimiendo arreglo: ");
		for (int i = 0; i < 25; i++) {
			System.out.println((i+1)+".- "+num[i]);
		}

		System.out.println("Adios");
	}
}