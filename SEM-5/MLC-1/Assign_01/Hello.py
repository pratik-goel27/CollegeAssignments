import pandas as pd

data = {
    'Name': ['A', 'B', 'C', 'D'],
    'Age': [20, 21, 22, 23],
    'Marks': [85, 90, 95, 88]
}

df = pd.DataFrame(data)
print(df,"\n")


# This includes the rows labeled as 1,2,3 :-
print(df.loc[1:3], "\n")

# All rows and specific column only :-
print(df.loc[:, 'Name'], "\n")

# Includes specific rows and specific columns :-
print(df.loc[1:3, ['Name', 'Marks']])


print(df.loc['Name'])