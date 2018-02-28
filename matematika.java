import java.util.Scanner;

public class matematika {
	public static void main(String[] args) {
		Scanner masuk=new Scanner(System.in);
		
		String pertambahan;
		String perkalian;
		int a,b,c;
		
		System.out.print("Bilangan 1: ");
		a=masuk.nextInt();
		System.out.print("Bilangan 2: ");
		b=masuk.nextInt();
		
		c=a+b;
		System.out.println("Bilangan 1: "+a+" + "+b+" = "+c);
		c=a*b;
		System.out.println("Bilangan 2: "+a+" * "+b+" = "+c);
		c=a*b;
		System.out.println("Sisa bagi : "+a+" % "+b+" = "+c);
	}
}