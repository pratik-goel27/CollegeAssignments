#include <stdio.h> 

int main() {
    int n = 7;
    char ch = 'A';
    //first line :-
    for(int i = 0; i < n; i++) {
        printf("%c",ch);
        ch++;
    }
    ch -= 2;
    for(int i = n-2; i >= 0; i--) {
        printf("%c",ch);
        ch--;
    }
    printf("\n");

    //Rest pattern :-
    for(int i = n-1; i > 0; i--){
        ch = 'A';
        for(int j = 0; j < i; j++) {
            printf("%c",ch);
            ch++;
        }

        for(int j = 0; j < 2*(n-i-1)+1; j++) {
            printf(" ");
        }

        ch--;
        for(int j = i; j > 0; j--) {
            printf("%c",ch);
            ch--;
        }
        printf("\n");
    }
    return (0);
}