#include <stdio.h>
#include <stdlib.h>

int main() {
    int start, end;
    scanf("%d %d", &start, &end);

    double v = 1.5;
    double a = 0.5;
    double distance;

    if (start == end) {
        distance = 0;
    } else {
        int diff = abs(end - start);

        if (start == 1 || end == 1)
            distance = 6.0 + (diff - 1) * 4.0;
        else
            distance = diff * 4.0;
    }

    double s_accel = (v * v) / (2.0 * a);
    double t_accel = v / a;
    double totalTime;

    if (distance == 0) {
        totalTime = 0;
    } else {
        double s_cruise = distance - (2.0 * s_accel);
        double t_cruise = s_cruise / v;
        totalTime = (2.0 * t_accel) + t_cruise;
    }

    printf("%.2f\n", totalTime);

    return 0;
}
