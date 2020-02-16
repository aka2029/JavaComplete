/*	https://www.hackerrank.com/challenges/java-loops/problem	*/

import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            for(int k = 0, l = 0, m = 0; k < n; k++){
                
                while(l<=k){
                m = m + (int)Math.pow(2,l)*b;
                l++;
                }

                int o = a+m;
                System.out.print(o);
                System.out.print(" ");
            }
            System.out.print('\n');
        }
        in.close();
    }
}

/* BETTER

for(int j=0;j<n;j++){
                a+=b;
                if(j>0)
                System.out.print(" ");
                System.out.print(a);

                b=b*2;
            }

*/