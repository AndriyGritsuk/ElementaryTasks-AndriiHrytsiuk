import TriangleSort.Triangle;
import TriangleSort.TriangleAreaComparator;
import TriangleSort.TriangleCalc;
import java.util.ArrayList;
import java.util.Comparator;
import org.apache.log4j.Logger;

public class RunTaskTriangleSort implements RunTask {
    private static final Logger logger = Logger.getLogger(RunTaskTriangleSort.class);

    private ServiceClass printMassage = new ServiceClass();

    public void runTask() throws Exception {

        int number = 1;     //The sequence number of the triangle
        String addTriangle;

        Comparator<Triangle> triangleComparator = new TriangleAreaComparator().thenComparing(new TriangleAreaComparator());
        ArrayList<Triangle> listOfTriangles = new ArrayList<>();
        TriangleCalc triangleCalc = new TriangleCalc();

        do {
        String dataFromUser = printMassage.messageSetTriangle();
        Triangle triangle = triangleCalc.triangleFromData(dataFromUser);    //Create Triangle with fields name and area
        if (triangle != null) {
            listOfTriangles.add(triangle);      //Add Triangle to the ArrayList if user has entered valid data
        }
            addTriangle = printMassage.messageAddTriangle();    //Ask does the user want add new Triangle
        } while (addTriangle.equals("y") || addTriangle.equals("yes"));

        printMassage.messageTriangleList();
        listOfTriangles.sort(triangleComparator);   //Sort list of Triangles
        for (Triangle counter : listOfTriangles) {      //Print result in console
            logger.info(number + ". [Triangle " + counter.getName() + "]: " + counter.getArea() + " cm");
            number++;
        }
    }
}
