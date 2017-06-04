for _ in range(int(raw_input())):
    p, q, r = map(int, raw_input().split())
    a = map(int, raw_input().split())
    b = map(int, raw_input().split())
    c = map(int, raw_input().split())
    a.sort()
    b.sort(key=lambda x: -1*x)
    c.sort()
    i=len(a) - 1
    while a[i] > b[0]:
        a.pop(i)
        i -= 1
    i=len(c) - 1
    while c[i] > b[0]:
        c.pop(i)
        i -= 1
    mod = 1000000007
    answer = 0
    for i in b:
        for j in a:
            for k in c:
                if i >= j and i >= k:
                    t = (i+j) * (i+k)
                    answer = (answer + t) % mod
    print answer
