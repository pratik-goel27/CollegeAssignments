import pandas as pd
# Bit a
data = {
    'Maxine':[20,30,40],
    'James':[50,20,10],
    'Amanda':[10,40,30]
}

temp = pd.DataFrame(data, index=['Morning','Afternoon','Evening'])
print(temp,"\n")


first_col = temp.iloc[:,0]
print(first_col,"\n")

# first_row = temp.iloc[0,:]
first_row = temp.loc['Morning']
print(first_row,"\n")

# _e_ = temp.loc[['Morning', 'Evening']]
_e_ = temp.iloc[[0,2]]
print(_e_)

# _f_ = temp.iloc[:, [0,2]]
_f_ = temp.loc['Morning':'Evening', ['Amanda', 'Maxine']]
print(_f_)

# BIT H
morn_aman = temp.iat[0,2]
morn_maxi = temp.iat[0,0]
eve_aman = temp.at['Evening','Amanda']
eve_maxi = temp.at['Evening','Maxine']
print("Values of Amanda: Morning: ",morn_aman," Evening: ",eve_aman)
print("Values of Maxine: Morning: ",morn_maxi," Evening: ",eve_maxi)

# BIT I
print(temp.describe())

print(temp.T)
# BIT J
print(temp.sort_index(axis=1))