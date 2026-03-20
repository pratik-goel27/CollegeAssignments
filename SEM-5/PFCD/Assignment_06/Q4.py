import numpy as np

arr = np.arange(1,10).reshape(3,3)
print("Original Array: \n",arr)

arr[[0,1]] = arr[[1,0]]
print("\nSwapped first 2 rows: \n",arr)

arr[:, [0,1]] = arr[:,[1,0]]
print("\nSwapped first 2 columns: \n",arr)