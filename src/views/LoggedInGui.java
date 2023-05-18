package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;

public class LoggedInGui implements ActionListener, MouseListener {
    private JFrame mainWindow = new JFrame("Riu Plaza ");
    private JButton showMorePho = new JButton("Company Website");
    private JButton mainReturn = new JButton("Log Out Account");
    private JButton moreInfo = new JButton("What Is Included");
    private JButton acceptLease = new JButton("Accept Lease");

    private JPanel pnlForContents = new JPanel();
    private JButton Photo1 = new JButton();
    private JButton Photo2 = new JButton();
    private JButton Photo3 = new JButton();
    private JButton Photo4 = new JButton();
    private JButton Photo5 = new JButton();
    private JButton Photo6 = new JButton();
    private JButton Photo7 = new JButton();
    private JButton Photo8 = new JButton();
    private JButton Photo9 = new JButton();
    private JButton returnButton2 = new JButton();

    private JFrame zoomedInWindow = new JFrame();
    private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private double screenWidth = size.getWidth();
    private double screenHeight = size.getHeight();
    private String username, password;

    private int indexOfCurrentUser;

    public LoggedInGui(String u, String p) {
        this.username = u;
        this.password = p;

        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainWindow.setSize((int) screenWidth, (int) screenHeight);
        mainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(
                LoggedInGui.class.getResource("/resources/HOME.png")));
        mainWindow.setLocationRelativeTo(null);

        showMorePho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        showMorePho.setForeground(Color.WHITE);
        showMorePho.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        showMorePho.setFocusPainted(false);
        showMorePho.setBorderPainted(true);
        showMorePho.setContentAreaFilled(false);
        showMorePho.addActionListener(this);
        showMorePho.addMouseListener(this);
        showMorePho.setBorder(new RoundBtn(15));

        mainReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainReturn.setForeground(Color.WHITE);
        mainReturn.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        mainReturn.setFocusPainted(false);
        mainReturn.setBorderPainted(true);
        mainReturn.setContentAreaFilled(false);
        mainReturn.addActionListener(this);
        mainReturn.addMouseListener(this);
        mainReturn.setBorder(new RoundBtn(15));

        moreInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moreInfo.setForeground(Color.WHITE);
        moreInfo.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        moreInfo.setFocusPainted(false);
        moreInfo.setBorderPainted(true);
        moreInfo.setContentAreaFilled(false);
        moreInfo.addActionListener(this);
        moreInfo.addMouseListener(this);
        moreInfo.setBorder(new RoundBtn(15));

        acceptLease.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        acceptLease.setForeground(Color.WHITE);
        acceptLease.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        acceptLease.setFocusPainted(false);
        acceptLease.setBorderPainted(true);
        acceptLease.setContentAreaFilled(false);
        acceptLease.addActionListener(this);
        acceptLease.addMouseListener(this);
        acceptLease.setBorder(new RoundBtn(15));

        pnlForContents.setLayout(null);
        mainWindow.getContentPane().setLayout(null);

        int p1PosX = 0;
        int p1PosY = 0;
        int p1Width = (int) ((31.0 / 96.0) * screenWidth);
        int p1Height = (int) (((1.0 / 3.0) * (screenHeight - 40)));
        Photo1.setBounds(p1PosX, p1PosY, p1Width, p1Height);
        Photo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Photo1.setForeground(Color.WHITE);
        Photo1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Photo1.setFocusPainted(false);
        Photo1.setBorderPainted(false);
        Photo1.setContentAreaFilled(false);
        Photo1.addActionListener(this);
        Photo1.addMouseListener(this);

        int p2PosX = 0;
        int p2PosY = p1Height + 5;
        int p2Width = p1Width;
        int p2Height = (int) (((1.0 / 3.0) * (screenHeight - 40)));
        Photo2.setBounds(p2PosX, p2PosY, p2Width, p2Height);
        Photo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Photo2.setForeground(Color.WHITE);
        Photo2.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Photo2.setFocusPainted(false);
        Photo2.setBorderPainted(false);
        Photo2.setContentAreaFilled(false);
        Photo2.addActionListener(this);
        Photo2.addMouseListener(this);

