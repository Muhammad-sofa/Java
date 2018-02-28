import java.util.*;

class remotetv{
	String power;
	String channel;
	int volume;
	
	
	public void setPower(String RemotePow){
		power = RemotePow;
	}
	public void setChannel(String RemoteChan){
		channel = RemoteChan;
	}
	public void setVolume(int RemoteVol){
		volume = RemoteVol;
	}
	
	public String getPow(){
		return power;
	}
	public String getChan(){
		return channel;
	}
	public int getVol(){
		return volume;
	}
	public void info(){
		System.out.println("");
		System.out.println("==========STATUS TV ANDA=========");
		System.out.println("Status TV  : "+getPow());
		System.out.println("Channel  : "+getChan());
		System.out.println("Volume : "+getVol());
		System.out.println("");
	}
}

class tugaspert8{
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	remotetv baru = new remotetv();
	String listchantv[] = new String[10];
	listchantv[0] = "TV belum dinyalakan";
	String statpowertv = "mati";
    int statvolumetv = 0;
	
	baru.setPower(statpowertv);
	baru.setVolume(statvolumetv);
	baru.setChannel(listchantv[0]);
	
	int n = 0;
	listchantv[1] = "BT SPORTS";
	listchantv[2] = "BT SPORTS 2 ";
	listchantv[3] = "BT SPORTS 3 ";
	listchantv[4] = "BEIN SPORTS";
	listchantv[5] = "ORANGE TV";
	listchantv[6] = "FOX SPORTS HD";
	listchantv[7] = "FOX SPORTS 2";
	
	do{
		System.out.println("");
		System.out.println("=========SILAHKAN MEMILIH MENU=========");
		System.out.println("1. Hidupkan TV");
		System.out.println("2. Perbesar Volume");
		System.out.println("3. Perkecil Volume");
		System.out.println("4. Ubah Channel");
		System.out.println("5. Matikan TV");
		System.out.println("6. Status/informasi");
		System.out.println("7. Keluar");
		System.out.print("Silahkan Memilih menu yang tersedia: ");
		int menu = Integer.parseInt(input.nextLine());
		System.out.println("========================================");
		switch(menu){
				case 1:
				statpowertv = "TV berhasil dinyalakan";
				statvolumetv = 15;
				listchantv[1] = "BT SPORTS";
				baru.setPower(statpowertv);
				baru.setVolume(statvolumetv);
				baru.setChannel(listchantv[1]);
				n = n+1;
				break;
			  case 2:
				if(statvolumetv <= 99){
					statvolumetv++;
					baru.setVolume(statvolumetv);
				}else if(statvolumetv >= 100){
					statvolumetv = statvolumetv;
					baru.setVolume(statvolumetv);
				}
				break;
				case 3:
				if(statvolumetv >= 1){
					statvolumetv--;
					baru.setVolume(statvolumetv);
				}else if(statvolumetv == 0){
					statvolumetv = statvolumetv;
					baru.setVolume(statvolumetv);
				}
				break;
				case 4:
				if(statpowertv == "TV berhasil dinyalakan"){
					if(n >= 1){
						n = n+1;
						baru.setChannel(listchantv[n]);
					}else if(n == 9){
						baru.setChannel(listchantv[n]);
					}
				}else if(statpowertv == "mati"){
					System.out.println("Mohon nyalakan TV anda");
				}
		
				break;
				case 5:
				statpowertv = "mati";
				statvolumetv = 0;
				listchantv[0] = "TV belum dinyalakan";
				baru.setPower(statpowertv);
				baru.setVolume(statvolumetv);
				baru.setChannel(listchantv[0]);
				break;
				case 6 :
				baru.info();
				break;
				case 7 : 
				System.exit(0);
				break;
				}
				}while(true);
				}
}
				
				
	
	
	
	
	
	
	
	
	
	
	
	