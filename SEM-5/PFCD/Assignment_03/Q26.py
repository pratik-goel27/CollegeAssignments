def replace_vowels(s):
    result = ""
    for ch in s:
        if ch in ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']:
            result += "*"
        else:
            result += ch
    return result

print(replace_vowels("helloworld"))