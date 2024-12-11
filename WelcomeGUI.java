package OOP;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeGUI {
    JFrame welcomeFrame, frame2;
    JButton Enterbutton;
    JLabel label1, label2, Imagelabel1;
    JPanel panel1, panel2;
    JTextField textField1, textField2;
    Font labelFont;
    ImageIcon image;
    Image frameicon;

    WelcomeGUI(){

        //frame Creation
        welcomeFrame = new JFrame("Welcome to our Library");
        welcomeFrame.setLayout(null);
        welcomeFrame.setSize(800, 800);
        labelFont = new Font("Roboto", Font.BOLD, 20);
        frameicon = Toolkit.getDefaultToolkit().getImage("C:/Users/Xedrik/Downloads/PSULOGO.png");
        welcomeFrame.setIconImage(frameicon);

        //panel creation
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setSize(800, 800);

        image = new ImageIcon("C:/Users/Xedrik/Downloads/psuschool.jpg");
        Imagelabel1 = new JLabel(image);
        Imagelabel1.setBounds(0, 0, 800, 350);
        panel1.add(Imagelabel1);

        //label creation
        label1 = new JLabel("Enter your Username");
        label1.setBounds(300, 400, 250, 20);
        label1.setFont(labelFont);
        panel1.add(label1);

        textField1 = new JTextField();
        textField1.setBounds(300, 425, 200, 30);
        panel1.add(textField1);

        label2 = new JLabel("Enter your Password");
        label2.setBounds(300, 475, 200, 20);
        label2.setFont(labelFont);
        panel1.add(label2);

        textField2 = new JTextField();
        textField2.setBounds(300, 500, 200, 30);
        panel1.add(textField2);


        Enterbutton = new JButton("Confirm");
        Enterbutton.setBounds(350, 550, 80, 30);
        panel1.add(Enterbutton);

        Enterbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String username = textField1.getText();
                String password = textField2.getText();

                if("admin".equals(username) && "admin".equals(password) || "Xedrik".equals(username) && "password".equals(password) || "Arlrom".equals(username) && "Nexercor".equals(password) ){
                    welcomeFrame.dispose();

                    new MainLibraryGUI(username);
                    return;

                }
                else{
                    JOptionPane.showMessageDialog(welcomeFrame, "Invalid Username or Password");
                }

            }
        });


        //adding the panel to the frame
        welcomeFrame.add(panel1);
        welcomeFrame.setVisible(true);

        //Window Action Listener for Closing the window
        welcomeFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                welcomeFrame.dispose();
            }
        });

    }
}