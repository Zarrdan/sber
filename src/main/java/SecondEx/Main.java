package SecondEx;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        LocalDateTime time = LocalDateTime.now();
        final String start = "\"Start talking\"";
        final String stop = "\"Stop talking\"";
        final String bye = "\"Goodbye\"";
        final String path = "\"Use another file:\"";
        final String reference = "src/main/java/SecondEx/";
        start(time, start, stop, bye, path, reference);
    }

    public static class Path {
          public static String pathname = "src/main/java/SecondEx/answer.txt";
    }

    public static ArrayList<String> readFile() throws FileNotFoundException {
        File doc = new File(Path.pathname);
        Scanner obj = new Scanner(doc);
        ArrayList<String> arrayFile = new ArrayList<>();
        while (obj.hasNextLine()) {
            arrayFile.add(obj.nextLine());
        }
        obj.close();
        return arrayFile;
    }

    private static void writeLogInFIle(ArrayList<String> outFile, LocalDateTime now, String reference) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-d HH-mm-ss");
        try {
            OutputStream f = new FileOutputStream(reference + dtf.format(now) + ".log", true);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for (int i = 0; i < outFile.size(); i++) {
                out.write(outFile.get(i) + "\n");
                out.flush();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void start(LocalDateTime time, String start, String stop, String bye, String path, String reference) throws IOException {

        ArrayList<String> arrayFileFirst = readFile();
        System.out.println(arrayFileFirst.get(0));
        Scanner in = new Scanner(System.in);
        ArrayList<String> outFile = new ArrayList<>();
        outFile.add(arrayFileFirst.get(0));
        while (in.hasNextLine()) {
            ArrayList<String> arrayFile = readFile();
            String name = in.nextLine();
            outFile.add(name);
            if (name.equals(stop)) {
                do {
                    name = in.nextLine();
                    outFile.add(name);
                } while (!name.equals(start));
            } else if (name.equals(bye)) {
                outFile.add(arrayFile.get(arrayFile.size() - 1));
                System.out.println(arrayFile.get(arrayFile.size() - 1));
                writeLogInFIle(outFile, time, reference);
                return;
            } else if (name.equals(path)) {
                Scanner newPath = new Scanner(System.in);
                System.out.print("Введите название файла ");
                String new1 = newPath.nextLine();
                Path.pathname = reference + new1;
                outFile.add(Path.pathname);
            } else {
                int numberStringAnswer;
                do {
                    numberStringAnswer = (int) (Math.random() * arrayFile.size());
                } while (numberStringAnswer == 0);
                outFile.add(arrayFile.get(numberStringAnswer));
                System.out.println(arrayFile.get(numberStringAnswer));
            }
        }
    }
}

