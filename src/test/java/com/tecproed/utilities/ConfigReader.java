package com.tecproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

//the purpose of this class is to read the data in the configuration.properties
//file!!

//creating a Properties instance!!
    static Properties properties;

//we are opening a file, by using FileInputStream!!
//we are loading the properties in that file!!
//then we read prpperties!!
//creating static block to initialize!!
    static {
//what is static word? where did you use static block?
//it is kind a initializer!!

    String path="configuration.properties";
        try {
//to open a file, we use FileInputStream!!
            FileInputStream fileInputStream=new FileInputStream(path);

            properties =new Properties();// we are initializing the
//properties file!!

            properties.load(fileInputStream);//loading file!!
            fileInputStream.close();//closing the file!!

        } catch (Exception e) {
            System.out.println("path is not found!!");
            e.printStackTrace();
        }
    }

//we are creating static method to read!!
//this method will return the value, When user enter the key!!
//
    public static String getProperties(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(properties.getProperty("fhc_login_url"));
//fhc_login_url=http://www.fhctrip.com/Account/Logon
    }
}
