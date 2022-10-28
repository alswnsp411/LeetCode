//두 개의 string array word1이랑 word2가 동일한지 체크 동일하면 true 리턴
// A string is represented by an array if the array elements concatenated in order forms the string. :array를 죽 이어붙여서 비교한다.

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String stringWord1= String.join("", word1);
        String stringWord2= String.join("", word2);
        
        if(stringWord1.equals(stringWord2)){
            return true;
        }else{
            return false;
        }
    }
}