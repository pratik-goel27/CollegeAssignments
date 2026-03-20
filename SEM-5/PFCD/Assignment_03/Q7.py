def checkAlpha(ch):
    vowel = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
    if ch in vowel:
        return "Vowel"
    else:
        return "Consonant"

print(checkAlpha('B'))