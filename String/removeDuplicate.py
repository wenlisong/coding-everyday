import sys
#woooow -> woow
#AABBBCC -> AABBCC

def main():
    n = int(sys.stdin.readline().strip())
    for i in range(n):
        line = sys.stdin.readline().strip()
        l = len(line)
        if l < 4:
            print(line)
        else:
            check_string(line)

def check_string(line):
    stack = []
    for char in line:
        l = len(stack)
        if l >= 2 and char == stack[-1]:
            if char == stack[-2]:
                continue
            if l >= 3 and stack[-2] == stack[-3]:
                continue
        stack.append(char)

    print(''.join(stack))
                

if __name__ == "__main__":
    main()