t = int(raw_input())
for _ in range(t):
    s = raw_input()
    l = len(s)
    if l%2 == 0:
        left = s[:l/2]
        right = s[l/2:]
    else:
        left = s[:l/2]
        right = s[l/2+1:]
    left_freq = [0 for i in range(26)]
    right_freq = [0 for i in range(26)]
    for i in left:
        left_freq[ord(i)-97] += 1
    for i in right:
        right_freq[ord(i)-97] += 1
    flag = True
    for i in range(26):
        if left_freq[i] != right_freq[i]:
            print "NO"
            flag = False
            break
    if flag:
        print "YES"