        int p3PosX = p1Width + 5;
        int p3PosY = 0;
        int p3Width = (int) ((22.5 / 48.0) * screenWidth);
        int p3Height = (int) ((28.5 / 54.0) * screenHeight);
        Photo3.setBounds(p3PosX, p3PosY, p3Width, p3Height);
        Photo3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Photo3.setForeground(Color.WHITE);
        Photo3.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Photo3.setFocusPainted(false);
        Photo3.setBorderPainted(false);
        Photo3.setContentAreaFilled(false);
        Photo3.addActionListener(this);
        Photo3.addMouseListener(this);

        int p4PosX = p1Width + 5 + p3Width + 5;
        int p4PosY = 0;
        int p4Width = (int) ((screenWidth - (p1Width + 5 + p3Width + 5)));
        int p4Height = (int) ((7.0 / 27.0) * screenHeight);
        Photo4.setBounds(p4PosX, p4PosY, p4Width, p4Height);
        Photo4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Photo4.setForeground(Color.WHITE);
        Photo4.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Photo4.setFocusPainted(false);
        Photo4.setBorderPainted(false);
        Photo4.setContentAreaFilled(false);
        Photo4.addActionListener(this);
        Photo4.addMouseListener(this);

        int p5PosX = p4PosX;
        int p5PosY = p4Height + 5;
        int p5Width = p4Width;
        int p5Height = p4Height;
        Photo5.setBounds(p5PosX, p5PosY, p5Width, p5Height);
        Photo5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Photo5.setForeground(Color.WHITE);
        Photo5.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Photo5.setFocusPainted(false);
        Photo5.setBorderPainted(false);
        Photo5.setContentAreaFilled(false);
        Photo5.addActionListener(this);
        Photo5.addMouseListener(this);

        int p6PosX = 0;
        int p6PosY = p2PosY + p2Height + 5;
        int p6Width = p1Width;
        int p6Height = (int) (((1.0 / 3.0) * (screenHeight - 40)));
        Photo6.setBounds(p6PosX, p6PosY, p6Width, p6Height);
        Photo6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Photo6.setForeground(Color.WHITE);
        Photo6.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Photo6.setFocusPainted(false);
        Photo6.setBorderPainted(false);
        Photo6.setContentAreaFilled(false);
        Photo6.addActionListener(this);
        Photo6.addMouseListener(this);

        int p7PosX = p3PosX;
        int p7PosY = p3PosY + p3Height + 5;
        int p7Width = (int) (p3Width * (2.0 / 3.0));
        int p7Height = (int) (((screenHeight - 40) - p3Height));
        Photo7.setBounds(p7PosX, p7PosY, p7Width, p7Height);
        Photo7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Photo7.setForeground(Color.WHITE);
        Photo7.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Photo7.setFocusPainted(false);
        Photo7.setBorderPainted(false);
        Photo7.setContentAreaFilled(false);
        Photo7.addActionListener(this);
        Photo7.addMouseListener(this);

        int p8PosX = (int) (p6Width + p7Width + 10);
        int p8PosY = (int) (p3Height + 5);
        int p8Width = (int) (((screenWidth - 10) - p6Width - p7Width) - 100);
        int p8Height = (int) ((p7Height) * (1.0 / 2.0));
        Photo8.setBounds(p8PosX, p8PosY, p8Width, p8Height);
        Photo8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Photo8.setForeground(Color.WHITE);
        Photo8.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Photo8.setFocusPainted(false);
        Photo8.setBorderPainted(false);
        Photo8.setContentAreaFilled(false);
        Photo8.addActionListener(this);
        Photo8.addMouseListener(this);

        int p9PosX = p8PosX;
        int p9PosY = p8PosY + p8Height + 5;
        int p9Width = (int) ((p8Width + 5) * (5.0 / 10.0));
        int p9Height = p8Height;
        Photo9.setBounds(p9PosX, p9PosY, p9Width, p9Height);
        Photo9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Photo9.setForeground(Color.WHITE);
        Photo9.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Photo9.setFocusPainted(false);
        Photo9.setBorderPainted(false);
        Photo9.setContentAreaFilled(false);
        Photo9.addActionListener(this);
        Photo9.addMouseListener(this);

