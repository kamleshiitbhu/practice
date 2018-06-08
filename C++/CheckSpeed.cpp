#include <iostream>
#include <time.h>
#include <string.h>
using namespace std;
typedef enum
{
	KB_PER_SEC = 1024,
	MB_PER_SEC = KB_PER_SEC * 1024,
	GB_PER_SEC = MB_PER_SEC * 1024
}SPEED_TYPE;
typedef enum
{
	KB = 1024,
	MB = KB * 1024,
	GB = KB * 1024
}UNIT;
int main(void)
{
	int size = 0;
	int unit = 4*KB;;
	char src[unit];
	char dest[unit];	
	cout<<"Enter size in Bytes = ";
	cin>>size;	
	clock_t begin = clock();
	for(int i=0;i<size;i++){
		memcpy(dest,src,unit);
	}
	clock_t end = clock();
	double elapsed_secs = double(end - begin);	
	long speed = (size/elapsed_secs) * CLOCKS_PER_SEC;
	cout<<"Speed in IOPS per second = "<<speed<<endl;
	cout<<"size = "<<elapsed_secs<<endl;
}