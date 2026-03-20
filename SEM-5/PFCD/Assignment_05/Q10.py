s = "hello welcome a e i o u ee"
d = {}

for ch in s:
    if ch in ['a','e','i','o','u','A','E','I','O','U']:
        if ch in d.keys():
            d[ch] += 1
        else:
            d[ch] = 1

print(list(d.keys()))