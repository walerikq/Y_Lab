package com.company.ThirdLesson.TransliteratorPack;

import com.company.ThirdLesson.TransliteratorPack.Transliterator;

import java.util.HashMap;

public class TransliteratorImpl implements Transliterator {

    private final HashMap<String, String> transliterateMap = new HashMap<>() {{
        put("А", "A");
        put("Б", "B");
        put("В", "V");
        put("Г", "G");
        put("Д", "D");
        put("Е", "E");
        put("Ё", "E");
        put("Ж", "ZH");
        put("З", "Z");
        put("И", "I");
        put("Й", "I");
        put("К", "K");
        put("Л", "L");
        put("М", "M");
        put("Н", "N");
        put("О", "O");
        put("П", "P");
        put("Р", "R");
        put("С", "S");
        put("Т", "T");
        put("У", "U");
        put("Ф", "F");
        put("Х", "KH");
        put("Ц", "TS");
        put("Ч", "CH");
        put("Ш", "SH");
        put("Щ", "SHCH");
        put("Ы", "Y");
        put("Ь", "");
        put("Ъ", "IE");
        put("Э", "E");
        put("Ю", "IU");
        put("Я", "IA");

    }};

    @Override
    public String transliterate(String source) {
        char[] charMass = source.toCharArray();
        String res = "";
        for (int i = 0; i < charMass.length; i++) {
            String num = String.valueOf(charMass[i]);

            if (Character.isUpperCase(charMass[i]) && transliterateMap.containsKey(num)) {
                res = res + transliterateMap.get(num).toUpperCase();
            } else if (Character.isLowerCase(charMass[i]) && transliterateMap.containsKey(num.toUpperCase())) {
                res = res + transliterateMap.get(num.toUpperCase()).toLowerCase();
            } else {
                res = res + num;
            }

        }
        return res;
    }


}
