class Solution {
    fun mergeAlternately(word1: String, word2: String): String = 
        (0 until maxOf(word1.length, word2.length))
            .joinToString("") { i ->
                buildString {
                    if (i < word1.length) append(word1[i])
                    if (i < word2.length) append(word2[i])
                }
            }
}