import pandas as pd

data = {
    'Name': ['a','b','c','d','e','f'],
    'Age':[19,19,19,20,21,19],
    'Marks':[80,60,70,90,50,60]
}

df = pd.DataFrame(data)

print(df)
#
# avg_marks = df['Marks'].mean()
#
# ans_row = df.loc[df['Marks'] > avg_marks]
# print("List of students: \n",ans_row['Name'])
#
#
# young_high_scores = df[(df["Age"] < 20)  &   (df['Marks'] > 60)]["Name"]
# print(young_high_scores.tolist())


avg_marks = df['Marks'].mean()

stud_above_avg_marks = df.loc[df['Marks'] > avg_marks]
print("Students above avg marks : \n",stud_above_avg_marks,"\n")

young_above_60 = df.loc[(df['Age'] < 20) & (df['Marks'] > 60)]["Name"]
print(young_above_60)