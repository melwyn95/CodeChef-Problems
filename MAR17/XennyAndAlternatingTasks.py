for _ in range(int(raw_input())):
    n = int(raw_input())
    x = map(int, raw_input().split())
    y = map(int, raw_input().split())
    x_first = 0
    y_first = 0
    switch = True
    for i in range(n):
        if switch:
            x_first += x[i]
            y_first += y[i]
            switch = False
        else:
            x_first += y[i]
            y_first += x[i]
            switch = True
    print min(x_first, y_first)
