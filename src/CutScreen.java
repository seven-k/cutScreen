import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yinchanglei on 2017/8/17 2017-8-22 22:33:59.
 */
public class CutScreen extends JFrame implements ActionListener {


    JPanel jp;
    JLabel jlTime;
    JComboBox jcbTime;
    JButton jbTime;

    public CutScreen() {
        jp = new JPanel();
        this.setContentPane(jp);
        this.setTitle("延迟截图");
        this.setVisible(true);
        jp.setLayout(null);
        jlTime = new JLabel("Delay Time:");
        jlTime.setBounds(25, 15, 100, 30);
        jp.add(jlTime);

        String[] str = new String[]{"1", "2", "3", "5", "10"};
        jcbTime = new JComboBox(str);
        jcbTime.setBounds(110, 15, 100, 30);
        jp.add(jcbTime);
        jbTime = new JButton("Start");
        jbTime.addActionListener(this);
        jbTime.setBounds(220, 15, 70, 30);
        jp.add(jbTime);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600, 300, 325, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbTime) {
            String time = jcbTime.getSelectedItem().toString();
            try {
                this.setExtendedState(JFrame.ICONIFIED);  //点击后窗口最小化
                Thread.sleep(Integer.parseInt(time) * 1000);
                openExe();
                System.exit(0);    //启动程序后退出主程序
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    //执行exe程序
    public static void openExe() {
        final Runtime runtime = Runtime.getRuntime();
        Process process = null;

        try {
            process = runtime.exec("tengxunjt.exe");

        } catch (final Exception e) {
            System.out.println("Error exec!");
        }
    }

    public static void main(String[] args) {
        new CutScreen();
    }
}
