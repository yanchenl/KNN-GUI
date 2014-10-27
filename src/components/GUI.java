package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame("KNN");
    private JButton input1 = new JButton("Select");
    private JButton input2 = new JButton("Select");
    private JButton submit = new JButton("Submit");
    private JLabel inLabel1 = new JLabel("Training Data:");
    private JLabel inLabel2 = new JLabel("Testing Data:");
    InMonitor1 inMonitor1 = new InMonitor1();
    InMonitor2 inMonitor2 = new InMonitor2();
    SubmitMonitor submitMonitor = new SubmitMonitor();
    TextMonitor textMonitor = new TextMonitor();
    private JTextField data1 = new JTextField(10);
    private JTextField data2 = new JTextField(10);
    String inputFile1;
    String inputFile2;

    public GUI() {
        this.frame.setLayout(null);
        this.frame.setSize(600, 200);
        this.inLabel1.setBounds(5, 25, 80, 20);
        this.inLabel2.setBounds(5, 50, 80, 20);
        this.input1.setBounds(450, 25, 80, 20);
        this.input2.setBounds(450, 50, 80, 20);
        this.submit.setBounds(450, 110, 80, 20);
        this.data1.setBounds(100, 25, 300, 20);
        this.data2.setBounds(100, 50, 300, 20);
        this.frame.add(inLabel1);
        this.frame.add(inLabel2);
        this.frame.add(input1);
        this.frame.add(input2);
        this.frame.add(data1);
        this.frame.add(data2);
        this.frame.add(submit);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.input1.addActionListener(inMonitor1);
        this.input2.addActionListener(inMonitor2);
        this.submit.addActionListener(submitMonitor);
        this.submit.addActionListener(textMonitor);
    }

    public class InMonitor1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            File workingDirectory = new File(System.getProperty("user.dir"));
            fc.setCurrentDirectory(workingDirectory);
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.showDialog(new JLabel(), "Select Train Data");
            File file = fc.getSelectedFile();
            //System.out.println(file.getAbsolutePath());
            inputFile1 = file.getAbsolutePath();
            data1.setText(inputFile1);
        }
    }

    public class InMonitor2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            File workingDirectory = new File(System.getProperty("user.dir"));
            fc.setCurrentDirectory(workingDirectory);
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.showDialog(new JLabel(), "Select Test Data");
            File file = fc.getSelectedFile();
            //System.out.println(file.getAbsolutePath());
            inputFile2 = file.getAbsolutePath();
            data2.setText(inputFile2);
        }
    }

    public class SubmitMonitor implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            inputFile1 = getInput1();
            inputFile2 = getInput2();
            System.out.println(inputFile1);
            System.out.println(inputFile2);
            //begin to run the following code
        }
    }

    public class TextMonitor implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String d1 = data1.getText();
            String d2 = data2.getText();
            inputFile1 = d1;
            inputFile2 = d2;
        }
    }

    public String getInput1() {
        return inputFile1;
    }

    public String getInput2() {
        return inputFile2;
    }

    public static void main(String[] args) throws InterruptedException {
        GUI gui = new GUI();
        Thread.sleep(10000);
        String inputFile1 = gui.getInput1();
        String inputFile2 = gui.getInput2();
        System.out.println(inputFile1);
        System.out.println(inputFile2);
    }
}
