package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{
	String[] weeks = {"一","二","三","四","五","六","日"};
	JPanel mb1,mb2,mb3;
	JLabel bq1,bq2;
	JTextField wbk1;
	JButton an1,an2,an3;
	JButton[] week;
	JTextField[] day=new JTextField[42];
	Color col = new Color(25,25,105);
	Calendar cal =Calendar.getInstance();
	int nowyear = cal.get(Calendar.YEAR);
	int nowmonth =cal.get(Calendar.MONTH)+1;
	int nowday = cal.get(Calendar.DAY_OF_MONTH);
	Calendar2 calendar = new Calendar2();
	
	
	public static void main(String[] args) {
		Main gg = new Main();
		
	}
	 Main(){
	mb1 = new JPanel();
	mb2 = new JPanel();
	mb3 = new JPanel();
	//bq1 =new JLabel();
	String d= nowyear+"/"+nowmonth+"/"+nowday+"       ";
	bq1 =new JLabel(d);
	bq1.setFont(new Font("宋体",Font.BOLD,16));
	bq2 =new JLabel("请输入年份：");
	wbk1 =new JTextField(10);
	an1 = new JButton("上月");
	an2 = new JButton("下月");
	an1.addActionListener(this);
	an2.addActionListener(this);
	an3 = new JButton("确定");
	mb2.setLayout(new GridLayout(7,7));
	for(int i=0;i<7;i++)
	{  JButton[] week =new JButton[7];
		JButton b= new JButton(this.weeks[i]);
		b.setFont(new Font("宋体",Font.BOLD,16));
		b.setForeground(Color.black);
     	b.setBackground(Color.white);
		b.setEnabled(false);
		week[i]=b;
		mb2.add(week[i]);
	}
	
	for(int i=0;i<42;i++)
	{
		JTextField b=new JTextField();
		//b.setBackground(col);
		b.setEditable(false);
		day[i]=b;
		mb2.add(day[i]);
	}
	
	mb1.add(bq1);mb1.add(an1);mb1.add(an2);
	mb3.add(bq2);mb3.add(wbk1);mb3.add(an3);
	
	this.add(mb1,BorderLayout.NORTH);
	this.add(mb2,BorderLayout.CENTER);
	this.add(mb3,BorderLayout.SOUTH);
	
	setday();
	this.setTitle("日历");
	this.setSize(500,500); 
	this.setLocation(200, 80);
	this.setResizable(false);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setVisible(true);
	}
	public void setday()
	{
		calendar.setdate(nowyear,nowmonth,nowday);
		int a= calendar.fristofweek;
		int b= calendar.dayofmonth;
		System.out.println(a);
		int i=1;
		for(int j=0;j<42;j++)
		{
			if(j<a||j>=(b+a))
				day[j].setText(" ");
			else
			{day[j].setText(String.valueOf(i));
			day[j].setHorizontalAlignment(JTextField.CENTER);	
			i++;}
		}
	}
					 
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("上月")){
			if(nowmonth>0)
				nowmonth--;
			else 
				{nowmonth=12;
				nowyear--;
				}	
				}
		else if(cmd.equals("下月"))
			{nowmonth=nowmonth%12;
			nowmonth++;}
		String d= nowyear+"/"+nowmonth+"       ";
		bq1.setText(d);
		calendar.setdate(nowyear,nowmonth,nowday);
		int a= calendar.fristofweek;
		int b= calendar.dayofmonth;
		int i=1;
		for(int j=0;j<42;j++)
		{
			if(j<a||j>=(b+a))
				day[j].setText(" ");
			else
			{day[j].setText(String.valueOf(i));
			day[j].setHorizontalAlignment(JTextField.CENTER);	
			i++;}
		}
	}
}