package com.asu.ser.util;

import java.io.File;
import java.net.URL;
/**
 * @author akhilesh
 */

public class Util {

    /**
     * Returns a file instance for the given file name
     * @return
     */
	public static File getFileFromResources(String fileName) {
		ClassLoader classLoader = new Util().getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
	}

}
