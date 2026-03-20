import numpy as np

arr = np.random.randint(0,100, size=(5,5))
print("Array: \n", arr)

counts = np.bincount(arr.flatten())


print("Counts: \n",counts)