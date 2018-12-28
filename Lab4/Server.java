package com.company;

public class Server {
    private static int[] simpleNumber = {3,5,7,11,13,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
    private int simpleKeyP;
    private int simpleKeyQ;
    private int moduleN;
    private int functionEuler;
    private int randomNumberD;
    private int secretNumberE;
    private int[] cipher;
    private int[] messageNumber;
    private char[] message;
    private String text;
    private boolean check = false;
    boolean sendCipher = false;

    public void setMessage(){

        message = new char[cipher.length];
        messageNumber = new int[cipher.length];
        for (int element = 0; element < cipher.length; element++){
            int tmp = 1;
            for (int degree = 1; degree <= secretNumberE; degree++){
                tmp = (tmp * cipher[element]) % moduleN;
            }
            messageNumber[element] = tmp;
        }

        for (int element = 0; element < messageNumber.length; element++){
            message[element] = getSymbol(messageNumber[element]);
        }

        text = String.valueOf(message);
    }

    public void calculatePublicAndPrivateKey (){
        while (!check) {
            simpleKeyP = simpleNumber[(int) (Math.random() * simpleNumber.length)];
            simpleKeyQ = simpleNumber[(int) (Math.random() * simpleNumber.length)];
            moduleN = simpleKeyP * simpleKeyQ;
            functionEuler = (simpleKeyP - 1) * (simpleKeyQ - 1);

            randomNumberD = simpleNumber[(int) (Math.random() * simpleNumber.length)];

            secretNumberE = (int) (Math.random() * 50);

            if ((((secretNumberE * randomNumberD) % functionEuler) == 1) && (secretNumberE != randomNumberD) && (randomNumberD < functionEuler) && (functionEuler % randomNumberD != 0) && moduleN > 160 && simpleKeyQ != simpleKeyP) {
                check = true;
            }

        }
        check = false;

        /*System.out.println("P = " + simpleKeyP);
        System.out.println("Q = " + simpleKeyQ);
        System.out.println("N = " + moduleN);
        System.out.println("D = " + randomNumberD);
        System.out.println("E = " + secretNumberE);
        System.out.println();*/
    }

    public String getCipherNumberText(){
        String cipherNumberText = " ";
        for(int element = 0; element < cipher.length; element++){
            cipherNumberText += String.valueOf(cipher[element]);
        }

        return cipherNumberText;
    }

    public void setCipher(int[] c){
        cipher = c;
    }

    public int getPublicKeyN(){
        return moduleN;
    }

    public int getPublicKeyD(){
        return randomNumberD;
    }

    public int getPrivateKeyE(){
        return secretNumberE;
    }

    public String getText(){
        return text;
    }

    public void clear(){
        simpleKeyP = 0;
        simpleKeyQ = 0;
        moduleN = 0;
        functionEuler = 0;
        randomNumberD = 0;
        secretNumberE = 0;
        cipher = null;
        messageNumber = null;
        message = null;
        text = null;
        check = false;
        sendCipher = false;
    }

    public static char getSymbol(int number){
        char symbol;
        switch (number){
            case 10:
                symbol = 'a';
                break;
            case 11:
                symbol = 'b';
                break;
            case 12:
                symbol = 'c';
                break;
            case 13:
                symbol = 'd';
                break;
            case 14:
                symbol = 'e';
                break;
            case 15:
                symbol = 'f';
                break;
            case 16:
                symbol = 'g';
                break;
            case 17:
                symbol = 'h';
                break;
            case 18:
                symbol = 'i';
                break;
            case 19:
                symbol = 'j';
                break;
            case 20:
                symbol = 'k';
                break;
            case 21:
                symbol = 'l';
                break;
            case 22:
                symbol = 'm';
                break;
            case 23:
                symbol = 'n';
                break;
            case 24:
                symbol = 'o';
                break;
            case 25:
                symbol = 'p';
                break;
            case 26:
                symbol = 'q';
                break;
            case 27:
                symbol = 'r';
                break;
            case 28:
                symbol = 's';
                break;
            case 29:
                symbol = 't';
                break;
            case 30:
                symbol = 'u';
                break;
            case 31:
                symbol = 'v';
                break;
            case 32:
                symbol = 'w';
                break;
            case 33:
                symbol = 'x';
                break;
            case 34:
                symbol = 'y';
                break;
            case 35:
                symbol = 'z';
                break;
            case 36:
                symbol = 'A';
                break;
            case 37:
                symbol = 'B';
                break;
            case 38:
                symbol = 'C';
                break;
            case 39:
                symbol = 'D';
                break;
            case 40:
                symbol = 'E';
                break;
            case 41:
                symbol = 'F';
                break;
            case 42:
                symbol = 'G';
                break;
            case 43:
                symbol = 'H';
                break;
            case 44:
                symbol = 'I';
                break;
            case 45:
                symbol = 'J';
                break;
            case 46:
                symbol = 'K';
                break;
            case 47:
                symbol = 'L';
                break;
            case 48:
                symbol = 'M';
                break;
            case 49:
                symbol = 'N';
                break;
            case 50:
                symbol = 'O';
                break;
            case 51:
                symbol = 'P';
                break;
            case 52:
                symbol = 'Q';
                break;
            case 53:
                symbol = 'R';
                break;
            case 54:
                symbol = 'S';
                break;
            case 55:
                symbol = 'T';
                break;
            case 56:
                symbol = 'U';
                break;
            case 57:
                symbol = 'V';
                break;
            case 58:
                symbol = 'W';
                break;
            case 59:
                symbol = 'X';
                break;
            case 60:
                symbol = 'Y';
                break;
            case 61:
                symbol = 'Z';
                break;
            case 62:
                symbol = '.';
                break;
            case 63:
                symbol = ',';
                break;
            case 64:
                symbol = '?';
                break;
            case 65:
                symbol = '!';
                break;
            case 66:
                symbol = '/';
                break;
            case 67:
                symbol = '(';
                break;
            case 68:
                symbol = ')';
                break;
            case 69:
                symbol = ':';
                break;
            case 70:
                symbol = ';';
                break;
            case 71:
                symbol = ' ';
                break;
            case 72:
                symbol = '0';
                break;
            case 73:
                symbol = '1';
                break;
            case 74:
                symbol = '2';
                break;
            case 75:
                symbol = '3';
                break;
            case 76:
                symbol = '4';
                break;
            case 77:
                symbol = '5';
                break;
            case 78:
                symbol = '6';
                break;
            case 79:
                symbol = '7';
                break;
            case 80:
                symbol = '8';
                break;
            case 81:
                symbol = '9';
                break;
            default:
                symbol = '_';
                break;
        }
        return symbol;
    }
}
