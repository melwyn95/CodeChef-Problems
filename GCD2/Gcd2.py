def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a%b)
t = int(raw_input())
for _ in range(t):
    a, b = raw_input().split()
    a = int(a)
    if a != 0:
        new_b = 0
        #c = long(b)
        b = map(int, list(b))
        for i in b:
            new_b = (new_b*10 + i) % a
            #print (new_b * 10 + i) % a
        #print new_b, b, a
        print gcd(a, new_b)
        #print c, gcd(a, c)
    else:
        print b
