package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileProcess {

    static String[][] filePaths = {
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


    public static String WordFinder(String inputWord, int lang, int lang2) throws IOException {


        String searchWord = "%%";
        searchWord += inputWord;
        searchWord += " /";

        boolean fileNotFound = false;

        BufferedReader bufferedReader;

        if (filePaths[lang][lang2] != null) {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePaths[lang][lang2]), StandardCharsets.UTF_8));
        } else {
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
        String synonym = bufferedReader.readLine();
        synonym = synonym.contains("2.") ? synonym.split("2.")[1] : synonym;
        bufferedReader.close();

        if (wordFound) {
            String tempLine = "";
            String[] rowWords = lineSecond.split(" ");
            if (rowWords[0].equals("1.")) {
                for (int i = 0; i < rowWords.length; i++) {
                    if (i == 0)
                        continue;
                    tempLine += rowWords[i];
                    if (i != rowWords.length - 1)
                        tempLine += " ";
                }
                lineSecond = tempLine + " | synonyms: " + synonym;
            }
        } else
            return " ";


        if (fileNotFound)
            return org.example.FileProcess.WordFinder(lineSecond.split(",")[0].split(" ")[0], 3, lang2);


        if (lineSecond != null)
            return lineSecond;
        else
            return " ";

    }


    public static void addWord(String[] word) {
        try {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (filePaths[i][j] == null)
                        continue;
                    FileOutputStream fileOutputStream = new FileOutputStream(filePaths[i][j], true);
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                    writer.write(word[i] + " /");
                    writer.newLine();

                    writer.write(word[j]);
                    writer.newLine();
                    writer.close();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void edit(int languageindex, String[] word) {
        for (int i = 0; i < 7; i++){

            String fileName = filePaths[languageindex][i];

            if (filePaths[languageindex][i] == null)
                continue;

            String textToAdd = word[languageindex] + " /";

            try {

                File inputFile = new File(fileName);
                File tempFile = new File("temp.txt");
                BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, StandardCharsets.UTF_8));


                writer.write(textToAdd + System.lineSeparator());
                reader.readLine();
                writer.write(word[i] + System.lineSeparator());


                String line = reader.readLine();
                while (line != null) {
                    writer.write(line + System.lineSeparator());
                    line = reader.readLine();
                }


                reader.close();
                writer.close();
                if (!inputFile.delete()) {
                    return;
                }
                if (!tempFile.renameTo(inputFile)) {
                    return;
                }
            } catch (IOException e) {
            }
        }
    }

}