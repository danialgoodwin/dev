""" Sample output for n=4:
####
   #
  ###
 #####
#######
#######
 #####
  ###
   #
"""

n=int(input())
s=['']*n*2
l='\n'
for i in range(n):s[i]=s[n*2-i-1]=' '*(n-i-1)+'#'*(i*2+1)
print('#'*n+l+l.join(s))
