t = int(raw_input())
def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)
for _ in range(t):
    n = int(raw_input())
    a = map(int, raw_input().split(" "))
    rooms = []
    for i in range(n):
        room = 1
        j = i
        while j < n - 1:
            if gcd(a[j], a[j+1]) > 1:
                room += 1
                j += 1
            else:
                k = j + 1
                while k < n and gcd(a[j], a[k]) == 1:
                    k += 1
                # print j, k, n
                if k < n and gcd(a[j], a[k]) > 1:
                    room += 1
                j = k
        rooms.append(room)
    print max(rooms)
