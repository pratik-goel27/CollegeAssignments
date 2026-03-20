#include <stdio.h>
#include <string.h>

void cntOfEachChar(char str[])
{
    int n = strlen(str);
    int cnt[123] = {0};

    for (int i = 0; i < n; i++)
    {
        cnt[str[i]]++;
    }

    for (int i = 0; i < n; i++)
    {
        if (cnt[str[i]] > 0)
        {
            printf("%c-%d, ", str[i], cnt[str[i]]);
            // cnt[str[i]] = 0; // mark as visited or printed
        }
    }
}

int main()
{
    char str[] = "bintu";
    cntOfEachChar(str);
    return 0;
}