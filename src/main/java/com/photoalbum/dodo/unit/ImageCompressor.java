package com.photoalbum.dodo.unit;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageCompressor {
    final static Integer WEIGHT = 1000;
    final static Integer HEIGHT = 752;
    final static String FORMATENAME = "JPG";

    final static String FORMPATH = "C:\\Users\\apple\\OneDrive\\桌面\\photoAlbumNew\\src\\main\\resources\\static\\image\\frontEnd\\CLT-L29026 (2).JPG";

    final static String OKPATH = "C:\\Users\\apple\\OneDrive\\桌面\\photoAlbumNew\\src\\main\\resources\\static\\image\\frontEnd\\new." +FORMATENAME;
    public static void compressImage(File inputFile, File outputFile, int targetWidth, int targetHeight, String formatName) throws Exception {
        // 讀取原始圖片
        BufferedImage originalImage = ImageIO.read(inputFile);

        // 創建一個新的、空的圖片，用於繪製壓縮後的圖片
        BufferedImage compressedImage = new BufferedImage(targetWidth, targetHeight, originalImage.getType());
        Graphics2D g2d = compressedImage.createGraphics();

        // 繪製並重新尺寸
        g2d.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g2d.dispose();

        // 保存壓縮後的圖片到文件
        ImageIO.write(compressedImage, formatName, outputFile);
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File(FORMPATH);
            File outputFile = new File(OKPATH);
            int targetWidth = WEIGHT;
            int targetHeight = HEIGHT;
            String formatName = FORMATENAME;

            compressImage(inputFile, outputFile, targetWidth, targetHeight, formatName);
            System.out.println("Image compression completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error during image compression.");
        }
    }
}
