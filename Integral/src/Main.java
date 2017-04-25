import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import static java.lang.Math.*;
/**
 * Created by Сергей on 20.04.2017.
 */
public class Main {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Приближенное вычисление интеграла по составным квадратурным формулам \n");
        System.out.print("Нижний предел интегрирования A = ");
        double A = in.nextDouble();
        System.out.print("Верхний предел интегрирования B = ");
        double B = in.nextDouble();
        System.out.print("Число промежутков деления [" + A +"," + B + "] в составной квадратичной фомрмуле m = ");
        int m = in.nextInt();
        DoubleUnaryOperator f = x -> exp(x);
        DoubleUnaryOperator Intf = x -> exp(x);
        Int.compute(A, B, m, f, Intf);
    }
}
