for _ in range(int(raw_input())):
    suma, sumb = 0, 0
    for __ in range(int(raw_input())):
        ip = map(int, raw_input().split())
        suma += ip[0]
        sumb += ip[1]
    print suma - sumb
