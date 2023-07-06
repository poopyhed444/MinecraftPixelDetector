package org.xinepeng;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class OpenCV {
    public static String ColorDetector(String urlStr) throws IOException {
        nu.pattern.OpenCV.loadShared();
        URL url = new URL(urlStr);
        BufferedImage img = ImageIO.read(url);
        Mat mat = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC3);
        Mat hsvImage = new Mat();
        Imgproc.cvtColor(mat, hsvImage , Imgproc.COLOR_BGR2HSV);
        Mat blackMask = new Mat();
        Scalar lowerBlack = new Scalar(0, 0, 0);
        Scalar upperBlack = new Scalar(180, 255, 50);
        Core.inRange(hsvImage , lowerBlack, upperBlack, blackMask);
        Mat whiteMask = new Mat();
        Scalar lowerWhite = new Scalar(0, 0, 200);
        Scalar upperWhite = new Scalar(180, 30, 255);
        Core.inRange(hsvImage , lowerWhite, upperWhite, whiteMask);
        int black_pixels = Core.countNonZero(blackMask);
        int white_pixels = Core.countNonZero(whiteMask);
        if (black_pixels > white_pixels) {
            return "§c§lBlack";
        } else {
            return "§f§lWhite";
        }
    }
}
