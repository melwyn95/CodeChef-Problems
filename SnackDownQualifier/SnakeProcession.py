R = int(raw_input())
for _ in range(R):
    L = int(raw_input())
    s = raw_input().split('.')
    new_s = ''
    for z in s:
        if len(z) > 0:
            new_s += z
    #print new_s
    if len(new_s) == 0:
        print 'Valid'
    elif len(new_s)%2 != 0:
        print 'Invalid'
    else:
        flag = True
        if new_s[0] == 'T': flag = False
        else:
            count_h = new_s.count('H')
            count_t = new_s.count('T')
            if count_h == count_t:
                for i in range(len(new_s)-1):
                    if new_s[i] == 'H' and new_s[i+1] != 'T':
                        flag = False
                        break
                    elif new_s[i] == 'T' and new_s[i+1] != 'H':
                        flag = False
                        break
            else:
                flag = False
        if flag:
            print 'Valid'
        else:
            print 'Invalid'
        
