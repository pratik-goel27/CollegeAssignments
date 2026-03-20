s = "hello123,.;'"
result = ""
for ch in s:
    if (65 <= ord(ch) <= 90) or (97 <= ord(ch) <= 122) or (48 <= ord(ch) <= 57):
        result += ch

print(result)
