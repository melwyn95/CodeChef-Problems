import time

def reduce_set(good_set, factor):
    i = 0
    while i < len(good_set)-factor:
        if (good_set[i] + good_set[i+factor]) in good_set:
            good_set.remove((good_set[i] + good_set[i+factor]))
        i += 1
    return good_set

def check(good_set):
    for i in range(len(good_set)):
        for j in range(i+1, len(good_set)):
            if (good_set[i]+good_set[j]) in good_set:
                return False
    return True

def solve():
    good_set = [i for i in range(41, 501)]
    i = 1
    while i < len(good_set) and not check(good_set):
        good_set = reduce_set(good_set, i)
        i += 1
    return good_set


good_set = map(str, solve())

for _ in range(int(raw_input())):
    n = int(raw_input())
    print " ".join(good_set[:n])
    
