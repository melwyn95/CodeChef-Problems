for _ in range(int(raw_input())):
    n = int(raw_input())
    a = map(int, raw_input().split())
    a.sort()
    if n > 0 and n <= 2:
        print max(a)
        for i in a: print i, 
    elif n > 2:
        mid = (2*n-1)/2 
        temp = a[mid+1]
        a[mid+1] = a[mid+2]
        a[mid+2] = temp
        print a[mid+1]
        for i in a: print i, 
    print 
        