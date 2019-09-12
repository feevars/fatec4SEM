def menu(op):
    if op == 1:
        ex01()
    elif op == 2:
        ex02()
    elif op == 3:
        ex03()
    elif op == 4:
        ex04()
    elif op == 5:
        ex05()
    else:
        print("Opção inválida.")


def ex01():
    print("\nExercício 1\nCálculo de área de retângulo:")
    a = float(input("Digite o tamanho do primeiro lado: "))
    b = float(input("Digite o tamanho do segundo lado: "))
    area = float(a * b)
    print("A área do retângulo é de ", area, "m²")


def ex02():
    print("\nExercício 2:\nReceba o salário de um funcionário e mostre o novo salário com reajuste de 15%.")
    salario = float(input("Digite o valor do salário: R$ "))
    salario += salario * 0.15
    print("O salário com reajuste é R$", salario)


def ex03():
    print("\nExercício 3:\nReceba a base e a altura de um triângulo. Calcule e mostre a sua área.")
    base = float(input("Digite o valor da base do triângulo: "))
    altura = float(input("Digite o valor da altura do triângulo: "))
    area = (base * altura) / 2
    print("A área do triângulo é de ", area, "m²")

def ex04():
    print("\nExercício 4:\nReceba a temperatura em graus Celsius. Calcule e mostre a sua temperatura convertida em "
          "Fahrenheit F = (9*C+160)/5.")
    c = float(input("Digite a temperatura em graus Celcius: "))
    f = (9 * c + 160) / 5
    print(c, "° Celsius é igual a", f, "° Fahrenheit.")


def ex05():
    print("\nExercício 5:\nReceba os coeficientes A, B e C de uma equação do 2º grau (AX²+BX+C=0). Calcule e mostre "
          "as raízes reais (considerar que a equação possui 2 raízes).")
    a = float(input("Digite um valor para A: "))
    b = float(input("Digite um valor para B: "))
    c = float(input("Digite um valor para C: "))
    delta = (b ** 2) - (4 * a * c)
    if delta < 0:
        print("\nA equação", a, "² + ", b, " + ", c, " não possui resultados reais: delta negativo.\nDelta = ", delta)
    elif delta == 0:
        r1 = (- b) / 2 * a
        print("\nA equação", a, "² + ", b, " + ", c, " é igual a ", r1, ".\nPossui apenas um resultado, ou dois resultados iguais, pois o delta é igual a zero.")
    elif delta > 0:
        r1 = ((-b)+(delta ** (1/2)))/(2*a)
        r2 = ((-b)-(delta ** (1/2)))/(2*a)
        print("\nA equação", a, "² + ", b, " + ", c, "possui dois resultados reais.\nr1 = ", r1, "\nr2 = ", r2)

