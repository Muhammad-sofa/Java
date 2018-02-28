import java.io.*;

public class Jurusan {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	
		
		System.out.println("Masukan NIM belakang anda: ");
		int NIM =Integer.parseInt (br.readLine ());
		
		System.out.println("Masukan Nama: ");
		String Nama = br.readLine ();
		
		System.out.println("Masukan Nama Jurusan: ");
		String Jurusan = br.readLine();
	
		
		switch(angka){
			case 1:
				System.out.println("Sistem Informasi");
				break;
			case 2:
				System.out.println("Sistem Komputer");
				break;
			case 3:
				System.out.println("Desain Komunikasi Visual");
				break;
			default:
				System.out.println("Pilihan Tidak Ada");
				break;
	

			
		
		
		}	
	}
}	