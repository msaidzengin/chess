public class At extends Tas {

	public At (char c, String l) {
		
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
		String[] dizi = new String[8];
		String s = this.getLocation();
		char a = s.charAt(0);
		int aa = Integer.parseInt(s.substring(1,2));
		String eski = "" + a + aa;
		
		String y1 = "" + (char)(a-2) + (aa+1);
		String y2 = "" + (char)(a-2) + (aa-1);
		String y3 = "" + (char)(a+2) + (aa+1);
		String y4 = "" + (char)(a+2) + (aa-1);
		String y5 = "" + (char)(a-1) + (aa+2);
		String y6 = "" + (char)(a+1) + (aa+2);
		String y7 = "" + (char)(a-1) + (aa-2);
		String y8 = "" + (char)(a+1) + (aa-2);
				
		int count = 0;
		int kont = Integer.parseInt(y1.substring(1,y1.length()));		
		if( (y1.charAt(0) >= 'a' && y1.charAt(0) <= 'h') && (kont>=0 && kont <=8) ){
			dizi[count] = y1;
			count++;
		}
		kont = Integer.parseInt(y2.substring(1,y2.length()));	
		if( (y2.charAt(0) >= 'a' && y2.charAt(0) <= 'h') && (kont>=0 && kont <=8) ){
			dizi[count] = y2;
			count++;
		}
		kont = Integer.parseInt(y3.substring(1,y3.length()));	
		if( (y3.charAt(0) >= 'a' && y3.charAt(0) <= 'h') && (kont>=0 && kont <=8) ){
			dizi[count] = y3;
			count++;
		}
		kont = Integer.parseInt(y4.substring(1,y4.length()));	
		if( (y4.charAt(0) >= 'a' && y4.charAt(0) <= 'h') && (kont>=0 && kont <=8) ){
			dizi[count] = y4;
			count++;
		}
		kont = Integer.parseInt(y5.substring(1,y5.length()));	
		if( (y5.charAt(0) >= 'a' && y5.charAt(0) <= 'h') && (kont>=0 && kont <=8) ){
			dizi[count] = y5;
			count++;
		}
		kont = Integer.parseInt(y6.substring(1,y6.length()));
		if( (y6.charAt(0) >= 'a' && y6.charAt(0) <= 'h') && (kont>=0 && kont <=8) ){
			dizi[count] = y6;
			count++;
		}
		kont = Integer.parseInt(y7.substring(1,y7.length()));	
		if( (y7.charAt(0) >= 'a' && y7.charAt(0) <= 'h') && (kont>=0 && kont <=8) ){
			dizi[count] = y7;
			count++;
		}
		kont = Integer.parseInt(y8.substring(1,y8.length()));	
		if( (y8.charAt(0) >= 'a' && y8.charAt(0) <= 'h') && (kont>=0 && kont <=8) ){
			dizi[count] = y8;
			count++;
		}
		
		return dizi;
	}

}
