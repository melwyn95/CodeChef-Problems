for i in range(int(raw_input())):
    A = []
    B = []
    for j in range(int(raw_input())):
        n = int(raw_input())
        A.append(n>>16)
        B.append(n-(A[len(A)-1]<<16))
    print " ".join(map(str, B))
    print " ".join(map(str, A))
