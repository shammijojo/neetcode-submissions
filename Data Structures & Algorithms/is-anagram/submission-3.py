class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if(len(s) != len(t)):
            return False;

        charactersByFrequency = dict()
        for c in s:
            if c in charactersByFrequency:
                count = charactersByFrequency[c]
                charactersByFrequency.update({c:count+1})
            else:
                charactersByFrequency[c] = 1;    
        
        for c in t:
            if c in charactersByFrequency:
                count = charactersByFrequency[c]
                if(count == 0):
                    return False;
                charactersByFrequency.update({c:count-1})
            else:
                return False;


        return True        








