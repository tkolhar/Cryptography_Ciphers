import java.util.Scanner;

public class Subcipher {
	
public static final int ASCII_SUB = 96;
public static final int ASCII_SUB_FOR_SPACE = 32;
public static final int ASCII_SUB_FOR_COMMA = 44;
public static final int ASCII_SUB_FOR_PERIOD = 46;
private static String permutation;
	
public static void main(String[] args) {

	System.out.println("Please provide the key: ");
    Scanner input = new Scanner(System.in);
    String key = input.nextLine();
    setPermutation(key);
    
    input.nextLine();
    
    System.out.println("Enter the text that you would like to cipher:");
    String cipher = input.nextLine();
    input.close();

    int length = cipher.length();
    char [] encryption = new char[50000]; 
    encryption = createCipher();
    String cipheredText = encrypt(encryption, cipher, length);

    System.out.println("The encrypted version of your sentence is: \n" + cipheredText);
    char[] encryptedCharacters = cipheredText.toCharArray();
    String original = decrypt(encryption, encryptedCharacters, length);

    System.out.println("Your original sentence was: " + original);
}

public static char[] createCipher(){
	
	
    String key = getPermutation();
    char[] encryption = new char[29];
    for(int i = 0;i < key.length();i++)
    {
    	encryption[i]= key.charAt(i);
    }
    return encryption;
}


public static String encrypt(char[] encryption, String cipher, int length){

    String lowercaseCipher = cipher.toLowerCase();
    char [] characterArray = new char [50000];
    characterArray = lowercaseCipher.toCharArray();
   
    for(int i = 0; i<length; i++){
        if(characterArray[i] == ' '){
            characterArray[i] = (char) (characterArray[i] - ASCII_SUB_FOR_SPACE);   
        }
        else
        if(characterArray[i] == ',')
        {
        	characterArray[i] = (char) (characterArray[i] - ASCII_SUB_FOR_COMMA+1);
  
        }
        else
        	
        if(characterArray[i] == '.')
        {
        	characterArray[i] = (char) (characterArray[i] - ASCII_SUB_FOR_PERIOD+2);	
        }
        else{
            characterArray[i] = (char) (characterArray[i] - ASCII_SUB+2);
        }
        
    }

    for(int i = 0; i<length; i++){
        characterArray[i] = encryption[characterArray[i]];
    }

    String cipheredText = new String(characterArray);
    return cipheredText;
}


public static String decrypt(char[] encryption, char[] encryptedCharacters, int length){

    int p = 0;
    int i = 0;
    int w = 0;
    int[] deciphered = new int[length];

    do {
        if(encryption[i] == encryptedCharacters[p])
        {
            deciphered[w] = i;
            i = 0;
            w++;
            p++;
        }
        else
        i++;
    }while(p<length);

    char[] finishedSentence = new char[length];
    for(int x = 0;x<length;x++){
        if(deciphered[x] == 0){
            finishedSentence[x] = (char) (deciphered[x] + ASCII_SUB_FOR_SPACE);
        }
        else
        if(deciphered[x] == 1){
            finishedSentence[x] = (char) (deciphered[x] + ASCII_SUB_FOR_COMMA - 1);
        }
        else
        	
        if(deciphered[x] == 2){
            finishedSentence[x] = (char) (deciphered[x] + ASCII_SUB_FOR_PERIOD - 2);
        }
        else{
            finishedSentence[x] = (char) (deciphered[x] + ASCII_SUB-2);
        }
    }   


    String deCipheredText = new String(finishedSentence);

    return deCipheredText;
}

public static String getPermutation() {
	return permutation;
}

public static void setPermutation(String permutation) {
	Subcipher.permutation = permutation;
}
}