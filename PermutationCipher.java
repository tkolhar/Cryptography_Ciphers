import java.util.Scanner;
import org.apache.commons.lang.ArrayUtils;

public class PermutationCipher {

private static int [][] permutation;
private static int [][] inverse;
private static int m;
	
public static void main(String[] args) {

	System.out.println("Please provide the value of m : ");
    Scanner input = new Scanner(System.in);
    m = input.nextInt();
    setM(m);
    
    input.nextLine();
    
    System.out.println("Please provide the permutation (2 x m) : ");
    permutation = new int[2][m];
    for(int i = 0;i< 2; i++)
    {
    	for(int j=0;j<m;j++)
    	{
    		 System.out.println("Please provide value [" + i + "][" + j + "] :");
    		 input = new Scanner(System.in);
    		 permutation[i][j] = input.nextInt();
    		 input.nextLine();   		 
    	}
    }
   
    System.out.println("Enter the text that you would like to cipher:");
    String cipher = input.nextLine();
    input.close();
    int length = cipher.length();
    
    // Divide plaintext into group of 'm'
    int quotient = length / m;
    int totalq = m * (quotient +1);
    int paddingbit = totalq - length;
    int totallen = length + paddingbit;
    int rows = totallen / m;
    
    char [][] grp = new char[rows][m];
    int k =0;
    for(int i = 0;i<rows;i++)
    {
    	for(int j=0;j<m;j++)
    	{
    		if (k == length)
    		{
    			grp[i][j] = '*';
    		}
    		else
    		{
    			grp[i][j] = cipher.charAt(k);
    			k++;
    		}
    	}
    }
    
    char [][] grp_apply = new char[rows][m];
    for(int i=0;i<rows;i++)
    {
    	for(int j=0;j<m;j++)
    	{
    		grp_apply[i][permutation[1][j]-1] = grp[i][j];
    		
    	}
    }
    
    System.out.println("\nThe encrypted text : ");
    for(int i=0;i<rows;i++)
    {
    	for(int j=0;j<m;j++)
    	{
    		System.out.print(grp_apply[i][j]);
    	}
    }
    
    //inverse key for decryption
    inverse = new int[2][m];
    for(int i=0;i<1;i++)
    {
    	for(int j=0;j<m;j++)
    	{
    		inverse[i][j] = permutation[i][j];
    	}
    }
    
    int [] temp = new int[m];
    int [] temp1 = new int[m];
    for(int i=0;i<m;i++)
    {
    	temp[i] = permutation[1][i];
    	temp1[i] = permutation[1][i];
    }
    
    for(int i=0;i<m;i++)
    {
       	int min=findMin(temp1,temp1.length);
       	int min_loc=indexOfMin(temp,min,temp.length);
       	inverse[1][i] = permutation[0][min_loc];
       	temp1 = ArrayUtils.removeElement(temp1, min);   
    }
    
    char [][] grp_decrypt = new char[rows][m];
    for(int i=0;i<rows;i++)
    {
    	for(int j=0;j<m;j++)
    	{	
    		grp_decrypt[i][inverse[1][j]-1] = grp_apply[i][j];
    		
    	}
    }
    
    System.out.println("\nThe decrypted text : ");
    char [] final_msg = new char[rows*m];   
    k =0;
    for(int i=0;i<rows;i++)
    {
    	for(int j=0;j<m;j++)
    	{
    		final_msg[k] = grp_decrypt[i][j];
    		k++;
    	}
    }
    for(int i=0;i<paddingbit;i++)
    {
    		final_msg = ArrayUtils.removeElement(final_msg, '*');
    }
    for(int i=0;i<final_msg.length;i++)
    {
    	System.out.print(final_msg[i]);
    }
}

public static int indexOfMin(int[] a, int min,int cnt) 
{
	  int loc = 0;
	  for (int i = 1; i < cnt; i++) 
	  {
	    if (a[i] == min) 
	    {
	       loc = i;
	       break;
	    }
	  }
	  return loc;
}

public static int findMin(int[] a, int cnt) 
{
	  int loc = 0;
	  int min = a[loc];
	  for (int i = 1; i < cnt; i++) {
	    if (a[i] < min) {
	      min = a[i];
	    //  loc = i;
	    }
	  }
	  return min;
}

public static int [][] getPermutation() {
	return permutation;
}

public static void setPermutation(int [][] permutation) {
	PermutationCipher.permutation = permutation;
}

public static int getM() {
	return m;
}

public static void setM(int m) {
	PermutationCipher.m = m;
}


public static int [][] getInverse() {
	return inverse;
}


public static void setInverse(int [][] inverse) {
	PermutationCipher.inverse = inverse;
}
}