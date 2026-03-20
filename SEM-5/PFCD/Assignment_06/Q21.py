import pandas as pd

s = pd.Series(['Cry','Apple','Orange','Sky','Banana'])

contains_vowels = s[s.str.contains('[aeiouAEIOU]')]
start_with_vowel = s[s.str.match('^[aeiouAEIOU]')]
print("Series of elements which contains vowels: \n",contains_vowels,"\n")
print("Series of elements which starts with a vowel: \n",start_with_vowel)