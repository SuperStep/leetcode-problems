class Solution {
    public boolean isValid(String string) {
         Stack<Character> stack = new Stack<>();

        for (char c : string.toCharArray()) {

            try {
                switch (c) {
                    case 40, 91, 123:
                        stack.push(c);
                        break;
                    case 41: {
                        char res = stack.pop();
                        if (res != 40) {
                            return false;
                        }
                    }
                    break;
                    case 93: {
                        char res = stack.pop();
                        if (res != 91) {
                            return false;
                        }
                    }
                    break;
                    case 125: {
                        char res = stack.pop();
                        if (res != 123) {
                            return false;
                        }
                    }
                    break;
                }
            } catch (Exception e) {
                return false;
            }


        }

        return stack.empty();
    }
}