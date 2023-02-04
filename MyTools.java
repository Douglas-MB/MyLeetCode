package mypack;


import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class MyTools {
    public static Scanner scan(){
        return new Scanner(System.in);
    }
    public static void clearPowerShell7() throws IOException {
        Runtime.getRuntime().exec("powershell.exe clear-host");
    }

    public static void clearWindowsOrLinux(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    public static int rng(int limitInf, int limitSup) throws Exception {

        class InvalidRangeException extends Exception{
            private String msg;
            public InvalidRangeException(String msg){
                this.msg =  msg;
            }
            public String msg(){
                return msg;
            }
        }

        Random randomNumber = new Random();
        int aux=0;
        try{
            if (limitInf > limitSup){
                throw new InvalidRangeException("Inferior limit is greater than Superior limit");
            } else if (limitInf==limitSup) {
                return limitSup;
            } else{
                aux = randomNumber.nextInt();
                if (aux >= limitInf && aux <= limitSup){
                    return aux;
                }else {
                    while (aux<limitInf||aux>limitSup){
                        aux = randomNumber.nextInt();
                    }
                }
            }
        }
        catch (InvalidRangeException e){
            System.out.println(e.msg());
        }

        return aux;
    }

    public static char isNum(String auxString){
        int auxCase = 0;
        int length = auxString.length();
        int aux = 0;

        while (length>-1) {
            char auxChar = auxString.charAt(aux);

            length--;
            switch (auxCase) {
                case 0 -> {
                    if (auxChar == '0') {
                        return auxChar;
                    } else {
                        auxCase = 1;
                    }
                }
                case 1 -> {
                    if (auxChar == '1') {
                        return auxChar;
                    } else {
                        auxCase = 2;
                    }
                }
                case 2 -> {
                    if (auxChar == '2') {
                        return auxChar;
                    } else {
                        auxCase = 3;
                    }
                }
                case 3 -> {
                    if (auxChar == '3') {
                        return auxChar;
                    } else {
                        auxCase = 4;
                    }
                }
                case 4 -> {
                    if (auxChar == '4') {
                        return auxChar;
                    } else {
                        auxCase = 5;
                    }
                }
                case 5 -> {
                    if (auxChar == '5') {
                        return auxChar;
                    } else {
                        auxCase = 6;
                    }
                }
                case 6 -> {
                    if (auxChar == '6') {
                        return auxChar;
                    } else {
                        auxCase = 7;
                    }
                }
                case 7 -> {
                    if (auxChar == '7') {
                        return auxChar;
                    } else {
                        auxCase = 8;
                    }
                }
                case 8 -> {
                    if (auxChar == '8') {
                        return auxChar;
                    } else {
                        auxCase = 9;
                    }
                }
                case 9 -> {
                    if (auxChar == '9') {
                        return auxChar;
                    }
                }
            }
            aux++;
        }

        return '.';
    }

}
