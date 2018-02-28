import java.io.*;

public class Stasiun {
	public static void main(String[] args) {
		acaratv a=new acaratv("indosiar","sinetron");
		
		System.out.println(a.getStasiunTv());
		System.out.println(a.getacara());
    	a.cetak();
	}
}
