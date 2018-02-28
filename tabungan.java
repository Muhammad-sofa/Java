public class tabungan {
	
public int saldo;
	
	public static void main(String args[] ) {
		
		tabungan tabungan = new tabungan(5000);
		
		System.out.println("saldo awal : "+tabungan.saldo);
		tabungan.ambiluang(2300);
		System.out.println("jumlah uang yang diambil : 2300");
		System.out.println("saldo sekarang : " + tabungan.saldo);
	}
}