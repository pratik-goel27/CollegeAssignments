student = {}

n = int(input("Enter the number of students: "))

for i in range(n):
    name = input("Enter the name of the student")
    marks = input("Enter the marks of the student")
    student[name] = marks

print(f"Student dictionary: {student}")

search_name=input("Enter the name of the student to be searched: ")

if search_name in student.items():
    print(f"Marks of Student: {search_name} is {student[search_name]}")
else:
    print("Student not found!!")