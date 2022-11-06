class Solution {
    public int[] findBall(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;  //n개의 ball
        int[] ball= new int[n];  //ball이 어디로 빠져나오는지 저장
        
        //박스 끝에서 막힌 경우
        if(grid[0][0]==-1){
            ball[0]=-1;
        }
        if(grid[0][n-1]==1){
            ball[n-1]=-1;
        }
        
        //ball[x] 하나하나 검사하기 
        for(int x=0; x<n; x++){
            int i=0;
            int j=x;
            
            while(i!=m){
                //벽에 막혔는지 확인
                if(j==0 && grid[i][j]==-1){
                    ball[x]=-1;
                    break;
                }
                if(j==n-1 && grid[i][j]==1){
                    ball[x]=-1;
                    break;
                }
                
                //벽은 아닐때
                if(grid[i][j]==1){
                    if(grid[i][j+1]==1){
                        i++;
                        j++;
                    }else if(grid[i][j+1]==-1){  //막힘
                        ball[x]=-1;
                        break;
                    }
                }else{  //grid[i][j]==-1
                    if(grid[i][j-1]==1){  //막힘
                        ball[x]=-1;
                        break;
                    }else if(grid[i][j-1]==-1){
                        i++;
                        j--;
                    }
                }
            }
            if(ball[x]!=-1){  //막히지 않은 경우
                ball[x]=j;   //통과한 index 저장
            }
        }
        return ball;
    }
}