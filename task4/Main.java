package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
List<Integer> numsList = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String num;
        while ((num = reader.readLine()) != null)
        {
            numsList.add(Integer.valueOf(num));
        }
        Integer[] nums = new Integer [numsList.size()];
        numsList.toArray(nums);
        Arrays.sort(nums);
        int len = nums.length;
        int med = 0;
        int res = 0;
        if (len % 2 == 1) {
            med = nums[len / 2];
        } else {
            med = (nums[len / 2 - 1] + nums[len / 2]) / 2;
        }
        for (int n : nums)
            res += Math.abs(med - n);
        System.out.println(res);
    }
}