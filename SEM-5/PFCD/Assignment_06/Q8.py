import numpy as np

arr = np.linspace(1.1,6.6,6).reshape(2,3)
print("Array (2,3) created using linspace \n",arr)

arr_integer = arr.astype(int)
print("\nChanged the type from float to int\n",arr_integer)