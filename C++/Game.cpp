#include<iostream>
using namespace std;
int rec(int arr[][5],int dp[][2][5],int curr_i,int curr_j,int bomb,int x)
{
    if(dp[curr_i][bomb][curr_j]!=-1){
          //  cout<<"OVERLAP!"<<endl;
        return dp[curr_i][bomb][curr_j];
    }
    if(bomb==0)                              //no bomb left
    {
        if(curr_i<x)
        {
           if(curr_i-1>=0)
           {
               int maxcoin=-1;
               if(curr_j-1>=0)
               {
                  if(arr[curr_i-1][curr_j-1]==1)
                  {
                      maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j-1,bomb,x)+1);
                  }
                  else if(arr[curr_i-1][curr_j-1]==0)
                  {
                      maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j-1,bomb,x));
                  }
               }
               if(arr[curr_i-1][curr_j]==1)
               {
                     maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j,bomb,x)+1);
               }
               else if(arr[curr_i-1][curr_j]==0)
               {
                   maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j,bomb,x));
               }

               if(curr_j+1<;5)
               {
                    if(arr[curr_i-1][curr_j+1]==1)
                    {
                      maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j+1,bomb,x)+1);
                    }
                  else if(arr[curr_i-1][curr_j+1]==0)
                  {
                      maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j+1,bomb,x));
                  }
               }

               if(maxcoin==-1)
                 maxcoin=0;
               return dp[curr_i][bomb][curr_j]=maxcoin;
           }
           else
           {
               return dp[curr_i][bomb][curr_j]=0;
           }
        }
        else
        {
            int maxcoin=-1;
            if(curr_i-1>=0)
            {
                if(curr_j-1>=0)
                {
                    if(arr[curr_i-1][curr_j-1]==1)
                    {
                        maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j-1,bomb,x)+1);
                    }
                    else
                    {
                        maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j-1,bomb,x));
                    }
                }

                if(arr[curr_i-1][curr_j]==1)
                {
                    maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j,bomb,x)+1);
                }
                else
                {
                    maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j,bomb,x));
                }

                if(curr_j+1<;5)
                {
                    if(arr[curr_i-1][curr_j+1]==1)
                    {
                        maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j+1,bomb,x)+1);
                    }
                    else
                    {
                        maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j+1,bomb,x));
                    }
                }
                if(maxcoin==-1)
                     maxcoin=0;
                return dp[curr_i][bomb][curr_j]=maxcoin;
            }
            else
            {
                return (dp[curr_i][bomb][curr_j]=0);
            }
        }
    }
    else
    {
        if(curr_i-1>=0)
        {
            int maxcoin=-1;
            if(curr_j-1>=0)
            {
                if(arr[curr_i-1][curr_j-1]==1){
                maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j-1,bomb,x)+1);
                maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j-1,0,curr_i-5)+1);
                }
                else
                {
                    maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j-1,0,curr_i-5));
                }
            }

            if(arr[curr_i-1][curr_j]==1)
            {
                maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j,bomb,x)+1);
                maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j,0,curr_i-5)+1);
            }
            else
            {
                maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j,0,curr_i-5));
            }

            if(curr_j+1<;5)
            {
                if(arr[curr_i-1][curr_j+1]==1){
                maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j+1,bomb,x)+1);
                maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j+1,0,curr_i-5)+1);
                }
                else
                {
                    maxcoin=max(maxcoin,rec(arr,dp,curr_i-1,curr_j+1,0,curr_i-5));
                }
            }
            if(maxcoin==-1)
                maxcoin=0;
            return dp[curr_i][bomb][curr_j]=maxcoin;
        }
        else
        {
            return (dp[curr_i][bomb][curr_j]=0);
        }
    }
}
int main()
{
    int n,m;
    cin>>n;
    int arr[n][5];
    for(int i=0;i<n;i++)
        for(int j=0;j<;5;j++)
        cin>>arr[i][j];
    int dp[n+1][2][5];
    for(int i=0;i<=n;i++)
        for(int j=0;j<;2;j++)
            for(int k=0;k<;5;k++)
               dp[i][j][k]=-1;

    cout<<rec(arr,dp,n,2,1,-1)<<endl;
    return 0;
}
