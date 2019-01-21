def bubble_sort(Array):
    # put max in last position
    last_index = len(Array) - 1
    for i in range(0, last_index):
        for j in range(0, last_index - i):
            if Array[j] > Array[j + 1]:
                Array[j], Array[j + 1] = Array[j + 1], Array[j]

    return Array


array = [3, 4, 6, 3, 2, 7, 23, 45, 12, 32, 0, 2, -2, 6, 1]
print(bubble_sort(array))
