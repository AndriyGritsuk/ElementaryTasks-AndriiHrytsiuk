package TriangleSort;

import java.util.Comparator;

public class TriangleAreaComparator implements Comparator<Triangle> {

    public int compare(Triangle firstTriangle, Triangle secondTriangle){

        return Double.compare(firstTriangle.getArea(), secondTriangle.getArea());
    }
}