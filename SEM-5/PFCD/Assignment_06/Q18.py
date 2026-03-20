import pandas as pd

df = pd.DataFrame(
    {
        'A' : [10,20,30],
        'B' : [40,50,60]
    }
)
print(df,"\n")

s = df.iloc[:, 0]      # Series
s1 = df.iloc[:, [0]]    # DataFrame
print(type(s))