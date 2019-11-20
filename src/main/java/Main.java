/*
General requirements
1. When transferring incorrect parameters for execution, the application should not
shut down the job.
2. Starting without parameters displays instructions for using the program.
3. Parameters are transferred in the order given in the job description.

1. Palindrome
Check if the number or part of it is a palindrome.
For example, the number 1234437 it is not a palindrome, but its part 3443 is a palindrome.
Numbers smaller than 10 not to be considered a palindrome.
Input Parameters: Number
Output: extracted from the palindrome, or 0 if the extraction failed.

2. Triangle Sort
Develop a console program that draws triangles in descending order their area.
After adding each new triangle, the program asks if it wants to user add one more.
If the user answers “y” or “yes” (case insensitive), the program will ask you to enter data for another triangle,
otherwise it displays result to the console.
• The calculation of the area of the triangle should be done according to the Heron formula.
• Each triangle is defined by its name and the lengths of its sides.
    Input format (separator - comma):
            <name>, <side length>, <side length>, <side length>
• The application must handle floating-point input.
• Input must be case insensitive, spaces, tabs.
• The output should be the following example:
============= Triangles list: ===============
1. [Triangle first]: 17.23 сm
2. [Triangle 22]: 13 cm
3. [Triangle 1]: 1.5 cm
*/

public class Main {

    public static void main(String[] args) throws Exception {

        String answer;
        String taskNumber;

        ServiceClass printMassage = new ServiceClass();

        do {
            taskNumber = printMassage.messageSelectTask();

            if (taskNumber.equals("1")) {
                RunTaskPalindrome runPalindrome = new RunTaskPalindrome();
                runPalindrome.runTask();

            } else if (taskNumber.equals("2")) {
                RunTaskTriangleSort runTriangleSort = new RunTaskTriangleSort();
                runTriangleSort.runTask();

            } else {
                printMassage.messageIncorrectTask();
                printMassage.messageSelectTask();
            }

            answer = printMassage.messageAnyTask();
        } while (answer.equals("y") || answer.equals("yes"));
    }
}
