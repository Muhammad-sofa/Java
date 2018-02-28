public abstract class Hewan {
	protected String nama;
	protected int jumlahkaki;
	protected boolean bisaterbang=false;
		
		public Hewan(String nama, int kaki, boolean terbang) {
			this.nama = nama;
			jumlahkaki = kaki;
			bisaterbang =terbang;
		}
	
		public abstract void bersuara();
		public void lihathewan() {
			System.out.println("nama hewan"+nama);
			System.out.println("jumlah kaki"+jumlahkaki);
			System.out.println("hewan bisa terbang"+bisaterbang);
		}
}