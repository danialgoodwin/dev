"""
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
"""
n = 1000
a = 3
b = 5

# Option 1 - Simple readability
sum = 0
for i in range(1, n):
    if i % 3 == 0 or i % b == 0:
        sum += i
print(sum)


# Option 2 - Speed?
multiples_a = range(1, n, a)
multiples_b = range(1, n, b)
numbers = set(multiples_a) | set(multiples_b)
print(sum(numbers))


# Option 3 - Speed?
sum_a = sum(range(1, n, a))
sum_b = sum(range(1, n, b))
sum_ab = sum(range(1, n, a * b))
print(sum_a + sum_b - sum_ab)


# Option 4 - Golf
print('\nOption 4 - Golf')
print(sum(set(range(1,n,a))|set(range(1,n,b))))
print(sum([x for x in range(1,n) if i%a*i%b==0]))
print(sum([x for x in range(1,n) if i%a==0 or i%b==0]))
