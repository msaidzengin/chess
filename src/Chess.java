import java.util.Scanner;
public class Chess {
	public static void main(String[] args) {
	
		Scanner k = new Scanner(System.in);
		
		Tas[][] board = new Tas[8][8];
		for(int i=2; i<6; i++)
			for(int j=0; j<8; j++)
				board[i][j] = new Tas();
			
		ChessBoard a = new ChessBoard();
		
		board[6][0] = new Piyon('b',"a2");
		board[6][1] = new Piyon('b',"b2");
		board[6][2] = new Piyon('b',"c2");
		board[6][3] = new Piyon('b',"d2");
		board[6][4] = new Piyon('b',"e2");
		board[6][5] = new Piyon('b',"f2");
		board[6][6] = new Piyon('b',"g2");
		board[6][7] = new Piyon('b',"h2");
		board[1][0] = new Piyon('s',"a7");
		board[1][1] = new Piyon('s',"b7");
		board[1][2] = new Piyon('s',"c7");
		board[1][3] = new Piyon('s',"d7");
		board[1][4] = new Piyon('s',"e7");
		board[1][5] = new Piyon('s',"f7");
		board[1][6] = new Piyon('s',"g7");
		board[1][7] = new Piyon('s',"h7");
					
		board[7][0] = new Kale('b',"a1");
		board[7][7] = new Kale('b',"h1");
		board[0][0] = new Kale('s',"a8");
		board[0][7] = new Kale('s',"h8");
		
		board[7][1] = new At('b',"b1");
		board[7][6] = new At('b',"g1");
		board[0][1] = new At('s',"b8");
		board[0][6] = new At('s',"g8");
		
		board[7][2] = new Fil('b',"c1");
		board[7][5] = new Fil('b',"f1");
		board[0][2] = new Fil('s',"c8");
		board[0][5] = new Fil('s',"f8");
		
		board[7][3] = new Vezir('b',"d1");
		board[0][3] = new Vezir('s',"d8");
				
		board[7][4] = new Sah('b',"e1");
		board[0][4] = new Sah('s',"e8");
					
		int hamleSayisi1 = 0;
		int hamleSayisi2 = 0;
		System.out.println("Oyuna beyaz baslayacak.");
		
		while ( oyunBittiMi(board) ) {
		
			String hb;
			boolean hamle = false;
			do{  //oyun basliyor.
				hamle = false;
				System.out.print("Beyazin hamlesi : ");
				hb = k.nextLine();
								
				if(girdiKontrol(hb))  //input kontrol
					System.out.println("hatali input");
				else{
					int e1 = Math.abs(Integer.parseInt(hb.substring(1,2))-8); //eski koordinat
					int e2 = hb.charAt(0)-97;
		
					int y1 =Math.abs(Integer.parseInt(hb.substring(4,5))-8);  //yeni koordinat
					int y2 = hb.charAt(3)-97;
					String eski = hb.substring(0,2);
					String yeni = hb.substring(3,5);			
					
					if ( ( board[e1][e2].checkMove(yeni)  ) &&    //hareket kontrol
						 ( board[e1][e2].getColor() == 'b') &&
						 ( board[y1][y2].getColor() != 'b') &&
						 ( gidebilirMi(e1,e2,y1,y2,board) ) &&
						 ( terfiKontrol(e1,e2,y1,y2,board,hb))  )
					
					{
					
						String isim = board[e1][e2].getClass().getSimpleName();
						String isimm = isim.substring(0, 1).toLowerCase() + isim.substring(1);
																	
						if(board[y1][y2].getColor() == 's'){  //eger tasi yediyse orayi siliyorum.
							String sil = board[e1][e2].getClass().getSimpleName();
							String sill = sil.substring(0, 1).toLowerCase() + sil.substring(1);
							a.removeIcon(y1,y2,sill,'s');	
						}
						
						hamleSayisi1++;
						
						board[y1][y2] = new Tas();
						board[y1][y2] = board[e1][e2];  //eski tas yeni yerine oynatildi.
						board[y1][y2].setLocation(yeni);
						board[e1][e2] = new Tas();
						
						a.removeIcon(e1,e2,isimm,'b');
						a.putIcon(y1,y2,isimm,'b');
						
						
						//piyon sona gelince baska tasa donusur.
						// sah veya piyon haricinde bir tasa terfi et.
						if (isimm.equals("piyon") && y1 == 0) {
						
							String degis = hb.substring(5);
							
							if ( degis.equals(" at") ) {
								board[y1][y2] = new Tas();
								board[y1][y2] = new At('b',yeni);
								a.removeIcon(y1,y2,"piyon",'b');
								a.putIcon(y1,y2,"at",'b');
							}
							else if ( degis.equals(" kale") ) {
								board[y1][y2] = new Tas();
								board[y1][y2] = new Kale('b',yeni);
								a.removeIcon(y1,y2,"piyon",'b');
								a.putIcon(y1,y2,"kale",'b');
							}
							else if ( degis.equals(" fil") ) {
								board[y1][y2] = new Tas();
								board[y1][y2] = new Fil('b',yeni);
								a.removeIcon(y1,y2,"fil",'b');
								a.putIcon(y1,y2,"fil",'b');
							}
							else if ( degis.equals(" vezir") ) {
								board[y1][y2] = new Tas();
								board[y1][y2] = new Vezir('b',yeni);
								a.removeIcon(y1,y2,"vezir",'b');
								a.putIcon(y1,y2,"vezir",'b');
							}
							else {
								//terfi etmezse bisey yapma.
							}							
							
						}
					}
					else{
						System.out.println("gecersiz hamle");
						hamle = true;
					}
				}					
				
			}while( girdiKontrol(hb) || hamle);  //beyazin hamlesi bitti.
			
			if ( !(oyunBittiMi(board)) ) //oyun kontrol
				break;
			else {
				//siyahin hamlesi
				//beyazin aynisi..
				String hs;
				hamle = false;
				do{
					hamle = false;
					System.out.print("Siyahin hamlesi : ");
					hs = k.nextLine();
								
					if(girdiKontrol(hs))
						System.out.println("hatali input");
					else{
						int e1 = Math.abs(Integer.parseInt(hs.substring(1,2))-8);
						int e2 = hs.charAt(0)-97;
		
						int y1 =Math.abs(Integer.parseInt(hs.substring(4,5))-8);
						int y2 = hs.charAt(3)-97;
						String eski = hs.substring(0,2);
						String yeni = hs.substring(3,5);			
					
						if ( ( board[e1][e2].checkMove(yeni)   ) && 
							 ( board[e1][e2].getColor() == 's' ) &&
							 ( board[y1][y2].getColor() != 's' ) &&
							 ( gidebilirMi(e1,e2,y1,y2,board)  ) &&
							 ( terfiKontrol(e1,e2,y1,y2,board,hs) )  )
							 
						{
					
							String isim = board[e1][e2].getClass().getSimpleName();
							String isimm = isim.substring(0, 1).toLowerCase() + isim.substring(1);
																	
							if(board[y1][y2].getColor() == 'b'){
								String sil = board[e1][e2].getClass().getSimpleName();
								String sill = sil.substring(0, 1).toLowerCase() + sil.substring(1);
								a.removeIcon(y1,y2,sill,'b');
							}
						
							hamleSayisi2++;
							
							board[y1][y2] = new Tas();
							board[y1][y2] = board[e1][e2];
							board[y1][y2].setLocation(yeni);
							board[e1][e2] = new Tas();
						
							a.removeIcon(e1,e2,isimm,'s');
							a.putIcon(y1,y2,isimm,'s');
							
						
							//piyon sona gelince baska tasa donusur.
							// sah veya piyon haricinde bir tasa terfi et.
							if (isimm.equals("piyon") && y1 == 7) {
						
								String degis = hs.substring(5);
							
								if ( degis.equals(" at") ) {
									board[y1][y2] = new Tas();
									board[y1][y2] = new At('s',yeni);
									a.removeIcon(y1,y2,"piyon",'s');
									a.putIcon(y1,y2,"at",'s');
								}
								else if ( degis.equals(" kale") ) {
									board[y1][y2] = new Tas();
									board[y1][y2] = new Kale('s',yeni);
									a.removeIcon(y1,y2,"piyon",'s');
									a.putIcon(y1,y2,"kale",'s');
								}
								else if ( degis.equals(" fil") ) {
									board[y1][y2] = new Tas();
									board[y1][y2] = new Fil('s',yeni);
									a.removeIcon(y1,y2,"fil",'s');
									a.putIcon(y1,y2,"fil",'s');
								}
								else if ( degis.equals(" vezir") ) {
									board[y1][y2] = new Tas();
									board[y1][y2] = new Vezir('s',yeni);
									a.removeIcon(y1,y2,"vezir",'s');
									a.putIcon(y1,y2,"vezir",'s');
								}
								else {
									//kale,at,vezir,fil degilse piyon terfi etmez.
								}							
							
							}
						}
						else{
							System.out.println("gecersiz hamle");
							hamle = true;
						}
					}					
				
				}while( girdiKontrol(hs) || hamle); //siyahin hamlesi bitti.
			}
	
		}  // oyun bitti.
		
		String kazanan = kim(board);  
		if(kazanan.equals("Beyaz"))
			System.out.println(kazanan + " " + hamleSayisi1 +" hamlede kazandi.");
		else
			System.out.println(kazanan + " " + hamleSayisi2 +" hamlede kazandi.");
			
		System.out.println("lutfen bekleyiniz");
		System.out.println("oyun 5-10 sn sonra kapaniyor.");
	}
	
