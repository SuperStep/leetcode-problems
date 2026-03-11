class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        _max = 0
        _counter = 0
        for num in nums:
            if num == 1:
                _counter = _counter + 1
            else:
                _counter = 0
            if _counter > _max:
                _max = _counter
        return _max

        