#include <stdio.h>
#include <stdbool.h>

void diffArr(int a[], int b[], int diff[], int* size) {
    int n = 4;
    bool found;
    for (int i = 0; i < n; i++) {
        found = false;
        for (int j = 0; j < n; j++) {
            if(a[i] == b[j]) {
                found = true;
                break;
            }
        }
        if(!found) {
            diff[(*size)++] = a[i];
        }
    }
}

int main() {
    int a[] = {1, 2, 3, 4};
    int b[] = {2, 4, 5, 6};
    int diff[4];
    int size = 0;
    diffArr(a, b, diff, &size);

    for(int i = 0; i < size; i++) {
        printf("%d\n", diff[i]);
    }

    return 0;
}