/*	https://www.hackerrank.com/challenges/java-end-of-file/problem	*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner Scan = new Scanner(System.in);

        int i = 0; 

        while(Scan.hasNext()){
            String sg = Scan.nextLine();
            System.out.println(++i + " " + sg);
        }
    }
}