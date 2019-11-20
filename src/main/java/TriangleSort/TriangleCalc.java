package TriangleSort;

import org.apache.log4j.Logger;

public class TriangleCalc {
    private static final Logger logger = Logger.getLogger(TriangleCalc.class);

    public Triangle triangleFromData(String dataFromUser) throws Exception {
        try {
            String[] parts = dataFromUser.split(",");
            if (parts.length > 4) throw new Exception();        //Validation for data which are more 4 symbols
            String name = getNameFromString(parts);
            double sideA = getSideFromString(parts, 1);
            double sideB = getSideFromString(parts, 2);
            double sideC = getSideFromString(parts, 3);
            if (isTriangle(sideA, sideB, sideC)) {        //Calculate the area by Heron's theorem when a triangle exists
                double halfPerimeter = (sideA + sideB + sideC) / 2;
                double area = Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
                area = Math.round(area * 100) / 100.0d;
                return new Triangle(name, area);
            } else {
                return null;
            }
        } catch (IllegalArgumentException iaex) {
            logger.info("You've entered wrong data.");
            return null;
        } catch (ArrayIndexOutOfBoundsException aibex) {
            logger.info("Entered data aren't enough.");
            return null;
        }
    }

    private String getNameFromString(String[] parts) {
        return parts[0];
    }

    public double getSideFromString(String[] parts, int i) {
        return Double.parseDouble(parts[i]);
    }

    public boolean isTriangle(double sideA, double sideB, double sideC) {   //Checking the existence of triangle
        if ((sideA + sideB) > sideC && Math.abs(sideA - sideB) < sideC) {
            return true;
        } else {
            logger.info("There is no triangle with the specified parameters");
            return false;
        }
    }
}
