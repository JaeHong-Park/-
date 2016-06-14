package Window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class Chatting extends JFrame implements ActionListener, KeyListener {

	JTextArea taInputMsg;
	
	JButton btnEmoticon;
	JButton btnChatClear;
	JButton btnMsgSend;
	
	JLabel lbconnectuser;
	JLabel lbImg;
	
	JPanel pnChatTool;
	
	JTextPane pnText;
	JScrollPane pnScroll;
	Container ct;
	
	StyleContext context;
	StyledDocument document;
	Style style;
	
	public Chatting() {
		ct = getContentPane();
		ct.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		// 접속한 유저수
		lbconnectuser = new JLabel("접속: " + "1" + "명");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.insets = new Insets(5, 5, 5, 5);
		ct.add(lbconnectuser, c);
		
		// 채팅 내역
		context = new StyleContext();
		document = new DefaultStyledDocument(context);

		pnText = new JTextPane(document);
		pnText.setEditable(false);
		pnScroll = new JScrollPane(pnText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnScroll.setBorder(new LineBorder(Color.LIGHT_GRAY));	// 테두리 설정
		
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1.0;
		c.insets = new Insets(0, 5, 0, 5);
		ct.add(pnScroll, c);
		
		///// 채팅 도구 영역
		pnChatTool = new JPanel();
		pnChatTool.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		// 이모티콘 버튼
		btnEmoticon = new JButton(new ImageIcon("images/icon_btn_emoticon.png"));
		btnEmoticon.setRolloverIcon(new ImageIcon("images/icon_btn_emoticon_over.png"));
		btnEmoticon.setToolTipText("이모티콘");			// 툴 팁
		btnEmoticon.setBorderPainted(false);		// 사각형 숨김
		btnEmoticon.setContentAreaFilled(false);	// 투명 하이라이트 숨김
		btnEmoticon.setPreferredSize(new Dimension(20, 20));	// 버튼 크기 설정
		pnChatTool.add(btnEmoticon);
		
		// 채팅창 지우기 버튼
		btnChatClear = new JButton(new ImageIcon("images/icon_btn_chatclear.png"));
		btnChatClear.setRolloverIcon(new ImageIcon("images/icon_btn_chatclear_over.png"));
		btnChatClear.setToolTipText("채팅창 지우기");		// 툴 팁
		btnChatClear.setBorderPainted(false);		// 사각형 숨김
		btnChatClear.setContentAreaFilled(false);	// 투명 하이라이트 숨김
		btnChatClear.setPreferredSize(new Dimension(20, 20));	// 버튼 크기 설정
		pnChatTool.add(btnChatClear);
		
		// 채팅 도구 영역 위치
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 0;
		c.gridwidth = 2;
		c.insets = new Insets(5, 5, 0, 5);
		ct.add(pnChatTool, c);
		
		
		///// 문자 입력 영역
		// 입력칸
		taInputMsg = new JTextArea();
		taInputMsg.setLineWrap(true);
		pnScroll = new JScrollPane(taInputMsg, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnScroll.setBorder(new LineBorder(Color.DARK_GRAY));	// 테두리 설정
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0.8;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		ct.add(pnScroll, c);
		
		// 보내기 버튼
		btnMsgSend = new JButton("보내기");
		btnMsgSend.setPreferredSize(new Dimension(80, 35));	// 버튼 크기 설정
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 0;
		c.insets = new Insets(5, 0, 5, 5);
		ct.add(btnMsgSend, c);

		
		///// 환경 설정
		// 액션, 키보드 반응 감지
		btnEmoticon.addActionListener(this);
		btnChatClear.addActionListener(this);
		btnMsgSend.addActionListener(this);
		taInputMsg.addKeyListener(this);
		
		// 채팅 창 셋팅
		setTitle("채팅");
		setBounds(1000, 300, 300, 450);
		setVisible(true);
		setResizable(false);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		// 창 오른쪽 위 'X'버튼 클릭 시 창 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 기본 셋팅
		taInputMsg.requestFocus();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object objAction = e.getSource();

		// '이모티콘'버튼 클릭
		if (objAction.equals(btnEmoticon)) {
			ImageIcon ii = new ImageIcon("images/Emo_Play_01.gif");
			lbImg = new JLabel(ii);
			style = context.getStyle(StyleContext.DEFAULT_STYLE);
			StyleConstants.setComponent(style, lbImg);
			
			try {
				document.insertString(document.getLength(), "\n", style);
			}
			catch (BadLocationException ex) {
				ex.printStackTrace();
			}
			
			ii.getImage().flush();
			settingInit();		// 기본 셋팅 초기화
		}
		
		// '지우기'버튼 클릭
		if (objAction.equals(btnChatClear)) {
			pnText.setText("");
		}
		
		// '보내기'버튼 클릭
		if (objAction.equals(btnMsgSend)) {
			sendMsg();					// 문자 전송
			taInputMsg.setText("");		// 입력칸 공백
			settingInit();				// 기본 셋팅 초기화
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object objKey = e.getKeyCode();
		
		// 'Enter'키 입력
		// 채팅 입력 칸에 입력된 내용을 채팅 창에 전송
		if (objKey.equals(KeyEvent.VK_ENTER)) {
			sendMsg();					// 문자 전송
			taInputMsg.setText("");		// 입력칸 공백
			e.consume();				// 더 이상 'Key'이벤트를 받지 않음  ※ 'Enter' 기본 기능이 개행이기 때문에 잠금
		}
	}

	// 사용 안 함  ※ KeyListener 기본 구성
	@Override
	public void keyTyped(KeyEvent e) {
	}

	// 사용 안 함  ※ KeyListener 기본 구성
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	///// 커스텀 메소드
	// 기본셋팅 초기화
	private void settingInit() {
		taInputMsg.requestFocus();	// 커서 위치를 채팅 입력 칸으로 지정
		pnText.setCaretPosition(document.getLength());	// 채팅 내역의 스크롤을 가장 아래로 이동
	}
	
	// 문자 전송
	private void sendMsg() {
		// 공백은 전송 불가
		if (!taInputMsg.getText().equals("")) {
			try {
				document.insertString(document.getLength(), taInputMsg.getText() + "\n", null);
			}
			catch (BadLocationException ex) {
				ex.printStackTrace();
			}
		}
	}
}