public class Aleatorio56 {
	public static void main(String[] args) {
		double num[] = new double[20];
		double x;

		System.out.println("Llenando el arreglo... ");
		for (int i = 0; i < 20; i++) {
			x = 5.0;
			x += Math.random();
			num[i] = x;
		}

		System.out.println("Imprimiendo arreglo: ");
		for (int i = 0; i < 20; i++) {
			System.out.println((i+1)+".- "+num[i]);
		}

		System.out.println("Adios");
	}
}