	public static boolean gidebilirMi(int e1, int e2, int y1, int y2, Tas[][] board) {
		
		//piyon duz gidebilir capraz gidemez
		//capraz yiyebilir duz yiyemez..
		if (board[e1][e2] instanceof Piyon) {
			if(board[e1][e2].getColor() == 'b' && e2 == y2 && board[y1][y2].getColor() != 's')
				return true;
			else if(board[e1][e2].getColor() == 'b' && e2 != y2 && board[y1][y2].getColor() == 's' )	
				return true;
			else if(board[e1][e2].getColor() == 's' && e2 == y2 && board[y1][y2].getColor() != 'b')
				return true;
			else if(board[e1][e2].getColor() == 's' && e2 != y2 && board[y1][y2].getColor() == 'b' )	
				return true;
			else	
				return false;
		}	
		
		else if (board[e1][e2] instanceof Kale) {
				
			
			if(e2 == y2){ //kale sutun boyunca hareket ediyorsa..
				if(y1 > e1){  //assume e1 > y1, eger degilse degistir.
					int temp = e1;
					e1 = y1;
					y1 = temp;
				}
				int count = 0;
				for(int i=y1+1; i<e1; i++) {
					if(board[i][e2].getColor() == 'y')
						count++;
				}
				
				return count == ( (e1-y1)-1 );   //eger esit degilse araya tas girmistir.
			}
			else{  //kale satir boyunca hareket ediyorsa..
				if(y2 > e2){  //yine e1 > e2 yapip ona gore islem yapiyoruz.
					int temp = e2;
					e2 = y2;
					y2 = temp;
				}
				int count = 0;
				for(int i=y2+1; i<e2; i++) {
					if(board[e1][i].getColor() == 'y')
						count++;
				}
				
				return count == ( (e2-y2)-1 );  //araya tas girmis mi,,
			}
			
		}
		
		else if (board[e1][e2] instanceof Fil) {
		
			//4 tane hamle var.
			//e1>y1 && e2>y2
			//e1>y1 && e2<y2
			//e1<y1 && e2>y2
			//e1<y1 && e2<y2
			
			if(e1>y1 && e2>y2){
				int count = 0;
				for(int i=y1+1; i<e1; i++){
					y2++;
					if(board[i][y2].getColor() == 'y')
						count++;
				} return count == ( (e1-y1)-1 );	
			}
			else if(e1>y1 && e2<y2){
				int count = 0;
				for(int i=y1+1; i<e1; i++){
					y2--;
					if(board[i][y2].getColor() == 'y')
						count++;
				} return count == ( (e1-y1)-1 );	
			}
			else if(e1<y1 && e2>y2){
				int count = 0;
				for(int i=e1+1; i<y1; i++){
					e2--;
					if(board[i][e2].getColor() == 'y')
						count++;
				} return count == ( (y1-e1)-1 );	
			}
			else {
				int count = 0;
				for(int i=e1+1; i<y1; i++){
					e2++;
					if(board[i][e2].getColor() == 'y')
						count++;
				} return count == ( (y1-e1)-1 );	
			}
		}
		
		else if (board[e1][e2] instanceof Vezir) {
					
			//fil in hamlelerini vezire koydum.
			
			if(e1>y1 && e2>y2){
				int count = 0;
				for(int i=y1+1; i<e1; i++){
					y2++;
					if(board[i][y2].getColor() == 'y')
						count++;
				} return count == ( (e1-y1)-1 );	
			}
			else if(e1>y1 && e2<y2){
				int count = 0;
				for(int i=y1+1; i<e1; i++){
					y2--;
					if(board[i][y2].getColor() == 'y')
						count++;
				} return count == ( (e1-y1)-1 );	
			}
			else if(e1<y1 && e2>y2){
				int count = 0;
				for(int i=e1+1; i<y1; i++){
					e2--;
					if(board[i][e2].getColor() == 'y')
						count++;
				} return count == ( (y1-e1)-1 );	
			}
			else if (e1<y1 && e2<y2) {
				int count = 0;
				for(int i=e1+1; i<y1; i++){
					e2++;
					if(board[i][e2].getColor() == 'y')
						count++;
				} return count == ( (y1-e1)-1 );	
			}
			
			// kalenin hamleleri..
			
			else if(e2 == y2 && e1 != y1){
				if(y1 > e1){
					int temp = e1;
					e1 = y1;
					y1 = temp;
				}
				int count = 0;
				for(int i=y1+1; i<e1; i++) {
					if(board[i][e2].getColor() == 'y')
						count++;
				}
				
				return count == ( (e1-y1)-1 );
			}
			else if (e1 == y1 && e2 != y2){
				if(y2 > e2){
					int temp = e2;
					e2 = y2;
					y2 = temp;
				}
				int count = 0;
				for(int i=y2+1; i<e2; i++) {
					if(board[e1][i].getColor() == 'y')
						count++;
				}
				
				return count == ( (e2-y2)-1 );
			}
			else
				return false;
			
		}
		
		else
			return true;
	}

	
	public static boolean girdiKontrol (String s) {

		if(s.length()<5)  //girdi "a1 a2" den kucuk olamaz
			return true;
		else if( !(s.charAt(0)>='a' && s.charAt(0)<= 'h' && s.charAt(3)>='a' && s.charAt(3)<= 'h') ) //0-3te (a-h)arasi char olmali. 
			return true;
		else if( !(s.charAt(1)>='1' && s.charAt(1)<= '8' && s.charAt(4)>='1' && s.charAt(4)<= '8') ) //1-4te (1-8)arasi rakam olmali.
			return true;
		else if(s.charAt(2)!=' ') //2.karakter bosluk olmali.
			return true;
		else if(s.length() > 5 && (s.charAt(5)!=' ')) //son karakter bosluk olmali. (b8 b10 giremez )
			return true;
		else
			return false; // "b2_b4_  " tireden sonra istedigimizi yazabiliriz.(piyon terfi etmek icin.)
	}
	
		
	public static boolean oyunBittiMi(Tas[][] board) {
		
		int count = 0;
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if ( board[i][j].getClass().getSimpleName() == "Sah" )
					count++;
			}
		}
		return count == 2; //eger sah sayisi 2 degil ise oyun bitmistir.
	}
	
	public static String kim(Tas[][] board) {
		int x=0;
		int y=0;
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if ( board[i][j].getClass().getSimpleName() == "Sah" ){
					x = i;
					y = j;
				}
			}
		}
		if(board[x][y].getColor() == 'b') //kazanan kisi beyaz mi 
			return "Beyaz";
		else
			return "Siyah"; //siyah mi..
	
	}
	
	public static boolean terfiKontrol (int e1, int e2, int y1, int y2, Tas[][] board, String s) {
		if(board[e1][e2] instanceof Piyon && board[e1][e2].getColor()== 'b' && y1 == 0) {
			String degis = s.substring(5);
			if(degis.equals(" at") || degis.equals(" kale") || degis.equals(" vezir") || degis.equals(" fil"))
				return true;		
			else{
				System.out.println("piyonu terfi etmelisin(kale,at,fil,vezir)");
				return false;
			}
		}
		else if(board[e1][e2] instanceof Piyon && board[e1][e2].getColor()== 's' && y1 == 7) {
			String degis = s.substring(5);
			if(degis.equals(" at") || degis.equals(" kale") || degis.equals(" vezir") || degis.equals(" fil"))
				return true;		
			else{
				System.out.println("piyonu terfi etmelisin(kale,at,fil,vezir)");
				return false;
			}
		}
		else
			return true;
	
	}
	
}
