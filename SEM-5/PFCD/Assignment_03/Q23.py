def idx_of_vowels(s):
    result = []
    for i in range(len(s)):
        ch = s[i]
        if ch in ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']:
            result.append(i)
    return result
print(idx_of_vowels("helloworld"))