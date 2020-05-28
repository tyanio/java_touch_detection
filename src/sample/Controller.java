package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.io.ByteArrayInputStream;

public class Controller {
    @FXML
    private Button start_btn;
    @FXML
    private ImageView currentFrame;

    private VideoCapture capture = new VideoCapture();

    public void startCamera(javafx.event.ActionEvent actionEvent) {
        capture.open(0);
        Mat frame = new Mat();
        MatOfByte buffer = new MatOfByte();

        if(capture.isOpened()){
            capture.read(frame);
            Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
            Imgcodecs.imencode(".png", frame, buffer);
            currentFrame.setImage(new Image(new ByteArrayInputStream(buffer.toArray())));
        }
    }
}
