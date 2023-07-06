package org.xinepeng;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.IOException;
import java.net.URL;

public class OpenCV {
    public static String ColorDetector(String urlStr) throws IOException {
        nu.pattern.OpenCV.loadShared();
        URL url = new URL(urlStr);
        Mat mat = Imgcodecs.imread(url.toString());
        int height = mat.height();
        int width = mat.width();
        int black_pixels = Core.countNonZero(mat);
        int white_pixels = (height * width) - black_pixels;
        if (black_pixels > white_pixels) {
            return "§c§lBlack";
        } else {
            return "§f§lWhite";
        }
    }
}
