# def findNum():
#     list = []
#     for i in range(100, 501):
#         if i % 3 == 0 and i % 5 == 0:
#             list.append(i)
#     return list
# print(findNum())


def findNum():
    lst = [n for n in range(100,501) if n % 3 == 0 and n % 5 == 0]
    print(lst)

findNum()