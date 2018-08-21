package com;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class IntegrationTest {

    private static final Logger LOGGER = getLogger(IntegrationTest.class);

    @Test
    public void case1() throws Exception {
        System.out.println(System.getProperty("user.dir"));

//        String path = "src/test/packages/com/res.txt";

        String path = "src/test/packages/com/res.txt";

        InputStream inputStream = new FileInputStream(path);
        Assert.assertEquals(inputStream, "hello");
    }

    @Test
    public void case2() {
        String path = "res.txt";
        File file = new File(path);
//        InputStream resource = this.getClass().getClassLoader().getResourceAsStream("res.txt");

        URL resource = IntegrationTest.class.getClassLoader().getResource(path);
        System.out.println(resource);
        if (resource != null) {
            try {
                LOGGER.info("Resolving the file path to {}" , resource.toURI());
                file = new File(resource.toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void case3() {
        String path = "res.txt";
        File file = new File(path);
        InputStream resource = this.getClass().getClassLoader().getResourceAsStream("res.txt");

        System.out.println(resource);
//        if (resource != null) {
//            try {
//                LOGGER.info("Resolving the file path to {}" , resource.toURI());
//                file = new File(resource.toURI());
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
//        }
    }
}