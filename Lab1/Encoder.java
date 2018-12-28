package com.company;

import java.util.*;

public class Encoder {

    public ArrayList<String> getArraySymbols() {
        ArrayList<String> ArraySymbols = new ArrayList<>();
        ArraySymbols.add(" ");
        ArraySymbols.add("\n");
        ArraySymbols.add(".");
        ArraySymbols.add(",");
        ArraySymbols.add("!");
        ArraySymbols.add("?");
        ArraySymbols.add("-");
        ArraySymbols.add(":");
        ArraySymbols.add(";");
        return ArraySymbols;
    }

    public char[] getArrayCipherCode(char[] ArrayKey, char[] ArrayEncryption, char[] ArrayAlphabet) {
        int count = ArrayKey.length;

        for (int i = 0; i < ArrayKey.length; i++) {
            ArrayEncryption[i] = ArrayKey[i];
        }

        for (int i = 0; i < ArrayAlphabet.length; i++) {
            char letter = ArrayAlphabet[i];
            boolean test = true;
            for (int j = 0; j < ArrayKey.length; j++) {
                if (ArrayAlphabet[i] == ArrayKey[j]) {
                    test = false;
                    count--;
                    break;
                }
            }
            if (test) {
                ArrayEncryption[i + count] = letter;
            }
        }
        return ArrayEncryption;
    }

    public String getCipher(char[] ArrayText, char[] ArrayEncryption, char[] ArrayAlphabet) {
        for (int i = 0; i < ArrayText.length; i++) {
            char letter = ArrayText[i];
            for (int j = 0; j < ArrayAlphabet.length; j++) {
                if (ArrayAlphabet[j] == ArrayText[i]) {
                    letter = ArrayEncryption[j];
                }
            }
            ArrayText[i] = letter;
        }
        String cipher = String.valueOf(ArrayText);
        return cipher;
    }

    public String getText(char[] ArrayCipher, char[] ArrayEncryption, char[] ArrayAlphabet) {
        for (int i = 0; i < ArrayCipher.length; i++) {
            char letter = ArrayCipher[i];
            for (int j = 0; j < ArrayEncryption.length; j++) {
                if (ArrayEncryption[j] == ArrayCipher[i]) {
                    letter = ArrayAlphabet[j];
                }
            }
            ArrayCipher[i] = letter;
        }
        String text = String.valueOf(ArrayCipher);
        return text;
    }

