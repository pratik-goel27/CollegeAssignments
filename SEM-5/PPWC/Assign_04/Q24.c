#include <stdio.h>
#include <string.h>

int main(){
    char str[] = "hello";
    int n = strlen(str);
    char *p = str;
    char *q = str + strlen(str)-1;
    while(p < q) {
        char temp = *p;
        *p = *q;
        *q = temp;

        p++;
        q--;
    }

    printf("%s", str);
    return 0;
}