import pandas as pd

arr = pd.Series([1,1,3,7,88,12,88,23,3,1,9,0])

idx_min = arr.idxmin()
idx_max = arr.idxmax()

print("First Occur of the max element: ",idx_max)
print("First Occur of the min element: ",idx_min)