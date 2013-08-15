#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
	int k;
	char str[6000];
	scanf("%d",&k);
	scanf("%s",str);
	
	int len=strlen(str);
	int i,j,mismatch,count,r;

	count=0;

	for(i=0;i<len-1;i++){
		for(j=i+1;j<len;j++){  
			mismatch=0;
			for (r=0; r<len-j; ++r){
				if (str[i+r] != str[j+r]){
					++mismatch;
					if (mismatch > k)
						break;
				}
				++count;
			}
		}
	}
	printf("%d",count);
	return 0;
}