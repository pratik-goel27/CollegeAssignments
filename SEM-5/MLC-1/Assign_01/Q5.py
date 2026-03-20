import pandas as pd

employee = {
    'ID': [1,2,3,4],
    'Name': ['a','b','c','d'],
    'Salary': [1000,2000,5000,3000]
}

df = pd.DataFrame(employee)

df['Bonus'] = df['Salary']*0.1

avg_salary = df['Salary'].mean()

above_avg = df[df['Salary'] > avg_salary]
print("Employee Data Frame: ", df)
print("Avg Salary: ",avg_salary)
print("Employee with above avg salary: \n",above_avg)

