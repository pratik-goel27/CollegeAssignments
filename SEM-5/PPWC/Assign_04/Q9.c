#include <stdio.h>

int main() {
    // int arr1[] = {10,13,20,33,44};
    // float arr2[] = {10.2,13.3,20.0,33.3,45.3,89.9};
    // int *p1 = &arr1[0];
    // float *p2 = arr2;

    // int size1 = sizeof(arr1) / sizeof(arr1[0]);
    // int size2 = sizeof(arr2) / sizeof(arr2[0]);

    // printf("First Array:- \n");
    // for(int i = 0; i < size1; i++) {
    //     printf("Idx %d: Value: %d and Address: %p\n", i, *(p1+sizeof(int)));
    // }

    int a = 10;

    int *p = &a;
    printf("%p",*p);

    char c = '*';
    int *ptr = c;
    printf("%p", *ptr);
    return 0;
}