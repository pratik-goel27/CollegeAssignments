lst = []
for i in range(10):
    num = int(input("Enter a num: "))
    lst.append(num)

search_num = int(input("Enter the num to be searched: "))
cnt = lst.count(search_num)

if cnt > 0:
    print(f"the num {search_num} is present {cnt} times")
else:
    print("The num is not present")