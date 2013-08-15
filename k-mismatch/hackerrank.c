#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

	/* Enter your code here. Read input from STDIN. Print output to STDOUT */    
	int k_in = 0;
	int count = 0;
	char input_string[5000];
	scanf("%d",&k_in);
	scanf("%s",input_string);
	int strlen_input = strlen(input_string);
	int differences =0;

	for(int size=1; size<=(strlen_input/2); size++){
		for(int j=0; (j+size)<=strlen_input; j++){
			for(int k=(j+1); (k+size)<=strlen_input; k++){
				differences = 0;
				for(int x=0; x<size; x++){
					if(input_string[j+x] != input_string[k+x]){
						differences++;
					}
				}
				if(differences <= k_in){
					count++;
				}
			}
		}
	}
	printf("%d",count);	
	return 0;
}