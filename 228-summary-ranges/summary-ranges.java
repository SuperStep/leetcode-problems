class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if(nums.length == 0)
            return res;
        int prev = nums[0];
        String str = String.valueOf(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(prev - nums[i] == -1) {
                prev = nums[i];
                continue;
            }
            else {
                if(str.equals(String.valueOf(prev)))
                    res.add(str);
                else
                    res.add(String.join("->", str, String.valueOf(prev)));
            }
            str = String.valueOf(nums[i]);
            prev = nums[i];
        }

        if(!str.equals(String.valueOf(prev)))
            res.add(String.join("->", str, String.valueOf(prev)));
        else
            res.add(str);
        return res;
    }
}