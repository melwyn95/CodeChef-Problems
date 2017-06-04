#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#define N (1000000 + 7)

int * primes;

int * seive() {
	int *primes = (int *) calloc(78500, sizeof(int *));
	int *numbers = (int *) calloc(N, sizeof(int *));
	int N_sqrt = (int) sqrt(N);
	int i, j, k=0;

	for (i=2;i<=N_sqrt;i++) {
		if (!numbers[i]) {
			primes[k++] = i;
			for (j=2*i;j<N;j+=i) {
				numbers[j] = 1;
			}
		}
	}
	for (i=N_sqrt+1;i<N;i++) {
		if (!numbers[i]) {
			primes[k++] = i;
		} 
	}
	free(numbers);
	return primes;
}

int * solve(int n, int *bitmap) {
	
	int current_prime = 0;
	
	while (n != 1) {
		if (n%primes[current_prime] == 0) {
			n /= primes[current_prime];
			bitmap[current_prime]++;
		} else {
			current_prime++;
		}
	}
	
	return bitmap;
}


// 01/06/2017 - Works for small input
// 02/06/2017 - Works for all input
int main() {
	int i = 0, t, n;
	primes = seive();
	
	scanf ("%d",&t);
	
	while (t--) {
		scanf ("%d",&n);
		int a[n];
		int *bitmap = (int *) calloc(78500, sizeof(int *));;
		for (i=0;i<n;i++) {
			scanf ("%d",&a[i]);
			bitmap = solve(a[i], bitmap);
		}	
		int answer = 1;
		for (i=0;i<78500;i++) {
			if (bitmap[i]) {
				answer *= (bitmap[i] + 1);
			}
		}
		printf ("%d\n", answer);
		free(bitmap);
	}
	
	free(primes);
	return 0;
}
