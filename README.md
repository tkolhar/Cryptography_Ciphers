# Cryptography_Ciphers

##Problem 1: 

1.Write computer programs for the Substitution Cipher based on Z29 which is cor-
responding to 26 alphabetic characters, space (26), \, " (27), and \."(28). 

The key is a random permutation on Z29. Write down encryption and decryption programs.

The program will ask to input a permutation and then the plaintext (or ciphertext).

Select a paragraph of text (I don't think any two people will choose a same paragraph if they choose independently) and encrypt it using your encryption algorithm. 

Then use your decryption program to check the correctness. You can use Java, C, or other computer languages. Record your plaintext, ciphertext and the key  in your answer sheet.


Solution: 

Accept a permutation by the program which is set { a to z, space,comma, period}

Explanation of Substitution Cipher: 

Encryption:
`1.	We encrypt using the logic that for each value appeared in the plaintext it will be replaced with the key.` 

`2.	For example, if there is an alphabet ‘l’ in the plaintext it will be replaced with comma (,) if there is an alphabet ‘i’ in the plaintext it will be replaced with ‘b’.`

`Decryption:
1.	For decryption, we just replace back by mapping to original value. `

For example, if alphabet ‘v’ is in the encrypted text it will be replaced with ‘h’.
                


For each value, there is a key associated:

space	,	.	a	b	c	D	e	f	g	h	i	j	K	l	m	n	o	p	q	R	s	t	u	v	w	x	y	z

p	u	y	k	h	q	J	l	i	d	v	b	space	O	,	c	f	r	e	t	x	a	n	z	m	g	w	.	s

Accept the plaintext to encrypt: Life is harder when you have choices. My culture believes that parents choose your path in life. Back in home my friends and I talked around what our parents wanted for us and worked carefully to get those goals. Then we moved here and I find myself in a culture where the children have to say about what they want to do.

Encrypt it using substitution cipher with above key:
,bilpbapvkxjlxpgvlfp.rzpvkmlpqvrbqlaypc.pqz,nzxlphl,blmlapnvknpekxlfnapqvrralp.rzxpeknvpbfp,bilyphkqopbfpvrclpc.pixblfjapkfjpbpnk,oljpkxrzfjpgvknprzxpekxlfnapgkfnljpirxpzapkfjpgrxoljpqkxliz,,.pnrpdlnpnvralpdrk,aypnvlfpglpcrmljpvlxlpkfjpbpibfjpc.al,ipbfpkpqz,nzxlpgvlxlpnvlpqvb,jxlfpvkmlpnrpak.pkhrznpgvknpnvl.pgkfnpnrpjry


Decryption back to the original text using the same key:

Your original sentence was: 

life is harder when you have choices. my culture believes that parents choose your path in life. back in home my friends and i talked around what our parents wanted for us and worked carefully to get those goals. then we moved here and i find myself in a culture where the children have to say about what they want to do.`

Problem 2:
Write computer programs for the Permutation Cipher based on Z29 as in Problem

1. In encryption program, the inputs are a value of m, a permutation as the key
and the plaintext, and the output is the ciphertext. Write the decryption program
accordingly.

Try your programs by some text. Note that since m and the length
of plaintext is not fixed, paddings might be added to the end of plaintext by the
program. 

You may think about what kind padding is better for the security and
design your paddings.

Solution:

Accept the value of m and the permutation key 

Explanation: 
Encryption using Permutation cipher:
1.	For a value of m: Divide the plaintext into group of m.

2.	For each row with m columns apply the permutation key and encrypt each row.

3.	For example, if key is of size 6 i.e. value m = 6 and has permutation value 431625.

4.	Consider a plaintext hello world t. 

5.	Now dividing it in group of 6 we get first row as hello’space’ since we are considering space also to encrypt. 

6.	Now according to the key value, we can encrypt it as loeh’space’l. 

7.	See that according to the key 1st position letter of original text is at 4th position of encrypted text so we get value ‘l’.

8.	Then proceeding 2nd position letter of original text is at 3rd  position of encrypted text and so on…

PADDING TECHNIQUE:

9.	Since value of m and plaintext is not known we use the symbol ‘*’ (star) to add padding at the end of the text so that we have the last column of size m.


Decryption using Permutation cipher:

1.	For the permutation provided we first obtain the inverse.

2.	In our example the inverse of the permutation is 352164.

3.	We again consider each row of encrypted text of column size m and apply the above key.

4.	For example, the encrypted text is loeh’space’l. 

5.	According to the key 1st position letter of encrypted text is at 3rd position in original text. 

6.	2nd position letter of encrypted text is at 5th position in the original text and so on ... 

7.	Remove padding symbols to obtain the original text in the end.

8.	hence we get back the original text as hello’space’.

Example:
Key: 431625
Plaintext: 
Life is harder when you have choices. My culture believes that parents choose your path in life. Back in home my friends and I talked around what our parents wanted for us and worked carefully to get those goals. Then we moved here and I find myself in a culture where the children have to say about what they want to do.

Encrypted text using the key 431625:
The encrypted text: 
f iLiehr sda hreewyu n ov ahceieohscM  .cytrlueueib elstevh  atarpt necsoeoh su oyprhitan iel .fakB  c onimhm  efyedirsnn a Idakt elao dur hdnawor t urnaptewn sta oderfsau n wr dko aderculfeylogt e to tshga elo h.seTw  nmee vohdearen If di  ydnsmfilen  ua lcr utwer ehte hehicrndl ev ahtesy o aotba ua hwttyweha  otn t.*od**




Decrypt the text using inverse of the key which in our case is 352164.
The decrypted text : 
Life is harder when you have choices. My culture believes that parents choose your path in life. Back in home my friends and I talked around what our parents wanted for us and worked carefully to get those goals. Then we moved here and I find myself in a culture where the children have to say about what they want to do.

Please note in the program you need to provide the permutation in 2 X m matrix format:

So, for example if the key is 431625 then program will accept value as:

1	2	3	4	5	6

4	3	1	6	2	5

The first row is just the position of letter is the encrypted text.



Problem 3 (CS5413)

4. The following is a piece of ciphertext which is encrypted by Vegene_re Cipher.

cjnpkgrlilqwawbnuptgkerwxuzviaiiysxckwdntjawhqcutttvp
tewtrpgvcwlkkkgczafsihrimixukrwxrfmgfgkfxgukpjvvzmcmj
vawbnuptgcicvxvkgczkekgcqbchvnrqhhwiadfrcyxgvzqqtuvbd
guvttkccdpvvfphftamzxqwrtgukcelqlrxgvycwtncbjkkeerecj
qihvrjzpkkfexqgjtpjfupemswwxcjqxzpjtxkvlyaeaemwhovudk
mnfxegfrwxtdyiaecyhlgjfpogymbxyfpzxxvpngkxfitnkfdniyr
wxukssxpkqabmvkgcqbciagpadfrcyxgvyyimjvwpkgscwbpurwxq
kftkorrwvnrqhxurlslgvjxmvccraceathhtfpmeygczwgutttvtt
katmcvgiltwcsmjmvyghitfzaxodkbf

Try to find the plaintext. You need to write programs for computing index of coin-
cidence Ic and mutual index of coincidence MIc.

Use the methods discussed in the lecture notes to find the key size m first and then find the key. Using the found key
you are able to decrypt the ciphertext.

Solution:

Accept the encrypted text to be decrypted using Vignere cipher.

Explanation:
1.	We start by computing Index of co-incidence using the formula:
            Ic(x) = Summation of  f i * (fi − 1) from 0 to 25 / n * (n − 1)

            Where f is frequency of letter occurring in the encrypted text and n is the length of the               
             encrypted text.

In our case length is 455 so n=455

Total Summation = 8902.0

n*(n-1) = 206570

Index of Co-incidence = 8902.0 / 206570

Index of Co-incidence = 0.04309435058333737

2.	Finding the key length:

1.	We consider value of m which is the key length as 2,3,4,5.

2.	For each m :

3.	We divide the encypted text in to m rows.

4.	For each row we calculate Index of co-incidence.

5.	Finally we compute average of Index of co-incidence for a value of m.

6.	We then consider the Index of incidence with highest value for a value of m.

7.	Then, that value is assumed to be the length of the key.

For m = 2 0.04238 

For m = 3 0.04168 

For m = 4 0.04311

For m = 5  0.06276

In our case the key with length 5 has highest Index of co-incidence.


3.	Finding the key :

1.	We calculate mutual index of co-incidence using the formula given in the notes

2.	For each shift from 0 to 25 we obtain a value . 

3.	The value which is about to Index of incidence is chosen. 

4.	In our case about to  0.04309435058333737

Using that we obtain K0 which is 2 for us

Then K1 = K0 + 15

K2 =K0 + 22

K3 = K0 + 13

K4 = K0 + 17

Hence, the key is ‘crypt’

4.	Finding the original text using the key:

1.	We divide the encrypted text in column of 5 since the length of key is 5.

2.	Then we perform shifting operation on each row using the key to obtain original text.

3.	Since in our case the total length of encrypted text is 455 we get 91 rows.

4.	Finally, we obtain the plain text:

   The decrypted text is

aspareantsofchildreninthesixthgradeatyourschoolwearereluctantlywritingyoutoprotestthepoormethinstructionthechildrenaregettinginmrjokesclassourcomplaintisbasedonseveralfactorsmrjokeoftenstepsoutinthehallduringclasstotalkwithpeoplewhowalkbyheassignsvirtuallynohomeworkwhileothermathclasseshavehomeworkeverynightalthoughthestudentslikemrjoketheycomplainthattheyarebehindtheothermathclassesandseelittlechanceofchatchingupweareveryconcernedaboutthisproblemmmmm




Original Text is : 

as pareants of children in the sixth grade at your school we are reluctantly writing you to protest the poor meth instruction the children are getting in mr jokes class our complaint is based on several factors mr joke often steps out in the hall during class total k with people who walk by he assigns virtually no homework while other math classes have homework every night although the students like mr joke they complain that they are behind the other math classes and see little chance of chatching up we are very concerned about this problemmmmm	


















