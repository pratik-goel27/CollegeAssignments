def rotate(a, b, c):
    return c,a,b

a = 'Doug'
b = 22
c = 1984

a,b,c = rotate(a,b,c)
print(a,b,c)

a,b,c = rotate(a,b,c)
print(a,b,c)

a,b,c = rotate(a,b,c)
print(a,b,c)