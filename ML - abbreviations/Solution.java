import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args)throws IOException {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int num_lines = Integer.parseInt(buffer.readLine());
		String[] data = new String[num_lines];
		String[] expand = new String[num_lines];

		for(int i=0; i<num_lines; i++){
			data[i] = buffer.readLine();
		}

		for(int i=0; i<num_lines; i++){
			expand[i] = buffer.readLine();
		}
		
		Hashtable<String,String> abbr = new Hashtable<String,String>();
		
		String regex = "[A-Z][A-Z]+\\s";
		Pattern pattern = Pattern.compile(regex);
		String key1, value1;
		for(int i=0; i<num_lines; i++){
			Matcher matcher = pattern.matcher(data[i]);
			if(matcher.find()){
				key1 = data[i].substring(matcher.start(), matcher.end());
				key1 = key1.trim();
				//System.out.println("key: "+key1);
				String regex1 = "\\s"+key1.charAt(0);
				for(int j=1; j<(key1.length()-1); j++){
					regex1 = regex1+"(\\w|\\s)+"+key1.charAt(j);
				}
				regex1 = regex1+"(\\w|\\s)+" +key1.charAt(key1.length()-1)+"\\w+\\s";
				//System.out.println("Regex: "+regex1);
				Pattern pat1 = Pattern.compile(regex1);
				Matcher mat = pat1.matcher(data[i]);
				if(mat.find()){
					//System.out.println("inside");
					value1 = data[i].substring(mat.start(), mat.end());
					value1 = value1.trim();//System.out.println(value1);
					abbr.put(key1,value1);
				}
			}
		}

		for(int i=0; i<num_lines; i++){
			//System.out.println("inside");
			for(int j=0; j<data[i].length(); j++){
				if(data[i].charAt(j) == '('){
					//System.out.println("insides");
					int end_brac = j;
					while(data[i].charAt(end_brac) != ')'){
						end_brac++;
					}
					//System.out.println("j = "+j+"   end= "+end_brac);
					String key = data[i].substring(j+1,end_brac);
					key = key.trim();
					//System.out.print("Key: "+key+"\t=>\t");
					//for(int k=(key.length()-1); k>=0; k--){
					String key_copy = key;
					char req_char = key.charAt(0);
					int num_of_req = 1;
					for(int y = 1; y<key.length(); y++){
						if(key.charAt(y) == req_char)
							num_of_req++;
					}
					int word_loc = j;
					boolean control = true;
					for(int x =0; x<num_of_req;x++){
						do{
							if((word_loc > 1) && (data[i].charAt(word_loc) == req_char) && (data[i].charAt(word_loc-1) == ' ')){
								control = false;
							}
							else{
								if(data[i].charAt(word_loc) == req_char)
									control = false;
							}

							if(word_loc != 0)
								word_loc--;
							else
								control = false;

						}while(control);
					}
					//}while((data[i].charAt(word_loc) != req_char) && ((data[i].charAt(word_loc-1) != ' ') || ((word_loc-1) = 0))){
					//	word_loc--;
					//}
					String value = data[i].substring(word_loc,j);
					value = value.trim();
					abbr.put(key,value);
					//System.out.println("value: "+value);

				}

				

					//key.append(data[i].charAt());
			}
		}
	
		for(int i=0; i<num_lines; i++){
			String key = expand[i];
			if(abbr.containsKey(key))
				System.out.println(abbr.get(key));
			else
				System.out.println();
		}
		// for(int i=0; i<num_lines; i++){
		//     System.out.println(data[i]);
		// }
	}
}