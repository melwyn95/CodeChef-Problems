count = 0
def dist(x1, y1, x2, y2):
    return pow((x2-x1), 2) + pow((y2-y1), 2)
def is_right_angled(d1, d2, d3):
    return (d1 + d2) == d3
for i in range(int(raw_input())):
    x1, y1, x2, y2, x3, y3 = map(int, raw_input().split())
    d1 = dist(x1, y1, x2, y2)
    d2 = dist(x1, y1, x3, y3)
    d3 = dist(x2, y2, x3, y3)
    if is_right_angled(d1, d2, d3) or is_right_angled(d2, d3, d1) or is_right_angled(d3, d1, d2):
        count += 1
print count
