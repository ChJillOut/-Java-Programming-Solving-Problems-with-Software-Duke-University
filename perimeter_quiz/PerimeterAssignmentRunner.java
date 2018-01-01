import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public int getNumPoints (Shape s) {
        // Put code here
        int totalPt = 0;
        for (Point currPt: s.getPoints()){
            totalPt = totalPt + 1;
        }
        return totalPt;
    }

        public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        int totalPtRes = getNumPoints(s);
        double avgLengthRes = getAverageLength(s);
        double LargestSideRes = getLargestSide(s);
        double LargestXRes = getLargestX(s);
        System.out.println("Total points = " + totalPtRes);
        System.out.println("Average length = " + avgLengthRes);
        System.out.println("The largest side = " + LargestSideRes);
        System.out.println("The largest X = " + LargestXRes);
    }
    
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double LargestSide = 0;
       for (Point currPt : s.getPoints()) {
           double currDist = prevPt.distance(currPt);
           if (currDist > LargestSide) {
               LargestSide = currDist;
               prevPt = currPt;
            }
            else {
                prevPt = currPt;
            }
        }
        return LargestSide;
    }
    
    public double getAverageLength(Shape s) {
        // Put code here
        double avgLength = getPerimeter(s)/getNumPoints(s);
        return avgLength;
    }
    
    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double LargestX = 0;
       for (Point currPt : s.getPoints()) {
           double currX = prevPt.getX();
           if (currX > LargestX) {
               LargestX = currX;
               prevPt = currPt;
            }
            else {
                prevPt = currPt;
            }
        }
        return LargestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double LargestPeri = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             Shape s = new Shape(fr);
             double currPeri = getPerimeter(s);
             if (currPeri > LargestPeri) {
                LargestPeri = currPeri;
            }
        }
        return LargestPeri;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double LargestPeri = 0;
        File Largestfile = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             Shape s = new Shape(fr);
             double currPeri = getPerimeter(s);
             if (currPeri > LargestPeri) {
                LargestPeri = currPeri;
                Largestfile = f;
            }
        }
        return Largestfile.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        double LargestPeriRes = getLargestPerimeterMultipleFiles();
        System.out.println("The largest perimeter of all shapes = "+ LargestPeriRes);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String LargestfileRes = getFileWithLargestPerimeter();
        System.out.println("File that has the largest such perimeter = " + LargestfileRes);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }
    

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
