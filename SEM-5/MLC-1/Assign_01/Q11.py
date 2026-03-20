import numpy as np
import pandas as pd

data = {
    'A':[1,2,np.nan,4,5],
    'B':[10,np.nan,30,40,50],
    'C':[100,np.nan,300,np.nan,500]
}

df = pd.DataFrame(data)
print(f"Original data frame:\n{df}")


print(df.fillna(df.mean(numeric_only=True)))

df_dropped = df.dropna(thresh=df.shape[1]-1)
print(df_dropped)