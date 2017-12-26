n, k = map(int, raw_input().split())
a = [0]
def T(n, k):
    if n <= k: return 1
    return a[n-1] - a[n-k-1]
for i in range(1, n+1):
    a.append(a[i-1] + T(i, k))
print (a.pop()-a.pop()) % 1000000007

