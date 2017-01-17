for _ in range(int(raw_input())):
    c, d, l = map(int, raw_input().split())
    if d == 0:
        min_legs = c * 4
    else:
        min_legs = d * 4 + max(0, c - (d * 2)) * 4
    max_legs = d * 4 + c * 4
    if l % 4 != 0:
        print "no"
    elif l >= min_legs and l <= max_legs:
        print "yes"
    else:
        print "no"
