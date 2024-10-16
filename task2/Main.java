package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        int m = Integer.valueOf(args[1]);
        int f = 1;
        do {
            System.out.print(f);
            f = (f + (m - 2)) % n + 1;
        } while (f != 1);
    }
}