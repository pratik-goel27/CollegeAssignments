def isPalindrome(s):
    ns = s[::-1]
    if ns == s:
        return True
    else:
        return False
print(isPalindrome("racecara"))
