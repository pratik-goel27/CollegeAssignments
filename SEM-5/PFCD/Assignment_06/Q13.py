import numpy as np

pattern = np.array([['-','*'], ['*','-']])
finalPattern = np.tile(pattern, (4,4))
print("Checkerboard Pattern:- \n",finalPattern)