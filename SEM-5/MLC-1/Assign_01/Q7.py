import numpy as np

temps = np.random.randint(20,41,size=30)
print("Daily temp", temps)

hottest = np.max(temps)
coldest = np.min(temps)
print(f"Hottest day: {hottest}")
print(f"Coldest day: {coldest}")

mean_temp = np.mean(temps)
median_temp = np.median(temps)
std_temp = np.std(temps)
print(mean_temp)
print(median_temp)
print(std_temp)