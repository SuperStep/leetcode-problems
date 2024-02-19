class Solution {
    public boolean isHappy(int n) {
        int sum=0;
       while(n>0)
       {
          int d=n%10;
           sum=sum+d*d;
           n=n/10;
       } 
      n=sum;
     if(n>9)
       {return isHappy(n);}
       else if(n<=9 && n!=1 && n!=7)
       {return false;}
       return true;
    }
}