import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		int k_in = Integer.parseInt(buffer.readLine());
		String input_str = buffer.readLine();
		int length = input_str.length();
		int count = 0;
		String sub_str,sub1;

		for(int size=1; size<=(input_str.length()/2); size++){
			for(int j=0; (j+size)<=input_str.length(); j++){
				sub_str = input_str.substring(j,j+size);
				for(int k=j+1; (k+size)<=input_str.length(); k++){
					sub1 = input_str.substring(k,k+size); 
					int differences = 0;
					for(int x=0; x<size; x++){
						if(sub_str.charAt(x) != sub1.charAt(x)){
							differences++;
						}
					}
					if(differences <= k_in)
						count++;
				}
			}
		}
		System.out.println(count);
	}
}