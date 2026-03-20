import numpy as np

arr = np.arange(1,16).reshape(3,5)
print("Original Array: \n",arr)

row_2 = arr[1]
print("\nSelected Row 2: \n",row_2)

col_5 = arr[:,4]
print("\nSelected Col 5: \n",col_5)

row_0_1 = arr[[0,1]]
print("\nSelected Row 0 & 1: \n", row_0_1)

col_2_4 = arr[:,[2,4]]
print("\nSelected col 2 & 4: \n",col_2_4)

ele = arr[1,4]
print("\nSelected element at row 1 and col 4: ",ele)

ele2 = arr[[1,2]][:,[0,2,4]]
print(ele2)