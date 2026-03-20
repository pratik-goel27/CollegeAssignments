#include <stdio.h>

int main() {
    int n;
    printf("Enter a num: ");
    scanf("%d", &n);

    printf("\n+-----------------------------------------+\n|");
    for(int i = 1; i <= 10; i++) printf("%4d", n*i);
    printf(" |\n|");
    for (int i = 1; i <= 10; i++) printf("%4d", i);
    printf(" |\n|");
    for(int i = 1; i <= 10; i++) printf("%4d", n);
    printf(" |\n+-----------------------------------------+\n");

    return 0;
}