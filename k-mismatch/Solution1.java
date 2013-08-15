import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(buffer.readLine());
		String input_str = buffer.readLine();
		int length = input_str.length();
		int count = 0;
		String sub_str;
		ArrayList<String> subs = new ArrayList<String>();

		for(int i=0; i<length; i++){
			for(int j=1; j<=length-i; j++){
				sub_str = input_str.substring(i, i+j);
				subs.add(sub_str);
			}
		}

		for(int i=0; i<subs.size(); i++){
			for(int j=i+1; j<subs.size(); j++){
				if(compare_str(subs.get(i),subs.get(j),k)){
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static boolean compare_str(String str1, String str2, int k){
		int differences = 0;
		int str1_len = str1.length();
		int str2_len = str2.length();
		
		if(str1_len != str2_len)
			return false;
		else{
			for(int i=0; i<str1_len; i++){
				if(str1.charAt(i) != str2.charAt(i)){
					differences++;
				}
			}
			if(differences <= k)
				return true;
			else
				return false;
		}
	}
}