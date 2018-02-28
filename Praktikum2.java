import java.io.*;

public class Praktikum2 {
	public static void main (String[] args) throws IOException {
	int i = 1;
				
		BufferedReader ind = new BufferedReader (new InputStreamReader (System.in));
		
	System.out.println("===========================================================");
	System.out.println("=======================<< INPUTAN >>=======================");
	System.out.println("===========================================================");
	System.out.println("");
		
		System.out.print("Masukkan Nama Anda		: ");
		String nama = ind.readLine();
		
		System.out.print("Masukkan NIM Anda		: ");
		String nim = ind.readLine();
		
		System.out.println("1. Desain Komunikasi Visual");
		System.out.println("2. Sistem Informasi");
		System.out.println("3. Sistem Komputer");
		System.out.println("4. Desain Grafis");
		System.out.println("5. Multimedia");		
		System.out.println("6. Manajemen Informasika");
		System.out.println("7. Manajemen");
		System.out.println("8. Akuntansi");
		System.out.println("9. Komputerisasi Perkantoran dan Kesekretariatan");
		System.out.print("Pilih Nomor Jurusan Anda	: ");
		int angka = Integer.parseInt(ind.readLine());
		
		System.out.print("Masukkan Nilai UTS Anda		: ");
		double uts = Double.parseDouble(ind.readLine());
		
		System.out.print("Masukkan Nilai UAS Anda		: ");
		double uas = Double.parseDouble(ind.readLine());

		System.out.print("Masukkan Nilai Tugas Anda	: ");
		double tugas = Double.parseDouble(ind.readLine());

		double hasil = (0.3*uts)+(0.3*uas)+(0.4*tugas);
		
	System.out.println("");
	System.out.println("===========================================================");
	System.out.println("========================<< HASIL >>========================");
	System.out.println("===========================================================");	
	System.out.println("");
	
	System.out.println("Nama			: "+nama);
	System.out.println("NIM			: "+nim);	
	switch (angka){
			case 1:
			System.out.println("Jurusan			: Desain Komunikasi Visual");
			break;
			case 2:
			System.out.println("Jurusan			: Sistem Informasi");
			break;
			case 3:
			System.out.println("Jurusan			: Sistem Komputer");
			break;
			case 4:
			System.out.println("Jurusan			: Desain Grafis");
			break;
			case 5:
			System.out.println("Jurusan			: Multimedia");
			break;
			case 6:
			System.out.println("Jurusan			: Manajemen Informasika");
			break;
			case 7:
			System.out.println("Jurusan			: Manajemen");
			break;
			case 8:
			System.out.println("Jurusan			: Akuntansi");
			break;
			case 9:
			System.out.println("Jurusan			: Komputerisasi Perkantoran dan Kesekretariatan");
			break;
			default : System.out.println("Maaf, angka yang anda masukkan tidak valid");
			break;}
	System.out.println("Nilai UTS		: "+uts);
	System.out.println("Nilai UAS		: "+uas);
	System.out.println("Nilai Tugas		: "+tugas);
	System.out.println("Nilai Akhir		: "+hasil);
		if (hasil>=80 && hasil<=100){
			System.out.println("Selamat "+nama+", predikat nilai akhir anda 'A'");
		} else if (hasil>74.50 && hasil<=79.50){
			System.out.println("Selamat "+nama+", predikat nilai akhir anda 'B+'");
		} else if (hasil>59.50 && hasil<=74.50){
			System.out.println("Selamat "+nama+", predikat nilai akhir anda 'B'");
		} else if (hasil>39.50 && hasil<=59.50){
			System.out.println("Selamat "+nama+", predikat nilai akhir anda 'C'");
		} else if (hasil>19.50 && hasil<=39.50){
			System.out.println("Selamat "+nama+", predikat nilai akhir anda 'D'");
		} else if (hasil>=0 && hasil<=19.50){
			System.out.println("Selamat "+nama+", predikat nilai akhir anda 'E'");
		} else {System.out.print("");
		}
	
	System.out.println("");
	System.out.println("===========================================================");
	System.out.println("=====================<< TERIMAKASIH >>=====================");
	System.out.println("===========================================================");		
	System.out.println("");
	}
}