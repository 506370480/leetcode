package sortandsearch;

public class FirstBadVersion {

    public int firstBadVersion(int n) {

            int pre = 1;
            int rear=n;
            int temp=1;
            while(pre<rear){
                //这样到最后的时候数组会越界！！！
                temp = (pre+rear)/2;
                //if(isBadVersion(temp)){
                if(true){
                    rear = temp;
                }else{
                    pre = temp+1;
                }
            }
            return temp;

        }


}
