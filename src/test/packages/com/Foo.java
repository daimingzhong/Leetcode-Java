package com;

import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Foo {

    public static void main(String[] args) {
        String path = "res.txt";
        String path2 = "test/packages/com/res.txt";
        File file = new File(path);

        URL resource = Foo.class.getResource(path);

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