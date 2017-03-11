for t in range(int(raw_input().strip())):
    n, k = map(long, raw_input().strip().split())
    if k == 0: print 0, n
    else: print n/k, n%k
