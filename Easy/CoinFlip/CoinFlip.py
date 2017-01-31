import math
t = int(raw_input())
for _ in range(t):
    G = int(raw_input())
    for __ in range(G):
        i, n, q = map(int, raw_input().split())
        if n % 2 == 0:
            #same as start
            print n / 2
        else:
            #opposite of start
            if i != q:
                print (n / 2) + 1
            else:
                print n / 2
