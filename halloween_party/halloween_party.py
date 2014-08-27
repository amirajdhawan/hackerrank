t = int(input())

for i in range(0, t):
	k = int(input())

	v = int(k/2)

	if k % 2 == 0:
		h = v
	else:
		h = v + 1;

	print(h*v)