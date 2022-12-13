import sys

def main():
    # n = int(sys.stdin.readline().strip())
    n = 10
    receive = 1024 - n
    count = 0
    coins = [64, 16, 4, 1]
    for coin in coins:
        if receive >= coin:
            count += receive // coin
            receive %= coin
    print(count)
            

if __name__ == "__main__":
    main()