package hello;

import java.util.Scanner;

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("分母不能为零");
        }

        // 化简分数
        int gcdValue = gcd(Math.abs(a), Math.abs(b));
        this.numerator = a / gcdValue;
        this.denominator = b / gcdValue;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public Fraction plus(Fraction r) {
        int newNumerator = this.numerator * r.denominator + r.numerator * this.denominator;
        int newDenominator = this.denominator * r.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction r) {
        int newNumerator = this.numerator * r.numerator;
        int newDenominator = this.denominator * r.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public void print() {
        if (denominator == 1) {
            System.out.print(numerator);
        } else {
            System.out.print(numerator + "/" + denominator);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 从输入中获取四个数字，分别构成两个分数的分子和分母
        int aNumerator = in.nextInt();
        int aDenominator = in.nextInt();
        int bNumerator = in.nextInt();
        int bDenominator = in.nextInt();

        // 创建两个分数对象
        Fraction a = new Fraction(aNumerator, aDenominator);
        Fraction b = new Fraction(bNumerator, bDenominator);

        // 输出样例中的计算
        Fraction result = a.multiply(b).plus(new Fraction(5, 6));

        // 打印结果，使用空格分隔
        a.print();
        System.out.print("    ");
        b.print();
        System.out.print("    ");
        a.plus(b).print();
        System.out.print("    ");
        a.multiply(b).print();
        System.out.print("    ");
        result.print();
        System.out.print("    ");
        a.print();
        System.out.print("    ");
        b.print();

        in.close();
    }
}

