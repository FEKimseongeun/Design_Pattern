package observerPattern.Homework;

import javax.swing.*;
import java.awt.*;

public class TextFieldWindow extends FrameWindow implements Observer {
    JTextField textField;

    TextFieldWindow(String title, int x, int y, int width, int height) {
        super(title, x, y, width, height);
        createWindow(title, x, y, width, height);
    }

    public void updateText(String msg) {
        textField.setText(msg);
        textField.validate();
    }


    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textField = new JTextField();
        panel.add(textField);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    @Override
    public void update(int n) {
        updateText("" + n);
    }
}