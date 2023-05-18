package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class RegisterGui implements ActionListener, MouseListener, KeyListener {
    private JFrame registerGui = new JFrame();
    private JLabel backLbl = new JLabel();
    private JLabel userLabel = new JLabel("Username:");
    private JLabel passWLabel1 = new JLabel("Password:");
    private JTextField useTxtFld = new JTextField();
    private JTextField phoneNumtxtfld = new JTextField();
    private JPasswordField pasFld1 = new JPasswordField();
    private JPasswordField pasFld2 = new JPasswordField();
    private JButton resetBtn = new JButton("RESET");
    private JButton registerBtn = new JButton("REGISTER");
    private JPanel thePnl = new JPanel();
    private JButton returnBtn = new JButton("RETURN");
    private JLabel lblPassword = new JLabel("Confirm Password:");
    private JLabel phoneNumlbl = new JLabel("Phone Number:");

    public RegisterGui() { // Default constructor's parameter does not need arguments and does not return
                           // anything; calls 2 methods.
        registerGui.setSize(800, 600);
        registerGui.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
        registerGui.setVisible(true);
        registerGui.setBackground(Color.WHITE);
        registerGui.setTitle("Register");
        registerGui.setResizable(false);
        registerGui.setForeground(Color.WHITE);

        formatElements();
    }

    private void formatElements() {// Private method's parameter does not need arguments and does not return
                                   // anything; formats all visible buttons.
        registerGui.getContentPane().setLayout(null);
        registerGui.getContentPane().setBackground(Color.WHITE);
        registerGui.setIconImage(Toolkit.getDefaultToolkit()
                .getImage(LoginGui.class.getResource("/resources/HOME.png")));
        backLbl.setBounds(0, 0, 786, 563);
        Dimension backLbl1 = backLbl.getSize();
        backLbl.setIcon(
                new ImageIcon(new ImageIcon(getClass().getResource("/resources/TheRightBackground.jpg")).getImage()
                        .getScaledInstance((int) backLbl1.getWidth(), (int) backLbl1.getHeight(), Image.SCALE_SMOOTH)));

        phoneNumtxtfld.setBounds(437, 239, 273, 43);
        phoneNumtxtfld.setForeground(Color.BLACK);
        phoneNumtxtfld.setFont(new Font("Tahoma", Font.PLAIN, 35));
        phoneNumtxtfld.setBorder(null);
        phoneNumtxtfld.setBackground(Color.WHITE);
        phoneNumtxtfld.addKeyListener(this);

        pasFld1.setBounds(437, 133, 273, 43);
        pasFld1.setBorder(null);
        pasFld1.setBackground(Color.WHITE);
        pasFld1.setForeground(Color.BLACK);
        pasFld1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        pasFld1.addKeyListener(this);
        pasFld1.addMouseListener(this);

        pasFld2.setBounds(437, 186, 273, 43);
        pasFld2.setBorder(null);
        pasFld2.setBackground(Color.WHITE);
        pasFld2.setForeground(Color.BLACK);
        pasFld2.setFont(new Font("Tahoma", Font.PLAIN, 35));
        pasFld2.addKeyListener(this);
        pasFld2.addMouseListener(this);

        useTxtFld.setBounds(437, 80, 273, 43);
        useTxtFld.setBorder(null);
        useTxtFld.setBackground(Color.WHITE);
        useTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 35));
        useTxtFld.setForeground(Color.BLACK);
        useTxtFld.addKeyListener(this);

        lblPassword.setBounds(54, 186, 293, 43);
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 35));

        passWLabel1.setForeground(Color.WHITE);
        passWLabel1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        passWLabel1.setBounds(54, 133, 160, 43);

        userLabel.setBounds(54, 80, 170, 43);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        registerBtn.setBounds(23, 467, 226, 70);

        registerGui.getContentPane().add(registerBtn);
        registerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 35));
        registerBtn.setFocusPainted(false);
        registerBtn.setBorderPainted(false);
        registerBtn.setContentAreaFilled(false);
        registerBtn.addMouseListener(this);
        registerBtn.addActionListener(this);
        returnBtn.setBounds(271, 467, 226, 70);

        registerGui.getContentPane().add(returnBtn);
        returnBtn.setForeground(Color.WHITE);
        returnBtn.setFont(new Font("Tahoma", Font.PLAIN, 35));
        returnBtn.setFocusPainted(false);
        returnBtn.setContentAreaFilled(false);
        returnBtn.setBorderPainted(false);
        returnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        returnBtn.addMouseListener(this);
        returnBtn.addActionListener(this);
        returnBtn.setIcon(
                new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HOME.png"))
                        .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        resetBtn.setBounds(520, 467, 226, 70);

        registerGui.getContentPane().add(resetBtn);

        resetBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resetBtn.setForeground(Color.WHITE);
        resetBtn.setFont(new Font("Tahoma", Font.PLAIN, 35));
        resetBtn.setFocusPainted(false);
        resetBtn.setBorderPainted(false);
        resetBtn.setContentAreaFilled(false);
        resetBtn.addMouseListener(this);
        resetBtn.addActionListener(this);

        phoneNumlbl.setForeground(Color.WHITE);
        phoneNumlbl.setFont(new Font("Tahoma", Font.PLAIN, 35));
        phoneNumlbl.setBounds(54, 239, 244, 43);

        registerGui.getContentPane().add(thePnl);
        registerGui.getContentPane().add(backLbl);
        thePnl.setBounds(0, 0, 786, 563);
        thePnl.setBackground(new Color(0, 0, 0, 0));
        thePnl.setLayout(null);
        thePnl.add(phoneNumlbl);
        thePnl.add(lblPassword);
        thePnl.add(passWLabel1);
        thePnl.add(userLabel);
        thePnl.add(phoneNumtxtfld);
        thePnl.add(pasFld2);
        thePnl.add(pasFld1);
        thePnl.add(useTxtFld);
    }

    // Notice: This method is not mine, nor it is my idea; I directly copied it from
    // https://www.baeldung.com/java-regex-validate-phone-numbers.
    public boolean ifValidPhone(String phoneNum) { // Public method's parameter needs a String argument and returns a
                                                   // boolean; checks if the user typed a valid phone number.
        String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Implemented from ActionListener interface. Public method's parameter
                                                 // takes an ActionEvent argument and does not return anything;
                                                 // performs set of actions based on the certain button clicked.
        String username = useTxtFld.getText();
        String password1 = String.valueOf(pasFld1.getPassword());
        String password2 = String.valueOf(pasFld2.getPassword());
        String phone = phoneNumtxtfld.getText();
        String alrdyRegistered = new Tools().searchU(username, String.valueOf(password1));
        if (e.getSource() == registerBtn) {
            if (username.length() < 8) {
                JOptionPane.showMessageDialog(registerGui, "Username needs to be at least 8 characters.");
            } else if (!(password1.equals(password2))) {
                JOptionPane.showMessageDialog(registerGui, "Please enter your password again.");
            } else if (alrdyRegistered.equals("OnlyUsername")) {
                JOptionPane.showMessageDialog(registerGui, "That username is taken.");
            } else if (alrdyRegistered.equals("OnlyPassword")) {
                JOptionPane.showMessageDialog(registerGui, "That password is taken.");
            } else if (alrdyRegistered.equals("Both")) {
                JOptionPane.showMessageDialog(registerGui, "Username and password are taken.");
            } else if ((password1.length() < 8) || (password2.length() < 8)) {
                JOptionPane.showMessageDialog(registerGui, "Password needs to be at least 8 characters.");
            } else if ((username.contains(password1)) || (username.contains(password2))) {
                JOptionPane.showMessageDialog(registerGui, "Username and password cannot be simmilar.");
            } else if (!(finalCheck(username, password1, password2))) {
                JOptionPane.showMessageDialog(registerGui, "No spaces are allowed!");
            } else if ((!(phone.matches("\\d{3}-\\d{3}-\\d{4}"))) || (!(phone.length() == 12))) {
                JOptionPane.showMessageDialog(registerGui,
                        "Invalid phone number:\n Please use the format:\n###-###-####");
            } else if (alrdyRegistered.equals("None")) {
                new Tools().registerTotFile(new User(username, password1, phone));
                JOptionPane.showMessageDialog(registerGui, "Account successfully created!");
                registerGui.dispose();
                LoginGui neww = new LoginGui();
                neww.formatElements();
            }
        }

        if (e.getSource() == resetBtn) {
            useTxtFld.setText("");
            pasFld1.setText("");
            pasFld2.setText("");
            phoneNumtxtfld.setText("");
        }
        if (e.getSource() == returnBtn) {
            LoginGui neww = new LoginGui();
            neww.formatElements();
            registerGui.dispose();
        }
    }

    public boolean finalCheck(String username, String pass1, String pass2) { // Public method's parameter needs 3 String
                                                                             // arguments and returns a boolean;
                                                                             // double checks that the user has not
                                                                             // typed a space.
        if (username.contains(" ") || pass1.contains(" ") || pass2.contains(" "))
            return false;
        else
            return true;
    }

    @Override
    public void mouseEntered(MouseEvent e) { // Implemented from MouseListener interface. Public method's parameter
                                             // takes a MouseEvent argument and does not return anything; displays
                                             // the two password fields when mouse hovers over.
        if (e.getSource() == pasFld1) {
            pasFld1.setEchoChar((char) 0);
            pasFld2.setEchoChar((char) 0);
        }
        if (e.getSource() == pasFld2) {
            pasFld1.setEchoChar((char) 0);
            pasFld2.setEchoChar((char) 0);
        }
        if (e.getSource() == returnBtn)
            returnBtn.setForeground(Color.lightGray);
        if (e.getSource() == resetBtn)
            resetBtn.setForeground(Color.lightGray);
        if (e.getSource() == registerBtn)
            registerBtn.setForeground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent e) { // Implemented from MouseListener interface. Public method's parameter takes
                                            // a MouseEvent argument and does not return anything; displays "*" over
                                            // password1 and password2 when mouse stops hovers over the component.
        if (e.getSource() == pasFld1) {
            pasFld1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
            pasFld2.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
        }
        if (e.getSource() == pasFld2) {
            pasFld1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
            pasFld2.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
        }
        if (e.getSource() == returnBtn)
            returnBtn.setForeground(Color.WHITE);
        if (e.getSource() == resetBtn)
            resetBtn.setForeground(Color.WHITE);
        if (e.getSource() == registerBtn)
            registerBtn.setForeground(Color.WHITE);
    }

    @Override
    public void keyTyped(KeyEvent e) { // Implemented from KeyListener interface. Public method's parameter takes a
                                       // KeyEvent argument and does not return anything; ensures that some keyboard
                                       // keys are not typed.
        if (e.getSource() == pasFld1)
            if (e.getKeyChar() == 32) // Everything but spaces are alowed
                e.consume();

        if (e.getSource() == pasFld2)
            if (e.getKeyChar() == 32)
                e.consume();

        if (e.getSource() == useTxtFld)
            if (e.getKeyChar() == 32)
                e.consume();

        if (e.getSource() == phoneNumtxtfld) {
            char c = e.getKeyChar();
            if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_MINUS) || (c == 41)
                    || (c == 40) || (c == 32) || (c == 95) || (c == 43)))
                e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { // Implemented from KeyListener interface. Public method's parameter takes a
                                         // KeyEvent argument and does not return anything;
        registerGui.setForeground(Color.WHITE);
    }

    @Override
    public void keyReleased(KeyEvent e) { // Implemented from KeyListener interface. Public method's parameter takes a
                                          // KeyEvent argument and does not return anything;
        registerGui.setForeground(Color.GRAY);

    }

    @Override
    public void mouseClicked(MouseEvent e) {// Implemented from MouseListener interface. Public method's parameter takes
                                            // a MouseEvent argument and does not return anything;
        registerGui.setForeground(Color.LIGHT_GRAY);

    }

    @Override
    public void mousePressed(MouseEvent e) {// Implemented from MouseListener interface. Public method's parameter takes
                                            // a MouseEvent argument and does not return anything;
        registerGui.setForeground(Color.gray);
    }

    @Override
    public void mouseReleased(MouseEvent e) {// Implemented from MouseListener interface. Public method's parameter
                                             // takes a MouseEvent argument and does not return anything;
        registerGui.setForeground(Color.darkGray);
    }
}