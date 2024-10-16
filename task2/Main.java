package org.example;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        File file1 = new File(args[0]);

        File file2 = new File(args[1]);

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String[] center = (reader.readLine().split(" "));
        double x0 = Double.valueOf(center[0]);
        double y0 = Double.valueOf(center[1]);
        double rS = Math.pow(Double.valueOf(reader.readLine()), 2);
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        String point;

        while ((point = reader2.readLine()) != null)
        {
            String[] pointS = point.split(" ");
            double x1 = Double.valueOf(pointS[0]);
            double y1 = Double.valueOf(pointS[1]);
            if (Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2) == rS)
                System.out.println(0);
            if (Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2) > rS)
                System.out.println(2);
            if (Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2) < rS)
                System.out.println(1);
        }

    }
}
