class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // Initialize sets for rows, columns and boxes
        val rows = Array(9) { HashSet<Char>() }
        val cols = Array(9) { HashSet<Char>() }
        val boxes = Array(9) { HashSet<Char>() }
        
        for (i in 0..8) {
            for (j in 0..8) {
                val cell = board[i][j]
                if (cell == '.') continue
                
                // Calculate box index
                val boxIndex = (i / 3) * 3 + j / 3
                
                // Check if number exists in row, column or box
                if (!rows[i].add(cell) || 
                    !cols[j].add(cell) || 
                    !boxes[boxIndex].add(cell)) {
                    return false
                }
            }
        }
        
        return true
    }
}
