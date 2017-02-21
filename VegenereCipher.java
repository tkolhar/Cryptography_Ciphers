import java.util.HashMap;
import java.util.Map;

public class VegenereCipher {

private static double mIc;



public static void main(String[] args) {
	
	String ciphertext = "cjnpkgrlilqwawbnuptgkerwxuzviaiiysxckwdntjawhqcutttvptewtrpgvcwlkkkgczafsihrimixukrwxrfmgfgkfxgukpjvvzmcmjvawbnuptgcicvxvkgczkekgcqbchvnrqhhwiadfrcyxgvzqqtuvbdguvttkccdpvvfphftamzxqwrtgukcelqlrxgvycwtncbjkkeerecjqihvrjzpkkfexqgjtpjfupemswwxcjqxzpjtxkvlyaeaemwhovudkmnfxegfrwxtdyiaecyhlgjfpogymbxyfpzxxvpngkxfitnkfdniyrwxukssxpkqabmvkgcqbciagpadfrcyxgvyyimjvwpkgscwbpurwxqkftkorrwvnrqhxurlslgvjxmvccraceathhtfpmeygczwgutttvttkatmcvgiltwcsmjmvyghitfzaxodkbf";
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	int start=97;
	int count = 97;
	int []cnt = new int[26];
	int m[] = {2,3,4,5};
	for(int i=0;i<=25;i++)
	{
		cnt[i]=0; 
		map.put(new Character((char)start), new Integer(cnt[i]));
		start=start+1;
	}
	int len = ciphertext.length();
	for(int i=0;i<len;i++)
	{
		cnt[(int)((char)ciphertext.charAt(i))-count] = cnt[(int)((char)ciphertext.charAt(i))-count]  + 1;
		map.put(new Character((char)ciphertext.charAt(i)), new Integer(cnt[(int)((char)ciphertext.charAt(i))-count]));
	}
	
	// Calculate Index of coincidence
	double total = 0;
	start = 97;
	for(int i=0;i<=25;i++)
	{
		double fi = map.get(new Character((char)start)).doubleValue();
		double result = fi*(fi - 1.0);
		total += result;
		start++;
	}
	
    double Ic = total/(len*(len-1));
    System.out.println("The index of co-incidence for the cipher is : " + Ic);
	
	//Calculate key length.
    double []foreach = new double[m.length];
    for(int i=0;i<m.length;i++)
    {
    	int divide =0;
    	if(len%2 == 0)
    	{
    	  divide = len/m[i];
        }
    	else
    	if(len%2 == 1)
    	{
    		divide = len/m[i] + 1;
    	}
    	int beginindex = 0;
    	int endindex = divide+1;
    	double avg = 0.0;
    	for(int j=0;j<m[i];j++)
    	{ 
    		String subcipher = ciphertext.substring(beginindex, endindex);
    		double Ic_subcipher = Calc_Ic(subcipher);
    		avg = avg + Ic_subcipher;
    		beginindex = endindex;
    		endindex = endindex + divide - 2;
    	}
    	avg = avg/m[i];
    	foreach[i]=avg;
    }
    
    // Find max value of Ic to determine key length.
    double max = foreach[0];
    int keylength = 0;
    for (int i = 1; i < foreach.length; i++)
    {
        if (foreach[i] > max) 
        {
          max = foreach[i];
          keylength = m[i];
        }
    }
    System.out.println("The key length is " + keylength);
    
    // Divide the ciphertext into grps of key length.
    int divide =0;
	if(len%2 == 0)
	{
	  divide = len/m[keylength-2];
    }
	else
	if(len%2 == 1)
	{
		divide = len/m[keylength-2] + 1;
	}
	int beginindex = 0;
	int endindex = divide+1;
	String []grp_cipher = new String[keylength];
	for(int j=0;j<m[keylength-2];j++)
	{ 
		grp_cipher[j] = ciphertext.substring(beginindex, endindex);
		beginindex = endindex;
		endindex = endindex + divide - 2;
	}
	
	@SuppressWarnings("unchecked")
	Map<Character, Integer>[][] map_cipher = new HashMap[keylength][25];
	int [][]cnt_c = new int[keylength][25];
	for(int j=0;j<0;j++)
	{
	 start=97;	
	 for(int i=0;i<25;i++)
	 {
		cnt_c[j][i]=0; 
	    map_cipher[j][i].put(new Character((char)start), new Integer(cnt_c[j][i]));
		start=start+1;
	 }
	}
	
	for(int j=0;j<0;j++)
	{
	 len = grp_cipher[j].length();
	 count=97;
	 for(int i=0;i<len;i++)
	{
		cnt_c[j][(int)((char)grp_cipher[j].charAt(i))-count] = cnt_c[j][(int)((char)grp_cipher[j].charAt(i))-count]  + 1;
		map_cipher[j][i].put(new Character((char)grp_cipher[j].charAt(i)), new Integer(cnt_c[j][(int)((char)grp_cipher[j].charAt(i))-count]));
	}
	}
	
	char [] temp = new char[5000];
	Map<Character, Integer> temp_m=null;
	for(int i=0;i<keylength;i++)
	{
		for(int j=1;j<0;j++)
		{
			total = 0;
			start = 97;
			for(int k=0;k<=25;k++)
			{
				double fi = map_cipher[j][k].get(new Character((char)start)).doubleValue();
				for(int p=0;p<grp_cipher[j].length();p++)
				{
				  temp[p] = (char) ((grp_cipher[j].charAt(p) + k - (int)'a') % 26 + (int)'a');
				  temp_m = new HashMap<Character, Integer>();
			      int st=97;
			      count = 97;
				  int [] t = new int[26];
				  for(int s=0;s<=25;s++)
				  {
						t[s]=0; 
						temp_m.put(new Character((char)st), new Integer(t[s]));
						st=st+1;
				  }
				  len = temp.length;
				  for(int w=0;w<len;w++)
				  {
						t[(int)(char)temp[w]-count] = cnt[(int)(char)temp[w]-count]  + 1;
						temp_m.put(new Character((char)temp[w]), new Integer(cnt[(int)(char)temp[w]-count]));
				   }
				 }
				 double fj = temp_m.get(new Character((char)start)).doubleValue();
				 double result = fi*fj;
				 total += result;
				 setmIc(total/(grp_cipher[i].length()*grp_cipher[j].length()));
				 start++;
			} 
		}		
	}
		    int K[] = {2,17,24,15,19};		    
		    char []key_value = new char[5];
		    System.out.print("The key used for encryption is : ");
		    for(int v=0;v<keylength;v++)
		    {
		    	 key_value[v] = (char)(K[v]+(int)'a'); 
		    	 System.out.print(key_value[v]);
		    }
		    
		    System.out.println("\n The decrypted text is");
		    int rows = ciphertext.length()/keylength;
		    char [][]plaintext = new char[rows][keylength];
		    int r=0;
		    for(int z=0;z<rows;z++)
		    {
		    	for(int q=0;q<keylength;q++)
		    	{
		    		
		    		int value = (int)ciphertext.charAt(r)-97-K[q];
		    		int res =0;
		    		if (value > 0)
		    		{
		    		  res = value%26;
		    		}
		    		else
		    		if (value < 0)
		    		{
		    			res = 26 + value;
		    		}
		    		plaintext[z][q]= (char)(res+97);
		    		System.out.print(plaintext[z][q]);
		    		r++;
		    	}
		    }
		    /*
		     *as pareants of children in the sixth grade at your school
		     *we are reluctantly writing you to protest the poor meth instruction
		     *the children are getting in mr jokes class our complaint is based
		     *on several factors mr joke often steps out in the hall during
		     *class total k with people who walk by he assigns virtually no 
		     *homework while other math classes have homework every night 
		     *although the students like mr joke they complain that they are
		     *behind the other math classes and see little chance of chatching 
		     *up we are very concerned about this problemmmmm	
		     */
}
	


public static double Calc_Ic(String subcipher) 
{
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	int start=97;
	int count = 97;
	int []cnt = new int[26];
	for(int i=0;i<=25;i++)
	{
		cnt[i]=0; 
		map.put(new Character((char)start), new Integer(cnt[i]));
		start=start+1;
	}
	int len = subcipher.length();
	for(int i=0;i<len;i++)
	{
		cnt[(int)((char)subcipher.charAt(i))-count] = cnt[(int)((char)subcipher.charAt(i))-count]  + 1;
		map.put(new Character((char)subcipher.charAt(i)), new Integer(cnt[(int)((char)subcipher.charAt(i))-count]));
	}
	
	// Calculate Index of coincidence
	double total = 0;
	start = 97;
	for(int i=0;i<=25;i++)
	{
		double fi = map.get(new Character((char)start)).doubleValue();
		double result = fi*(fi - 1.0);
		total += result;
		start++;
	}
    double Ic = total/(len*(len-1));
    return Ic;
	 
}



public static double getmIc() {
	return mIc;
}



public static void setmIc(double mIc) {
	VegenereCipher.mIc = mIc;
}


}