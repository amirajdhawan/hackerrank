init_height = 1
test_cases = int(input())

for i in range(0, test_cases):
	cycles = int(input())
	final_height = init_height
	for i in range(1, cycles + 1):
		if i % 2 == 0:
			final_height = final_height + 1
		else:
			final_height = 2 * final_height

	print(final_height)