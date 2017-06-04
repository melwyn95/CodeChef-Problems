#include<stdio.h>

int main() {
	
	int t, n;
	
	scanf("%d",&t);
	
	while (t-- > 0) {
		scanf("%d",&n);
		char s[n];
		int c[1007] = {0};
		scanf("%s",s);
		int i = 1, buildings = n;
		for (;i<n-1;i++) {
			if (s[i] == '1') {
				c[i-1] = c[i] = c[i+1] = 1;
			}
		}
		if (s[0] == '1') {
			c[0] = c[1] = 1;
		} 
		if (s[n-1] == '1') {
			c[n-1] = c[n-2] = 1;
		}
		for (i=0;i<n;i++) {
			buildings -= c[i];
		}
		printf ("%d\n",buildings);
	}
	
	
	return 0;
}
