import java.util.Scanner;
import org.apache.log4j.Logger;

class ServiceClass {
    private static final Logger logger = Logger.getLogger(ServiceClass.class);

    private Scanner scan = new Scanner(System.in);

    String messageSelectTask(){
        logger.info("Select the task you would like to solve:" + "\n" +
                "1. Palindrome." + "\n" +
                "2. Triangle sort.");
        return scan.nextLine();
    }

    void messageIncorrectTask() {
        logger.info("You've entered an incorrect task number.");
    }

    String messageAnyTask(){
        logger.info("Do you want select any task?");
        return scan.nextLine().toLowerCase();
    }

    String messageEnterTheNumber (){
        logger.info("Enter the number, please:");
        return scan.nextLine();
    }

    void messageTriangleList() {
        logger.info("============= Triangles list: ===============");
    }

    String messageSetTriangle() {
        logger.info("Set the triangle in the following format:" + "\n"
                + "<name>, <side length>, " + "<side length>, <side length>");
        return scan.nextLine();
    }

    String messageAddTriangle() {
        logger.info("Add another triangle?");
        return scan.nextLine().toLowerCase();
    }
}
