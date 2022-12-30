""" Sample output for n=3
+++
+++
+++
"""

s=int(input())
print((('+'*s+'\n')*s)[:-1])
# print((('+'*s+'\n')*s).strip('\n'))

# s=int(input())
# print('\n'.join(['+'*s for _ in ['']*s]))
# print('\n'.join(['+'*s for _ in range(s)]))
