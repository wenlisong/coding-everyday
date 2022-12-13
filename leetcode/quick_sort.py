def quick_sort(array, low, high):
    i = low
    j = high
    if i >= j:
        return array
    key = array[i]
    while i < j:
        while i < j and array[j] >= key:
            j -= 1
        array[i], array[j] = array[j], array[i]
        while i < j and array[i] <= key:
            i += 1
        array[i], array[j] = array[j], array[i]

    quick_sort(array, low, i - 1)
    quick_sort(array, i + 1, high)
    return array


array = [3, 4, 6, 3, 2, 7, 23, 45, 12, 32, 0, 2, -2, 6, 1]
low = 0
high = len(array) - 1
print(quick_sort(array, low, high))
