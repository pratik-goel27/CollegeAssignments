#include <stdio.h>
#include <stdbool.h>

void uniqueArr(int arr[], int n, int ans[], int* size) {
    bool dup;
    for(int i = 0; i < n; i++) {
        dup = false;
        for(int j = 0; j < *size; j++) {
            if(arr[i] == ans[j]) {
                dup = true;
                break;
            }
        }
        if(!dup) {
            ans[(*size)++] = arr[i];
        }
    }
}

int main() {
    int arr[] = {4,7,7,3,2,5,5};
    int n = sizeof(arr) / sizeof(arr[0]);
    int ans[n];
    int size = 0;
    uniqueArr(arr, n, ans, &size);

    for(int i = 0; i < size; i++) {
        printf("%2d", ans[i]);
    }

    return 0;
}