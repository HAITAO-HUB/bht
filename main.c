#include<stdio.h>
void InsertSort(int a[], int len)
{
      int i = 0;
      for(i = 1; i < len; i++)
      {
            int tmp = a[i];
            int j = 0;
            for (j = i - 1; j >= 0;j--)
            {
                  if (tmp< a[j])
                  {
                        a[j+1] = a[j];
                  }
                  else
                  {
                        break;
                  }
            }
      a[j + 1] = tmp;
      }
}
void Show(int a[], int len)
{
	int i=0;
      for ( i = 0; i < len; i++)
      {
            printf("%d ", a[i]);
      }
}
int main()
{
      int a[] = { 45, 12, 33, 23, 35, 11, 5, 12, 2, 28 };
      int len = sizeof(a) / sizeof(a[0]);
      InsertSort(a, len);
      Show(a, len);
      return 0;
}
