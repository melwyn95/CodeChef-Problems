sub = lambda x, y: x-y
a = map(lambda x:x<<(1<<(1<<(1<<1))), range(30008))
def bin_search(a, l ,h, x):
    if l <= h:
        m = (l + h) / 2
        if x >= a[m] and x <= (a[m]+30000):
            return m
        else:
            if x > a[m]:
                return bin_search(a, m+1, h, x)
            else:
                return bin_search(a, l, m-1, x)
    return -1
def sol(n):
    if n == 0:
        return (0, 0)
    i = bin_search(a, 0, 30007-1, n)
    return (sub(n, a[i]), i)
for _ in range(int(raw_input())):
    A = []
    B = []
    for __ in range(int(raw_input())):
        t = sol(int(raw_input()))
        A.append(t[0])
        B.append(t[1])
    print "Case %d:"%(_+1)
    print " ".join(map(str, A))
    print " ".join(map(str, B))
