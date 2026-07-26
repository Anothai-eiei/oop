#include <stdio.h>
int main(){
	double s;
	
	scanf("%lf", &s);

	if (s >= 80 && s <= 100) {
		printf("A");
	}
	else if (s < 80 && s >= 70) {
		printf("B");
	}
	else if (s < 70 && s >= 60) {
		printf("C");
	}
	else if (s < 60 && s >= 50) {
		printf("D");
	}
	else if (s < 50 && s >= 0) {
		printf("F");
	}
	else {
		printf("Out of Range");
	}

	return 0;
}
