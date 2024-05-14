package com.geek.algorithm.tmp;

/**
 * @author lucas.zhao
 * @date 2023/10/09 15:22
 * @email jczhao_cs@163.com
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseFileCopy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // 源文件名
        String destinationFile = "destination.txt";  // 目标文件名

        try {
            List<String> lines = readLinesFromFile(sourceFile);
            List<String> reversedLines = reverseLines(lines);
            writeLinesToFile(reversedLines, destinationFile);
            System.out.println("文件复制完成！");
        } catch (IOException e) {
            System.out.println("文件复制失败：" + e.getMessage());
        }
    }

    // 从文件中逐行读取文本内容，并返回一个字符串列表
    private static List<String> readLinesFromFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    // 将字符串列表中的内容反转
    private static List<String> reverseLines(List<String> lines) {
        List<String> reversedLines = new ArrayList<>(lines);
        Collections.reverse(reversedLines);
        return reversedLines;
    }

    // 将字符串列表中的内容逐行写入到文件中
    private static void writeLinesToFile(List<String> lines, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
