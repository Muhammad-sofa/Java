public class Method002 {
	public static void cetak(String pesan) {
		System.out.println(pesan);
	}
	public static int add(int a, int b) {
		int c=a+b;
		return c;
	}
	public static void main(String[] args) {
		cetak("Tes Method");
		int bil1=90;
		int bil2=20;
		int hasil=add(bil1, bil2);
		cetak("Hasil add() : "+hasil);
	}
}