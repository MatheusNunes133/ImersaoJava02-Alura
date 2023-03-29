package org.figurinhas.gerador.classes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class StickerFactory {

    public void generateImage(String url, String archiveName, String text, int fontSize) throws Exception{

        //Ler imagem
        InputStream image = new URL(url).openStream();
        BufferedImage originalImage = ImageIO.read(image);

        createImage(originalImage, archiveName, fontSize, text);

    }

    //Função que cria a imagem por completa
    public static void createImage(BufferedImage originalImage, String archiveName, int fontSize, String text){
        //Cria imagem em memória com transparencia e tamanho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;

        //Cria imagem maior que a original
        var newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        //Copiar imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        //Configurando a fonte do texto
        fontConfigure(graphics, width, newHeight, fontSize, text);

        //Criando diretorio para salvar imagem
        createDirectory(archiveName, newImage);
    }

    //Configurando a fonte do texto da figurinha
    public static void fontConfigure(Graphics2D graphics, int width, int newHeight, int fontSize, String text){
        //Configurar Fonte
        var font = new Font(Font.DIALOG_INPUT, Font.BOLD, fontSize);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        //Escrever uma frase cômica na imagem
        graphics.drawString(text, width-(width*0.7f), newHeight-100);
    }

    //Função que verifica se o diretorio "saida" já está criado
    public static void createDirectory(String archiveName, BufferedImage image){
        File file = new File("src/main/java/org/figurinhas/gerador/saida/");
            try{
                if(file.exists()) {
                    ImageIO.write(image, "png", new File("src/main/java/org/figurinhas/gerador/saida/" + archiveName+".png"));
                }else {
                    file.mkdir();
                    ImageIO.write(image, "png", new File("src/main/java/org/figurinhas/gerador/saida/"+archiveName+".png"));
                }
            }catch (IOException e){
                System.out.println("Não foi possivel salvar a imagem :(");
            }
    }
}

