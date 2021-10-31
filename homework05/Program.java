import java.util.Scanner;
class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int n = 0;
		int p = 0;
		int min = 9;

		while (x != -1) {
			n = Math.abs(x);
			while (n!= 0) {
				p = n%10;
				if (p < min) {
					min = p;
				}
				n = n/10;
			}
			x = scanner.nextInt();
		}
		System.out.println(min);
	}
}