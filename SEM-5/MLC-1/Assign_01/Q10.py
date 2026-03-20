import pandas as pd

data = {
    'Name':['a','b','c'],
    'Quantity':[5,10,15],
    'Price':[50,20,30]
}

df = pd.DataFrame(data)
print(df)

df['Total'] = df['Quantity'] * df['Price']
print(df)

max_sales = df.loc[df['Total'].idxmax()]

print(max_sales)