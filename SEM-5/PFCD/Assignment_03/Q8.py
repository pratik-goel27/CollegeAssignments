def days_in_month(month):
    month = month.lower()
    if month in ['january','march', 'may','july','august','october','december']:
        return "No. of days: 31 days"
    elif month in ['april','june','september','november']:
        return "No. of days: 30 days"
    elif month == 'february':
        return "No. of days: 28/29 days"
    else:
        return "Enter the correct month"
print(days_in_month("JanUary"))