#include <stdio.h>
int main()
{
    float x = 25.0, y = 10.0;
    printf("%f\n",x);
    if (y != (x - 10.0)) {
        x = x - 10.0;
        printf("%f\n",x);
    }else
        x = x / 2.0;

    printf("%f\n",x);
    return 0;
}