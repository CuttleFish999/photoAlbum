package com.photoalbum.dodo.unit;

import net.coobird.thumbnailator.Thumbnails;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;



public class createThumbnail {
    public byte[] createThumbnail(byte[] imageBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // 設置縮圖大小和質量
        Thumbnails.of(inputStream)
                .size(200, 200) // 這裡的尺寸可以根據需要調整
                .outputQuality(0.8) // 輸出的圖片質量，範圍是0.0至1.0
                .toOutputStream(outputStream);

        return outputStream.toByteArray();
    }
}