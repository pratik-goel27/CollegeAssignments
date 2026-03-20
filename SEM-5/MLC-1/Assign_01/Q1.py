import math

import numpy as np

def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True

def extract_prime(arr):
    primes = [int(x) for x in arr if is_prime(x)]
    return primes



arr = np.arange(1, 21)
primes = extract_prime(arr)

mean_value = np.mean(primes)
var_val = np.var(primes)

print(f"Original Array: {arr}")
print(f"Primes Numbers: {primes}")
print(f"Means of the primes: {mean_value}")
print(f"Variance of the primes: {var_val}")
