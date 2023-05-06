package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileProcess {

    public static String WordFinder(String inputWord, int lang, int lang2) throws IOException {

        String[][] filePaths = {
                {null,
                        "dicts/fra/fra-deu.txt",
                        "dicts/fra/fra-ell.txt",
                        "dicts/fra/fra-eng.txt",
                        "dicts/fra/fra-ita.txt",
                        "dicts/fra/fra-swe.txt",
                        "dicts/fra/fra-tur.txt"},

                {"dicts/deu/deu-fra.txt",
                        null,
                        "dicts/deu/deu-ell.txt",
                        "dicts/deu/deu-eng.txt",
                        "dicts/deu/deu-ita.txt",
                        "dicts/deu/deu-swe.txt",
                        "dicts/deu/deu-tur.txt"},

                {null,
                        null,
                        null,
                        "dicts/ell/ell-eng.txt",
                        "dicts/ell/ell-ita.txt",
                        "dicts/ell/ell-swe.txt",
                        null},

                {"dicts/eng/eng-fra.txt",
                        "dicts/eng/eng-deu.txt",
                        "dicts/eng/eng-ell.txt",
                        null,
                        "dicts/eng/eng-ita.txt",
                        "dicts/eng/eng-swe.txt",
                        "dicts/eng/eng-tur.txt"},

                {null,
                        "dicts/ita/ita-deu.txt",
                        "dicts/ita/ita-ell.txt",
                        "dicts/ita/ita-eng.txt",
                        null,
                        "dicts/ita/ita-swe.txt",
                        "dicts/ita/ita-tur.txt"},

                {"dicts/swe/swe-fra.txt",
                        "dicts/swe/swe-deu.txt",
                        "dicts/swe/swe-ell.txt",
                        "dicts/swe/swe-eng.txt",
                        "dicts/swe/swe-ita.txt",
                        null,
                        "dicts/swe/swe-tur.txt"},

                {null,
                        "dicts/tur/tur-deu.txt",
                        null,
                        "dicts/tur/tur-eng.txt",
                        null,
                        null,
                        null},
        };


        String searchWord = "%%";
        searchWord += inputWord;
        searchWord += " /";

        boolean fileNotFound = false;
        BufferedReader bufferedReader;

        if (filePaths[lang][lang2] != null) {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePaths[lang][lang2]), StandardCharsets.UTF_8));
        }
        else {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePaths[lang][3]), StandardCharsets.UTF_8));
            fileNotFound = true;
        }


        String line;
        boolean wordFound = false;
        String lineSecond = " ";


        int lineNumber = 0;
        while ((line = bufferedReader.readLine()) != null) {
            lineNumber++;
            String tempLine = "%%" + line.toLowerCase();

            if (tempLine.contains(searchWord.toLowerCase())) {
                line = bufferedReader.readLine();


                lineSecond = line;
                wordFound = true;
                break;
            }

        }

        bufferedReader.close();

        if (wordFound) {
            String tempLine = "";
            String[] rowWords = lineSecond.split(" ");
            if (rowWords[0].equals("1.")){
                for (int i = 0; i < rowWords.length; i++){
                    if (i == 0)
                        continue;
                    tempLine += rowWords[i];
                    if (i != rowWords.length-1)
                        tempLine += " ";
                }
                lineSecond = tempLine;
            }
        }
        else
            return " ";


        if (fileNotFound)
            return FileProcess.WordFinder(lineSecond.split(",")[0],3,lang2);


        if (lineSecond != null)
            return lineSecond;
        else
            return " ";

    }

    public static void addWord(String fileName, String word) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            writer.newLine();
            writer.write(word);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }


}