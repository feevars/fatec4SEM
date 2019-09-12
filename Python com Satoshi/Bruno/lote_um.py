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
    elif op == 6:
        ex06()
    elif op == 7:
        ex07()
    elif op == 8:
        ex08()
    elif op == 9:
        ex09()
    elif op == 10:
        ex10()
    elif op == 11:
        ex11()
    elif op == 12:
        ex12()
    elif op == 13:
        ex13()
    elif op == 14:
        ex14()
    elif op == 15:
        ex15()
    elif op == 16:
        ex16()
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
        print("\nA equação", a, "²+", b, "+", c, "não possui resultados reais: delta negativo.\nDelta = ", delta)
    elif delta == 0:
        r1 = (- b) / 2 * a
        print("\nA equação", a, "² +", b, "+", c, "é igual a ", r1, ".\nPossui apenas um resultado, ou dois resultados iguais, pois o delta é igual a zero.")
    elif delta > 0:
        r1 = ((-b)+(delta ** (1/2)))/(2*a)
        r2 = ((-b)-(delta ** (1/2)))/(2*a)
        print("\nA equação", a, "² +", b, "+", c, "possui dois resultados reais.\nr1 = ", r1, "\nr2 = ", r2)


def ex06():
    print("\nExercício 6:\nReceba os valores em x e y. Efetua a troca de seus valores e mostre seus conteúdos.")
    x = float(input("Digite um valor para x: "))
    y = float(input("Digite um valor para y: "))
    aux = y
    y = x
    x = aux
    print("Após a troca o valor de x é", x, "e o valor de y é", y)


def ex07():
    print("\nExercício 7:\nReceba os valores do comprimento, largura e altura de um paralelepípedo.\nCalcule e mostre "
          "seu volume.")
    x = float(input("Digite o valor do comprimento em cm: "))
    y = float(input("Digite o valor da largura em cm: "))
    z = float(input("Digite o valor da altura em cm: "))
    volume = x * y * z
    print("O volume do paralelepípedo é de", volume, "cm³")


def ex08():
    print("\nExercício 8:\nReceba o valor de um depósito em poupança. Calcule e mostre o valor após 1 mês de "
          "aplicação, sabendo que rende 1,3% ao mês.")
    deposito = float(input("Digite o valor do depósito: R$ "))
    deposito += deposito * 0.013
    print("Após um mês, o saldo será de: R$", deposito)


def ex09():
    print("\nExercício 9:\nReceba os 2 números inteiros. Calcule e mostre a soma dos quadrados.")
    a = int(input("Digite o primeiro número inteiro: "))
    b = int(input("Digite o segundo número inteiro: "))
    somaquad = (a ** 2) + (b ** 2)
    print("A soma dos quadrados é:", somaquad)


def ex10():
    print("\nExercício 10:\nReceba 2 números reais. Calcule e mostre a diferença desses valores.")
    a = float(input("Digite o primeiro número real: "))
    b = float(input("Digite o segundo número real: "))
    dif = a - b
    print(a, "-", b, "=", dif)


def ex11():
    print("\nExercício 11:\nReceba o raio de uma circunferência. Calcule e mostre o comprimento da circunferência.")
    raio = float(input("Digite o valor do raio da circunferência: "))
    comprimento = 2 * 3.14 * raio
    print("O comprimento da circunferência é de ", comprimento)


def ex12():
    print("\nExercício 12:\nReceba o ano de nascimento e o ano atual. Calcule e mostre a sua idade e quantos anos "
          "terá daqui a 17 anos.")
    anoNasc = int(input("Digite o ano de nascimento: "))
    anoAtual = int(input("Digite o ano atual: "))
    if anoAtual < anoNasc:
        print("O ano atual não pode ser menor que o ano de nascimento.")
    else:
        idade = anoAtual - anoNasc
        i17 = idade + 17
        print("A idade é", idade, "e após 17 anos terá", i17, "anos.")


def ex13():
    print("\nExercício 13:\nReceba a quantidade de alimento em quilos. Calcule e mostre quantos dias durará esse "
          "alimento sabendo que a pessoa consome 50g ao dia.")
    alimento = float(input("Digite a quantidade de alimento em Kg: "))
    dias = alimento / 0.050
    print("O alimento deve durar ", dias, "dias.")


def ex14():
    print("\nExercício 14:\nReceba 2 ângulos de um triângulo. Calcule e mostre o valor do 3º ângulo.")
    a1 = float(input("Digite o valor do primeiro ângulo: "))
    a2 = float(input("Digite o valor do segundo ângulo "))
    if (a1 + a2 >= 180) | (a1 <= 0) | (a2 <= 0):
        print("É impossível formar um triângulo com os valores inseridos.")
    else:
        a3 = float(180 - a1 - a2)
        print("O terceiro ângulo do triângulo será ", a3, "°")


def ex15():
    print("\nExercício 15:\nReceba os valores de 2 catetos de um triângulo retângulo. Calcule e mostre a hipotenusa.")
    c1 = float(input("Digite o valor do primeiro cateto: "))
    c2 = float(input("Digite o valor do segundo cateto: "))
    hip = ((c1 ** 2) + (c2 ** 2)) ** (1/2)
    print("O valor da hipotenusa é ", hip)


def ex16():
    print("\nExercício 16:\nReceba a quantidade de horas trabalhadas, o valor por hora, o percentual de desconto e o "
          "número de descendentes. Calcule o salário que serão as horas trabalhadas x o valor por hora. Calcule o "
          "salário líquido (= Salário Bruto – desconto). A cada dependente será acrescido R$ 100 no Salário Líquido. "
          "Exiba o salário a receber.")
