for _ in range(int(raw_input())):
    n = int(raw_input())
    a = map(int, raw_input().split())
    con = [False for i in range(n)]
    a.sort()
    #print a
    for i in range(n-1):
        #print a[i+1]-a[i]
        if a[i+1] - a[i] != 1:
            if con[i]:
                print a[i+1]
            else:
                print a[i]
            break
        else:
            con[i] = con[i+1] = True
