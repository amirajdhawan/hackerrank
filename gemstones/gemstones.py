import string
n = int(input())
comp = []
for i in range(0,n):
	comp.append(set(input()))

ans = set(comp[0])
for fch in comp[0]:
	for lst in comp[1:]:
		if fch not in lst:
			ans.remove(fch)
			break

print(len(ans))

# Un optimized
# for ch in string.lowercase:
# 	print('char: ' + ch)
# 	for lst in comp:
# 		if ch not in lst:
# 			print('breaking');
# 			break
# 		else:
# 			if lst == comp[::len(comp)-1]:
# 				print ch