    public char[] getArrayWaningMonogramCounter(int[] SymbolsCounter, char[] ArrayAlphabet) {
        char[] ArraySymbols = ArrayAlphabet;
        for (int i = 0; i < SymbolsCounter.length; i++) {
            int min = SymbolsCounter[i];
            int min_i = i;
            for (int j = i + 1; j < SymbolsCounter.length; j++) {
                if (SymbolsCounter[j] > min) {
                    min = SymbolsCounter[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                char letterTmp = ArraySymbols[i];
                int tmp = SymbolsCounter[i];
                ArraySymbols[i] = ArraySymbols[min_i];
                ArraySymbols[min_i] = letterTmp;
                SymbolsCounter[i] = SymbolsCounter[min_i];
                SymbolsCounter[min_i] = tmp;
            }
        }

        for (int i = 0; i < ArraySymbols.length / 2; i++) {
            System.out.print("[" + (i + 1) + "]:" + ArraySymbols[i] + " ");
        }
        System.out.println();

        System.out.println("Частоты букв:");
        for (int i = 0; i < SymbolsCounter.length; i++) {
            System.out.print("[" + (i + 1) + "]:" + SymbolsCounter[i] + " ");
        }
        System.out.println();
        return ArraySymbols;
    }

    public String getTextWithoutKeyMonogram(char[] ArrayCounterCipher, char[] ArrayCounterText, char[] ArrayCipher) {
        for (int i = 0; i < ArrayCipher.length; i++) {
            char letter = ArrayCipher[i];
            for (int j = 0; j < ArrayCounterCipher.length; j++) {
                if (ArrayCipher[i] == ArrayCounterCipher[j]) {
                    letter = ArrayCounterText[j];
                }
            }
            ArrayCipher[i] = letter;
        }
        String text = String.valueOf(ArrayCipher);
        return text;
    }

    public String[] getArrayDigramm(char[] ArraySymbols) {
        ArrayList<String> Symbols = getArraySymbols();
        ArrayList<String> Text = new ArrayList<>();
        ArrayList<String> Digramm = new ArrayList<>();

        for (int i = 0; i < ArraySymbols.length; i++) {
            Text.add(String.valueOf(ArraySymbols[i]));
        }
        for (int i = 0; i < Text.size() - 1; i++) {
            if (!Symbols.contains(Text.get(i)) && !Symbols.contains(Text.get(i + 1))) {
                Digramm.add(Text.get(i) + Text.get(i + 1));
                i++;
            }
        }
        String[] digram = new String[Digramm.size()];

        for (int i = 0; i < Digramm.size(); i++) {
            digram[i] = Digramm.get(i).toString();
        }
        return digram;
    }

    public String[] getArrayFrequentWaningDigramm(String[] ArrayDigramm) {
        Map<String, Integer> MapDigramm = new HashMap<String, Integer>();
        ArrayList<String> ArraySymbols = new ArrayList<String>();
        ArrayList<Integer> ArrayCounter = new ArrayList<Integer>();

        for (int i = 0; i < ArrayDigramm.length; i++) {
            ArraySymbols.add(ArrayDigramm[i]);
        }
        for (int i = 0; i < ArraySymbols.size(); i++) {
            String tmp = ArraySymbols.get(i);

            if (!MapDigramm.containsKey(tmp)) {
                MapDigramm.put(tmp, 1);
            } else {
                MapDigramm.put(tmp, MapDigramm.get(tmp) + 1);
            }
        }

        ArraySymbols.clear();

        for (Map.Entry<String, Integer> entry : MapDigramm.entrySet()) {
            ArrayCounter.add(entry.getValue());
            ArraySymbols.add(entry.getKey());
        }

        String[] DigrammsMassive = new String[ArraySymbols.size()];
        int[] CounterMassive = new int[ArrayCounter.size()];

        for (int i = 0; i < ArrayCounter.size(); i++) {
            CounterMassive[i] = (ArrayCounter.get(i) * 1000 / ArrayCounter.size());
            DigrammsMassive[i] = ArraySymbols.get(i);
        }

        for (int i = 0; i < CounterMassive.length; i++) {
            int min = CounterMassive[i];
            int min_i = i;
            for (int j = i + 1; j < CounterMassive.length; j++) {
                if (CounterMassive[j] > min) {
                    min = CounterMassive[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                String letterTmp = DigrammsMassive[i];
                int tmp = CounterMassive[i];
                DigrammsMassive[i] = DigrammsMassive[min_i];
                DigrammsMassive[min_i] = letterTmp;
                CounterMassive[i] = CounterMassive[min_i];
                CounterMassive[min_i] = tmp;
            }
        }

        String[] frequent = new String[5];

        for (int i = 0; i < frequent.length; i++) {
            frequent[i] = DigrammsMassive[i];
        }

        for (int i = 0; i < frequent.length; i++) {
            System.out.print("[" + (i + 1) + "]:" + frequent[i] + " ");
        }
        System.out.println();

        System.out.println("Частоты биграмм:");
        for (int i = 0; i < frequent.length; i++) {
            System.out.print("[" + (i + 1) + "]:" + CounterMassive[i] + " ");
        }

        System.out.println();
        return frequent;
    }

    public String[] getTextWithoutKeyDigramms(String[] ArrayCipherDigrammCounterWaning, String[] ArrayBigTextDigrammCounterWaning, char[] ArrayCipher) {
        ArrayList<String> Symbols = getArraySymbols();
        ArrayList<String> Cipher = new ArrayList<>();
        ArrayList<String> Text = new ArrayList<>();

        for (int i = 0; i < ArrayCipher.length - 1; i++) {
            Cipher.add(String.valueOf(ArrayCipher[i]));
        }
        for (int i = 1; i < ArrayCipher.length - 1; i++) {
            String letter = Cipher.get(i);
            if (!Symbols.contains(Cipher.get(i)) && !Symbols.contains(Cipher.get(i + 1))) {
                for (int j = 0; j < ArrayCipherDigrammCounterWaning.length; j++) {
                    String temp = Cipher.get(i) + Cipher.get(i + 1);
                    if (temp.equals(ArrayCipherDigrammCounterWaning[j])) {
                        letter = ArrayBigTextDigrammCounterWaning[j];
                        i++;

                    }
                }
            }
            Text.add(letter);
        }
        String[] text = new String[Text.size()];

        for (int i = 0; i < Text.size(); i++){
            text[i] = Text.get(i).toString();
        }
        return text;
    }
}

