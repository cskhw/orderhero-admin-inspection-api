package com.deliverylab.inspection.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileController {

    // 파일에 내용 저장하기
    private static void fileWriter(String path, String fileName, String insertStr, boolean add) throws Exception {
        File file = new File(path);

        if (!file.exists()) {
            // 경로가 없다면 생성합니다. (디렉토리)
            try {
                file.mkdirs();
            } catch (Exception e) {
                System.out.println("path mkdirs Error : " + e.toString());
            }
        }

        FileWriter writer = null;
        try {
            // 기존 파일의 내용에 이어서 쓰려면 true를
            // 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
            writer = new FileWriter(file + "/" + fileName, add);
            writer.write(insertStr);

            writer.flush();

            System.out.println("file write 완료 ... ");
            System.out.println("file write 내용 : " + insertStr);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("fileWriter 에러 : " + e.toString());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // 덮어쓰기
    public static void newFileWriter(String path, String fileName, String insertStr) throws Exception {
        fileWriter(path, fileName, insertStr, false);
    }

    // 이어쓰기
    public static void addFileWriter(String path, String fileName, String insertStr) throws Exception {
        fileWriter(path, fileName, insertStr, true);
    }

    // 파일 읽어서 내용 가저오기
    public static String fileReader(String path) throws Exception {
        File file = new File(path);
        String temp = "";

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                temp += sc.nextLine();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("fileReader 에러 : " + e.toString());
        }
        return temp;
    }
}
