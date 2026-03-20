sentence = input("Enter a sentence").lower()
d = {}

word = sentence.split()

for w in word:
    if w in d:
        d[w] += 1
    else:
        d[w] = 1

print("Duplicate words: ")
for word, count in d.items():
    if count > 1:
        print(word,":",count)
