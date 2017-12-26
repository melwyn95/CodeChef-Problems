for T in range(int(raw_input())):
    n = int(raw_input())
    a = map(int, raw_input().split())
    neg = []
    pos = []
    w = 0
    for ai in a:
        w += ai
        if ai < 0: neg.append(ai)
        else: pos.append(ai)
    neg.sort(key=lambda x: -1*x)
    sum_pos = sum(pos)
    sum_neg = sum(neg)
    basic_sol = len(pos) * sum_pos + sum_neg
    worst_sol = w * n 
    flag = True
    if len(neg) == 0: flag = False
    i = 0
    extra = len(pos)
    new_sum_neg = sum_neg
    while flag:
        candidate = neg[i]
        extra += 1
        new_sum_neg -= candidate
        new_sol = (sum_pos + candidate) * extra + new_sum_neg
        #print 'candidate: ', candidate
        #print 'exta: ', extra
        #print 'new_sum_neg: ', new_sum_neg
        #print 'new_sol: ', new_sol
        #print 'basic_sol: ', basic_sol
        #print '-------------------------'
        if new_sol > basic_sol:
            basic_sol = new_sol
            sum_pos += candidate
            i += 1
        else:
            break
    if basic_sol > worst_sol: print basic_sol
    else: print worst_sol
        
        
    
