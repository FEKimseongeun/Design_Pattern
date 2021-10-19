package observerPattern.Homework;//�輺�� 201910782
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainWindow extends FrameWindow implements ActionListener {
    private static final String MAIN_TITLE = "StrategyPattern.Practice.Main Window";
    private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
    private static final String LABEL_WINDOW_TITLE = "Label Window";
    private static final String REMOVE_TITLE = "Remove ";
    private static final String ADD_TITLE = "Add ";
    private static final String TEXTFIELD_OBSERVER_BUTTON_TITLE = "TextField Window Observer";
    private static final String LABEL_OBSERVER_BUTTON_TITLE = "Label Window Observer";
    private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static final int GAP = 50;

    private JButton stopButton;
    private JButton textFieldObserverButton;
    private JButton labelObserverButton;
    private PrimeObservableThread primeThread;
    private TextFieldWindow textFieldWindow;
    private LabelWindow labelWindow;
    private boolean textFieldObserverRemoved = false;
    private boolean labelObserverRemoved = false;

    public MainWindow(String title) {
        super(title, X, Y, WIDTH, HEIGHT);
        primeThread = new PrimeObservableThread();
        textFieldWindow = new TextFieldWindow(TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
        labelWindow = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);
        createWindow(title, X, Y, WIDTH, HEIGHT);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                primeThread.stopRunning();
                textFieldWindow.closeWindow();
                labelWindow.closeWindow();
                System.exit(0);
            }
        });

        primeThread.addObserver(textFieldWindow);
        primeThread.addObserver(labelWindow);
        primeThread.run();
    }

    private JButton createButton(String text, ActionListener listener, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height / 3);
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
        button.setPreferredSize(buttonDimension);
        return button;
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(width, height));
        textFieldObserverButton = createButton(REMOVE_TITLE + TEXTFIELD_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(textFieldObserverButton);
        labelObserverButton = createButton(REMOVE_TITLE + LABEL_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(labelObserverButton);
        stopButton = createButton(STOP_THREAD_BUTTON_TITLE, this, width, height);
        panel.add(stopButton);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textFieldObserverButton) {
            if (textFieldObserverRemoved) {
                primeThread.addObserver(textFieldWindow);
                textFieldObserverRemoved = false;
                textFieldObserverButton.setText(REMOVE_TITLE + TEXTFIELD_OBSERVER_BUTTON_TITLE);
            }
            else {
                primeThread.removeObserver(textFieldWindow);
                textFieldObserverRemoved = true;
                textFieldObserverButton.setText(ADD_TITLE + TEXTFIELD_OBSERVER_BUTTON_TITLE);
            }
        }
        else if (e.getSource() == labelObserverButton) {
            if (labelObserverRemoved) {
                primeThread.addObserver(labelWindow);
                labelObserverRemoved = false;
                labelObserverButton.setText(REMOVE_TITLE + LABEL_OBSERVER_BUTTON_TITLE);
            }
            else {
                primeThread.removeObserver(labelWindow);
                labelObserverRemoved = true;
                labelObserverButton.setText(ADD_TITLE + LABEL_OBSERVER_BUTTON_TITLE);
            }
        }
        else if (e.getSource() == stopButton) {
            primeThread.stopRunning();
        }
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(MainWindow.MAIN_TITLE);
    }
}