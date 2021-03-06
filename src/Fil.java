public class Fil extends Tas {

	public Fil (char c, String l) {
		
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
		String[] dizi = new String[14];
		String s = this.getLocation();
		char a = s.charAt(0);
		int aa = Integer.parseInt(s.substring(1,2));
		String eski = "" + a + aa;
	
		
		int count = 0;
		int art = 1;
		for(int i=aa+1; i<9; i++){
			String yer = "" + (char)(a+art) + (i);
			dizi[count] = yer;
			count++;
			if((char)(a+art)=='h')
				break;
			art++;
		}
		art = 1;
		for(int i=aa-1; i>0; i--){
			String yer = "" + (char)(a+art) + (i);
			dizi[count] = yer;
			count++;
			if((char)(a+art)=='h')
				break;
			art++;
		}
		
		
		int azal = 1;
		for(int i=aa+1; i<9; i++){
			String yer = "" + (char)(a-azal) + (i);
			dizi[count] = yer;
			count++;
			if((char)(a-azal)=='a')
				break;
			azal++;
		}
		azal = 1;
		for(int i=aa-1; i>0; i--){
			String yer = "" + (char)(a-azal) + (i);
			dizi[count] = yer;
			count++;
			if((char)(a-azal)=='a')
				break;
			azal++;
		}
		
		return dizi;
	}

}
