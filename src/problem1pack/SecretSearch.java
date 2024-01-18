package problem1pack;

import static java.lang.Math.pow;

public class SecretSearch implements ISecretSearch{
    private double xA;
    private double yA;
    private double vA;
    private double xB;
    private double yB;
    private double vB;

    public SecretSearch(double[] input) {
        if (input[2] > 0 && input[5] > 0 && input[1] > 0 && input[4] < 0 && input[0] < input[3]){
            this.xA = input[0];
            this.yA = input[1];
            this.vA = input[2];
            this.xB = input[3];
            this.yB = input[4];
            this.vB = input[5];
        }
        else {
            System.out.println("Wrong input");
        }
    }

    @Override
    public double minTimeA() {
        return yA/vA; // tA = sA/vA = yA/vA
    }

    @Override
    public double timeFromA(double xZ) {
        System.out.println("Call D where AD is the perpendicular line to horizontal X shown as problem1.png");
        System.out.print("Calculate ZD = xZ-xD = xZ - xA =");
        double ZD = Math.abs(xZ - xA);
        System.out.println(ZD);
        System.out.println("Regarding Pythagoras, calculate AZ");
        double AZ = Math.sqrt(ZD*ZD + yA*yA); // for yA = AD
        System.out.println();
        return AZ/vA; // t = s/v
    }

    @Override
    public double pointC() {
        System.out.println("Meet at the same time means time of A equals to time of B is t time");
        System.out.println("We have the equation: AC/vA = BC/vB");
        System.out.println("Call E where BE is the perpendicular line to horizontal X shown as problem1.png");
        System.out.println("There will be 2 xC, but choose 1 only");
        double a = pow(vB,2) - pow(vA,2);
        double b = 2*(xB* pow(vA,2)-xA* pow(vB,2));
        double c = -pow((vA*xB),2) - pow((vA*yB),2)+pow((vB*yA),2)+pow((vB*xA),2);
        double delta = pow(b,2) - 4*a*c;
        return (-b+Math.sqrt(delta))/2*a;
    }

    @Override
    public String toString() {
        return "SecretSearch{" +
                "xA=" + xA +
                ", yA=" + yA +
                ", vA=" + vA +
                ", xB=" + xB +
                ", yB=" + yB +
                ", vB=" + vB +
                '}';
    }
}
