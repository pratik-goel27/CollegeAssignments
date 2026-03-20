#include <stdio.h>
#include <stdbool.h>

bool bs(int a[], int low, int high, int target) {
    bool found = false;
    int idx = -1;
    while(low <= high) {
        int mid = (low+high) / 2;
        if(a[mid] == target) {
            found = true;
            idx = mid;
            return true;
        }else if(a[mid] > target) {
            high = mid - 1;
        }else {
            low = mid + 1;
        }
    }
    return false;
}

int main() {
    int arr[] = {1,2,3,4,5,6,7,8,9,10};
    int target = 6;
    printf("%d",bs(arr, 0,9,6));
    return 0;
}