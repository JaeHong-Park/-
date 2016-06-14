package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button_Img_Test extends JFrame implements ActionListener
{
//	private JLabel result = new JLabel("");
 
 	public Button_Img_Test()
	{
		
		
		ImageIcon ii = new ImageIcon("test.png");
		JButton b = new JButton("", ii);//button에 이미지 넣기
		JLabel lbImg = new JLabel(ii);
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		ct.add(b);
		ct.add(lbImg);
//		ct.add(result);
		b.addActionListener(this);
		
		setBounds(300, 300, 400, 500);
		setVisible(true);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
 	public void actionPerformed(ActionEvent e)//button클릭했을때 수행할 문장을 넣어줌.
	{
// 		result.setText("Test Button을 클릭했습니다");//button 클릭하며 label에 text를 출력해줌.
	}
}