#include <stdio.h>
int main(){
	int n1, n2;

	scanf("%d%d", &n1, &n2);

	int r1 = n1 + n2;
	int r2 = n1 - n2;

	if (n1 > n2 || n1 < n2) {
		printf("%d - %d = %d", n1, n2, r2);
	}
	else {
		printf("%d + %d = %d", n1, n2, r1);
	}
	
	return 0;
}
