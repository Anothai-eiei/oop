#include <stdio.h>
#include <ctype.h>
int main(){
	char t;

	scanf(" %c", &t);

	if (isdigit(t)) {
		printf("number");
	}
	else if (islower(t)) {
		printf("lowercase");
	}
	else if (isupper(t)) {
		printf("uppercase");
	}
	else {
		printf("error");
	}

	return 0;
}
