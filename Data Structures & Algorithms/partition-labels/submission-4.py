class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        char_dict : dict = {}

        for i in range(0,len(s)):
            c = s[i]
            char_dict[c] = i

        l : int = 0
        r : int = 0
        result : list[int] = []

        while l < len(s):
            index = l
            while index <= r:
                r = max(r,char_dict.get(s[index]))
                index+=1
            result.append(r-l+1)    
            l = r+1
            r = l


        return result
        