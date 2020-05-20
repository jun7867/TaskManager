package user.management.oodp;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import user.management.oodp.SignUpDialog;



public class SignUpCheck extends JFrame{

	private JPanel mainPanel = new JPanel(new GridLayout(17, 0));	

	private JLabel idlabel = new JLabel("다이얼로그에서 받아온 아이디 값");

	private JTextField idText = new JTextField();

	private JLabel pwlabel = new JLabel("다이얼로그에서 받아온 비밀번호 값");

	private JTextField pwText = new JTextField();

	private JLabel pwchecklabel = new JLabel("다이얼로그에서 받아온 비밀번호 확인 값");

	private JTextField pwCheckText = new JTextField();

	private JLabel namelabel = new JLabel("다이얼로그에서 받아온 이름 값");

	private JTextField nameText = new JTextField();

	private JLabel birthYearlabel = new JLabel("다이얼로그에서 받아온 생일 연도 값");

	private JTextField birthYearText = new JTextField();

	private JLabel birthMonthlabel = new JLabel("다이얼로그에서 받아온 생일 월 값");

	private JTextField birthMonthText = new JTextField();

	private JLabel birthDaylabel = new JLabel("다이얼로그에서 받아온 생일 일자 값");

	private JTextField birthDayText = new JTextField();

	private JLabel phoneNumberlabel = new JLabel("다이얼로그에서 받아온 핸드폰 번호 값");

	private JTextField phoneNumberText = new JTextField();

	private JButton signUpbtn = new JButton("다이얼로그 창에서 회원 가입 정보 입력 하기 위한 버튼!");

	private SignUpCheck owner = this;

	

	public SignUpCheck() {

		super("메인창");		

		

		this.mainPanel.add(idlabel);

		this.mainPanel.add(idText);

		this.mainPanel.add(pwlabel);

		this.mainPanel.add(pwText);

		this.mainPanel.add(pwchecklabel);

		this.mainPanel.add(pwCheckText);

		this.mainPanel.add(namelabel);

		this.mainPanel.add(nameText);

		this.mainPanel.add(birthYearlabel);

		this.mainPanel.add(birthYearText);

		this.mainPanel.add(birthMonthlabel);

		this.mainPanel.add(birthMonthText);

		this.mainPanel.add(birthDaylabel);

		this.mainPanel.add(birthDayText);

		this.mainPanel.add(phoneNumberlabel);

		this.mainPanel.add(phoneNumberText);

		this.mainPanel.add(signUpbtn);

		

		this.setContentPane(mainPanel);

		this.setSize(500,500);

		this.setVisible(true);

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		//회원가입 버튼을 눌렀을때 회원가입 다이얼로그 창 생성

		signUpbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				SignUpDialog signup = new SignUpDialog(owner);

				

				signup.setVisible(true);

								

				//메인 창에서 회원가입 입력이 모두 완료 되었는지 체크하는 것은 membershipProgress로 판단

				if(signup.memberCheck()) {				

					idText.setText(signup.getIdText());

					pwText.setText(signup.getPwText());

					pwCheckText.setText(signup.getPwCheckText());

					nameText.setText(signup.getNameText());

					birthYearText.setText(signup.getBirthYearText());

					birthMonthText.setText(signup.getBirthMonthContent());

					birthDayText.setText(signup.getBirthDayText());

					phoneNumberText.setText(signup.getPhoneNumberText());

				}

			}

		});

		

				

	}

	

	public static void main(String[] args) {

		new SignUpCheck();

	}

}