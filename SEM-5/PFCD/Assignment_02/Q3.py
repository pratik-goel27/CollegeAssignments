score = int(input("Enter you marks: "))
grade = ""
if 90 <= score <= 100:
    grade = "A"
    print("Excellent")
elif 80 <= score <= 89:
    grade = "B"
    print(f"Grade is {grade} Good")
elif 70 <= score <= 79:
    grade = "C"
    print("Average")
elif 60 <= score <= 69:
    grade = "D"
    print("Needs Improvement")
else:
    grade = "F"
    print("Failing")
