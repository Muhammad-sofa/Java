import java.io.*;

public class acaratv {
	private String StasiunTv;
	private String acara;
	private String cetak;
	
	acaratv() {
		
	}
	acaratv(String StasiunTv, String acara) {
		this.StasiunTv =StasiunTv;
		this.acara =acara;
	}
	
	public void setacara(String acara) {
		this.acara=acara;
	}
	public void setStasiunTv(String StasiunTv) {
		this.StasiunTv=StasiunTv;
	}
	
	
	public String getacara() {
		return this.acara;
	}
	public String getStasiunTv() {
		return this.StasiunTv;
	}
	
	
	public void cetak() {
		System.out.println("acara"+acara+"Stasiun tv"+StasiunTv);
	}
}