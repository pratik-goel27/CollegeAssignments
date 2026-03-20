student = {}

n = int(input("Enter the number of students: "))

for i in range(n):
    name = input("Enter the names of the students: ")
    marks = float(input("Enter the percentage of marks: "))
    student[name] = marks

for name, percent in student.items():
    print(f"Name: {name}, percentage: {percent}")

    