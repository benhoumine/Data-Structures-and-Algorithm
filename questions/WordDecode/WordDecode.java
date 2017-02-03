import java.io.*;
import java.util.*;
public class WordDecode {
	/*** The idea is very simple, lets say dictionary[ ] is an array of
	 *	 Strings which contains all the words. Now let enc is the encrypted
	 *	 message and dec will be the decrypted message.Lets take initialize start=0,i=0.
	 *   We would search from 0th index till the last and check whether the 
	 *   substring is equals to any
	 *	 word of the dictionary or any word of the dictionary is a substring of the string
	 *	 "match" or not.So there will be two cases, 
	 *
	 *   Case 1:( When Length of "match" <=maximum length of a word in dictionary )
	 *   -------
	 *   In this case, we need to search whether the substring starting from "start" to i
	 *	 is equals to any word of the dictionary.If it's then append this substring to 
	 *    
	 */

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		// max_length is used to hold the maximum length of a word in the dictionary
		int max_length=0;
		String dictionary[]=br.readLine().split(" "),dec="";
		// dec is the decoded message
		
		// Now I'm counting the maximum length of a word
		for(String s: dictionary)
			max_length=Math.max(max_length,s.length());
		
		System.out.println("Enter encoded string=");
		String enc=br.readLine();
		int start=0; // start is the starting index from which the substrings will be matched.
					// initially start is pointing to the beginning of the string.
		
		for(int i=0;i<enc.length();i++){
			// get the substring starting from index "start" to "i"
			String match=enc.substring(start, i+1);
			
			/*** if the length of current substring is<= 
			 * 
			 */
			if(i-start<max_length){
				for(String s:dictionary)
					if(match.equals(s)){
						dec+=s+" ";
						start=i+1; // next matching will be from index i+1
						break;
					}
			}
			/** Now in following case, the length of the substring is greater than the max length of a word
			 * in the dictionary.So we need to search if any word of dictionary is contained 
			 * in this substring ( i.e if any word of dictionary is substring of the String "match" )
			 */
			else{ 
				for(String s: dictionary){
					int idx=match.indexOf(s);
					if(idx!=-1){
						dec+=s+" ";
						start+=idx+s.length();
						break;
					}
				}
			}
		}
		System.out.println(dec);
	}
}
