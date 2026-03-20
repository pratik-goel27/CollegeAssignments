def calculator():
    a = int(input("Enter a num: "))
    b = int(input("Enter another num: "))
    c = input("Enter the operation to be done: ")

    match c:
        case "add":
            print(f"Result: {a+b}")
        case "sub":
            print(f"Result: {a-b}")
        case "mult":
            print(f"Result: {a*b}")
        case "div":
            if b != 0:
                print(f"Result: {a/b}")
            else:
                print("Division by zero is not possible")
        case _:
            print("Invalid Operator")

calculator()