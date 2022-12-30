"""
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
"""

def is_palindrome(num) -> bool:
    s = str(num)
    return s == s[::-1]


numbers = range(1000, 100, -1)
max_palindrome = 0
for n in numbers:
    for m in numbers:
        p = n * m
        if is_palindrome(p) and p > max_palindrome:
            max_palindrome = p
        if p < max_palindrome:
            break
print(p)
        
        
