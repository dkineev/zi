package com.company;

public class Counter {
    public int[] getArrayCounter (char[]ArrayCipher){
        int[] ArrayCounter = new int[33];
        for (int i = 0; i<ArrayCipher.length; i++){
            switch (ArrayCipher[i]){
                case 'а':
                    ArrayCounter[0]++;
                    break;
                case 'б':
                    ArrayCounter[1]++;
                    break;
                case 'в':
                    ArrayCounter[2]++;
                    break;
                case 'г':
                    ArrayCounter[3]++;
                    break;
                case 'д':
                    ArrayCounter[4]++;
                    break;
                case 'е':
                    ArrayCounter[5]++;
                    break;
                case 'ё':
                    ArrayCounter[6]++;
                    break;
                case 'ж':
                    ArrayCounter[7]++;
                    break;
                case 'з':
                    ArrayCounter[8]++;
                    break;
                case 'и':
                    ArrayCounter[9]++;
                    break;
                case 'й':
                    ArrayCounter[10]++;
                    break;
                case 'к':
                    ArrayCounter[11]++;
                    break;
                case 'л':
                    ArrayCounter[12]++;
                    break;
                case 'м':
                    ArrayCounter[13]++;
                    break;
                case 'н':
                    ArrayCounter[14]++;
                    break;
                case 'о':
                    ArrayCounter[15]++;
                    break;
                case 'п':
                    ArrayCounter[16]++;
                    break;
                case 'р':
                    ArrayCounter[17]++;
                    break;
                case 'с':
                    ArrayCounter[18]++;
                    break;
                case 'т':
                    ArrayCounter[19]++;
                    break;
                case 'у':
                    ArrayCounter[20]++;
                    break;
                case 'ф':
                    ArrayCounter[21]++;
                    break;
                case 'х':
                    ArrayCounter[22]++;
                    break;
                case 'ц':
                    ArrayCounter[23]++;
                    break;
                case 'ч':
                    ArrayCounter[24]++;
                    break;
                case 'ш':
                    ArrayCounter[25]++;
                    break;
                case 'щ':
                    ArrayCounter[26]++;
                    break;
                case 'ъ':
                    ArrayCounter[27]++;
                    break;
                case 'ы':
                    ArrayCounter[28]++;
                    break;
                case 'ь':
                    ArrayCounter[29]++;
                    break;
                case 'э':
                    ArrayCounter[30]++;
                    break;
                case 'ю':
                    ArrayCounter[31]++;
                    break;
                case 'я':
                    ArrayCounter[32]++;
                    break;
                default:
                    break;
            }
        }

        for (int i = 0;i < ArrayCounter.length; i++){
            double tmp;
            tmp = (ArrayCounter[i]*10000 / ArrayCipher.length);
            ArrayCounter[i] = (int)tmp;
        }
        return ArrayCounter;
    }
}
