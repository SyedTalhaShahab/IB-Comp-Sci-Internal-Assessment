package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class AdminGui extends JFrame
        implements ActionListener, ChangeListener, MouseListener, ListSelectionListener, KeyListener {
    private JPanel pane_panel = new JPanel();
    private JEditorPane review_editorPane = new JEditorPane();
    private JScrollPane review_scrollPane = new JScrollPane();

    private JButton logOut_Btn = new JButton("Log Out");
    private JLabel backGrd_img_lbl = new JLabel();
    private JTabbedPane users_tbdPn = new JTabbedPane(JTabbedPane.TOP);
    private JScrollPane registered_scrlPn = new JScrollPane();
    private JScrollPane residents_scrlPn = new JScrollPane();
    private JScrollPane help_scrlPn = new JScrollPane();
    private JScrollPane search_scrlPn = new JScrollPane();
    private JScrollPane mony_scrlPn = new JScrollPane();

    private JLabel total_Lbl = new JLabel("Monthly Revenue:");
    private JEditorPane money_editorPane = new JEditorPane();
    private JList<String> registered_JList;
    private JList<String> residents_JList;
    private DefaultListModel<String> main_U = new DefaultListModel<String>();
    private DefaultListModel<String> residents_U = new DefaultListModel<String>();
    private DefaultListModel<String> registered_U = new DefaultListModel<String>();
    private DefaultListModel<String> help_U = new DefaultListModel<String>();
    private DefaultListModel<String> search_U = new DefaultListModel<String>();
    private JList<String> main_JList = new JList<String>(main_U);
    private JList<String> search_JList;
    private JList<String> help_JList;
    private JTextField searchNameTxtFld = new JTextField();
    private JLabel searchNameLbl = new JLabel("Enter Username:");
    private List<String> residents;
    private List<String> registered;
    private List<String> search;

    private NumberFormat moneyFormaterR = NumberFormat.getInstance();
    private Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private int screnH = (int) size.getHeight();
    private int screnW = (int) size.getWidth();
    private int usersX = 20;
    private int usersY = 20;
    private int usersW = (int) (screnW * (3.3333 / 10.0));
    private int usersH = ((int) (screnH * (95.555 / 100.0))) - usersY - 20;

    public AdminGui() { // Default constructor's parameter does not need arguments and does not return
                        // anything; sets the window and calls a method.
        this.setSize(screnW, screnH);
        this.setTitle("Admin");
        this.setIconImage(Toolkit.getDefaultToolkit()
                .getImage(LoginGui.class.getResource("/resources/HOME.png")));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.formatElements();
    }

    private void formatElements() { // Private method's parameter does not need arguments and does not return
                                    // anything; formats all visible buttons and sorts current residents and
                                    // registered users.

        for (int i = 0; i < new Tools().getUserList().size(); i++) {
            boolean acpt = new Tools().getUserList().get(i).isAccept();
            String usernam = new Tools().getUserList().get(i).getUsername();
            if (acpt)
                residents_U.addElement(usernam);
            else
                registered_U.addElement(usernam);
        }

        help_U.addElement("CTRL + Click to select more items.");
        help_U.addElement("Click \"X\" to exit the application.");
        help_U.addElement("Click \"Log Out\" to close account.");
        help_U.addElement("Click \"Search\" to search account.");

        residents_JList = new JList<String>(residents_U);
        registered_JList = new JList<String>(registered_U);
        help_JList = new JList<String>(help_U);
        search_JList = new JList<String>(search_U);

        setResizable(false);
        pane_panel.setBorder(new EmptyBorder(1, 1, 1, 1));
        pane_panel.setBounds(0, 0, MAXIMIZED_HORIZ, MAXIMIZED_HORIZ);
        pane_panel.setLayout(null);
        setContentPane(pane_panel);

        logOut_Btn.setForeground(Color.WHITE);
        logOut_Btn.setFont(new Font("Tahoma", Font.BOLD, 20));
        logOut_Btn.setBorderPainted(false);
        logOut_Btn.setContentAreaFilled(false);
        logOut_Btn.setBorderPainted(false);
        logOut_Btn.addActionListener(this);
        logOut_Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logOut_Btn.setIcon(
                new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HOME.png"))
                        .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        logOut_Btn.addMouseListener(this);
        logOut_Btn.setVisible(true);

        total_Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        total_Lbl.setOpaque(true);
        total_Lbl.setBackground(new Color(0, 0, 0, 80));
        total_Lbl.setForeground(Color.WHITE);
        total_Lbl.setFont(new Font("Tahoma", Font.BOLD, 25));
        pane_panel.add(total_Lbl);

        pane_panel.add(mony_scrlPn);
        pane_panel.add(review_scrollPane);

        logOut_Btn.setBounds(0, 0, (int) ((7.0 / 32.0) * screnW), (int) ((1.0 / 6.0) * screnH));
        pane_panel.add(logOut_Btn);
        getContentPane().add(logOut_Btn);

        getContentPane().add(review_scrollPane);

        residents_JList.setForeground(Color.BLACK);
        residents_JList.setFont(new Font("Tahoma", Font.PLAIN, 30));
        residents_JList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        residents_JList.addListSelectionListener(this);

        registered_JList.setForeground(Color.BLACK);
        registered_JList.setFont(new Font("Tahoma", Font.PLAIN, 30));
        registered_JList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        registered_JList.addListSelectionListener(this);

        search_JList.setForeground(Color.BLACK);
        search_JList.setFont(new Font("Tahoma", Font.PLAIN, 30));
        search_JList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        search_JList.addListSelectionListener(this);

        help_JList.setFont(new Font("Tahoma", Font.PLAIN, 30));
        help_JList.setEnabled(false);
        help_JList.setForeground(Color.BLACK);

        users_tbdPn.setFont(new Font("Tahoma", Font.PLAIN, 25));
        users_tbdPn.addChangeListener(this);
        users_tbdPn.addTab("Residents", null, residents_scrlPn, null);
        users_tbdPn.setEnabledAt(0, true);
        users_tbdPn.addTab("Registered", null, registered_scrlPn, null);
        users_tbdPn.setEnabledAt(1, true);
        users_tbdPn.addTab("Search", null, search_scrlPn, null);
        users_tbdPn.setEnabledAt(2, true);
        users_tbdPn.addTab("Help", null, help_scrlPn, null);
        users_tbdPn.setEnabledAt(3, true);

        int users_tbdPnX = 20;
        int users_tbdPnY = 20;
        int users_tbdPnW = (int) (screnW * (3.0 / 10.0));
        int users_tbdPnH = ((int) (screnH * (95.0 / 100.0))) - users_tbdPnY - 20;
        users_tbdPn.setBounds(users_tbdPnX, users_tbdPnY, users_tbdPnW, users_tbdPnH);

        int logOutBtnW = (int) (screnW * (3.0 / 32.0));
        int logOutBtnH = (int) (screnH * (1.0 / 6.0));
        logOut_Btn.setBounds((screnW - logOutBtnW), (screnH - logOutBtnH), logOutBtnW, logOutBtnH);

        int users_tbdPn_AltW = (int) (screnW * (3.0 / 10.0));
        int users_tbdPn_AltH = (int) ((screnH * (9.0 / 10.0)) - usersY - 20);

        int srchNameLblX = usersX;
        int srchNameLblY = usersY + users_tbdPn_AltH;
        int srchNameLblW = (int) (users_tbdPn_AltW * (50.0 / 100.0));
        int srchNameLblH = screnH - users_tbdPn_AltH - 80;
        searchNameLbl.setBounds(srchNameLblX, srchNameLblY, srchNameLblW, srchNameLblH);
        searchNameLbl.setForeground(Color.WHITE);
        searchNameLbl.setFont(new Font("Tahoma", Font.BOLD, 30));

        int srchNameTxtFldX = srchNameLblX + srchNameLblW;
        int srchNameTxtFldY = srchNameLblY;
        int srchNameTxtFldW = srchNameLblW;
        int srchNameTxtFldH = srchNameLblH;
        searchNameTxtFld.setBounds(srchNameTxtFldX, srchNameTxtFldY, srchNameTxtFldW, srchNameTxtFldH);
        searchNameTxtFld.setBackground(Color.WHITE);
        searchNameTxtFld.setForeground(Color.BLACK);
        searchNameTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 30));
        searchNameTxtFld.addKeyListener(this);

        int review_scrollPaneX = users_tbdPnX + users_tbdPnW + 70;
        int review_scrollPaneY = users_tbdPnY;
        int review_scrollPaneW = (int) ((screnW - users_tbdPnW) * (9.0 / 10.0));
        int review_scrollPaneH = (int) ((screnH) * (85.0 / 100.0));
        review_scrollPane.setBounds(review_scrollPaneX, review_scrollPaneY, review_scrollPaneW, review_scrollPaneH);
        review_editorPane.setFont(new Font("Tahoma", Font.PLAIN, 20));

        review_editorPane.setEditable(false);

        int total_LblX = review_scrollPaneX;
        int total_LblY = srchNameTxtFldY;
        int total_LblW = srchNameLblW;
        int total_LblH = srchNameLblH;
        total_Lbl.setBounds(total_LblX, total_LblY, total_LblW, total_LblH);

        int mony_scrlPnX = total_LblX + srchNameLblW + 20;
        int mony_scrlPnY = srchNameTxtFldY;
        int mony_scrlPnW = srchNameLblW;
        int mony_scrlPnH = srchNameLblH;
        mony_scrlPn.setBounds(mony_scrlPnX, mony_scrlPnY, mony_scrlPnW, mony_scrlPnH);

        money_editorPane.setEditable(false);
        money_editorPane.setFont(new Font("Tahoma", Font.PLAIN, 30));
        mony_scrlPn.setViewportView(money_editorPane);
        review_scrollPane.setViewportView(review_editorPane);

        getContentPane().add(logOut_Btn);
        getContentPane().add(users_tbdPn);
        getContentPane().add(searchNameLbl);
        getContentPane().add(searchNameTxtFld);
        getContentPane().add(backGrd_img_lbl);

        residents_scrlPn.setViewportView(residents_JList);
        registered_scrlPn.setViewportView(registered_JList);
        search_scrlPn.setViewportView(search_JList);
        help_scrlPn.setViewportView(help_JList);
        main_JList.setFont(new Font("Tahoma", Font.PLAIN, 30));

        backGrd_img_lbl.setBounds(0, 0, screnW, screnH);
        backGrd_img_lbl.setVisible(true);
        backGrd_img_lbl
                .setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/QuietBack.jpg"))
                        .getImage().getScaledInstance(screnW, screnH, Image.SCALE_SMOOTH)));

        getContentPane().setLayout(null);
    }

    private String formatForAdmin(int index) { // Private method's parameter needs an int argument and returns a String;
                                               // formats all user's information for administrator.
        int beds = new Tools().getUserList().get(index).getBeds();
        int roomSize = new Tools().getUserList().get(index).getRoomSize();
        String phone = new Tools().getUserList().get(index).getPhoneNumber();
        String format = "$150 " + "\t" + " Bed: " + beds + "\t" + " Room Size: " + roomSize;

        format += "\t" + "Phone Number: " + phone;
        if (beds == 0)
            return phone;
        return format;
    }

    @Override
    public void stateChanged(ChangeEvent e) { // Implemented from ChangeListener interface. Public method's parameter
                                              // needs a ChangeEvent argument and returns nothing; executes a set of
                                              // actions based on the certain button clicked.
        users_tbdPn.setBounds(usersX, usersY, usersW, usersH);

        // _JList.getSelectedIndex() != -1) // If user has clicked items before, clear
        // the selection
        if (((JTabbedPane) e.getSource()).getSelectedIndex() == 0) { // If user clicks residents tab
            cleanBtns(false, false, true, true, true);
            if (residents_JList.getSelectedIndex() != -1)
                residents_JList.clearSelection();
            cleanSearch();
        }

        if (((JTabbedPane) e.getSource()).getSelectedIndex() == 1) { // If user clicks registered users tab
            cleanBtns(false, false, false, false, true);
            if (registered_JList.getSelectedIndex() != -1)
                registered_JList.clearSelection();
            cleanSearch();
        }

        if (((JTabbedPane) e.getSource()).getSelectedIndex() == 2) { // If user clicks search tab
            cleanBtns(true, true, false, false, true);
            if (search_JList.getSelectedIndex() != -1)
                search_JList.clearSelection();
            int usersAltW = (int) (screnW * (3.0 / 10.0));
            int usersAltH = (int) ((screnH * (9.0 / 10.0)) - usersY - 20);
            users_tbdPn.setBounds(usersX, usersY, usersAltW, usersAltH);
            cleanSearch();
        }

        if (((JTabbedPane) e.getSource()).getSelectedIndex() == 3) { // If user clicks help tab
            cleanBtns(false, false, false, false, false);
            if (help_JList.getSelectedIndex() != -1)
                help_JList.clearSelection();
            int usersAltH = ((int) (screnH * (2.18 / 10.0)));
            users_tbdPn.setBounds(usersX, usersY, usersW, usersAltH);
            cleanSearch();
        }
    }

    private void cleanSearch() {
        // search = search_JList.getSelectedValuesList();
        // if (search.size() > 0)
        // search_U.removeAllElements();
    }

    private void cleanBtns(boolean one, boolean two, boolean three, boolean four, boolean five) {
        money_editorPane.setText("");
        review_editorPane.setText("");
        searchNameTxtFld.setText("");

        searchNameLbl.setVisible(one);
        searchNameTxtFld.setVisible(two);
        total_Lbl.setVisible(three);
        mony_scrlPn.setVisible(four);
        review_scrollPane.setVisible(five);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Implemented from ActionListener interface. Public method's parameter
                                                 // takes an ActionEvent argument and does not return anything;
                                                 // performs set of actions based on the certain button clicked.
        if (e.getSource().equals(logOut_Btn)) {
            LoginGui welp = new LoginGui();
            welp.formatElements();
            this.dispose();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) { // Implemented from MouseListener interface. Public method's parameter
                                             // takes a MouseEvent argument and does not return anything; creates the
                                             // hover effect.
        if (e.getSource() == logOut_Btn)
            backGrd_img_lbl.setForeground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent e) {// Implemented from MouseListener interface. Public method's parameter takes
                                           // a MouseEvent argument and does not return anything; creates the hover
                                           // effect.
        if (e.getSource() == logOut_Btn)
            backGrd_img_lbl.setForeground(Color.WHITE);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) { // Implemented from ListSelectionListener interface. Public
                                                     // method's parameter takes a ListSelectionEvent argument and
                                                     // does not return anything; executes certain code when certain
                                                     // buttons are pressed.
        String formated_String_info = "";
        int total = 0;
        main_U.clear();
        if (e.getSource() == residents_JList) {
            if (!e.getValueIsAdjusting()) {
                residents = residents_JList.getSelectedValuesList();
                for (int i = 0; i < residents.size(); i++)
                    for (int ii = 0; ii < new Tools().getUserList().size(); ii++)
                        if (new Tools().getUserList().get(ii).getUsername().equals(residents.get(i).toString())) {
                            main_U.addElement(formatForAdmin(ii));
                            total += new Tools().getUserList().get(ii).getTotal();
                            formated_String_info += main_U.get(i).toString() + "\n";
                        }
                formated_String_info = formated_String_info.replace("[", "");
                formated_String_info = formated_String_info.replace("]", "");
                review_editorPane.setText(formated_String_info);
                money_editorPane.setText("$" + moneyFormaterR.format(total));
            }
        }
        if (e.getSource() == registered_JList) {
            if (!e.getValueIsAdjusting()) {
                registered = registered_JList.getSelectedValuesList();
                String phone = "", username = "";
                for (int i = 0; i < registered.size(); i++)
                    for (int ii = 0; ii < new Tools().getUserList().size(); ii++)
                        if (new Tools().getUserList().get(ii).getUsername().equals(registered.get(i).toString())) {
                            phone = new Tools().getUserList().get(ii).getPhoneNumber();
                            username = new Tools().getUserList().get(ii).getUsername();
                            main_U.addElement(phone + "\t" + "\t" + username);
                            formated_String_info += main_U.get(i).toString() + "\n";
                        }
                formated_String_info = formated_String_info.replace("[", "");
                formated_String_info = formated_String_info.replace("]", "");
                review_editorPane.setText(formated_String_info);
            }
        }

        if (e.getSource() == search_JList) {
            if (!e.getValueIsAdjusting()) {
                search = search_JList.getSelectedValuesList();
                for (int i = 0; i < search.size(); i++)
                    for (int ii = 0; ii < new Tools().getUserList().size(); ii++)
                        if (new Tools().getUserList().get(ii).getUsername().equals(search.get(i).toString())) {
                            main_U.addElement(formatForAdmin(ii));
                            total += new Tools().getUserList().get(ii).getTotal();
                            formated_String_info += search.get(i).toString() + "    " + main_U.get(i).toString() + "\n";
                        }
                formated_String_info = formated_String_info.replace("[", "");
                formated_String_info = formated_String_info.replace("]", "");
                review_editorPane.setText(formated_String_info);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { // Implemented from MouseListener interface. Public method's parameter
                                             // takes a MouseEvent argument and does not return anything;

        this.setForeground(Color.DARK_GRAY);
    }

    @Override
    public void mousePressed(MouseEvent e) { // Implemented from MouseListener interface. Public method's parameter
                                             // takes a MouseEvent argument and does not return anything;
        this.setForeground(Color.BLACK);
    }

    @Override
    public void mouseReleased(MouseEvent e) {// Implemented from MouseListener interface. Public method's parameter
                                             // takes a MouseEvent argument and does not return anything;
        this.setForeground(Color.GRAY);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        backGrd_img_lbl.setForeground(Color.WHITE);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String search4This = searchNameTxtFld.getText();
        if (search4This.isEmpty())
            search_U.clear();

        if ((!search_U.isEmpty()))
            search_U.clear();

        for (int i = 0; i < residents_U.size(); i++)
            if (residents_U.get(i).toLowerCase().startsWith(search4This.toLowerCase())
                    || residents_U.get(i).toUpperCase()
                            .startsWith(search4This.toUpperCase()))
                search_U.addElement(residents_U.get(i));

        for (int i = 0; i < registered_U.size(); i++)
            if (registered_U.get(i).toLowerCase().startsWith(search4This.toLowerCase())
                    || registered_U.get(i).toUpperCase().startsWith(search4This.toUpperCase()))
                search_U.addElement(registered_U.get(i));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        backGrd_img_lbl.setForeground(Color.BLACK);
    }
}