import java.util.function.DoubleUnaryOperator;
import static java.lang.Math.*;
import java.util.ArrayList;
/**
 * Created by Сергей on 20.04.2017.
 */
public class Int {
    public static void compute (double A, double B, int m, DoubleUnaryOperator f, DoubleUnaryOperator Intf) {
        double J = Intf.applyAsDouble(B) - Intf.applyAsDouble(A);
        System.out.println("J = " + J +" - точное значение интеграла \n");
        double h = (B-A)/m;
        ArrayList<Double> Z = new ArrayList<>();
        for (int k = 0; k <= m; k++) {
            Z.add(A+k*h);
        }
        LeftRect(h, Z, m, f, J);
        RightRect(h, Z, m, f, J);
        MiddleRect(h, Z, m, f, J);
        Trapezium(h, Z, m, f, J);
        Simpson(h, Z, m, f, J);
        Report(f, A, B, h, m);
    }

    public static void LeftRect(double h, ArrayList<Double> Z, int m, DoubleUnaryOperator f, double J) {
        System.out.println("Формула левых прямоугольников");
        double LeftRect = 0;
        for (int k = 0; k <= m-1; k++) {
            LeftRect += h*f.applyAsDouble(Z.get(k));
        }
        System.out.println("Jh = " + LeftRect + " - приближенное значение интеграла");
        System.out.println(abs(J - LeftRect) + " - абсолютная фактическая погрешность \n");
    }

    public static void RightRect(double h, ArrayList<Double> Z, int m, DoubleUnaryOperator f, double J) {
        System.out.println("Формула правых прямоугольников");
        double RightRect = 0;
        for (int k = 0; k <= m-1; k++) {
            RightRect += h*f.applyAsDouble(Z.get(k+1));
        }
        System.out.println("Jh = " + RightRect + " - приближенное значение интеграла");
        System.out.println(abs(J - RightRect) + " - абсолютная фактическая погрешность \n");
    }

    public static void MiddleRect(double h, ArrayList<Double> Z, int m, DoubleUnaryOperator f, double J) {
        System.out.println("Формула средних прямоугольников");
        double MiddleRect = 0;
        for (int k = 0; k <= m - 1; k++) {
            MiddleRect += h * f.applyAsDouble((Z.get(k) + Z.get(k+1))/2);
        }
        System.out.println("Jh = " + MiddleRect + " - приближенное значение интеграла");
        System.out.println(abs(J - MiddleRect) + " - абсолютная фактическая погрешность \n");
    }

    public static void Trapezium(double h, ArrayList<Double> Z, int m, DoubleUnaryOperator f, double J) {
        System.out.println("Формула трапеций");
        double Trapezium = 0;
        for (int k = 0; k <= m - 1; k++) {
            Trapezium += h / 2 * (f.applyAsDouble(Z.get(k)) + f.applyAsDouble(Z.get(k + 1)));
        }
        System.out.println("Jh = " + Trapezium + " - приближенное значение интеграла");
        System.out.println(abs(J - Trapezium) + " - абсолютная фактическая погрешность \n");
    }

    public static void Simpson(double h, ArrayList<Double> Z, int m, DoubleUnaryOperator f, double J) {
        System.out.println("Формула Симпсона");
        double Simpson = h / 6 * (f.applyAsDouble(Z.get(0)) + 4*f.applyAsDouble((Z.get(0) + Z.get(1))/2) + f.applyAsDouble(Z.get(1)));
        for (int k = 1; k <= m - 1; k++) {
            Simpson += h / 6 * (f.applyAsDouble(Z.get(k)) + 4*f.applyAsDouble((Z.get(k) + Z.get(k+1))/2) + f.applyAsDouble(Z.get(k+1)));
        }
        System.out.println("Jh = " + Simpson + " - приближенное значение интеграла");
        System.out.println(abs(J - Simpson) + " - абсолютная фактическая погрешность \n");
    }

    public static void Report(DoubleUnaryOperator f, double A, double B, double h, int m) {
        System.out.println("A = " + A + ", B = " + B + ", m = " + m);
        System.out.print("Квадратурные формулы");
        System.out.print("         ");
        System.out.print("Функция");
        System.out.print("        ");
        System.out.print("Теоретическая погрешность \n");
        System.out.print("Левых прямоугольников");
        System.out.print("         ");
        System.out.print("exp(x)");
        System.out.print("        ");
        System.out.print(exp(B)/2 * (B-A)* h + "\n");
        System.out.print("Правых прямоугольников");
        System.out.print("        ");
        System.out.print("exp(x)");
        System.out.print("        ");
        System.out.print(exp(B)/2 * (B-A) * h + "\n");
        System.out.print("Средних прямоугольников");
        System.out.print("       ");
        System.out.print("exp(x)");
        System.out.print("        ");
        System.out.print(exp(B)/24 *(B-A)* pow(h, 2) + "\n");
        System.out.print("Трапеций");
        System.out.print("                      ");
        System.out.print("exp(x)");
        System.out.print("        ");
        System.out.print(exp(B)/12 *(B-A)* pow(h, 2) + "\n");
        System.out.print("Симпсона");
        System.out.print("                      ");
        System.out.print("exp(x)");
        System.out.print("        ");
        System.out.print(exp(B)/2880 *(B-A)* pow(h, 4) + "\n");
    }


}
