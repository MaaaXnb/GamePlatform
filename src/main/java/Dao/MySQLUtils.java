package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;
public class MySQLUtils {
    private static final String INSTANCE = "us-cdbr-east-04.cleardb.com";
    private static final String PORT_NUM = "3306";
    private static final String DB_NAME = "heroku_8f284e9fa0bc4a5";
    public static String getMySQLAddress() throws IOException {
        Properties prop = new Properties();
        String propFileName = "application.properties";


        InputStream inputStream = MySQLUtils.class.getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);


        String username = prop.getProperty("user");
        String password = prop.getProperty("password");
        // Encode special characters in your password.
        try {
            password = URLEncoder.encode(password, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&autoReconnect=true&serverTimezone=UTC&createDatabaseIfNotExist=true",
                INSTANCE, PORT_NUM, DB_NAME, username, password);
    }

}