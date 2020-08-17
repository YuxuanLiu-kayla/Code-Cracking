# The solution code of 'Valid Palindrome'

def isPalindrome(s):
    '''
    Input: a String
    Output: a boolean value

    Check whether a given string is a palindrome or not.
    
    '''
    # create a new string without non-alphanumeric characters.
    newS = ''.join([char for char in s if char.isalnum()]).lower()

    # check whether it is a valid palindrome
    return (newS == newS[::-1])
    
