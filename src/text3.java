import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class text3 extends JFrame{
    private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=800;
    private int frmH=600;
    private int screenW=dim.width ;
    private int screenH=dim.height ;
    private String [][] boxs1 = new String[][]{{"1","2","3","4","5"},//4*4
            {"6","7","8","9","10"},
            {"11","12","13","14","15"},
            {"16","17","18","19","20"},
            {"21","22","23","24"," "}};
    private JLabel [] jl = new JLabel [25];//4*4
    //    private JLabel [] jl2 = new JLabel [9];//3*3
    private final int LEFTn = 37,UPn = 38, RIGHTn = 39, DOWNn = 40;//數字範圍做判斷
    private boolean flag=true;
    private JMenuBar jmb =new JMenuBar();
    private JMenu jmG = new JMenu("Game");
    private JMenuItem g1 =new JMenuItem("give up!!");
    MainFrame mf;
    public text3(MainFrame mf3){
        mf=mf3;

        initComp();
    }
    private void initComp(){
        this.setBounds((screenW-frmW)/2,(screenH-frmH)/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mf.setVisible(true);
                dispose();
            }
        });
        Container cp ;
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(5,5));
        cp.setBackground(new Color(192,192,192));
        this.setJMenuBar(jmb);
        jmb.add(jmG);
        jmG.add(g1);
        for(int i = 0; i < jl.length; i++)//先設位置
        {
            jl[i] = new JLabel();
            jl[i].setFont(new Font("t2",Font.ITALIC,80));
            cp.add(jl[i]);
        }
        boxs1 = num();
        for(int i=0; i< jl.length; i++)//更新數字顯示的位置東西丟進去
            jl[i].setText("  "+boxs1[i/boxs1.length][i%boxs1.length]);

        g1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == g1) //投降
                {
                    flag = false;
                    for(int i=0; i< jl.length; i++)//初始化數字顯示的位置//15+1=16
                    {
                        boxs1[i/boxs1.length][i%boxs1.length] = Integer.toString(i+1);
                        if(boxs1[i/boxs1.length][i%boxs1.length].equals("16")) boxs1[i/boxs1.length][i%boxs1.length] = " ";
                        jl[i].setText("  ");//清空
                    }
                    boxs1 = num();
                    for(int i=0; i< jl.length; i++)//更新數字顯示的位置//重來了
                        jl[i].setText("  "+boxs1[i/boxs1.length][i%boxs1.length]);
                    flag = true;
                    g1.setEnabled(true);


                }
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (flag==true) {
                    String str=" ";
                    int [] zero = null;
                    zero = getZero(boxs1);  //取得" "的位置
                    switch(e.getKeyCode())
                    {
                        case LEFTn: //按左鍵
                            if(zero[1]+1<boxs1[zero[0]].length)
                            {
                                str = boxs1[zero[0]][zero[1]+1];
                                boxs1[zero[0]][zero[1]+1] = " ";
                            }
                            break;
                        case UPn: //按上鍵
                            if(zero[0]+1<boxs1.length)
                            {
                                str = boxs1[zero[0]+1][zero[1]];
                                boxs1[zero[0]+1][zero[1]] = " ";
                            }
                            break;
                        case RIGHTn: //按右鍵
                            if(zero[1]-1 >= 0)
                            {
                                str = boxs1[zero[0]][zero[1]-1];
                                boxs1[zero[0]][zero[1]-1] = " ";
                            }
                            break;
                        case DOWNn: //按下鍵
                            if(zero[0]-1 >= 0)
                            {
                                str = boxs1[zero[0]-1][zero[1]];
                                boxs1[zero[0]-1][zero[1]] = " ";
                            }
                            break;
                        default:
                    }
                    boxs1[zero[0]][zero[1]] = str;
                    //更新數字顯示的位置
                    for(int i=0; i< jl.length; i++)
                        jl[i].setText("  "+boxs1[i/boxs1.length][i%boxs1.length]);


                    //判斷是否過關
                    if(boxs1[0][0].equals("1") && boxs1[0][1].equals("2") &&boxs1[0][2].equals("3")&&boxs1[0][3].equals("4") &&boxs1[0][4].equals("5") &&
                            boxs1[1][0].equals("6") && boxs1[1][1].equals("7") &&boxs1[1][2].equals("8")&&boxs1[1][3].equals("9") &&boxs1[1][4].equals("10") &&
                            boxs1[2][0].equals("11") && boxs1[2][1].equals("12") &&boxs1[2][2].equals("13")&&boxs1[2][3].equals("14") &&boxs1[2][4].equals("15") &&
                            boxs1[3][0].equals("16") && boxs1[3][1].equals("17") &&boxs1[3][2].equals("18")&&boxs1[3][3].equals("19") &&boxs1[3][4].equals("20") &&
                            boxs1[4][0].equals("21") && boxs1[4][1].equals("22") &&boxs1[4][2].equals("23")&&boxs1[4][3].equals("24") &&
                            boxs1[4][4].equals(" ")
                            )
                    {


                        JOptionPane.showMessageDialog(null, "過關了!!成功", "訊息",
                                JOptionPane.INFORMATION_MESSAGE);

                        //判斷是否再玩一次
                        if(JOptionPane.showConfirmDialog(null, "再玩一次？", "訊息",
                                JOptionPane.YES_NO_OPTION) == 0
                                )
                        {
                            boxs1 = num();
                            for(int i=0; i< jl.length; i++)//更新數字顯示的位置
                                jl[i].setText("  "+boxs1[i/boxs1.length][i%boxs1.length]);
                        }
                        else {
                            mf.setVisible(true);
                            dispose();
                        } //結束遊戲
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });


    }
    private String[][] num()//配合getZero
    {
        String [][] boxs2 = new String[][]{{"1","2","3","4","5"},//4*4
                {"6","7","8","9","10"},
                {"11","12","13","14","15"},
                {"16","17","18","19","20"},
                {"21","22","23","24"," "}};

        //用亂數打亂數字的排列
        for(int count = 0; count < 200; count++)
        {
            String temp = " ";
            int [] zero = null;
            int rnd= (int)(Math.random()*4)+LEFTn;//用來隨機移動數字
            //上下左右4個數值來控制
            //來改變" "的位置
            //因而改變位置

            zero = getZero(boxs2);  //取得0的位置
            switch(rnd)//用switch判斷
            {
                case LEFTn: //左移
                    if(zero[1]+1<boxs2[zero[0]].length)
                    {
                        temp = boxs2[zero[0]][zero[1]+1];
                        boxs2[zero[0]][zero[1]+1] = " ";
                    }
                    break;
                case UPn: //上移
                    if(zero[0]+1<boxs2.length)
                    {
                        temp = boxs2[zero[0]+1][zero[1]];
                        boxs2[zero[0]+1][zero[1]] = " ";
                    }
                    break;
                case RIGHTn: //右移
                    if(zero[1]-1 >= 0)
                    {
                        temp = boxs2[zero[0]][zero[1]-1];
                        boxs2[zero[0]][zero[1]-1] = " ";
                    }
                    break;
                case DOWNn: //下移
                    if(zero[0]-1 >= 0)
                    {
                        temp = boxs2[zero[0]-1][zero[1]];
                        boxs2[zero[0]-1][zero[1]] = " ";
                    }
                    break;
                default:
            }
            boxs2[zero[0]][zero[1]] = temp;
        }

        return boxs2;
    }

    //取得0的位置
    private int [] getZero(String [][] boxlxly)
    {
        int lxlylocation[] = new int[2];

        for(int r = 0; r < boxlxly.length; r++)
        {
            for(int c = 0; c < boxlxly[r].length; c++)
            {
                //取得數字0的位置
                if(boxlxly[r][c].equals(" "))
                {
                    lxlylocation[0] = r;  //" "的x位置(lx)
                    lxlylocation[1] = c;  //" "的y位置(ly)
                }
            }
        }

        return lxlylocation;
    }




}
