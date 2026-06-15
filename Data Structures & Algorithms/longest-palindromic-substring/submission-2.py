class Solution:
    def longestPalindrome(self, s: str) -> str:
        max_length = 0
        longest_palindrome = ""

        for i in range(0,len(s)):
            left = i
            right = i
            while left >=0 and right < len(s) and s[left] == s[right]:
                length = right-left+1
                if(length > max_length):
                    max_length = length
                    longest_palindrome = s[left:right+1]
                left -= 1
                right += 1  

        for i in range(1,len(s)):
            left = i
            right = i-1
            while left >=0 and right < len(s) and s[left] == s[right]:
                length = right-left+1
                if(length > max_length):
                    max_length = length
                    longest_palindrome = s[left:right+1]
                left -= 1
                right += 1   

        return  longest_palindrome            
                
              
        