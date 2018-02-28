import java.io.*;

public class skor {
	
		
		public static String Nilai(int a) {
			String hasil= " ";
			if (100>=a&&a>=90) {
			hasil= "A";}
			if (89>=a&&a>=80) {
			hasil= "B";}
			if (79>=a&&a>=70) {
			hasil= "C"; }
			if (69>=a&&a>=60) {
			hasil= "D"; }
			if (59>=a&&a>=50) {
			hasil= "E"; }
			if (49>=a&&a>=40) {
			}
			
			
			if 39-0 {
				hasil="f";
			}
			return hasil;
		}
			
		
		public static void main(String[] args)throws IOException {
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Masukan nilai : ");
			
			int nilai =Integer.parseInt(br.readLine());
			
			String huruf =Nilai(nilai);
			System.out.println("nilai anda : "+huruf);
}		}