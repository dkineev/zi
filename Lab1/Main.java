//cipher - шифр
//encryption(enc) - шифровать
//description(dec) - расшифровать
//encoder - шифратор
//counter - счетчик
//comforter - пустышка
//monogram - монограмма
//digramm - биграмма

package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Encoder encoder = new Encoder();
        Counter counter = new Counter();

        File text = new File("text.txt");
        BufferedReader readerText = new BufferedReader(new FileReader(text));
        File cipher = new File("cipher.txt");
        BufferedReader readerCipher = new BufferedReader(new FileReader(cipher));
        File bigText = new File("bigText.txt");
        BufferedReader readerBigText = new BufferedReader(new FileReader(bigText));

        String texts = "";
        String comforterText;
        do {
            comforterText = readerText.readLine();
            if (comforterText == null) {
                break;
            }
            texts += comforterText + "\n";
        } while (comforterText != null);

        String ciphers = "";
        String comforterCipher;
        do {
            comforterCipher = readerCipher.readLine();
            if (comforterCipher == null) {
                break;
            }
            ciphers += comforterCipher + "\n";
        } while (comforterCipher != null);

        String bigTexts = "";
        String comforterBigText;
        do {
            comforterBigText = readerBigText.readLine();
            if (comforterBigText == null) {
                break;
            }
            bigTexts += comforterBigText + "\n";
        } while (comforterBigText != null);

        System.out.println("Текст: ");
        System.out.println(texts);

        System.out.print("Операция: ");
        String operation = in.nextLine();
        System.out.println();

        String Alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        char[] ArrayTexts = texts.toCharArray();
        char[] ArrayBigTexts = bigTexts.toCharArray();
        char[] ArrayCiphers = ciphers.toCharArray();
        char[] ArrayAlphabet = Alphabet.toCharArray();
        char[] ArrayEncryption = Alphabet.toCharArray();

        switch (operation) {
            case "заш":
                System.out.print("Введите ключевое слово: ");
                String keyEncryption = in.nextLine();
                System.out.println();

                char[] ArrayKeyEncryption = keyEncryption.toCharArray();

                ArrayEncryption = encoder.getArrayCipherCode(ArrayKeyEncryption, ArrayEncryption, ArrayAlphabet);

                texts = encoder.getCipher(ArrayTexts, ArrayEncryption, ArrayAlphabet);

                for (int i = 0; i < ArrayAlphabet.length; i++) {
                    System.out.print("[" + (i + 1) + "]:" + ArrayAlphabet[i] + " ");
                }
                System.out.println();


                for (int i = 0; i < ArrayEncryption.length; i++) {
                    System.out.print("[" + (i + 1) + "]:" + ArrayEncryption[i] + " ");
                }
                System.out.println();

                System.out.println();
                System.out.println("Шифр: ");
                System.out.println(texts);

                write("cipher.txt", texts);
                break;
            case "рас":
                System.out.println("Шифр: ");
                System.out.println(ciphers);

                System.out.print("Введите ключевое слово: ");
                String keyDescription = in.nextLine();

                char[] ArrayKeyDescription = keyDescription.toCharArray();

                ArrayEncryption = encoder.getArrayCipherCode(ArrayKeyDescription, ArrayEncryption, ArrayAlphabet);

                ciphers = encoder.getText(ArrayCiphers, ArrayEncryption, ArrayAlphabet);

                System.out.println();
                System.out.println("Текст: ");
                System.out.println(ciphers);

                write("text.txt", ciphers);
                break;
            case "моно":
                System.out.println("Шифр: ");
                System.out.println(ciphers);


                int[] symbolsCipher = counter.getArrayCounter(ArrayCiphers);
                int[] symbolsText = counter.getArrayCounter(ArrayBigTexts);

                char[] ArrayAlphabetText = Alphabet.toCharArray();
                char[] ArrayAlphabetCipher = Alphabet.toCharArray();

                System.out.println("Буквы в шифре: ");
                char[] ArrayCounterCipher = encoder.getArrayWaningMonogramCounter(symbolsCipher, ArrayAlphabetCipher);
                System.out.println("Буквы в тексте: ");
               char[] ArrayCounterText = encoder.getArrayWaningMonogramCounter(symbolsText, ArrayAlphabetText);

                ciphers = encoder.getTextWithoutKeyMonogram(ArrayCounterCipher, ArrayCounterText, ArrayCiphers);

                System.out.println();
                System.out.println("Текст: ");
                System.out.println(ciphers);
                break;
            case "бигр":
                System.out.println("Шифр: ");
                System.out.println(ciphers);

                String[] ArrayCipherDigramm = encoder.getArrayDigramm(ArrayCiphers);
                String[] ArrayBigTextDigramm = encoder.getArrayDigramm(ArrayBigTexts);

                System.out.println("Биграммы в шифре: ");
                String[] ArrayCipherDigrammWaning = encoder.getArrayFrequentWaningDigramm(ArrayCipherDigramm);
                System.out.println("Биграммы в тексте: ");
                String[] ArrayBigTextDigrammWaning = encoder.getArrayFrequentWaningDigramm(ArrayBigTextDigramm);

                String[] ArrayDigrammTexts = encoder.getTextWithoutKeyDigramms(ArrayCipherDigrammWaning, ArrayBigTextDigrammWaning, ArrayCiphers);

                System.out.println("Текст после биграмм: ");
                for (int i = 0; i < ArrayDigrammTexts.length; i++){
                    System.out.print(ArrayDigrammTexts[i]);
                }
                break;
            case "мб":
                System.out.println("Шифр: ");
                System.out.println(ciphers);


                int[] symbolsMonogramCipher = counter.getArrayCounter(ArrayCiphers);
                int[] symbolsMonogramText = counter.getArrayCounter(ArrayBigTexts);

                char[] ArrayAlphabetMonogramText = Alphabet.toCharArray();
                char[] ArrayAlphabetMonogramCipher = Alphabet.toCharArray();

                System.out.println("Буквы в шифре: ");
                char[] ArrayCounterMonogramCipher = encoder.getArrayWaningMonogramCounter(symbolsMonogramCipher, ArrayAlphabetMonogramCipher);
                System.out.println("Буквы в тексте: ");
                char[] ArrayCounterMonogramText = encoder.getArrayWaningMonogramCounter(symbolsMonogramText, ArrayAlphabetMonogramText);

                ciphers = encoder.getTextWithoutKeyMonogram(ArrayCounterMonogramCipher, ArrayCounterMonogramText, ArrayCiphers);

                System.out.println();
                System.out.println("Текст после частотного анализа по буквам: ");
                System.out.println(ciphers);

                char[] Array = ciphers.toCharArray();

                String[] ArrayCipherDigrammDubl = encoder.getArrayDigramm(Array);
                String[] ArrayBigTextDigrammDybl = encoder.getArrayDigramm(ArrayBigTexts);

                System.out.println("Биграммы в шифре: ");
                String[] ArrayCipherDigrammWaningDubl = encoder.getArrayFrequentWaningDigramm(ArrayCipherDigrammDubl);
                System.out.println("Биграммы в тексте: ");
                String[] ArrayBigTextDigrammWaningDubl = encoder.getArrayFrequentWaningDigramm(ArrayBigTextDigrammDybl);

                String[] ArrayDigrammTextsDubl = encoder.getTextWithoutKeyDigramms(ArrayCipherDigrammWaningDubl, ArrayBigTextDigrammWaningDubl, Array);

                System.out.println();
                System.out.println("Текст после частотного анализа по биграммам: ");
                for (int i = 0; i < ArrayDigrammTextsDubl.length; i++){
                    System.out.print(ArrayDigrammTextsDubl[i]);
                }
                break;
            default:
                System.err.println("Not found");
                break;
        }
    }

    public static void write(String fileName, String text) {
        File cipher = new File(fileName);
        try {
            if (!cipher.exists()) {
                cipher.createNewFile();
            }
            PrintWriter out = new PrintWriter(cipher.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

