import math

a = input("Digite o valor de a: ")
b = input("Digite o valor de b: ")
c = input("Digite o valor de c: ")

def bhaskara (a,b,c):
    delta = math.sqrt(b) - (4 * a * c)

    if delta < 0:
        print("A equação não possui raízes reais")
    elif delta == 0:

    else:
        bhask = -b