for _ in range(int(raw_input())):
    n = int(raw_input())
    c = map(int, raw_input().split())
    if n%2 == 0:
        print 'no'
    else:
        a = [i for i in range(1, (n/2) + 2)]
        b = [i for i in range(n/2, 0, -1)]
        a = a+b
        #print a, c
        if c == a:
            print 'yes'
        else:
            print 'no'
        
