import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    // Метод считывает файл как одну строчку в заданной кодировке
    static String getFileAsString(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path)); // Считать все байты из файла
        return new String(encoded, encoding);                 // Создать строчку
    }

    // Метод считывает файл как набор строчек
    static List<String> getFileStrings(String path, Charset encoding) throws IOException {
        return Files.readAllLines(Paths.get(path), encoding);
    }

    // Метод проверяет, является ли файл html.
    static List<String> checkHtml(List<String> text) throws FileNotHtmlException{
        int htmlChecker = 0;
        for (String openTag : text) {
            if (openTag.trim().contains("<html")) {
                for (String closeTag : text) {
                    if (closeTag.trim().contains("</html>")) {
                        htmlChecker = 1;
                    }
                }
            }
        }

        if (htmlChecker == 1)
            return text;
        else {
            throw new FileNotHtmlException();
        }
    }

    // Метод убирает теги из строки.
    static String removeTagsFromString(String string) {
        int tagStart = 0;
        int tagEnd = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(string);

        for (int i = sb.length() - 1; i >= 0; i --) {
            if (sb.charAt(i) == '>')
                tagStart = i;
            else if (sb.charAt(i) == '<') {
                tagEnd = i;
                sb.delete(tagEnd, tagStart + 1);
            }
        }

        return sb.toString().trim();
    }

    // Метод убирает тэги из списка строк.
    static List<String> removeTagsFromList(List<String> strings) {
        List<String> resultList = new ArrayList<String>();
        String string;

        for (String str : strings) {
            string = removeTagsFromString(str);
            if(string.length() != 0)
                resultList.add(string);
        }

        return resultList;
    }

    // Метод записывает строчку в заданный файл
    static void writeStringsToFile(String path, List<String> strings) throws  IOException {
        FileWriter fileReader = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
        for (String str : strings) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
