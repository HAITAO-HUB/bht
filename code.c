#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
void SelectSort(int a[], int len)
{
      for (int i = 0; i < len - 1; i++)
      {
            for (int j = i + 1; j < len; j++)
            {
                  if (a[i]>a[j])
                  {
                        int tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                  }
            }
      }
}
void Show(int a[],int len)
{
      for (int i = 0; i < len; i++)
      {
            printf("%d ", a[i]);
      }
}
int main()
{
      int a[] = {45,12,33,23,35,11,5,12,2,28};
      int len = sizeof(a) / sizeof(a[0]);
      SelectSort(a,len);
      Show(a,len);
      return 0;
}
