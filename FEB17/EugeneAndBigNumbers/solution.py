def digits(number):
    digits = 0
    while number > 0:
        digits += 1
        number /= 10
    return digits
for i in range(int(raw_input())):
    a, n, m = map(long, raw_input().split())
    dig = digits(a)
    basic = a
    r = dig * n - dig
    answer = 0
    for i in range(n):
        #print dig, answer
        #a *= 10 ** dig
        #print (a * (10 ** r))
        answer += (a * (10 ** r)) % m
        r -= dig
        #a += basic
    # print a
    print answer % m
