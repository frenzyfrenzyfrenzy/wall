package com.svintsov.vk.utility;

import android.support.annotation.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    @Nullable
    public static String removeNumberOfPosts(String in) {
        String patternStringBig = "^\\{\"response\":\\[\\d+,\\{";
        Pattern patternBig = Pattern.compile(patternStringBig);
        Matcher matcherBig = patternBig.matcher(in);
        if (matcherBig.find()) {
            String patternStringSmall = "\\d+";
            Pattern patternSmall = Pattern.compile(patternStringSmall);
            Matcher matcherSmall = patternSmall.matcher(matcherBig.group());
            matcherSmall.find();

            StringBuffer inBuffer = new StringBuffer(in);
            inBuffer.replace(matcherBig.start() + matcherSmall.start(), matcherBig.end() - 1, "");
            return inBuffer.toString();
        }
        else return null;
    }
}
