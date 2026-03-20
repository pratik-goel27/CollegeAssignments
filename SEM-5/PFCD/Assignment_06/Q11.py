import numpy as np

array1 = np.array([[0,1], [2,3]])
array2 = np.array([[4,5], [6,7]])

array3 = np.vstack((array1,array2))
print("Vertical Stacking: array3\n",array3)

array4 = np.hstack((array1, array2))
print("\nHorizontal Stacking: array4\n",array4)

array5 = np.vstack((array4, array4))
print("\nVertical Stacking of 2 copies of array4: \n",array5)

array6 = np.hstack((array3,array3))
print("\nHorizontal Stacking of 2 copies of array3: \n",array6)
