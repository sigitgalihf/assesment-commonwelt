package com.testbankcommonwelt.assesment;

import java.util.Scanner;

public class SoalNo1 {
    public static void main(String[] args) {
        int i,j,k, pagar;
        boolean replay=true;

        Scanner scan = new Scanner(System.in);

        while (replay){
            System.out.print("input number ? ");
            pagar = scan.nextInt();

            i=1;
            while(i<=pagar){
                k=pagar;

                while(k>i){
                    System.out.print(" ");
                    k--;
                }

                j=1;
                while(j<=i){
                    System.out.print("#");
                    j++;
                }

                i++;
                System.out.println();
            }
        }
    }
}
