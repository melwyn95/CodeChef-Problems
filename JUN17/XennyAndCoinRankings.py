for _ in range(int(raw_input())):
    u, v = map(int, raw_input().split())
    n = u+v
    start_index = (n * (n+1)) / 2
    offset = n+1 - v
    print start_index + offset
