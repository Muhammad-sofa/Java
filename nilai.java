import java.io.*;
public class nilai {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(" ");
		System.out.println("==============================");
		System.out.println("========Nama mahasiswa========");
		System.out.println("==============================");
		System.out.println(" ");
		
		String nama1,nama2,nama3;
		Double angka1,angka2,angka3;
		
		System.out.print("Masukan nama1 : ");
		nama1 =br.readLine();
		System.out.print("Masukan nama2 : ");
		nama2 =br.readLine();
		System.out.print("Masukan nama3 : ");
		nama3 =br.readLine();
		System.out.println(" ");
		
		System.out.println("Masukan nilai1 : ");
		angka1 =Double.parseDouble(br.readLine());
		System.out.println("Masukan nilai2 : ");
		angka2 =Double.parseDouble(br.readLine());
		System.out.println("Masukan nilai3 : ");
		angka3 =Double.parseDouble(br.readLine());
		System.out.println(" ");
		
		System.out.print("Nama Mahasiswa : " +nama1);
		System.out.print(" ");
		System.out.print("Mendapat Nilai : " +angka1);
		System.out.println(" ");
		System.out.print("Nama Mahasiswa : " +nama2);
		System.out.print(" ");
		System.out.print("Mendapat Nilai : " +angka2);
		System.out.println(" ");
		System.out.print("Nama Mahasiswa : " +nama3);
		System.out.print(" ");
		System.out.print("Mendapat Nilai : " +angka3);
		System.out.println(" ");
		
		
		
	}
}