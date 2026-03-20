#include <stdio.h>
#include <string.h>

char firstRepChar(char str[]) {
    int n = strlen(str);
    int cnt[122] = {0};

    for(int i = 0; i < n; i++) {
        if(++cnt[str[i]] == 2) {
            return str[i];
        }
    }

    return '\0';
}

int main() {
    char str[] = "racecar";
    char result = firstRepChar(str);

    if(result != '\0') {
        printf("First Repetetive character in the string %s is %c", str, result);
    }else {
        printf("No repetetive character is there in the string.");
    }
    
    return 0;
}