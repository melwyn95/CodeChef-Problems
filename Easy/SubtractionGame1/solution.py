def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a%b)
for t in range(int(raw_input())):
    n = int(raw_input())
    a = map(int, raw_input().split())
    print reduce(gcd, a)
