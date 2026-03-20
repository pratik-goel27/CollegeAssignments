#include <stdio.h>

int main() {
    int a[4] = {0,0,0,0}; 
    int b[4] = {0,0,0,0}; 
    int c[4] = {2,0,0,0}; 
    int d[4] = {1,2,3,4}; 
    int sumarr[4];
    int *arr[4];
    arr[0] = a;
    arr[1] = b;
    arr[2] = c;
    arr[3] = d;

    int *p1, *p2, *p3, *p4, *p5;
    p1 = a;
    p2 = b;
    p3 = c;
    p4 = d;
    p5 = sumarr;

    for(int i = 0; i < 4; i++) {
        *(p5+i) = *(p1+i)+*(p2+i)+*(p3+i)+*(p4+i);
    }

    for(int i = 0; i < 4; i++) {
        printf("%d\n", *(p5+i));
    }
    return 0;
}