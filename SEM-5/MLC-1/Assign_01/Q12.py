import numpy as np

arr = np.arange(1,31).reshape(5,6)

even_num = arr[arr % 2 == 0]

avg = np.mean(even_num)
print(even_num)
print(avg)