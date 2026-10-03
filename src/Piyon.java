public class Piyon extends Tas {

	public Piyon(char c, String l) {
		
		setColor(c);
		setLocation(l);
	
	}
	
	public boolean checkMove (String loc) {
		
		String[] arr = getMoves();
		
		int count = 0;			
		for(int i=0; i<arr.length; i++) {
			if( loc.equals(arr[i]))
				count++;
		}
		return count==1;
		
	}
	
	public String[] getMoves () {

		String s = this.getLocation();
		String[] dizi;
		if (this.getColor() == 'b'){
			if("a2".equals(s)||"b2".equals(s)||"c2".equals(s)||"d2".equals(s)||"e2".equals(s)||"f2".equals(s)||"g2".equals(s)||"h2".equals(s)){
				
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
			if("a7".equals(s)||"b7".equals(s)||"c7".equals(s)||"d7".equals(s)||"e7".equals(s)||"f7".equals(s)||"g7".equals(s)||"h7".equals(s)){
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
