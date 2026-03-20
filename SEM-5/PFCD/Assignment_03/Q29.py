def isPerfectNum(n):
    l = []
    for i in range(1,n // 2 + 1):
        if n % i == 0:
            l.append(i)
    if n == sum(l):
        return "Perfect Num"
    else:
        return "Not a Perfect Num"
print(isPerfectNum(28))