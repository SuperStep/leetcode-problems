class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> lineWords = new ArrayList<>();
        int lineLength = 0;

        for (String word : words) {
            if (lineLength + word.length() + lineWords.size() > maxWidth) {
                // Justify the current line
                int spaces = maxWidth - lineLength;
                if (lineWords.size() == 1) {
                    result.add(lineWords.get(0) + " ".repeat(spaces));
                } else {
                    int gaps = lineWords.size() - 1;
                    int spacesBetweenWords = spaces / gaps;
                    int extraSpaces = spaces % gaps;
                    StringBuilder justifiedLine = new StringBuilder();
                    for (int i = 0; i < gaps; i++) {
                        justifiedLine.append(lineWords.get(i));
                        justifiedLine.append(" ".repeat(spacesBetweenWords + (i < extraSpaces ? 1 : 0)));
                    }
                    justifiedLine.append(lineWords.get(lineWords.size() - 1));
                    result.add(justifiedLine.toString());
                }

                // Start a new line
                lineWords.clear();
                lineWords.add(word);
                lineLength = word.length();
            } else {
                lineWords.add(word);
                lineLength += word.length();
            }
        }

        // Justify the last line (left-justified)
        StringBuilder lastLine = new StringBuilder();
        for (String word : lineWords) {
            lastLine.append(word);
            lastLine.append(" ");
        }
        lastLine.deleteCharAt(lastLine.length() - 1); // Remove the trailing space
        lastLine.append(" ".repeat(maxWidth - lastLine.length()));
        result.add(lastLine.toString());

        return result;
    }
}