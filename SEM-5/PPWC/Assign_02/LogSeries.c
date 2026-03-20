#include <stdio.h>
#include <math.h>

int main() {
    int x;
    printf("Enter the num: ");
    scanf("%d", &x);
    float ratio = (x-1.0) / x;
    float ans = 0;
    for(int i = 1; i <= x; i++) {
        ans += (1.0/i) * pow(ratio , i);
    }

    printf("%f", ans);
    return 0;
}