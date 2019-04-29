package org.sysone.service;

import org.springframework.stereotype.Component;

@Component
public class SysOneCompressorService {

    public String compress(String valueToCompress) {

        if(valueToCompress.isEmpty()) return "";
        if(valueToCompress.length() == 1) return "1" + valueToCompress.toUpperCase();

        String input = valueToCompress.toUpperCase();
        char[] charArray = input.toCharArray();
        char tempLetter = charArray[0];
        int count = 1;
        StringBuffer compressed = new StringBuffer();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == tempLetter) {
                count++;
                if(i == charArray.length - 1){
                    compressed.append(count + String.valueOf(tempLetter));
                }
            }else{
                compressed.append(count + String.valueOf(tempLetter));
                count = 1;
                tempLetter = charArray[i];
            }
        }

        return compressed.toString();
    }


}
