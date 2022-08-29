package com.luoxiaobatman.assignment.interview.coding.strikingly.parser;

import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.Token;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DoubleCurlyBracesParserTest {
    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new DoubleCurlyBracesParser();
    }

    @Test
    void tokenize() throws ParseException {
        String template = "My name is {{ name }} and I am forever {{ age }}.";
        Token token = parser.tokenize(template);
        Map<String, Object> values = new HashMap<>();
        values.put("name", "Bill");
        values.put("age", 21);
        String actual = parser.interpolate(token, template, values);
        String expected = "My name is Bill and I am forever 21.";
        assertEquals(expected, actual);
    }

    @Test
    void tokenizeCase2() throws ParseException {
        String template = "Say hello to {{ name }}. He is {{ age }}.";
        Token token = parser.tokenize(template);
        Map<String, Object> values = new HashMap<>();
        values.put("name", "Bill");
        values.put("age", 21);
        values.put("male", true);
        String actual = parser.interpolate(token, template, values);
        String expected = "Say hello to Bill. He is 21.";
        assertEquals(expected, actual);
    }

    @Test
    void tokenizeCase3() throws ParseException {
        String template = "Tommy is a good friend of {{ name }}. He lives in {{ city }}.";
        Token token = parser.tokenize(template);
        Map<String, Object> values = new HashMap<>();
        values.put("name", "Bill");
        assertThrows(ParseException.class, () -> parser.interpolate(token, template, values));
    }
}