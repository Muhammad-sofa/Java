import java.util.ArrayList;
import java.util.*;
import java.text.*;

public class Mahkota {
public void Menu(){
    System.out.println("=============================================================");
    System.out.println("                  HOTEL MAHKOTA LAMONGAN                     ");
    System.out.println("=============================================================");
    System.out.println("1. Tipe Kamar Hotel ");
    System.out.println("2. Transaksi Pemesanan Kamar Hotel");
    System.out.println("3. Omset perhari");
    System.out.println("4. Help");
    System.out.println("5. Exit");
    }

 public void cover(){
    System.out.println("=============================================================");
    System.out.println("                  HOTEL MAHKOTA LAMONGAN                     ");
    System.out.println("=============================================================");
    }
	
 public void Tipe_Hotel(){
    System.out.println("1. Executive Room       (EXR)  = Rp.425.000");
    System.out.println("2. Suite Room           (STR)  = Rp.375.000");
    System.out.println("3. Junior Suite Room    (JSR)  = Rp.350.000");
    System.out.println("4. Deluxe Room          (DLX)  = Rp.275.000");
    System.out.println("5. Superior Room        (SPR)  = Rp.200.000");
    System.out.println("6. Standart Room        (STD)  = Rp.175.000");
	System.out.println("");
}

public void Tanggal(){
	Date HariSekarang = new Date();
	SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'pada' hh:mm:ss a zzz");
	System.out.println("");
	System.out.println("Tanggal dan waktu saat ini : "+ft.format(HariSekarang));
	System.out.println("");
}
	
