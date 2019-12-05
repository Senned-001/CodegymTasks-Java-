package com.codegym.task.task33.task3313;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* 
Serializing a date into JSON

*/
public class Solution {
    public static void main(String[] args) throws JsonProcessingException {
        Event event = new Event("Event #1");

        String result = new ObjectMapper().writeValueAsString(event);

        System.out.println(result);
    }
}