import pandas as pd

marks = pd.Series([35,78,55,92,40,25,67,89])
print(f"Created a panda series of marks for 8 students: \n{marks}")
marks_updated = marks.where(marks >= 40, "Fails")
print(marks_updated)