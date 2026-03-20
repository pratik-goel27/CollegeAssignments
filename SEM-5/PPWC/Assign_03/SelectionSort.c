#include <stdio.h>

int main() {
    int arr[] = {64,25,12,22,11};
    int n = sizeof(arr) / sizeof(arr[0]);

    int small, idx;
    for(int i = 0; i < n-1; i++) {
        small = arr[i];
        idx = i;
        for(int j = i; j < n; j++) {
            if(small > arr[j]) {
                small = arr[j];
                idx = j;
            }
        }

        int temp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = temp;
    }

    for(int i = 0; i < n; i++) {
        printf("%d ",arr[i]);
    }
    return 0;
}