        int showMorePhoW = (int) ((19.0 / 100.0) * screenWidth);
        int showMorePhoH = (int) ((4.0 / 100.0) * screenHeight);
        int showMorePhoX = (int) (screenWidth - p4Width);
        int showMorePhoY = (p8PosY + p8Height + 5);
        showMorePho.setBounds(showMorePhoX, showMorePhoY, showMorePhoW, showMorePhoH);

        int mainReturnX = (int) (p9PosX + p9Width + 5);
        int mainReturnY = showMorePhoY + showMorePhoH + 5;
        int mainReturnW = showMorePhoW;
        int mainReturnH = showMorePhoH;
        mainReturn.setBounds(mainReturnX, mainReturnY, mainReturnW, mainReturnH);

        int moreInfoX = mainReturnX;
        int moreInfoY = mainReturnY + mainReturnH + 5;
        int moreInfoW = showMorePhoW;
        int moreInfoH = showMorePhoH;
        moreInfo.setBounds(moreInfoX, moreInfoY, moreInfoW, moreInfoH);

        int acceptLeaseX = moreInfoX;
        int acceptLeaseY = moreInfoY + mainReturnH + 5;
        int acceptLeaseW = showMorePhoW;
        int acceptLeaseH = showMorePhoH;
        acceptLease.setBounds(acceptLeaseX, acceptLeaseY, acceptLeaseW, acceptLeaseH);

        Photo1.setIcon(icon2ImgAndBack("Light1.jpg", Photo1.getWidth(), Photo1.getHeight()));
        Photo1.setRolloverIcon(icon2ImgAndBack("Dark1.jpg", Photo1.getWidth(), Photo1.getHeight()));
        Photo2.setIcon(icon2ImgAndBack("Light2.jpg", Photo2.getWidth(), Photo2.getHeight()));
        Photo2.setRolloverIcon(icon2ImgAndBack("Dark2.jpg", Photo2.getWidth(), Photo2.getHeight()));
        Photo3.setIcon(icon2ImgAndBack("Light3.jpg", Photo3.getWidth(), Photo3.getHeight()));
        Photo3.setRolloverIcon(icon2ImgAndBack("Dark3.jpg", Photo3.getWidth(), Photo3.getHeight()));
        Photo4.setIcon(icon2ImgAndBack("Light4.jpg", Photo4.getWidth(), Photo4.getHeight()));
        Photo4.setRolloverIcon(icon2ImgAndBack("Dark4.jpg", Photo4.getWidth(), Photo4.getHeight()));
        Photo5.setIcon(icon2ImgAndBack("Light5.jpg", Photo5.getWidth(), Photo5.getHeight()));
        Photo5.setRolloverIcon(icon2ImgAndBack("Dark5.jpg", Photo5.getWidth(), Photo5.getHeight()));
        Photo6.setIcon(icon2ImgAndBack("Light6.jpg", Photo6.getWidth(), Photo6.getHeight()));
        Photo6.setRolloverIcon(icon2ImgAndBack("Dark6.jpg", Photo6.getWidth(), Photo6.getHeight()));
        Photo7.setIcon(icon2ImgAndBack("Light7.jpg", Photo7.getWidth(), Photo7.getHeight()));
        Photo7.setRolloverIcon(icon2ImgAndBack("Dark7.jpg", Photo7.getWidth(), Photo7.getHeight()));
        Photo8.setIcon(icon2ImgAndBack("Light8.jpg", Photo8.getWidth(), Photo8.getHeight()));
        Photo8.setRolloverIcon(icon2ImgAndBack("Dark8.jpg", Photo8.getWidth(), Photo8.getHeight()));
        Photo9.setIcon(icon2ImgAndBack("Light9.jpg", Photo9.getWidth(), Photo9.getHeight()));
        Photo9.setRolloverIcon(icon2ImgAndBack("Dark9.jpeg", Photo9.getWidth(), Photo9.getHeight()));

        mainWindow.getContentPane().add(mainReturn);
        mainWindow.getContentPane().add(moreInfo);
        mainWindow.getContentPane().add(acceptLease);
        mainWindow.getContentPane().add(showMorePho);

