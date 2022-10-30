class Solution {
    int largestCount=0; //largest overlap 숫자 저장
    
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;  // n*n행렬 img
        int[][] copyImg= new int[n][n];  //img1 깊은 복사할 배열
        
        if(n==1){  //1*1 행렬인 경우 sliding하지않고 비교.
            if(img1[0][0]==1 && img2[0][0]==1){
                return 1;  //largestCount=1
            }else{
                return 0;  //largestCount=0
            }
        }
        
        //sliding 하지않고 비교
        countOverlap(img1, img2, n);
        
        //오른쪽 + 위, 아래 sliding
        for(int i=0; i<n; i++){  //img1 깊은 복사
            for(int j=0; j<n; j++){
                copyImg[i][j]=img1[i][j];
            }
        }
        
        int[][] rightUpCopyImg= new int[n][n];
        int[][] rightDownCopyImg= new int[n][n];
        for(int i=0; i<n; i++){
            //오른쪽으로 sliding
            if(i!=0){
                rightPush(copyImg, n);
                countOverlap(copyImg, img2, n); //오른쪽으로만 sliding한 이미지 비교
            }
            for(int r=0; r<n; r++){  //슬라이딩한 이미지 깊은 복사
                for(int c=0; c<n; c++){
                    rightUpCopyImg[r][c]=copyImg[r][c];
                    rightDownCopyImg[r][c]=copyImg[r][c];
                }
            }
            
            for(int j=1; j<n; j++){
                //위쪽으로 sliding
                upPush(rightUpCopyImg, n);
                countOverlap(rightUpCopyImg, img2, n);
                //아래쪽으로 sliding
                downPush(rightDownCopyImg, n);
                countOverlap(rightDownCopyImg, img2, n);
            }
        }
        
        //왼쪽 + 위, 아래 sliding
        for(int i=0; i<n; i++){  //img1 깊은 복사
            for(int j=0; j<n; j++){
                copyImg[i][j]=img1[i][j];
            }
        }
        
        int[][] leftUpCopyImg= new int[n][n];
        int[][] leftDownCopyImg= new int[n][n];
        for(int i=0; i<n; i++){
            //왼쪽으로 sliding
            if(i!=0){
                leftPush(copyImg, n);
                countOverlap(copyImg, img2, n); //왼쪽으로만 sliding한 이미지 비교
            }
            for(int r=0; r<n; r++){  //슬라이딩한 이미지 깊은 복사
                for(int c=0; c<n; c++){
                    leftUpCopyImg[r][c]=copyImg[r][c];
                    leftDownCopyImg[r][c]=copyImg[r][c];
                }
            }
            
            for(int j=1; j<n; j++){
                //위쪽으로 sliding
                upPush(leftUpCopyImg, n);
                countOverlap(leftUpCopyImg, img2, n);
                //아래쪽으로 sliding
                downPush(leftDownCopyImg, n);
                countOverlap(leftDownCopyImg, img2, n);
            }
        }
        
        return largestCount;
    }
    
    public void countOverlap(int[][] img1, int[][] img2, int n){
        int count=0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(img1[i][j]==1 && img2[i][j]==1){
                    count++;
                }
            }
        }
        if(largestCount<count){
            largestCount=count;
        }
    }
    
    public void rightPush(int[][] copyImg, int n){
        int save=0;
        int prev=0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                save=copyImg[i][j];  //sliding 전 숫자 저장
                
                if(j==0){
                    copyImg[i][j]=0;
                }else{
                    copyImg[i][j]=prev;  //sliding
                }
                prev=save;
            }
        }
    }
    
    public void leftPush(int[][] copyImg, int n){
        int save=0;
        int prev=0;
        
        for(int i=0; i<n; i++){
            for(int j=n-1; j>=0; j--){
                save=copyImg[i][j];  //sliding 전 숫자 저장
                
                if(j==n-1){
                    copyImg[i][j]=0;
                }else{
                    copyImg[i][j]=prev;  //sliding
                }
                prev=save;
            }
        }
    }
    
    public void downPush(int[][] copyImg, int n){
        int[] save=new int[n];
        int[] prev= new int[n];
        
        for(int i=0; i<n; i++){
            save=copyImg[i].clone();
            
            if(i==0){
                for(int j=0; j<n; j++){
                    copyImg[i][j]=0;
                }
            }else{
                copyImg[i]=prev.clone();
            }
            
            prev=save.clone();
        }
    }
    
    public void upPush(int[][] copyImg, int n){
        int[] save=new int[n];
        int[] prev= new int[n];
        
        for(int i=n-1; i>=0; i--){
            save=copyImg[i].clone();
            
            if(i==n-1){
                for(int j=0; j<n; j++){
                    copyImg[i][j]=0;
                }
            }else{
                copyImg[i]=prev.clone();
            }
            
            prev=save.clone();
        }
    }
}