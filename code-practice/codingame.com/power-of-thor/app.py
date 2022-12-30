# https://www.codingame.com/multiplayer/codegolf/power-of-thor
# https://www.codingame.com/ide/puzzle/power-of-thor-episode-1

# lx, ly, tx, ty = [int(i) for i in input().split()]
# while 1:
#     remaining_turns = int(input())  # The level of Thor's remaining energy, representing the number of moves he can still make.
#     m = ''
#     if ty != ly:
#         if ty < ly: m = 'S'; ty += 1
#         else: m = 'N'; ty -= 1
#     if tx != lx:
#         if tx < lx: m += 'E'; tx += 1
#         else: m += 'W'; tx -= 1
#     print(m)




# Golf
# a,b,c,d=[int(i) for i in input().split()]
# while input():
#  m=''
#  if d<b:m='S';d+=1
#  if d>b:m='N';d-=1
#  if c<a:m+='E';c+=1
#  if c>a:m+='W';c-=1
#  print(m)



# x,y,a,b=[int(i) for i in input().split()]
# v='NS'[y>b]*abs(y-b)
# h='WE'[x>a]*abs(x-a)
# m=list(zip(v.ljust(40),h.ljust(40)))
# input()
# while True:
#  input(''.join(m.pop(0)).strip()+'\n')


# x,y,a,b=[int(i) for i in input().split()]
# m=list(zip(('NS'[y>b]*abs(y-b)).ljust(40),('WE'[x>a]*abs(x-a)).ljust(40)))
# input()
# while input(''.join(m.pop(0)).strip()+'\n'):pass


# x,y,a,b=map(int,input().split())
# m=list(zip(('NS'[y>b]*abs(y-b)).ljust(40),('WE'[x>a]*abs(x-a)).ljust(40)))
# input()
# while input(''.join(m.pop(0)).strip()+'\n'):pass


# 116
# x,y,a,b=map(int,input().split())
# m=["NS"[y>b]]*abs(y-b)+[""]*90+["WE"[x>a]]*abs(x-a)
# while 1:print(m.pop(0)+m.pop())


# 115
x,y,a,b=map(int,input().split())
while 1:
 i,j=(y<b)-(y>b),(x<a)-(x>a);print((' NS'[i]+' WE'[j]).strip());a-=j;b-=i


# 142
# Nope: l=lambda d,s,e:i=(s>e)-(s<e);d[i],s+i
# x,y,a,b=map(int,input().split())
# def l(d,s,e):i=(s>e)-(s<e);return d[i],s-i
# while 1:
#  v,b=l(' NS',b,y)
#  h,a=l(' WE',a,x)
#  print((v+h).strip())



