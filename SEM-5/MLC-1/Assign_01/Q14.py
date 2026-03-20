import pandas as pd

data = {
    'Name': ['a','b','c','d','e'],
    'Tasks_completed': [50,40,70,60,55],
    'Hours_Worked':[10,20,12,11,15]
}

df = pd.DataFrame(data)
# print(df)
# df['Efficiency'] = df['Tasks_completed'] / df['Hours_Worked']
# print(df)
#
# ans_row = df.loc[df['Efficiency'].idxmax()]
# print("Name: ", ans_row['Name'])
# print("Value: ", round(ans_row['Efficiency'], 2))




df['Efficiency'] = df['Tasks_completed'] / df['Hours_Worked']


# Identify employee with the highest efficiency :-
highest_eff = df.loc[df['Efficiency'].idxmax()]
print(highest_eff)