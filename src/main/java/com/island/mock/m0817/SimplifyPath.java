package com.island.mock.m0817;

public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
        String result = simplifyPath(path);
        System.out.println(result);
    }

    public static String simplifyPath(String path) {
        String[] splitedPath = path.split("/");
        int i = 0;
        String[] allPath = new String[splitedPath.length];
        if (allPath == null || allPath.length == 0) {
            return "/";
        }

        int j = 0;
        allPath[j] = splitedPath[0];
        String result = "";

        for (i = 1; i < splitedPath.length; i++) {
            if (splitedPath[i] == "/") {

            } else if (splitedPath[i].equals(".")) {

            } else if (splitedPath[i].trim().equals("")) {

            } else if (splitedPath[i].equals("..")) {
                if (j > 0) {
                    allPath[j] = null;
                    j--;
                }
            } else {
                j++;
                allPath[j] = splitedPath[i];
            }
        }

        int run = 0;
        for (int k = 0; k <= j; k++) {
            if (allPath[k] != null && !allPath[k].trim().equals("")) {
                result = result + "/" + allPath[k];
                run++;
            }
        }
        if (run == 0) {
            result = "/";
        }

        return result;
    }

}
