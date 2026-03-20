#include <stdio.h>

int main() {
    int a = 10;
    float b = 11.5;
    char c = 'p';
    void *ptr;

    ptr = &a;
    printf("Integer value using void pointer = %d\n",*(int *)ptr);

    ptr = &b;
    printf("Float value using float pointer = %f\n", *(float *)ptr);

    ptr = &c;
    printf("Char value using char pointer = %c\n", *(char *)ptr);
    return 0;
}