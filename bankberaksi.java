import java.util.Scanner;

public class bankberaksi
{
	public static void main(String[] args)
	{
		//	Objek Scanner
		Scanner scan = new Scanner(System.in);
		
		//	Buat objek dari class Bank
		bank obj_bank = new bank(100000);
		
		System.out.println("Selamat Datang di Bank ABC");
		System.out.println("Saldo saat ini : Rp. "+obj_bank.getSaldo());	//	Panggil method getSaldo
		System.out.print("Simpan uang    : Rp. ");	int simpan = scan.nextInt();
		obj_bank.simpanUang(simpan);	//	Panggil method simpanUang
		
		System.out.println("Saldo saat ini : Rp. "+obj_bank.getSaldo());	//	Panggil method getSaldo
		System.out.print("Ambil uang     : Rp. ");	int ambil = scan.nextInt();
		obj_bank.ambilUang(ambil);		//	Panggil method ambilUang
		
		System.out.println("Saldo saat ini : Rp. "+obj_bank.getSaldo());
	}
}