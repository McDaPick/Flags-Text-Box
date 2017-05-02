package Frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Mikey
 */
public class Frame extends JFrame implements FocusListener {

    private JList flags;
    private JLabel reflector;
    private JTextField drop;
    private JScrollPane scroller;

    public Frame(String title) throws Exception {
        super(title);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponents(getContentPane());
        setVisible(true);
    }

    public void addComponents(Container contentPane) throws Exception {
        SplashScreen splashy = new SplashScreen();

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String value = (String) drop.getText();

                for (int i = 0; i < splashy.strings.length; i++) {
                    if (splashy.strings[i].equals(value)) {
                        reflector.setIcon(splashy.images.get(i));
                    }
                }
            }
        };

        reflector = new JLabel();

        flags = new JList(splashy.strings);
        scroller = new JScrollPane();
        scroller.setViewportView(flags);

        flags.setDragEnabled(true);

        drop = new JTextField("");
        //drop.setDragEnabled(true);
        drop.addFocusListener(this);
        drop.addActionListener(action);
    
        reflector = new JLabel();

        contentPane.setLayout(new BorderLayout());
        
        contentPane.add(scroller, BorderLayout.EAST);

        contentPane.add(drop, BorderLayout.SOUTH);

        contentPane.add(reflector, BorderLayout.CENTER);

    }

    public void focusGained(FocusEvent e) {
        System.out.println("Focus gained");
    }

    @Override
    public void focusLost(FocusEvent e) {
        System.out.println("Focus lost");
        drop.setText("");
    }
}
