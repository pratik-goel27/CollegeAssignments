import random

n = int(input("Enter the size of the list: "))

lst = [random.randint(1,99) for _ in range(n)]

total = sum(lst)
avg = total/n

print("Random list: ",lst)
print("Sum of list: ", total)
print("Avg of list: ",avg)