class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();

        while( num > 999 ){
            ans.append('M');
            num -= 1000;
        }

        if( num > 899 ){
            ans.append("CM");
            num -= 900;
        } else if( num > 499 ) {
            ans.append('D');
            num -= 500;
        } else if( num > 399 ) {
            ans.append("CD");
            num -= 400;
        }

        while( num > 99 ) {
            ans.append('C');
            num -= 100;
        }
        if( num > 89 ) {
            ans.append("XC");
            num -= 90;
        } else if( num > 49 ){
            ans.append( 'L' );
            num -= 50;
        } else if( num > 39 ){
            ans.append("XL");
            num -= 40;
        }

        while( num > 9 ){
            ans.append('X');
            num -= 10;
        }
        if( num > 8 ){
            ans.append("IX");
            num -= 9;
        } else if( num > 4 ){
            ans.append('V');
            num -= 5;
        } else if( num > 3 ){
            ans.append("IV");
            num -= 4;
        }

        while( num > 0 ){
            ans.append('I');
            num -= 1;
        }

        return ans.toString();
    }
}