package com.company;

public class User {
    private char[] message;
    private int[] messageNumber;
    private int[] cipher;
    private int publicKeyD;
    private int publicKeyN;
    boolean sendKey = false;
    boolean cipherInstalled = false;

    public void setMessageText(String text){
        message = text.toCharArray();
        messageNumber = new int[message.length];
        cipher =  new int [message.length];

        for (int element = 0; element < message.length; element++){
            messageNumber[element] = getNumber(message[element]);
        }
    }

    public String getMessageText(){
        String messageText = String.valueOf(message);
        return messageText;
    }

    public String getMessageNumber(){
    String messageNumberText = " ";
    for(int element = 0; element < messageNumber.length; element++){
        messageNumberText += String.valueOf(messageNumber[element]);
    }

    return messageNumberText;
    }

    public String getCipherNumber(){
        String cipherNumberText = " ";
        for(int element = 0; element < cipher.length; element++){
            cipherNumberText += String.valueOf(cipher[element]);
        }

        return cipherNumberText;
    }

    public void setCipher(){
        for (int element = 0; element < messageNumber.length; element++) {
            int tmp = 1;
            for (int degree = 1; degree <= publicKeyD; degree++) {
                tmp = (tmp * messageNumber[element]) % publicKeyN;
            }
            cipher[element] = tmp;
            cipherInstalled = true;
        }
    }

    public int[] getCipher(){
        return cipher;
    }

    public void setPublicKey(int d, int n){
        publicKeyD = d;
        publicKeyN = n;
        sendKey = true;
    }

    public int getPublicKeyN(){
        return publicKeyN;
    }

    public int getPublicKeyD(){
        return publicKeyD;
    }

    public void clear(){
        publicKeyD = 0;
        publicKeyN = 0;
        cipher = null;
        messageNumber = null;
        message = null;
        sendKey = false;
        cipherInstalled = false;
    }

    public static int getNumber(char symbol){
        int number;
        switch (symbol){
            case 'a':
                number = 10;
                break;
            case 'b':
                number = 11;
                break;
            case 'c':
                number = 12;
                break;
            case 'd':
                number = 13;
                break;
            case 'e':
                number = 14;
                break;
            case 'f':
                number = 15;
                break;
            case 'g':
                number = 16;
                break;
            case 'h':
                number = 17;
                break;
            case 'i':
                number = 18;
                break;
            case 'j':
                number = 19;
                break;
            case 'k':
                number = 20;
                break;
            case 'l':
                number = 21;
                break;
            case 'm':
                number = 22;
                break;
            case 'n':
                number = 23;
                break;
            case 'o':
                number = 24;
                break;
            case 'p':
                number = 25;
                break;
            case 'q':
                number = 26;
                break;
            case 'r':
                number = 27;
                break;
            case 's':
                number = 28;
                break;
            case 't':
                number = 29;
                break;
            case 'u':
                number = 30;
                break;
            case 'v':
                number = 31;
                break;
            case 'w':
                number = 32;
                break;
            case 'x':
                number = 33;
                break;
            case 'y':
                number = 34;
                break;
            case 'z':
                number = 35;
                break;
            case 'A':
                number = 36;
                break;
            case 'B':
                number = 37;
                break;
            case 'C':
                number = 38;
                break;
            case 'D':
                number = 39;
                break;
            case 'E':
                number = 40;
                break;
            case 'F':
                number = 41;
                break;
            case 'G':
                number = 42;
                break;
            case 'H':
                number = 43;
                break;
            case 'I':
                number = 44;
                break;
            case 'J':
                number = 45;
                break;
            case 'K':
                number = 46;
                break;
            case 'L':
                number = 47;
                break;
            case 'M':
                number = 48;
                break;
            case 'N':
                number = 49;
                break;
            case 'O':
                number = 50;
                break;
            case 'P':
                number = 51;
                break;
            case 'Q':
                number = 52;
                break;
            case 'R':
                number = 53;
                break;
            case 'S':
                number = 54;
                break;
            case 'T':
                number = 55;
                break;
            case 'U':
                number = 56;
                break;
            case 'V':
                number = 57;
                break;
            case 'W':
                number = 58;
                break;
            case 'X':
                number = 59;
                break;
            case 'Y':
                number = 60;
                break;
            case 'Z':
                number = 61;
                break;
            case '.':
                number = 62;
                break;
            case ',':
                number = 63;
                break;
            case '?':
                number = 64;
                break;
            case '!':
                number = 65;
                break;
            case '/':
                number = 66;
                break;
            case '(':
                number = 67;
                break;
            case ')':
                number = 68;
                break;
            case ':':
                number = 69;
                break;
            case ';':
                number = 70;
                break;
            case ' ':
                number = 71;
                break;
            case '0':
                number = 72;
                break;
            case '1':
                number = 73;
                break;
            case '2':
                number = 74;
                break;
            case '3':
                number = 75;
                break;
            case '4':
                number = 76;
                break;
            case '5':
                number = 77;
                break;
            case '6':
                number = 78;
                break;
            case '7':
                number = 79;
                break;
            case '8':
                number = 80;
                break;
            case '9':
                number = 81;
                break;
            default:
                number = 0;
                break;
        }
        return number;
    }


}
