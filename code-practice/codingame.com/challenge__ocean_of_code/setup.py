import subprocess


def test():
    print('test()')
    print(subprocess.run(['pytest']))


def main():
    print('main()')
    test()


if __name__ == '__main__':
    main()
