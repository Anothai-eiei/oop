#include <stdio.h>
int main() {
	double a, b, c;

	scanf("%lf%lf%lf", &a, &b, &c);

	if (a >= b && a <= c || a <= b && a >= c) {
		printf("%.2lf", a);
	}else if (b >= a && b <= c || b <= a && b >= c) {
		printf("%.2lf", b);
	}else {
		printf("%.2lf", c);
	}
	return 0;
}
