class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area=0;
        
        //a rect <b rect 인 경우
        if(bx1<ax1 && ax2<bx2 && by1<ay1 && ay2<by2){
            area= (bx2-bx1)*(by2-by1);
        }else if(ax1< bx1 && bx2<ax2 && ay1<by1 && by2<ay2){ // a rect > b rect 인 경우
            area= (ax2-ax1)*(ay2-ay1);
        }else{  
            //안겹치는 경우
            if(by1>=ay2 || ay1>=by2 || bx2<ax1 || ax2<bx1){
                area=(ax2-ax1)*(ay2-ay1)+(bx2-bx1)*(by2-by1);
            }else{  //겹치는 경우
                 //겹치는 rect
                int cx1=(ax1<bx1)?bx1:ax1;
                int cy1=(ay1<by1)?by1:ay1;
                int cx2=(ax2<bx2)?ax2:bx2;
                int cy2=(ay2<by2)?ay2:by2;
                area=(ax2-ax1)*(ay2-ay1)+(bx2-bx1)*(by2-by1)-(cx2-cx1)*(cy2-cy1);
            }
           
        }
        
        return area;
        
    }
}