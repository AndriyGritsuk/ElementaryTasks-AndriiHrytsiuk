import TriangleSort.Triangle;
import TriangleSort.TriangleCalc;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestTriangleSort {

    @DataProvider(name = "dataForTriangleSort")
    public static Object[][] dataForTesTriangleFromData() {
        return new Object[][]{
                {"1,3,4,5",     "1",    6.0},
                {"2,6,8,10",    "2",    24.0},
                {"3,5,6,5",     "3",    12.0},
                {"4,10,10,12",  "4",    48.0},
                {"5,8,5,5",     "5",    12.0},
                {"6,9,12,15",   "6",    54.0},
                {"7,15,15,24",  "7",    108.0},
                {"8,15,18,15",  "8",    108.0},
                {"9,12,16,20",  "9",    96.0},
                {"10,20,20,24", "10",   192.0}
        };
    }

    @Test (dataProvider = "dataForTriangleSort")
    public void testTriangleFromData (String input, String expectedName, double expectedArea) throws Exception {
        TriangleCalc triangleCalc = new TriangleCalc();
        Triangle actualTriangle = triangleCalc.triangleFromData(input);

        String actualName = actualTriangle.getName();
        double actualArea = actualTriangle.getArea();

        Assert.assertEquals(actualName, expectedName, "Expected " + expectedName + " , but found " + actualName);
        Assert.assertEquals(actualArea, expectedArea, "Expected " + expectedArea + " , but found " + actualArea);
    }

    @DataProvider(name = "wrongDataForTriangle")
    public static Object[][] wrongDataForTriangle() {
        return new Object[][]{
                {""},
                {" "},
                {"1"},
                {"n"},
                {"1,2"},
                {"1,2,3"},
                {"1,2,3,n"},
                {"1,n,3,4"},
                {"1,2,n,4"},
                {"1,2,3,n"},
                {"#,@,),₴,?,$,0"},
        };
    }

    @Test (dataProvider = "wrongDataForTriangle")
    public void testTriangleFromWrongData (String input) throws Exception{
        TriangleCalc triangleCalc = new TriangleCalc();
        Triangle actualTriangle = triangleCalc.triangleFromData(input);

        Assert.assertNull(actualTriangle, "Expected that triangle doesn't exist, but triangle is " + actualTriangle);
    }

    @DataProvider(name = "redundantDataFromUser")
    public static Object[][] redundantDataFromUser() {
        return new Object[][]{
                {"1,2,3,4,5"},
                {"1,2,3,4,5,6"},
                {"1,2,3,4,5,6,7"},
                {"1,2,3,4,5,6,7,8"},
                {"1,2,3,4,n"},
                {"1,2,3,4,5,n"},
                {"1,2,3,4,5,6,n"},
                {"1,2,3,4,5,6,7,n"},
                {"S,O,F,T,S,E,R,V,E"},
        };
    }

    @Test(expectedExceptions = Exception.class, dataProvider = "redundantDataFromUser")
    public void testTriangleFromDataException(String input) throws Exception {
        TriangleCalc triangleCalc = new TriangleCalc();

        triangleCalc.triangleFromData(input);
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testTriangleCalcException() {
        TriangleCalc triangleCalc = new TriangleCalc();
        String [] parts = {"1","2","3","4"};

        triangleCalc.getSideFromString(parts, 10);
    }


    @DataProvider(name = "dataForIsTriangle")
    public static Object[][] dataForIsTriangle() {
        return new Object[][]{
                {3.0,4.0,5.0,       true},
                {6.0,8.0,10.0,      true},
                {12.0,16.0,20.0,    true},
                {5.0,6.0,5.0,       true},
                {20.0,20.0,24.0,    true},
                {1.0,4.0,5.0,       false},
                {3.0,4.0,8.0,       false},
                {2.0,6.0,50.0,      false},
                {3.0,7.0,1.0,       false},
                {0.0,0.0,0.0,       false},
        };
    }

    @Test (dataProvider = "dataForIsTriangle")
    public void testIsTriangle (double sideA, double sideB, double sideC, boolean expectedIsTriangle) {
        TriangleCalc triangleCalc = new TriangleCalc();
        boolean actualIsTriangle = triangleCalc.isTriangle(sideA,sideB,sideC);

        Assert.assertEquals(actualIsTriangle, expectedIsTriangle, "Expected " + expectedIsTriangle + " " +
                ", but found " + actualIsTriangle);
    }
}

