#include <stdio.h>
#include <ctype.h>
int main(){
	char x;

	scanf(" %s", &x);

	x = toupper(x);
	
	switch (x) {
    		case 'A':
        		printf("Genius");
        		break;
    		case 'B':
        		printf("Good");
       			break;
    		case 'C':
        		printf("Try Harder");
        		break;
    		case 'D':
        		printf("Very Bad");
        		break;
    		case 'F':
        		printf("Fail");
        		break;
    		default:
        		printf("Invalid Input");
}
	return 0;
}
