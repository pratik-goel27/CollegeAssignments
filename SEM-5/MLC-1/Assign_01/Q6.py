# //DOUBT

import numpy as np

arr = np.arange(1,10).reshape(3,3)
print(arr)

arr_transpose = arr.T
print(arr_transpose)

arr_inverse = np.linalg.inv(arr)
print(arr_inverse)

