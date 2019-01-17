public class Piyon extends Tas {

	public Piyon(char c, String l) {
		
		setColor(c);
		setLocation(l);
	
	}
	
	public boolean checkMove (String loc) {
		
		String[] arr = getMoves();
		
		int count = 0;			
		for(int i=0; i<arr.length; i++)
			if( loc.equals(arr[i]))
				count++;
			
			return count==1;
		
	}
	
	public String[] getMoves () {

		String s = this.getLocation();
		String[] dizi;
		if (this.getColor() == 'b'){
			if(s=="a2"||s=="b2"||s=="c2"||s=="d2"||s=="e2"||s=="f2"||s=="g2"||s=="h2"){
				
				dizi = new String[4];
				
				char a = s.charAt(0);
				char b = (char)(s.charAt(0) - 1);
				char c = (char)(s.charAt(0) + 1);
				int i = Integer.parseInt(s.substring(1,2)) + 1;
				String b1 = "" + a + i;
				String b2 = "" + b + i;
				String b3 = "" + c + i;
				String b4 = "" + a + (i+1);
			
				yerineKoy(dizi,b1,0);
				yerineKoy(dizi,b2,1);
				yerineKoy(dizi,b3,2);
				yerineKoy(dizi,b4,3);
			}
			else{
				dizi = new String[3];
				
				char a = s.charAt(0);
				char b = (char)(s.charAt(0) - 1);
				char c = (char)(s.charAt(0) + 1);
				int i = Integer.parseInt(s.substring(1,2)) + 1;
				String b1 = "" + a + i;
				String b2 = "" + b + i;
				String b3 = "" + c + i;
			
				yerineKoy(dizi,b1,0);
				yerineKoy(dizi,b2,1);
				yerineKoy(dizi,b3,2);
			}
		}
		else{
			if(s=="a7"||s=="b7"||s=="c7"||s=="d7"||s=="e7"||s=="f7"||s=="g7"||s=="h7"){
				dizi = new String[4];
				
				char a = s.charAt(0);
				char b = (char)(s.charAt(0) - 1);
				char c = (char)(s.charAt(0) + 1);
				int i = Integer.parseInt(s.substring(1,2)) - 1;
				String b1 = "" + a + i;
				String b2 = "" + b + i;
				String b3 = "" + c + i;
				String b4 = "" + a + (i-1);
				yerineKoy(dizi,b1,0);
				yerineKoy(dizi,b2,1);
				yerineKoy(dizi,b3,2);
				yerineKoy(dizi,b4,3);
			}
			else{
			
				dizi = new String[3];
				
				char a = s.charAt(0);
				char b = (char)(s.charAt(0) - 1);
				char c = (char)(s.charAt(0) + 1);
				int i = Integer.parseInt(s.substring(1,2)) - 1;
				String b1 = "" + a + i;
				String b2 = "" + b + i;
				String b3 = "" + c + i;
				yerineKoy(dizi,b1,0);
				yerineKoy(dizi,b2,1);
				yerineKoy(dizi,b3,2);
			
			}
		}
	
		return dizi;
	}
	
	public static void yerineKoy(String[] dizi, String yer, int i) {
	
		if((yer.charAt(0)=='`' || yer.charAt(0)=='i') || (yer.charAt(1)=='0' || yer.charAt(1)=='9') ) {}
		else
			dizi[i] = yer;	
	}

}
