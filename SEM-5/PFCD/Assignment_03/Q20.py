def primes():
    result = []
    for i in range(2, 101):
        flag = 1
        for j in range(2, int(i**0.5)+1):
            if i % j == 0:
                flag = 0
                break
        if flag == 1:
            result.append(i)
    return result
print(primes())
