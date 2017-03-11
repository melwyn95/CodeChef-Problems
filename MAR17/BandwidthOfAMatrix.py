bw_list = []
def fun(n):
    new_list = [n-i for i in range(n)]
    return_list = []
    for i in range(n):
        return_list.append(sum(new_list[i+1:])*2)
    bw_list.append(return_list)

for i in range(501):
    fun(i)
for T in range(int(raw_input())):
    n = int(raw_input())
    z = 0
    for i in range(n):
        for j in map(int, raw_input().split()):
            if j == 0:
                z += 1
    if z != n*n:
        for i, j in enumerate(bw_list[n]):
            if z >= j:
                print i
                break
    else:
        print 0
