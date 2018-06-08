def add(*arr):
	sum=0
	for i in range(0,len(arr)):
		sum = sum + arr[i]
	return sum

def add1(a,b,c,d):
	return a+b+c+d

l=range(0,4)
print add1(*l)