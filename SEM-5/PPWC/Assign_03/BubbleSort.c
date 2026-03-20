#include <stdio.h>
#include <stdbool.h>

void bubbleSort(int a[], int size) {
    bool swapped = false;
    for(int i = 0; i < size-1; i++) {
        for(int j = 0; j < size-i-1; j++) {
            if(a[j] > a[j+1]) {
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;

                swapped = true;
            }
        }
        if(!swapped) {
            break;
        }
    }
}

int main() {
    int a[] = {5,2,4,3,1};
    int size = 5;
    bubbleSort(a, size);

    for(int i = 0; i < size; i++) {
        printf("%d\n",a[i]);
    }
    return 0;
}