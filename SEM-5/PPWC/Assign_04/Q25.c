#include <stdio.h>

int main(){
    int n;
    printf("Enter the size of the arr:- ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter the array elements:- \n");

    for(int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int *largest = arr;
    for(int i = 0; i < n; i++) {
        if(*(arr+i) > *largest) {
            largest = arr+i;
        }
    }

    printf("Elements in the array:- \n");
    for(int i = 0; i < n; i++) {
        printf("%2d", arr[i]);
    }

    printf("\nLargest element in the array is: %d", *largest);
    return 0;
}