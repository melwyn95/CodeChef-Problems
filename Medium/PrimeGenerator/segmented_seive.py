import math, time
def seive(n):
    primes = []
    numbers = [True] * n
    for i in range(2, n):
        if numbers[i]:
            j = i * 2
            while j < n:
                numbers[j] = False
                j += i
    for i in range(2, n):
        if numbers[i]:
            primes.append(i)
    return primes
def segmented_seive(n):
    limit = int(math.sqrt(n)) + 1
    primes = seive(limit)

    low = limit
    high = limit * 2
    numbers = [True] * limit
    while low < n:
        print low
        for prime in primes:
            low_limit = (low/prime) * prime
            if low_limit < low:
                low_limit += low
            j = low_limit
            while j < high:
                numbers[j-low] = False
                j += prime
##        for i in range(low, high):
##            if numbers[i-low]:
##                primes.append(i)
        low += limit
        high += limit
        if high > n:
            high = n
    return primes





def solution(low, high):
    primes = seive(int(math.sqrt(high)) + 1)
    print primes
    l = low
    low = int(math.sqrt(high)) + 1
    numbers = [True] * (high-low + 1)
    print numbers
    for prime in primes:
        low_limit = (low/prime) *prime
        if low_limit < low:
            low_limit += prime
        j = low_limit
        while j < high:
            numbers[j-low] = False
            j += prime
    primes = []
    for i in range(l, high):
        if numbers[i-low]: primes.append(i)
    return primes
print solution(999000000, 1000000000)

