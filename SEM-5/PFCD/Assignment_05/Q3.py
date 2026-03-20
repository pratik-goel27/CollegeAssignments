items_price = {}

n = int(input("Enter the number of items: "))

for i in range(n):
    name = input("Enter the name of the item: ")
    price = float(input("Enter the price of the item: "))
    items_price[name] = price

# ans = 0
# for price in items_price.values():
#     ans+= price

ans = sum(items_price.values())
print(ans)
