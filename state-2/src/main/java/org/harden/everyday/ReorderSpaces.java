package org.harden.everyday;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：junsenfu
 * @date ：Created in 2022/9/7 9:47
 * 文件说明：1592. 重新排列单词间的空格 </p>
 */
public class ReorderSpaces {

    //"  this   is  a sentence "
    public String reorderSpaces(String text) {

            int count = 0;
            List<String> str = new ArrayList<>();
            int index = 0;
            while (index < text.length()) {
                //计算空格
                if (text.charAt(index) == ' ') {
                    count++;
                    index++;
                } else {
                    StringBuilder dump = new StringBuilder();
                    while (index < text.length()) {
                        if (text.charAt(index) != ' ') {
                            dump.append(text.charAt(index));
                            index++;
                        } else {
                            break;
                        }
                    }
                    str.add(dump.toString());
                }
            }
            StringBuilder bl = new StringBuilder();
            int black = count;
            if (str.size() > 1) {
                black = count / (str.size() - 1);
            }
            for (int i = 0; i < black; i++) {
                bl.append(' ');
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str.size()-1; i++) {
                builder.append(str.get(i));
                builder.append(bl);
            }
            //最后一位
            builder.append(str.get(str.size()-1));
            for(int i=(count-((str.size() - 1)*black));i>0;i--){
                builder.append(' ');
            }
            return builder.toString();
    }


    public static void main(String[] args) {
//        String text= " practice   makes   perfect";
        String text="  this   is  a sentence ";
        ReorderSpaces reorderSpaces = new ReorderSpaces();
        System.out.println(reorderSpaces.reorderSpaces(text));
    }

}
