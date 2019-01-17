public class Sah extends Tas {

	public Sah(char c, String l) {
		
		setColor(c);
		setLocation(l);
	
	}
	
	public boolean checkMove (String loc) {
	
		String[] arr = getMoves();
		int count = 0;
			
		for(int i=0; i<arr.length; i++)
			if(loc.equals(arr[i]))
				count++;
		
		return count == 1;
				
	}
	
	public String[] getMoves () {
		
		String s = this.getLocation();
		char a = s.charAt(0);
		int aa = Integer.parseInt(s.substring(1,2));
		
		String eski = "" + a + aa;
		
		String yer1 = "" + (char)(a-1) + (aa+1);
		String yer2 = "" + (char)(a) + (aa+1);
		String yer3 = "" + (char)(a+1) + (aa+1);
		String yer4 = "" + (char)(a-1) + (aa);
		String yer5 = "" + (char)(a+1) + (aa);
		String yer6 = "" + (char)(a-1) + (aa-1);
		String yer7 = "" + (char)(a) + (aa-1);
		String yer8 = "" + (char)(a+1) + (aa-1);
		
		String[] dizi = new String[8];
	
		yerineKoy(dizi,yer1,0);
		yerineKoy(dizi,yer2,1);
		yerineKoy(dizi,yer3,2);
		yerineKoy(dizi,yer4,3);
		yerineKoy(dizi,yer5,4);
		yerineKoy(dizi,yer6,5);
		yerineKoy(dizi,yer7,6);
		yerineKoy(dizi,yer8,7);
				
		return dizi;
	}
	
	public static void yerineKoy(String[] dizi, String yer, int i) {
	
		if((yer.charAt(0)=='`' || yer.charAt(0)=='i') || (yer.charAt(1)=='0' || yer.charAt(1)=='9') ) {}
		else
			dizi[i] = yer;	
	}

}
