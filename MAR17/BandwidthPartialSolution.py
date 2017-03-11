import time
bw_list = []
def fun(n):
    new_list = []
    for i in range(n):
        row = []
        for j in range(n):
            row.append(abs(i-j))
        new_list.append(row)
    #for i in new_list:
    #    print i
    return_list = []
    for k in range(n):
        count = 0
        for i in new_list:
            for j in i:
                if j > k:
                    count += 1
        return_list.append(count)
    #print return_list
    bw_list.append(return_list)
def new_fun(n):
    new_list = [n-i for i in range(n)]
    return_list = []
    for i in range(n):
        return_list.append(sum(new_list[i+1:])*2)
    return return_list

start = time.time()
for i in range(501):
    new_fun(i)
print time.time()-start

#for i in range(101):
#    fun(i)
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
