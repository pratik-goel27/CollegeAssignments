#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    char a[] = "mine";
    char b[]= "cs";
    char c[] = "sc";
    char d[] = "soa";
    char *argv[] = {a,b,c,d,NULL};
    
    for(int i = 0; argv[i] != NULL; i++) {
        char *p = argv[i];

        while(*p != '\0') {
            *p = toupper(*p);
            p++;
        }
    }

    for(int i = 0; argv[i] != NULL; i++) {
        printf("%s\n", argv[i]);
    }


    int *arr[4];
    arr[0] = &(4);

    return 0;
}