    public static void main(String[] args) {
	
    Scanner yoga = new Scanner(System.in);
    Scanner scan = new Scanner(System.in);
		String room [][] = {
		{"Executive Room","425000","8"},
		{"Suite Room","375000","5"},
		{"Junior Suite Room","350000","5"},
		{"Deluxe Room","275000","5"},
		{"Superior Room","200000","2"},
		{"Standart Room","175000","1"}};
		
		int masuk, banyak = 1, no = 1, b, a, harga = 0;
		String nama = "", alamat = "";
		
        int i = 2;
        int menu_utama = 0;
        int menu_2;
        int menu = 0;
        int pil_kamar=0;
        // penamaan variabel untuk omset
        int tipek_1;
        int tipek_2;
        int tipek_3;
        int tipek_4;
        int tipek_5;
        int tipek_6;
        int harga_1;
        int harga_2;
        int harga_3;
        int harga_4;
        int harga_5;
        int harga_6;
        int omset;
        int total;
        ArrayList arr_data = new ArrayList();
        String menu1[] = new String[100];
        int harga1[] = new int [100];
        String balik ="Y";
        String user1, password1 = null, user, password;
        Mahkota mn = new Mahkota();
        //kapasitas hotel dari setiap kamar
        int kap_tipek1 = 7;
        int kap_tipek2 = 5;
        int kap_tipek3 = 5;
        int kap_tipek4 = 15;
        int kap_tipek5 = 8;
        int kap_tipek6 = 12;
        
        //data untuk login
        user1 = "admin";
        password1= "123";
        int kes=3;
        int log=0;
        
    do{
     
        do {//login   
        System.out.print("Masukkan Username : ");
        user = yoga.nextLine() ;
        System.out.print("Masukkan Password : ");
        password = yoga.nextLine();
        if (user1.equals(user) && password1.equals(password)){
			System.out.println("");
            System.out.println("Selamat, Anda berhasil login");
			System.out.println("");
            log=1;
        }else{
            kes=kes-1;
            if (kes==0) {
				System.out.println("");
                System.out.println("KESEMPATAN ANDA HABIS ! ! !");
                System.exit(0);
            } else {
				System.out.println("");
				System.out.println("Maaf, username dan password salah");
                System.out.println("Kesempatan anda login kurang dari "+kes);
				System.out.println("");
                log=0;
            }
        }
    } while (log==0);
 
        do{
		mn.Tanggal();
        mn.Menu();
        System.out.print("Masukkan Pilihan Anda : ");
        menu_utama = yoga.nextInt();
        switch(menu_utama){
        case 1:
                        
        do{
		mn.Tanggal();
        mn.cover();
        System.out.println("HOTEL MAHKOTA LAMONGAN");
        System.out.println("");
        String kamar[] = new String[6];
        kamar[0] = "1. Executive Room      (EXR) = Rp.425.000";
        kamar[1] = "2. Suite Room          (STR) = Rp.375.000";
        kamar[2] = "3. Junior Suite Room   (JSR) = Rp.350.000";
        kamar[3] = "4. Deluxe Room         (DLX) = Rp.275.000";
        kamar[4] = "5. Superior Room       (SPR) = Rp.200.000";
        kamar[5] = "6. Standart Room       (STD) = Rp.175.000";
        System.out.println(kamar[0]);
        System.out.println(kamar[1]);
        System.out.println(kamar[2]);
        System.out.println(kamar[3]);
        System.out.println(kamar[4]);
        System.out.println(kamar[5]);
        System.out.println("");
        System.out.print("Apakah anda ingin kembali ke menu? (Y/N) : ");
        balik = scan.nextLine();
        }while(balik.equalsIgnoreCase("n"));  
        break;
                        
        case 2:
                        
        do{
		mn.Tanggal();
        mn.cover();
        System.out.println("");
        System.out.println("1. Memesan Kamar Hotel");
        System.out.println("2. Melihat Pesanan Kamar Hotel");
        System.out.println("3. Exit");
        System.out.println("");
        System.out.print("Masukkan pilihan anda : ");
        menu_2 = yoga.nextInt();
                            
        switch(menu_2){
        case 1:
                                        
        do{
		mn.Tanggal();
        mn.cover();
			System.out.println("HOTEL MAHKOTA LAMONGAN");
			System.out.println("");
			System.out.println("1. Executive Room           (EXR)  = Rp.425.000");
			System.out.println("2. Suite Room               (STR)  = Rp.375.000");
			System.out.println("3. Junior Suite Room        (JSR)  = Rp.350.000");
			System.out.println("4. Deluxe Room              (DLX)  = Rp.275.000");
			System.out.println("5. Superior Room            (SPR)  = Rp.200.000");
			System.out.println("6. Standart Room            (STD)  = Rp.175.000");
			System.out.println("");
			
			System.out.println("Anda Akan Memesan Kamar Hotel");
			System.out.println("Mohon Masukkan Informasi Di bawah ini");
			System.out.print("Nama   : ");
			nama = scan.nextLine();
			System.out.print("Alamat : ");
			alamat = scan.nextLine();
			System.out.print("Tipe Kamar yang Anda Pilih   : ");
			no = scan.nextInt();
			System.out.print("Banyaknya Kamar yang Dipesan : ");
			banyak = scan.nextInt();
			a = Integer.parseInt(room[no - 1][1]);
			b = Integer.parseInt(room[no - 1][2]);
			harga = (banyak * a) - ((banyak * a) * b/100);
			System.out.println("Harga Total		     : Rp. "+harga);
			System.out.println("=============================================================");
			
			System.out.println("");
			balik = scan.nextLine();		
        }while(balik.equalsIgnoreCase("n"));
        break;
                                                                                                                        
        case 2:
        do{
		mn.Tanggal();
        mn.cover();
			System.out.println("Daftar Pesanan");
			System.out.println("Nama		: "+nama);
			System.out.println("Alamat		: "+alamat);
			System.out.println("Tipe Kamar  	: "+room[no - 1][0]);
			System.out.println("Jumlah Kamar	: "+banyak);
			System.out.println("Harga		: "+room[no - 1][1]);
			System.out.println("Diskon		: "+room[no - 1][2] + "%");
			System.out.println("Total biaya 	: Rp. "+harga);
            System.out.println("=============================================================");
			System.out.println("");
			System.out.print("Apakah anda ingin kembali ke menu? (Y/N) : ");
			balik = scan.nextLine();
        }while(balik.equalsIgnoreCase("n"));
        
		case 3:
        break;
        default:
            System.out.println("Nomer tidak termasuk");
            menu=1;
        break;
        }
                                    
        }while(menu_2<3);
        break;
                       
        case 3:
        do{    
        mn.Tanggal();
		mn.cover();
        mn.Tipe_Hotel();
			System.out.print("");
            System.out.print("1. Jumlah kamar yang terjual pada Executive Room : ");
            tipek_1 = yoga.nextInt();
            System.out.print("   Harga kamar : ");
            harga_1 = yoga.nextInt();
            System.out.println("");
			
            System.out.print("2. Jumlah kamar yang terjual pada Suite Room : ");
            tipek_2 = yoga.nextInt();
            System.out.print("   Harga kamar : ");
            harga_2 = yoga.nextInt();
            System.out.println("");
			
            System.out.print("3. Jumlah kamar yang terjual pada Junior Suite Room : ");
            tipek_3 = yoga.nextInt();
            System.out.print("   Harga kamar : ");
            harga_3 = yoga.nextInt();
            System.out.println("");
			
            System.out.print("4. Jumlah kamar yang terjual pada Deluxe Room : ");
            tipek_4 = yoga.nextInt();
            System.out.print("   Harga kamar : ");
            harga_4 = yoga.nextInt();
            System.out.println("");
			
            System.out.print("5. Jumlah kamar yang terjual pada Superior Room : ");
            tipek_5 = yoga.nextInt();
            System.out.print("   Harga kamar : ");
            harga_5 = yoga.nextInt();
            System.out.println("");
			
            System.out.print("6. Jumlah kamar yang terjual pada Standart Room : ");
            tipek_6 = yoga.nextInt();
            System.out.print("   Harga kamar : ");
            harga_6 = yoga.nextInt();
            System.out.println("");
            
            //perhitungan omset harian
            System.out.println("");
            total = (tipek_1 * (harga_1 * 92/100))+ (tipek_2 * (harga_2 * 95/100)) + (tipek_3 * (harga_3 * 95/100)) + 
			(tipek_4 * (harga_4 * 95/100)) + (tipek_5 * (harga_5 * 98/100)) + (tipek_6 * (harga_6 * 99/100));
            System.out.println("=============================================================");
            System.out.println("");
            System.out.println("Omset per hari HOTEL MAHKOTA LAMONGAN adalah Rp. "+total);
            System.out.println("");
            System.out.println("=============================================================");
            System.out.println("");
            System.out.print("Apakah anda ingin kembali ke menu ? (Y/N) : ");
            balik = scan.nextLine();
        }while(balik.equalsIgnoreCase("n"));
        break;
                    
        case 4:
        do{
		mn.Tanggal();
        mn.cover();
            System.out.println("");
            String cara[] = new String[6];
            cara[0] = "1. FAQ ";
            cara[1] = "2. Call Center";
            cara[2] = "3. Syarat dan Keentuan";
            cara[3] = "4. Live Support";
            cara[4] = "5. Customer Care Policy";    
            System.out.println(cara[0]);
            System.out.println(cara[1]);
            System.out.println(cara[2]);
            System.out.println(cara[3]);
            System.out.println(cara[4]);
            System.out.print("Apakah anda ingin kembali ke menu ? (Y/N) : ");
            balik = scan.nextLine();
            }while(balik.equalsIgnoreCase("n"));
        break;
                    
        case 5:
        System.exit(0);
        break;
                        
        default:
        System.out.println("Nomer tidak termasuk");
        menu_utama=1;
        break;
                                 
        }//menu utama
        }while(menu_utama<5);//batas ulang menu utama
    }while(i<=2);    
    }
}