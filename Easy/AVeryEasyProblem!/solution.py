p = [2**i for i in range(16,-1,-1)]
def r(n):
    if n==0:return ''
    elif n==3:return '2+2(0)'
    elif n==1:return '2(0)'
    elif n==2:return '2'
    else:
        i = 0
        while n<p[i]:
            i += 1
        if n-p[i]>0: return '2('+r(16-i)+')+'+r(n-p[i])
        else: return '2('+r(16-i)+')'
print('137='+r(137))
print('1315='+r(1315))
print('73='+r(73))
print('136='+r(136))
print('255='+r(255))
print('1384='+r(1384))
print('16385='+r(16385))
