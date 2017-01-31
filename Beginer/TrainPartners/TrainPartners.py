import math
t = int(raw_input())
for _ in range(t):
    n = int(raw_input())
    m = n % 8
    if m == 1:
        print "{}LB".format(4+(n/8)*8)
    elif m == 2:
        print "{}MB".format(5+(n/8)*8)
    elif m == 3:
        print "{}UB".format(6+(n/8)*8)
    elif m == 4:
        print "{}LB".format(1+(n/8)*8)
    elif m == 5:
        print "{}MB".format(2+(n/8)*8)
    elif m == 6:
        print "{}UB".format(3+(n/8)*8)
    elif m == 7:
        print "{}SU".format(8+(n/8)*8)
    elif m == 0:
        print "{}SL".format(7+(n/8 - 1)*8)
