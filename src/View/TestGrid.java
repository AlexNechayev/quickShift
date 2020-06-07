package View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestGrid extends JPanel{
    private JPanel testGrid;
    private JPanel one;
    private JPanel two;
    private JPanel three;
    private JPanel gg;
    private JPanel aa;
    private JPanel bb;


    public TestGrid(){
        add(testGrid);
        this.setVisible(true);

        gg = new Test("Alex Nechaev","8:00","12:00");
        aa = new Test("Alwerqewrex Nechaev","8:00","12:00");
        bb = new Test("Alewrwerwqetqerqtgex Nechaev","8:00","12:00");

        one.removeAll();
        one.repaint();
        one.revalidate();

        one.add(gg);
        one.repaint();
        one.revalidate();


        two.removeAll();
        two.repaint();
        two.revalidate();

        two.add(aa);
        two.repaint();
        two.revalidate();

        three.removeAll();
        three.repaint();
        three.revalidate();

        three.add(bb);
        three.repaint();
        three.revalidate();


        one.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Hello");
            }
        });
    }



}
