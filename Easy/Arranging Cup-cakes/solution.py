import math
for T in range(int(raw_input())):
    n = int(raw_input())
    sqrt = int(math.sqrt(n) + 2)
    answer = 1000000000
    for i in range(1, sqrt):
        if n % i == 0:
            if abs(n/i - i) < answer:
                answer = (n/i - i)
    print answer
