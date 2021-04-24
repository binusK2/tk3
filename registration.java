// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame
	extends JFrame
	implements ActionListener {

	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel mno;
	private JTextField tmno;
	private JLabel sdi;
	private JTextField tsdi;
	private JLabel mail;
	private JTextField tmail;
	private JLabel add;
	private JLabel dob;
	private JComboBox date;
	private JComboBox month;
	private JComboBox year;

	private JCheckBox term;
	private JButton sub;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;

	private String dates[]
		= { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25",
			"26", "27", "28", "29", "30",
			"31" };
	private String months[]
		= { "Jan", "feb", "Mar", "Apr",
			"May", "Jun", "July", "Aug",
			"Sup", "Oct", "Nov", "Dec" };
	private String years[]
		= { "1995", "1996", "1997", "1998",
			"1999", "2000", "2001", "2002",
			"2003", "2004", "2005", "2006",
			"2007", "2008", "2009", "2010",
			"2011", "2012", "2013", "2014",
			"2015", "2016", "2017", "2018",
			"2019" };

	// constructor, to initialize the components
	// with default values.
	public MyFrame()
	{
		setTitle("Registration Form");
		setBounds(300, 50, 470, 370);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		name = new JLabel("Nama pengguna");
		name.setLayout(null);
		c.add(name);
		name.setBounds(20, 30, 250, 30);

		tname = new JTextField();
		c.add(tname);
		tname.setBounds(170, 35, 260, 25);

		mno = new JLabel("Kata sandi");
		mno.setLayout(null);
		c.add(mno);
		mno.setBounds(20, 60, 250, 30);

		tmno = new JTextField();
		c.add(tmno);
		tmno.setBounds(170, 65, 260, 25);

		sdi = new JLabel("Konfirmasi Kata sandi");
		sdi.setLayout(null);
		c.add(sdi);
		sdi.setBounds(20, 90, 250, 30);
		tsdi = new JTextField();
		c.add(tsdi);
		tsdi.setBounds(170, 95, 260, 25);

		mail = new JLabel("Email");
		c.add(mail);
		mail.setBounds(20, 120, 250, 30);

		tmail = new JTextField();
		c.add(tmail);
		tmail.setBounds(170, 125, 260, 25);

		dob = new JLabel("Tanggal lahir");
		dob.setLayout(null);
		c.add(dob);
		dob.setBounds(20, 150, 250, 30);

		date = new JComboBox(dates);
		c.add(date);
		date.setBounds(170, 155, 60, 25);

		month = new JComboBox(months);
		c.add(month);
		month.setBounds(270, 155, 60, 25);

		year = new JComboBox(years);
		c.add(year);
		year.setBounds(370, 155, 60, 25);

		sub = new JButton("Login");
		sub.setBounds(260, 220, 90, 35);
		sub.addActionListener(this);
		c.add(sub);

		reset = new JButton("Reset");
		reset.setBounds(120, 220, 90, 35);
		reset.addActionListener(this);
		c.add(reset);

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == sub) {
			if (term.isSelected()) {
				String data1;
				String data
					= "Name : "
					+ tname.getText() + "\n"
					+ "Mobile : "
					+ tmno.getText() + "\n";
				if (male.isSelected())
					data1 = "Gender : Male"
							+ "\n";
				else
					data1 = "Gender : Female"
							+ "\n";
				String data2
					= "DOB : "
					+ (String)date.getSelectedItem()
					+ "/" + (String)month.getSelectedItem()
					+ "/" + (String)year.getSelectedItem()
					+ "\n";

				String data3 = "Address : " + tadd.getText();
				tout.setText(data + data1 + data2 + data3);
				tout.setEditable(false);
				res.setText("Registration Successfully..");
			}
			else {
				tout.setText("");
				resadd.setText("");
				res.setText("Please accept the"
							+ " terms & conditions..");
			}
		}

		else if (e.getSource() == reset) {
			String def = "";
			tname.setText(def);
			tadd.setText(def);
			tmno.setText(def);
			res.setText(def);
			tout.setText(def);
			term.setSelected(false);
			date.setSelectedIndex(0);
			month.setSelectedIndex(0);
			year.setSelectedIndex(0);
			resadd.setText(def);
		}
	}
}

// Driver Code
class Registration {

	public static void main(String[] args) throws Exception
	{
		MyFrame f = new MyFrame();
	}
}
