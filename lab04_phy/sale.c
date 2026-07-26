#include <stdio.h>

int main() {
    double price;
    int discount, qty;
    double total1, total2;

    scanf("%lf", &price);
    scanf("%d", &discount);
    scanf("%d", &qty);

    total1 = price * qty * (100 - discount) / 100.0;

    total2 = (qty - qty / 3) * price;

    if (total1 <= total2) {
        printf("Discount %d%%\n", discount);
        printf("%.2lf", total1);
    } else {
        printf("Buy 2 Get 1\n");
        printf("%.2lf", total2);
    }

    return 0;
}
