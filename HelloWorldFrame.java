import java.awt.*;

public class HelloWorldFrame {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(300, 200);
        frame.setBackground(Color.RED);
        Label label = new Label("Hello World", Label.CENTER);
        frame.add(label);
        frame.setVisible(true);
    }
}
