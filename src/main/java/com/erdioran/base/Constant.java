package com.erdioran.base;

import java.nio.file.Paths;

public class Constant {
    public static final String PARENT_DIR = System.getProperty("user.dir");
    public static final String TARGET_DIR = Paths.get(System.getProperty("user.dir"), "target").toString();
}
