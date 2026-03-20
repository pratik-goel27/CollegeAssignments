import numpy as np

a = 2 ** np.arange(6).reshape(2,3)

flattened = a.flatten()
print("2D array when flattened :-\n", flattened)

raveled = a.ravel()
print("\n2D array when raveled :-\n", raveled)

print("\nOriginal array\n", a)