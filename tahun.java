import java.io.*;
public class tahun {
	public static void main (String [] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Masukan nilai tabungan : ");
		int nabung = Integer.parseInt (br.readLine());
		System.out.println();
		System.out.println("Tahun		4%	5%	6%	7%			");
		System.out.println("==========================================");
		int a,b;
		double hasil;
		
		
		for (a=1;a<=10; a++){
			System.out.print ("Tahun ke-"+a+"    =");
		for (b=4;b<=7;b++) {
		hasil = nabung+ (nabung*a*b/100);
			System.out.print (hasil+"	");
			System.out.print("    ");
		}
		System.out.println();
		}
	}
}