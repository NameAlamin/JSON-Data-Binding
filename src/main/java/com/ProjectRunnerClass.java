package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ProjectRunnerClass {
    public static void main(String[] args) {
        try{
            // create ObjectMapper class this class provide jackson dependency
            ObjectMapper mapper = new ObjectMapper();

            // read json file and convert to java POJO
            Student student1 = mapper.readValue(new File("data/sample-lite.json"),Student.class);

            // now print individual item
            System.out.println("Id = "+student1.getId());
            System.out.println("FirstName = "+student1.getFirstName());
            System.out.println("LastName = "+student1.getLastName());
            System.out.println("Active = "+student1.active);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
