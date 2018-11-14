/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.ArrayList;

/**
 *
 * @author PhuongPyke
 */
public class NewClass {

    public static StringBuilder quotesMark(StringBuilder sb) {
        int count = 0; // khởi tạo 1 biến count gán giá trị =0;
        for (int i = 0; i < sb.length(); i++) { //  for vòng lặp  giả sử độ dài 9 
            if (i < sb.length() - 1) { // nếu for đến  thằng thử 8 thì dừng cái điều kiện này và ngược lại nếu i nằm trong khoảng từ 0->8 thì nhảy xuống cái điều kiện dưới
                if (sb.charAt(i) == ' ' && sb.charAt(i + 1) == '\"') { // nếu trong khi for bắt gặp vị trí nào có ' ' (dấu cách)và tại vị trí trước nó tức là i+1 có dấu \ thì ->
                    sb.insert(i + 1, ' '); // thêm dấu ' ' vào vị trí i+1
                }
            }
        }
        for (int i = 0; i < sb.length(); i++) { // for tiếp 
            if (i < sb.length() - 1) { // giống trên
                if (sb.charAt(i) == '\"') { // nếu tại vị trí thứ i  mà  == \ thì count tự động tăng lên 1 giả sử trong cái string đó có 3 cái \ thì count lúc này = 3
                    count++;
                    if (count % 2 != 0) { // tiếp điều kiện . nếu count chia lấy dư (%) cho 2 mà khác 0  tức nó là lẻ -> xóa cái thằng lẻ đó đi 
                        sb.deleteCharAt(i + 1);
                    } else { // còn ngược lại  chia dư cho 2 mà nó ==0 thì nó là chẵn thì xóa cái thằng ở vị trí i-1;
                        sb.deleteCharAt(i - 1);
                    }
                }
            }
        }
        return sb;
    }
}
