import pandas as pd

data = {
    'Name': ['a','b','c','d','e'],
    'Maths': [88, 92, 75, 85, 90],
    'English': [91, 89, 78, 84, 95],
    'Science': [85, 94, 80, 88, 92]
}


df = pd.DataFrame(data)
print(df)

df['Total'] = df[['Maths', 'English', 'Science']].sum(axis=1)
print(df)
df['Average'] = df['Total'] / 3

topper_row = df.loc[df['Average'].idxmax()]
print("topper name", topper_row['Name'])
print("topper average", topper_row['Average'])
