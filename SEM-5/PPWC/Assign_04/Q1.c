#include <stdio.h>
int main() {
    int Ia = 345;
    float Fb = 4.5;
    char Chvar = 'Z';

    printf("Ia: Value=%d and Address=%p\n", Ia, (void*)&Ia);
    printf("Fb: Value=%f and Address=%p\n", Fb, (void*)&Fb);
    printf("Chvar: Value=%d and Address=%p", Chvar, (void*)&Chvar);
}
