package com.luoxiaobatman.assignment.interview.coding.strikingly;

import com.luoxiaobatman.assignment.interview.coding.strikingly.parser.DoubleCurlyBracesParser;
import com.luoxiaobatman.assignment.interview.coding.strikingly.parser.ParseException;
import com.luoxiaobatman.assignment.interview.coding.strikingly.parser.Parser;
import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.Token;

import java.util.HashMap;
import java.util.Map;


public class StringInterpolation {
    public static void main(String[] args) throws ParseException {
        Parser parser = new DoubleCurlyBracesParser();

        String template = "foobarbaz {{ name }} {{addr}}";
        Token tokenize = parser.tokenize(template);
        Map<String, Object> values = new HashMap<>();
        values.put("name", "joe");
        values.put("addr", 21);
        String interpolate = parser.interpolate(tokenize, template, values);
        System.out.println(interpolate);
    }
}
