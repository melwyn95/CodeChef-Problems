d = {}
def max_coins(n):
    if n == 0:
        return 0
    return max(n, max_coins(n/2)+max_coins(n/3)+max_coins(n/4))

def fun(n):
    if n == 0: return 0
    if n not in d:
        d[n] = max(n, fun(n/2)+fun(n/3)+fun(n/4))
        return d[n]
    else:
        return d[n]

try:
    while True:
        inp = raw_input()
        if inp != "":
            n = int(inp)
            print fun(n)
        else: break
except EOFError:
    pass
