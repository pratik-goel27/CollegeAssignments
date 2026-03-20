def prodOfDigits(num):
    ans = 1
    n = num
    while num > 0:
        ans *= (num%10)
        num //= 10
    return f"Product of the digits of the num {n} is {ans}"
print(prodOfDigits(1234))