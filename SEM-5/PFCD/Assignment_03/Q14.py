def findArmstrongNum(n):
    m = n
    armNum = 0
    while n > 0:
        armNum = armNum + ((n%10)**3)
        n //= 10
    if m == armNum:
        return f"{m} is Armstrong number"
    else:
        return f"{m} is not an Armstrong number"

print(findArmstrongNum(153))

