# def remove_vowels(s):
#     result = ""
#     for ch in s:
#         if ch not in ['a','e','i','o','u','A','E','I','O','U']:
#             result += ch
#     return result
#
# print(remove_vowels("Hello"))

def remove_vowels(s):
    lst = ['a','e','i','o','u','A','E','I','O','U']
    result = ""
    for ch in s:
        if ch in lst:
            continue
        else:
            result += ch

    return result

print(remove_vowels("Hello world"))