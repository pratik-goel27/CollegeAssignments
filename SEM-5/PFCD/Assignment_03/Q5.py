def numDigits(num):
    cnt = 0
    while num > 0:
        cnt += 1
        num //= 10
    return cnt

print(numDigits(1234))