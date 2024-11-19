class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        // If concatenation in both orders is not equal, no solution exists
        if (str1 + str2 != str2 + str1) {
            return ""
        }
        
        // Get the GCD length and return the substring
        return str1.substring(0, gcd(str1.length, str2.length))
    }
    
    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }
}