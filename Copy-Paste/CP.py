def bin_search(i, a, l, h):
    if l > h:
        return True
    mid = (l + h) / 2
    if a[mid] == i:
        return False
    else:
        if i < a[mid]:
            return bin_search(i, a, l, mid-1)
        else:
            return bin_search(i, a, mid+1, h)
t = int(raw_input())
for _ in range(t):
    n = int(raw_input())
    a = map(int, raw_input().split())
    a.sort()
    unique = []
    for i in a:
        if bin_search(i, unique, 0, len(unique)-1):
            unique.append(i)
    print len(unique)
