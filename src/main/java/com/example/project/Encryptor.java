package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if (messageLen == 0) {
            return 1;
        }
        int columns = messageLen / rows;
        if (messageLen % rows != 0) {
            columns++;
        }
        return columns;
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int columns = message.length() / rows;
        if (message.length() % rows != 0) {
            columns++;
        }
        if (message.length() == 0) {
            columns = 1;
        }
        String[][] encryptArr = new String[rows][columns];
        int msgCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (msgCount < message.length()) {
                    encryptArr[i][j] = message.substring(msgCount, msgCount + 1);
                    msgCount++;
                } else {
                    encryptArr[i][j] = "=";
                }
            }
        }
        return encryptArr;
    }

    public static String encryptMessage(String message, int rows) {
        int columns = message.length() / rows;
        if (message.length() % rows != 0) {
            columns++;
        }
        String[][] encryptArr = new String[rows][columns];
        int msgCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (msgCount < message.length()) {
                    encryptArr[i][j] = message.substring(msgCount, msgCount + 1);
                    msgCount++;
                } else {
                    encryptArr[i][j] = "=";
                }
            }
        }
        String encryptedMessage = "";
        for (int i = columns - 1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                encryptedMessage += encryptArr[j][i];
            }
        }
        return encryptedMessage;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        int columns = encryptedMessage.length() / rows;
        String[][] decryptArr = new String[rows][columns];
        int msgCount = 0;
        for (int i = columns - 1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                if (msgCount < encryptedMessage.length()) {
                    decryptArr[j][i] = encryptedMessage.substring(msgCount, msgCount + 1);
                    msgCount++;
                } else {
                    decryptArr[j][i] = encryptedMessage.substring(msgCount, msgCount + 1);
                }
            }
        }
        String message = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!decryptArr[i][j].equals("=")) {
                    message += decryptArr[i][j];
                }
            }
        }
        return message;
    }
}