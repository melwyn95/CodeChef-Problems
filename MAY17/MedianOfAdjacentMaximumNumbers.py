for _ in range(int(raw_input())):
    n = int(raw_input())
    a = map(int, raw_input().split())
    a.sort()
    if n > 0 and n <= 2:
        print max(a)
        for i in a: print i, 
    elif n > 2:
        b = []
        for i in range(n):
            b.append(a[i])
            b.append(a[n+i])
        print b[n]
        for i in b: print i, 
    print 
        
