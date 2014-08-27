first_input = input()
n_input = input()

first_input = first_input.split()
n_input = n_input.split()

n = int(first_input[0])
t = int(first_input[1])
n_array = []

for i in range(0, n):
	n_array.append(int(n_input[i]))

for k in range(0, t):
	t_input = input()
	t_input = t_input.split()

	i = int(t_input[0])
	j = int(t_input[1])

	print(min(n_array[i:j+1]))