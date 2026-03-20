#include <stdio.h>

void sumarr(int a[], int b[], int r[], int size) {
    for (int i = 0; i < size; i++) {
        r[i] = a[i] + b[i];
    }
}

int main() {
    int a[4] = {1,2,3,4};
    int b[4] = {5,6,7,8};
    int r[4];
    int size = 4;
    sumarr(a, b, r, size);

    for(int i = 0; i < size; i++) {
        printf("%d\n", r[i]);
    }
    return 0;
}
