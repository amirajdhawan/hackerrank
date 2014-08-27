import string
t = int(input())

for i in range(0, t):
	curstr = str(input())
	count = 0;
	for ind in range(0, int(len(curstr))):
		prvch = curstr[len(curstr) - 1 - ind]
		prvint = string.ascii_letters.index(prvch)
		curch = curstr[ind]
		curint = string.ascii_letters.index(curch)

		if prvint - curint >= 0:
			count += prvint - curint
		
	print(count)