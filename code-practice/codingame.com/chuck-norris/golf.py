# https://www.codingame.com/ide/puzzle/chuck-norris-codesize

# 146
s=o=''
for c in input():s+=f'{ord(c):07b}'
i=1
t=s[0]
for c in s[1:]+'_':
 if t!=c:o,i,t=o+(' 0 'if t=='1'else' 00 ')+'0'*i,0,c
 i+=1
print(o[1:])


# 144
s=t=o=''
for c in input():s+=f'{ord(c):07b}'
i=0
for c in s+'_':
 if t and t!=c:o,i=o+(' 0 'if t=='1'else' 00 ')+'0'*i,0
 i+=1
 t=c
print(o[1:])


# 140
s=t=o=''
for c in input():s+=f'{ord(c):07b}'
i=0
for c in s+'_':
 if t and t!=c:o,i=o+(' 0 ',' 00 ')[t=='0']+'0'*i,0
 i+=1
 t=c
print(o[1:])


# 151,147,130,123
t=o=''
for c in str(''.join(f'{ord(c):07b}' for c in input())):
 if t!=c:o+=(' 0 ',' 00 ')[c=='0'];t=c
 o+='0'
print(o[1:])

# t=o=''
#  if t!=c:o+=;t=c
#  o+='0'
# print(' '.join((' 0 0',' 00 0')[c=='0']if    for c in str(''.join(f'{ord(c):07b}' for c in input()))))


# 155,147,143
m=str(''.join(f'{ord(c):07b}' for c in input()))
print(('0 ','00 ')[m[0]=='0']+m.replace('01','0 0 1').replace('10','1 00 0').replace('1','0'))





