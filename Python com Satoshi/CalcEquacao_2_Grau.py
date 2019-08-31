import math

a = input("Digite o valor de a: ")
b = input("Digite o valor de b: ")
c = input("Digite o valor de c: ")

def bhaskara (self, a,b,c):
    self.a = a
    self.b = b
    self.c = c

    delta = math.sqrt(b) - (4 * a * c)

    if delta < 0:
        print("A equação não possui raízes reais")
    elif delta == 0:
        raiz = -b / (2 * a)
        print(raiz)
    else:
        raiz = (-1 * b + math.sqrt(delta)) / (2*a)
        print(raiz)
        raiz = (-1 * b - math.sqrt(delta)) / (2*a)
        print(raiz)