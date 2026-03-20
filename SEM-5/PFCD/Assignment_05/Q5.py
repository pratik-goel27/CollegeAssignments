tlds = {
    'Canada': 'ca',
    'United States': 'us',
    'Mexico': 'mx'
}

# if 'Canada' in tlds.keys():
#     print("Yes it is there")
# else:
#     print("NO it is not there")
#
# if 'France' in tlds.keys():
#     print("Yes it is there")
# else:
#     print("NO it is not there")


tlds['Sweden'] = 'sw'
print(tlds)
tlds['Sweden'] = 'se'
print(tlds)

revs_tlds = {value:key for key, value in tlds.items()}
print(revs_tlds)
