import numpy as np

arr1 = np.arange(2,19,2).reshape(3,3)
print(arr1)

arr2 = np.arange(9,0,-1).reshape(3,3)
print(arr2)

arr3 = arr1 * arr2
print(arr3)