        mainWindow.getContentPane().add(Photo1);
        mainWindow.getContentPane().add(Photo2);
        mainWindow.getContentPane().add(Photo3);
        mainWindow.getContentPane().add(Photo4);
        mainWindow.getContentPane().add(Photo5);
        mainWindow.getContentPane().add(Photo6);
        mainWindow.getContentPane().add(Photo7);
        mainWindow.getContentPane().add(Photo8);
        mainWindow.getContentPane().add(Photo9);

        mainWindow.setVisible(true);
        mainWindow.getContentPane().setBackground(Color.DARK_GRAY);

        findIndexOfCurrentUser();

    }

    private void findIndexOfCurrentUser() { // Private method's parameter does not need arguments and does not
                                            // return anything; finds the index of the current user using the
                                            // application.
        int i = 0;
        int dahSize = new Tools().getUserList().size();
        while (i < dahSize) {
            if ((new Tools().getUserList().get(i).getUsername()).equalsIgnoreCase(username)
                    && (new Tools().getUserList().get(i).getPassword()).equalsIgnoreCase(password)) {
                indexOfCurrentUser = i;
                return; //break out of method
            }
            i++;
        }
    }

    public Icon icon2ImgAndBack(String temp, int w, int h) {
        return new ImageIcon(new ImageIcon(getClass().getResource("/resources/Photos/" + temp)).getImage()
                .getScaledInstance(w, h, Image.SCALE_SMOOTH));
    } // Takes 5 seconds

    public String formatReceipt() { // Public method's parameter does not need arguments and returns a
                                    // String; formats the pane that will display the user's selected options on the
                                    // receipt.

        int bedz = new Tools().getUserList().get(indexOfCurrentUser).getBeds(); // double
        int roomSize = new Tools().getUserList().get(indexOfCurrentUser).getRoomSize(); // 250
        return "Bed" + bedz + "\tRoom Size: \t" + roomSize;
    }

    private void createImagePage() {
        zoomedInWindow = new JFrame("RIU Plaza");
        zoomedInWindow.setIconImage(
                Toolkit.getDefaultToolkit().getImage(LoggedInGui.class.getResource("/resources/HOME.png")));
        zoomedInWindow.setVisible(true);
        zoomedInWindow.setResizable(false);
        zoomedInWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        zoomedInWindow.setSize((int) screenWidth, (int) screenHeight);
        zoomedInWindow.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen

        returnButton2.setFocusPainted(false);
        returnButton2.setBorderPainted(true);
        returnButton2.setContentAreaFilled(false);
        returnButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        returnButton2.addMouseListener(this);
        returnButton2.addActionListener(this);
        returnButton2.setIcon(
                new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HOME.png"))
                        .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        returnButton2.setBorder(new RoundBtn(15));

        int returnButton2W = (int) ((3.0 / 100.0) * screenWidth);
        int returnButton2H = (int) ((5.0 / 100.0) * screenHeight);
        int returnButton2X = (int) ((screenWidth - returnButton2W) - (screenWidth * (1.0 / 30.0)));
        int returnButton2Y = (int) ((screenHeight - returnButton2H) - (screenHeight * (1.0 / 11.55)));
        returnButton2.setBounds(returnButton2X, returnButton2Y, returnButton2W, returnButton2H);
        zoomedInWindow.add(returnButton2);

        returnButton2.setVisible(true);

        mainWindow.setVisible(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == (showMorePho))
            showMorePho.setForeground(new Color(204, 51, 255));
        if (e.getSource() == (mainReturn))
            mainReturn.setForeground(new Color(204, 51, 255));
        if (e.getSource() == (moreInfo))
            moreInfo.setForeground(new Color(204, 51, 255));
        if (e.getSource() == (acceptLease))
            acceptLease.setForeground(new Color(204, 51, 255));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == (showMorePho))
            showMorePho.setForeground(Color.WHITE);
        if (e.getSource() == (mainReturn))
            mainReturn.setForeground(Color.WHITE);
        if (e.getSource() == (moreInfo))
            moreInfo.setForeground(Color.WHITE);
        if (e.getSource() == (acceptLease))
            acceptLease.setForeground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == (Photo1) || e.getSource() == (Photo2) || e.getSource() == (Photo3)
                || e.getSource() == (Photo4) || e.getSource() == (Photo5) || e.getSource() == (Photo6)
                || e.getSource() == (Photo7) || e.getSource() == (Photo8) || e.getSource() == (Photo9)) {
            createImagePage();
            JButton zoomedInPhoto = new JButton();
            zoomedInPhoto.setBounds(0, 0, (int) (screenWidth - 5), (int) (screenHeight - 5));
            zoomedInPhoto.setForeground(Color.WHITE);
            zoomedInPhoto.setFocusPainted(false);
            zoomedInPhoto.setBorderPainted(false);
            zoomedInPhoto.setContentAreaFilled(false);
            if (e.getSource() == (Photo1))
                zoomedInPhoto.setIcon(icon2ImgAndBack("Light1.jpg", (int) screenWidth, (int) screenHeight));
            if (e.getSource() == (Photo2))
                zoomedInPhoto.setIcon(icon2ImgAndBack("Light2.jpg", (int) screenWidth, (int) screenHeight));
            if (e.getSource() == (Photo3))
                zoomedInPhoto.setIcon(icon2ImgAndBack("Light3.jpg", (int) screenWidth, (int) screenHeight));
            if (e.getSource() == (Photo4))
                zoomedInPhoto.setIcon(icon2ImgAndBack("Light4.jpg", (int) screenWidth, (int) screenHeight));
            if (e.getSource() == (Photo5))
                zoomedInPhoto.setIcon(icon2ImgAndBack("Light5.jpg", (int) screenWidth, (int) screenHeight));
            if (e.getSource() == (Photo6))
                zoomedInPhoto.setIcon(icon2ImgAndBack("Light6.jpg", (int) screenWidth, (int) screenHeight));
            if (e.getSource() == (Photo7))
                zoomedInPhoto.setIcon(icon2ImgAndBack("Light7.jpg", (int) screenWidth, (int) screenHeight));
            if (e.getSource() == (Photo8))
                zoomedInPhoto.setIcon(icon2ImgAndBack("Light8.jpg", (int) screenWidth, (int) screenHeight));
            if (e.getSource() == (Photo9))
                zoomedInPhoto.setIcon(icon2ImgAndBack("Light9.jpg", (int) screenWidth, (int) screenHeight));
            zoomedInWindow.getContentPane().add(zoomedInPhoto);
        }

        if (e.getSource() == (moreInfo)) {
            JFrame aa = new JFrame("What is included");
            JOptionPane.showMessageDialog(aa,
                    "-Room has free Wifi\n-Concierge service\n-Breakfast and dinner\n-Executive Double Beds\n-Weekly cleaning services\n-Cool Air Conditioning\n-Room size: 268 sq ft\n\n\n Only $150 Per Night");
        }

        if (e.getSource() == (showMorePho)) {
            try {
                URI myURL = new URI(
                        "https://www.riu.com/en/hotel/usa/new-york/hotel-riu-plaza-new-york-times-square/index.jsp#galeria");
                java.awt.Desktop.getDesktop().browse(myURL);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == (returnButton2)) {
            zoomedInWindow.dispose();
            mainWindow.setVisible(true);
        }

        if (e.getSource() == (mainReturn)) {
            LoginGui neww = new LoginGui();
            neww.formatElements(); // TODO
            mainWindow.removeAll();
            mainWindow.dispose();
        }

        if (e.getSource() == acceptLease) {
            int input = JOptionPane.showConfirmDialog(null, "Note: You will not be able to edit afterwards.",
                    "Confirm Options? ", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                new Tools().getUserList().get(indexOfCurrentUser).setAccept(true);
                new Tools().getUserList().get(indexOfCurrentUser).setBeds(2);
                new Tools().getUserList().get(indexOfCurrentUser).setRoomSize(250);
                new Tools().getUserList().get(indexOfCurrentUser).setAccept(true);

                JOptionPane.showMessageDialog(new JFrame("Notice"),
                        "Thank you for the confirmation." + "\nWe will text you free of charge: 571-101-7097.");
                new Tools().updateTxtFromList();
                System.exit(0);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mainWindow.setForeground(Color.WHITE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mainWindow.setForeground(Color.WHITE);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mainWindow.setForeground(Color.WHITE);
    }
}
