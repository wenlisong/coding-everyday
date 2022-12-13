import sys
# calculator
def main():
    line = sys.stdin.readline().strip()
    # line = '1+2+99-10-10'
    num_list = [str(i) for i in range(10)]
    op_list = ['+', '-']
    num = ''

    stack1 = []
    stack2 = []
    for char in line:
        if char in num_list:
            num += char
        elif char in op_list:
            stack1.append(int(num))
            stack2.append(char)
            num = ''
    if num != '':
        stack1.append(int(num))

    res = 0
    while stack2:
        op = stack2.pop()
        if op == '+':
            res += stack1.pop()
        elif op == '-':
            res -= stack1.pop()
    res += stack1.pop()
    print(res) 

if __name__ == "__main__":
    main()