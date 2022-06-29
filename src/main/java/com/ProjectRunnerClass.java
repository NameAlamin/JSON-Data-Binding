package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class ProjectRunnerClass {
    public static void main(String[] args) {
        try{
            // ****************************  now convert JSON data to JAVA-POJO  ********************************


            // create ObjectMapper class this class provide jackson dependency
            ObjectMapper mapper = new ObjectMapper();

            // read json file and convert to java POJO
            Student student1 = mapper.readValue(new File("data/sample-full.json"),Student.class);

            // now print individual item
            System.out.println("=========== Print basic information ===========");
            System.out.println("Id = "+student1.getId());
            System.out.println("FirstName = "+student1.getFirstName());
            System.out.println("LastName = "+student1.getLastName());
            System.out.println("Active = "+student1.isActive());

            // now print Address: street and city
            System.out.println("=========== Print Address ===========");
            Address printAddress = student1.getAddress();
            System.out.println("Street = "+printAddress.getStreet());
            System.out.println("City = "+printAddress.getCity());

            //now print languages array
            System.out.println("=========== Print Languages array ===========");
            for (String printLanguage:student1.getLanguages()) {
                System.out.println(printLanguage);
            }


            // ****************************  now convert JAVA-POJO to JSON data  ********************************
            Java_Pojo_to_JSON_Conversion pojo_to_json = new Java_Pojo_to_JSON_Conversion();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File("data/output.json"),pojo_to_json);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
