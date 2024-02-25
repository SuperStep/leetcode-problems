class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        for (String word : words) {
            if (word.length() > maxWidth) {
                throw new IllegalArgumentException();
            }
        }
        List<String> lines = new ArrayList<>();
        int firstWordInLine = 0;
        int unjustifiedLineLength = words[firstWordInLine].length();
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            int wordLength = word.length();
            if (unjustifiedLineLength + wordLength + 1 <= maxWidth) { // line has space
                unjustifiedLineLength += wordLength + 1; // + 1 for space
            } else { // line has no more space
                int lastWordInLine = i - 1;
                lines.add(makeLine(words, maxWidth, firstWordInLine, lastWordInLine,
                    unjustifiedLineLength));
                firstWordInLine = i;
                unjustifiedLineLength = wordLength;
            }
        }
        lines.add(makeLine(words, maxWidth, firstWordInLine, words.length - 1, unjustifiedLineLength));
        return lines;
    }

    private String makeLine(String[] words, 
                            int maxWidth, 
                            int firstWordInLine, 
                            int lastWordInLine,
                            int unjustifiedLineLength) {
        StringBuilder sb = new StringBuilder(maxWidth);
        sb.append(words[firstWordInLine]);
        if (lastWordInLine == words.length - 1) {
            for (int i = firstWordInLine + 1; i <= lastWordInLine; i++) {
                sb.append(" "); // always before a word
                sb.append(words[i]);
            }
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int totalWords = lastWordInLine - firstWordInLine + 1;
        if (totalWords == 1) {
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int additionalSpaces = maxWidth - unjustifiedLineLength;
        int additionalSpacesPerWord = additionalSpaces / (totalWords - 1);
        int leftSpaces = additionalSpaces % (totalWords - 1);
        for (int i = firstWordInLine + 1; i <= lastWordInLine; i++) {
            sb.append(" "); // always before a word
            for (int j = 0; j < additionalSpacesPerWord; j++) {
                sb.append(" ");
            }
            if (leftSpaces > 0) {
                sb.append(" ");
                leftSpaces--;
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }
}