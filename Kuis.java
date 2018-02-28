import java.io.*;
public class Kuis {
public static void main (String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("================================");
		System.out.println("         PT. Jaya Abadi         ");
		System.out.println("================================");
		System.out.println(" ");
		
		System.out.println("1. Golongan A = 4000");
		System.out.println("2. Golongan B = 5000");
		System.out.println("3. Golongan C = 6000");
		System.out.println("4. Golongan D = 7000");
		
		System.out.println("Masukan pilihan anda : ");
		int pilih =Integer.parseInt(br.readLine()); 
		System.out.println("Masukan jam kerja : ");
		int jjk=Integer.parse.Int(br.readLine());
		
		
		if (jjk<=48) {
			int upah;
		}
		if (jjk>48) {
			int upahh;
		}
		if (pilih ==1) {
		int upj =4000;
		System.out.println("Golongan A");
		int upah=jjk*upj;
		int upahh =((48*upj)+(jjk-48)*3000);
			
			if (jjk<=48) {
			System.out.println("upah : "+upah);
			}
			else
			System.out.println("upah : "+upahh);
		}
		if (pilih ==2) {
		int upj =5000;
		System.out.println("Golongan B");
		int upah=jjk*upj;
		int upahh =((48*upj)+(jjk-48)*3000);
			
			if (jjk<=48) {
			System.out.println("upah : "+upah);
			}
			else 
			System.out.println("upah : "+upahh);
			}
		}
		if (pilih ==3) {
		int upj =6000;
		System.out.println("Golongan C");
		int upah=jjk*upj;
		int upahh =((48*upj)+(jjk-48)*3000);
			
			if (jjk<=48) {
			System.out.println("upah : "+upah);
			}
			else
			System.out.println("upah : "+upahh);
		}
		if (pilih ==4) {
		int upj =7000;
		System.out.println("Golongan D");
		int upah=jjk*upj;
		int upahh =((48*upj)+(jjk-48)*3000);
			
			if (jjk<=48) {
			System.out.println("upah : "+upah);
			}
			else
			System.out.println("upah : "+upahh);
		}
}
}