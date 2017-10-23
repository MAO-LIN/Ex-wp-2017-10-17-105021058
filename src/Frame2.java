import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame2 extends JFrame{
    private Container cp;
    private JTextField jtf=new JTextField();
    private Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
    private int LoginH=500,LoginW=400;
    private int screenW= dim.width;
    private int screenH= dim.height;
    private JButton btn[]=new JButton[9];
    private JPanel conter=new JPanel(new GridLayout(3,4,5,5));
    private LoginFrame log;
    public Frame2(LoginFrame loginFrame){
        log=loginFrame;
        initComp();
    }
    private void initComp(){
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-LoginW/2,screenH/2-LoginH/2,LoginW,LoginH);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(BorderLayout.NORTH,jtf);
        cp.add(BorderLayout.CENTER,conter);
        jtf.setEditable(false);
        for(int i=0;i<9;i++){
            btn[i]=new JButton(Integer.toString(i));
            conter.add(btn[i]);
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tempBtn= (JButton)e.getSource();
                    jtf.setText(jtf.getText()+tempBtn.getText());
                }
            });
        }
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                Frame2.this.setVisible(false);
                dispose();
                log.setVisible(true);
            }
        });

    }
}
