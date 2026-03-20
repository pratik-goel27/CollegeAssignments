import numpy as np

arr = np.arange(1,17).reshape(4,4)
print(arr)
sub_matrix = arr[2:4, 0:2]
print(sub_matrix)

det_val = np.linalg.det(sub_matrix)
print(det_val)