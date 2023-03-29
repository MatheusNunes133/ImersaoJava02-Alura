package org.figurinhas.gerador;

import org.figurinhas.gerador.classes.StickerFactory;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        String url = getUrl();
        String archiveName = getArchiveName();
        String text = getText();
        int fontSize = getSizeText();
        var generateImage = new StickerFactory();
        generateImage.generateImage(url, archiveName, text, fontSize);

    }

    public static String getUrl(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira a url da imagem:");
        String url = scan.next();
        return url;
    }
    public static String getArchiveName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o nome do arquivo:");
        String archiveName = scan.next();
        return archiveName;
    }

    public static String getText(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira texto da figurinha:");
        String text = scan.next();
        return text;
    }

    public static int getSizeText(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o tamanho da fonte:");
        int sizeText = scan.nextInt();
        return sizeText;
    }



}