#include <iostream>
using namespace std;
int createNum(int num[],int size)
{
	int result = 0;
	int digit = 10;
	int index = 0;
	while(index<size)
	{
		result = result*digit + num[index];
		index++;		
	}
	return result;
}
int findMinimum(int a[],int size)
{
	if(size<=0)
	{
		return 1;
	}
	int min = a[0];
	for(int i=1;i<size;i++)
	{
		if(min>a[i])
		{
			min = a[i];
		}
	}
	return min-1;
}
int findMaximum(int a[],int size)
{
	if(size<=0)
	{
		return 1;
	}
	int max = a[0];
	for(int i=1;i<size;i++)
	{
		if(max<a[i])
		{
			max = a[i];
		}
	}
	return max+1;
}
void printArray(int a[],int size)
{
	for(int i=0;i<size;i++)
	{
		cout<<a[i]<<" ";
	}
	cout<<endl;
}
int createString(char num[],int size)
{
	int a[10] = {0};
	a[0] = 1;
	int i = 1;
	int j;
	while(1)
	{
		if(i<=size && num[i-1] == 'M')
		{
			a[i] = findMaximum(a,i);
			i++;
		}
		if(i>size)
			break;
		a[i] = findMinimum(a,i);
		i++;
	}	
	printArray(a,size+1);
	int min = findMinimum(a,i) + 1;
	if(min<1)
	{
		int add = 1 - min;
		for(int i = 0;i<=size;i++)
		{
			a[i] = a[i] + add;
		}
	}
	return createNum(a,size+1);
}
int main(void)
{
	char num[] = {'A'};
	cout<<"create Number is = "<<createString(num,1)<<endl;
}