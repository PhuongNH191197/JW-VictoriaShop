/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author PhuongPyke
 */
public class FormatDate {

    public static String chuanHoaDanhTuRieng(String str) {
        String temp[] = str.split("-");
        str = ""; // ? ^-^
        for (String s : temp) {
            str += String.valueOf(s.charAt(temp.length - 1));

        }
        return str;
    }

    public static void main(String[] args) {
        String test = chuanHoaDanhTuRieng("2018-11-07");
        System.out.println(test);
    }
}
