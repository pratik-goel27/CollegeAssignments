#include <stdio.h>

int main() {
    int a = 5;
    int b = 10;
    printf("a: Add=%p\n", (void*)&a);
    printf("b: Add=%p\n", (void*)&b);
    int temp = a;
    a = b;
    b = temp;
    
    printf("After swapping \n a: Add=%p\n", (void*)&a);
    printf("b: Add=%p\n", (void*)&b);
    return 0;
}