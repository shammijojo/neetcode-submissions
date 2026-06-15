class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = dict()
        for x in strs:
            word_dict = dict()
            for c in x:
                if c in word_dict:
                    count = word_dict[c]
                    word_dict.update({c:count+1})
                else:
                    word_dict[c] = 1

            key = tuple(sorted(word_dict.items()))

            if key in result:
                group = result[key]
                group.append(x)
            else:
                result[key] = [x]   

        return list(result.values())                
                      

        