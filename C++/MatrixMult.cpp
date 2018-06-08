#include <iostream>
using namespace std;

int main() {
	int t,n;
	cin>>t;
	while(t--)
	{
	    cin>>n;
	    int arr[n];
	    for(int i=0;i<n;i++)
	    {
	        cin>>arr[i];
	    }
	    int i=0;
	    while(i<n-1)
	    {
	        if(arr[i]==arr[i+1])
	        {
	            arr[i]+=arr[i];
	            arr[i+1]=0;
	        }
	        i++;
	    }
	    for(i=0;i<n;i++)
	    {
	        cout<<arr[i]<<" ";
	    }
	    cout<<endl;
	    i=0;
	    int j = i+1;
	    while(j<n)
	    {
	        if(arr[i]!=0)
	            i++;
	        else if(arr[j]==0)
	            j++;
	        else
	        {
	            arr[i] = arr[i]^arr[j];
	            arr[j] = arr[i]^arr[j];
	            arr[i] = arr[i]^arr[j];
	            i++;
	            j++;
	        }
	    }
	    for(i=0;i<n;i++)
	    {
	        cout<<arr[i]<<" ";
	    }
	    cout<<endl;
	}
	return 0;
}