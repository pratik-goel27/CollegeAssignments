def shift_char(s):
    s = s.lower()
    result = ""
    for ch in s:
        if ch == 'z':
            result += 'a'
        else:
            result += chr(ord(ch) + 1)
    return result
print(shift_char("python"))