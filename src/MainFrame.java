import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame{
    private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=800;
    private int frmH=600;
    private int screenW=dim.width ;
    private int screenH=dim.height ;
    private JMenuBar jmb =new JMenuBar();
    private JMenu jmG = new JMenu("Game");
    private JMenu jmA = new JMenu("About");
    private JMenuItem a1 =new JMenuItem("教你怎麼玩");
    private JMenuItem g1 =new JMenuItem("3*3");
    private JMenuItem g2 =new JMenuItem("4*4");
    private JMenuItem g3 =new JMenuItem("5*5");



    public MainFrame(){

        initComp();

    }
    private void initComp(){
        this.setBounds((screenW-frmW)/2,(screenH-frmH)/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("GameNumberPuzzle");
        this.setJMenuBar(jmb);

        this.getContentPane().setBackground(new Color(192,192,192));
        jmb.add(jmG);
        jmG.add(g1);
        jmG.add(g2);
        jmG.add(g3);
        jmb.add(jmA);
        jmA.add(a1);
        g1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem tmp1=(JMenuItem)e.getSource();
                if(tmp1==g1){
                    text1 QQ1=new text1(MainFrame.this);
                    QQ1.setVisible(true);
                    MainFrame.this.setVisible(false);

                }

            }
        });
        g2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem tmp2=(JMenuItem)e.getSource();
                if(tmp2==g2){
                    text2 QQ2=new text2(MainFrame.this);
                    QQ2.setVisible(true);
                    MainFrame.this.setVisible(false);

                }

            }
        });
        g3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem tmp3=(JMenuItem)e.getSource();
                if(tmp3==g3){
                    text3 QQ3=new text3(MainFrame.this);
                    QQ3.setVisible(true);
                    MainFrame.this.setVisible(false);

                }

            }
        });
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == a1) //遊戲說明
                {
                    JOptionPane.showMessageDialog(null, "過關排列方式      操作方式\n"+
                                    "    1  2   3   4      ↑ 上移\n" +
                                    "    5  6   7   8      ←  左移 \n" +
                                    "    9  10 11 12     →  右移 \n " +
                                    "  13 14 15               ↓ 下移 "
                            , "遊戲規則",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });



    }
}
