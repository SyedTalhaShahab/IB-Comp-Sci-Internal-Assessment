package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginGui extends JFrame implements ActionListener, KeyListener, MouseListener {
    private static final long serialVersionUID = 1L;
    private JButton resetBtn = new JButton("CLEAR");
    private JButton adminBtn = new JButton("ADMIN");
    private JButton loginBtn = new JButton("LOGIN");
    private JButton registerBtn = new JButton("REGISTER");
    private JTextField textField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JPanel pnlForContents = new JPanel(); // I am using lightweight Jpanel and not heavy-loaded Jframe.
    private JLabel lblBackGrd = new JLabel();
    private JLabel userLabel = new JLabel("USERNAME:");
    private JLabel passWLabel = new JLabel("PASSWORD:");

    public LoginGui() {
        this.setSize(610, 415);
        this.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        this.setBackground(Color.WHITE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(LoggedInGui.class.getResource("/resources/HOME.png")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Riu Plaza");
        this.setForeground(Color.BLACK);
        this.setResizable(false);
        this.setVisible(true);
        this.formatElements2();
    }

    public static void main(String[] args) { // Public static method's parameter needs a String array of arguments and
                                             // does not return anything; calls 2 public methods from other classes.

        LoginGui doSecond = new LoginGui();
        doSecond.formatElements();
        Tools doFirst = new Tools();
        doFirst.readFile();
    }

    public void formatElements() { // Private method's parameter does not need arguments and does not return
                                   // anything; formats all visible buttons.
        pnlForContents.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        lblBackGrd
                .setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/resources/Login Screen.jpg"))
                        .getImage().getScaledInstance(600, 400, BufferedImage.SCALE_SMOOTH)));
        lblBackGrd.setBounds(0, 0, 594, 378);

        userLabel.setForeground(Color.WHITE);
        userLabel.setBounds(56, 40, 195, 43);
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 31));

        passWLabel.setForeground(Color.WHITE);
        passWLabel.setBounds(56, 117, 205, 43);
        passWLabel.setFont(new Font("Tahoma", Font.BOLD, 31));

        textField.setForeground(new Color(142, 142, 142));
        textField.setFont(new Font("Tahoma", Font.BOLD, 30));
        textField.setSize(192, 43);
        textField.setLocation(241, 41);
        textField.setBounds(335, 37, 192, 49);
        textField.addKeyListener(this);
        textField.setBorder(null);

        passwordField.setForeground(new Color(142, 142, 142));
        passwordField.setFont(new Font("Tahoma", Font.BOLD, 30));
        passwordField.setBounds(335, 119, 192, 43);
        passwordField.addKeyListener(this);
        passwordField.addMouseListener(this);
        passwordField.setBorder(null);

        adminBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        adminBtn.setBounds(26, 282, 188, 51);
        adminBtn.setForeground(Color.WHITE);
        adminBtn.setFont(new Font("Tahoma", Font.BOLD, 35));
        adminBtn.setFocusPainted(false);
        adminBtn.setBorderPainted(false);
        adminBtn.setContentAreaFilled(false);
        adminBtn.addActionListener(this);
        adminBtn.addMouseListener(this);

        resetBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resetBtn.setBounds(283, 221, 192, 51);
        resetBtn.setForeground(Color.WHITE);
        resetBtn.setFont(new Font("Tahoma", Font.BOLD, 35));
        resetBtn.setFocusPainted(false);
        resetBtn.setBorderPainted(false);
        resetBtn.setContentAreaFilled(false);
        resetBtn.addActionListener(this);
        resetBtn.addMouseListener(this);

        loginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginBtn.setBounds(26, 221, 188, 51);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Tahoma", Font.BOLD, 35));
        loginBtn.setFocusPainted(false);
        loginBtn.setBorderPainted(false);
        loginBtn.setContentAreaFilled(false);
        loginBtn.addActionListener(this);
        loginBtn.addMouseListener(this);

        registerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerBtn.setBounds(293, 282, 234, 51);
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(new Font("Tahoma", Font.BOLD, 35));
        registerBtn.setFocusPainted(false);
        registerBtn.setBorderPainted(false);
        registerBtn.setContentAreaFilled(false);
        registerBtn.addActionListener(this);
        registerBtn.addMouseListener(this);

    }

    public void formatElements2() {
        pnlForContents.setBounds(0, 0, 596, 378);
        pnlForContents.add(loginBtn);
        pnlForContents.add(adminBtn);
        pnlForContents.add(resetBtn);
        pnlForContents.add(registerBtn);
        pnlForContents.add(userLabel);
        pnlForContents.add(passWLabel);
        pnlForContents.add(textField);
        pnlForContents.add(passwordField);
        pnlForContents.add(lblBackGrd);
        getContentPane().add(pnlForContents);
    }

    @Override
    public void actionPerformed(ActionEvent e) {// Implemented from ActionListener interface. Public method's parameter
                                                // takes an ActionEvent argument and does not return anything; performs
                                                // set of actions based on the certain button clicked.
        String username = String.valueOf(textField.getText());
        String password = String.valueOf(passwordField.getPassword());
        if (e.getSource() == adminBtn) {
        if (new Tools().searchA(username, password)) { // replace true in if statement to avoid user and pass
                new AdminGui();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Admin Username or Password.");
            }
        }
        if (e.getSource() == (registerBtn)) {
            new RegisterGui();
            this.dispose();
        }
        if (e.getSource() == (resetBtn)) {
            textField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == (loginBtn)) {
            if ((!username.contains(" ")) && (!password.contains(" "))) {
                String alrdyRegistered = new Tools().searchU(username, password);
                if (alrdyRegistered.equals("Both")) {
                    if (new Tools().isAcceptedTermsNCon(password)) {
                        JOptionPane.showMessageDialog(this,
                                "Terms and Conditions Already Signed.\nPlease contact 571-101-7078.");
                    } else {
                        new LoggedInGui(username, password);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter valid values.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No spaces are allowed.");
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {// Implemented from MouseListener interface. Public method's parameter takes
                                            // a MouseEvent argument and does not return anything; creates a hover
                                            // effect for buttons.
        if (e.getSource().equals(passwordField))
            passwordField.setEchoChar((char) 0);
        if (e.getSource().equals(adminBtn))
            adminBtn.setForeground(Color.lightGray);
        if (e.getSource().equals(resetBtn))
            resetBtn.setForeground(Color.lightGray);
        if (e.getSource().equals(registerBtn))
            registerBtn.setForeground(Color.lightGray);
        if (e.getSource().equals(loginBtn))
            loginBtn.setForeground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent e) {// Implemented from MouseListener interface. Public method's parameter takes
                                           // a MouseEvent argument and does not return anything; creates a hover
                                           // effect for buttons.
        if (e.getSource().equals(passwordField))
            passwordField.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
        if (e.getSource().equals(adminBtn))
            adminBtn.setForeground(Color.WHITE);
        if (e.getSource().equals(resetBtn))
            resetBtn.setForeground(Color.WHITE);
        if (e.getSource().equals(registerBtn))
            registerBtn.setForeground(Color.WHITE);
        if (e.getSource().equals(loginBtn))
            loginBtn.setForeground(Color.WHITE);
    }

    @Override
    public void keyTyped(KeyEvent e) { // Implemented from KeyListener interface. Public method's parameter takes a
                                       // KeyEvent argument and does not return anything; ensures the keys typed in
                                       // textField and passwordField are restricted.
        if (e.getSource().equals(textField)) {
            char c = e.getKeyChar();
            if (c == 32)
                e.consume();
        }
        if (e.getSource().equals(passwordField)) {
            char c = e.getKeyChar();
            if (c == 32)
                e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { // Implemented from KeyListener interface. Public method's parameter takes a
                                         // KeyEvent argument and does not return anything;
        this.setForeground(Color.WHITE);
    }

    @Override
    public void mouseClicked(MouseEvent e) { // Implemented from MouseListener interface. Public method's parameter
                                             // takes a MouseEvent argument and does not return anything;
        this.setForeground(Color.BLACK);
    }

    @Override
    public void mousePressed(MouseEvent e) { // Implemented from MouseListener interface. Public method's parameter
                                             // takes a MouseEvent argument and does not return anything;
        this.setForeground(Color.LIGHT_GRAY);
    }

    @Override
    public void mouseReleased(MouseEvent e) { // Implemented from MouseListener interface. Public method's parameter
                                              // takes a MouseEvent argument and does not return anything;
        this.setForeground(Color.DARK_GRAY);
    }

    @Override
    public void keyReleased(KeyEvent e) { // Implemented from KeyListener interface. Public method's parameter takes a
                                          // KeyEvent argument and does not return anything;
        this.setForeground(Color.LIGHT_GRAY);
    }
}
