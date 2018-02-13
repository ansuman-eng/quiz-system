package project;

import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;

class First extends Frame {
	 
	 static TextField name, pass;
	
	First()
	{
		Button b = new Button("Submit");
		b.setBounds(250,400,100,30);
		add(b);
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("Online Examination Management System");
		setLocationRelativeTo(null);
		name = new TextField(20);
		pass = new TextField(20);
		pass.setEchoChar('*');
		name.setBounds(250,200,100,30);
		pass.setBounds(250,250,100,30);
		
		Label l3,l4;
		l3 = new Label("Username :");
		l4=  new Label("Password :");
		
		
		l3.setBounds(100,200,100,30);
		l4.setBounds(100, 250, 100, 30);
		add(name);
		add(pass);
		add(l3);
		add(l4);
		FTerminator t = new FTerminator();
		addWindowListener(t);
		
		b.addActionListener(new textInputListener());
		
		Label l1,l2;
		l1 = new Label("Welcome to the Online Examination Management System.");
		l1.setBounds(125 ,100 , 400, 30);
		l2 = new Label("Please Enter your credentials to access functionality.");
		l2.setBounds(140, 130, 400, 30);
		add(l1);
		add(l2);
	}


	
	public static void main(String args[])
	{
		First f = new First();
		
	}
	
} 


/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////


class insertmcq extends Frame
{
	static TextField question, op1, op2, op3, op4, ans;
	static String fil;
	static Label la;
	insertmcq(String s)
	{
		fil=s;
		Button b = new Button("SUBMIT");
		Button b2 =new Button("GO BACK");
		b2.setBounds(250, 430, 100, 30);
		b2.addActionListener(new CloseInsertMCQ(this));
		
		
		
		b.setBounds(250,400,100,30);
		
		add(b2);
		b2.addActionListener(new CloseInsertMCQ(this));
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("MC Question Insertion");
		setLocationRelativeTo(null);
		
		
		
		question = new TextField(200);
		op1 = new TextField(200);
		op2=  new TextField(200);
		op3 = new TextField(200);
		op4=  new TextField(200);
		ans = new TextField(200);
		
		Label l1 = new Label("Please enter the question below");
		l1.setBounds(50,170, 200, 30);
		question.setBounds(50,200,500,30);
		Label l2, l3, l4, l5, l6;
		l2= new Label("A");
		l3 =new Label("B");
		l4= new Label("C");
		l5 =new Label("D");
		l6 =new Label("Ans");
		l2.setBounds(25,230,25,30);
		op1.setBounds(50,230, 100, 30);
		l3.setBounds(25,260,25,30);
		op2.setBounds(50,260,100,30);
		l4.setBounds(25,290,25,30);
		op3.setBounds(50,290,100,30);
		l5.setBounds(25,320,25,30);
		op4.setBounds(50,320,100,30);
		l6.setBounds(25,350,25,30);
		ans.setBounds(50,350,100,30);
		add(question);
		add(l1); 
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(op1);
		add(op2);
		add(op3);
		add(op4);
		add(ans);
		
		la= new Label("Question Added. Add another or go back", Label.CENTER);
		la.setBounds(50,500,500,30);
		la.setVisible(false);
		add(la);
		
		b.addActionListener(new ActionListener(){
			String q, a, f, o1, o2, o3, o4, concat;
			public void actionPerformed(ActionEvent event)
			{
				q= insertmcq.question.getText();
				a=insertmcq.ans.getText();
				f=insertmcq.fil;
				o1=insertmcq.op1.getText();
				o2=insertmcq.op2.getText();
				o3=insertmcq.op3.getText();
				o4=insertmcq.op4.getText();
				concat= o1+"   "+o2+"   "+o3+"   "+o4+"   "+a;
				
				try {
					FileWriter fw = new FileWriter(f, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					
					pw.println(q+" "+"[MCQ]");  //Question added with marker to identify
					pw.println(concat);  //Options and answers added on Next Line
					
											
					pw.close();
					
				}
				
				catch(IOException e)
				{
					System.out.println("Exception Caught" + e);
				}
				
				insertmcq.ans.setText("");   //clears text fields and pops message if question is added
				insertmcq.question.setText("");
				insertmcq.op1.setText("");
				insertmcq.op2.setText("");
				insertmcq.op3.setText("");
				insertmcq.op4.setText("");
				insertmcq.la.setVisible(true);
				
				
				
				
			}
			
		});
		
		add(b);
		
		FTerminator t = new FTerminator();
		addWindowListener(t);
		
	}
}

//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

class inserttf extends Frame
{	static TextField question,ans;
	static String fil;
	static Label l2;
	
	inserttf(String s)
	{	fil=s;
		Button b = new Button("SUBMIT");
		b.setBounds(250,400,100,30);
		Button b2 =new Button("GO BACK");
		b2.setBounds(250, 430, 100, 30);
		b2.addActionListener(new CloseInsertTF(this));
		
		
		
		setLocationRelativeTo(null);
		add(b2);
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("T/F Question Insertion");
		setLocationRelativeTo(null);
		
		question = new TextField(200);
		ans = new TextField(200);
		
		Label l1 = new Label("Please enter the question below");
		Label l6 = new Label("Ans");
		
		l1.setBounds(50,170, 200, 30);
		question.setBounds(50,200,500,30);
		l6.setBounds(25,250,25,30);
		ans.setBounds(50,250,100,30);
		
		l2= new Label("Question Added. Add another or go back", Label.CENTER);
		l2.setBounds(50,500,500,30);
		l2.setVisible(false);
		add(l2);
		
		add(l1); add(l6); add(question); add(ans);
		
		FTerminator t = new FTerminator();
		addWindowListener(t);
		
		b.addActionListener(new ActionListener(){
			String q, a, f;
			public void actionPerformed(ActionEvent event)
			{
				q= inserttf.question.getText();
				a=inserttf.ans.getText();
				f=inserttf.fil;
				
				try {
					FileWriter fw = new FileWriter(f, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					
					pw.println(q+" "+"[T/F]");  //Question added with marker to identify
					pw.println(a); //Answer added on next line
											
					pw.close();
					
				}
				
				catch(IOException e)
				{
					System.out.println("Exception Caught" + e);
				}
				
				inserttf.ans.setText(""); //Clears fields and pops message if question added
				inserttf.question.setText("");
				inserttf.l2.setVisible(true);
				
			}
			
		});
		
		add(b);
		
		
	}
	
	
}



////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////


class insertfill extends Frame
{		static TextField question,ans;
		static String fil;
		static Label l2;
	insertfill(String s)
		{	fil=s;
			Button b = new Button("SUBMIT");
			b.setBounds(250,400,100,30);
			Button b2 =new Button("GO BACK");
			b2.setBounds(250, 430, 100, 30);
			b2.addActionListener(new CloseInsertFill(this));
			
			//add(b);
			add(b2);
			setSize(600,600);
			setLayout(null);
			setVisible(true);
			setTitle("Fill in Question Insertion");
			setLocationRelativeTo(null);
			
			question = new TextField(200);
			ans = new TextField(200);
		
			
			Label l1 = new Label("Please enter the question below");
			Label l6 = new Label("Ans");
			
			l1.setBounds(50,170, 200, 30);
			question.setBounds(50,200,500,30);
			l6.setBounds(25,250,25,30);
			ans.setBounds(50,250,100,30);
			l2= new Label("Question Added. Add another or go back", Label.CENTER);
			l2.setBounds(50,500,500,30);
			l2.setVisible(false);
			add(l2);
			add(l1); add(l6); add(question); add(ans); 
			
			FTerminator t = new FTerminator();
			addWindowListener(t);
			
			b.addActionListener(new ActionListener(){
				String q, a, f;
				public void actionPerformed(ActionEvent event)
				{
					q= insertfill.question.getText();
					a=insertfill.ans.getText();
					f=insertfill.fil;
					
					try {
						FileWriter fw = new FileWriter(f, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						
						pw.println(q+" "+"[FILL]");   //Stores the question with a marker to identify
						pw.println(a); //Stores answer in next line
												
						pw.close();
						
					}
					
					catch(IOException e)
					{
						System.out.println("Exception Caught" + e);
					}
					
					insertfill.ans.setText("");  //Pops message that question is stored
					insertfill.question.setText("");
					insertfill.l2.setVisible(true);
					
					
				}
				
			});

			add(b);


		}
	
	
}

///////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

class Insert extends Frame 
{
	Button b1, b2, b3, b4;
	Label l1;
	Insert(String s)
	{
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("Online Examination Management System");
		setLocationRelativeTo(null);
		
		l1 = new Label("What kindof question would you like to enter ?");
		l1.setBounds(175 ,100 , 400, 30);
		add(l1);
		
		b1= new Button("MULTIPLE CHOICE");
		b2= new Button("FILL IN THE BLANKS");
		b3= new Button("TRUE/FALSE");
		b4= new Button("CANCEL");
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		b3.setBounds(225,310,150,30);
		b4.setBounds(225,350,150,30);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new insertmcq(s); //If MCQ selected, instantiates with file name
				
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new insertfill(s); //If F-I-B selected, instantiates with file name
				
			}
		});
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new inserttf(s); //If T/F selected, instantiates with file name
				
			}
		});
		b4.addActionListener(new CloseInsert(this));
		
		
		
		
		
		FTerminator t = new FTerminator();
		addWindowListener(t);
		
		
		
	}
}

class Generate extends Frame {
	
	Label l1;
	static Label l2,l3;
	static String fil,filo;
	static TextField serial;
	static TextField code;
	Button b1, b2;
	Generate(String s, String t)
	{	fil=s;  //Reference to the "deleted" file 
		filo=t; //Reference to the q/a file 
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("Online Examination Management System");
		setLocationRelativeTo(null);
		
		l1 = new Label("Please enter the number of questions to be in the test.");
		l1.setBounds(125 ,100 , 400, 30);
		add(l1);
		l2= new Label("Test Generated. Generate another or Go Back ?");
		l2.setBounds(175, 300, 400, 30);
		l2.setVisible(false);
		add(l2);
		l3=new Label("Number of available questions are less. Try again.");
		l3.setBounds(200, 300, 400, 30);
		l3.setVisible(false);
		add(l3);
		
		
				
		
		serial= new TextField(100);
		serial.setBounds(250,150,100,30);
		add(serial);
		code = new TextField(100);
		code.setText("Unique Test Code");
		code.setBounds(250,200,100,30);
		add(code);
		
		//Button b1,b2;
		b1=new Button("SUBMIT");
		b1.addActionListener(new ActionListener() {
			String f,num,f1;
			int n,k=0,check=0, checkarr;
			String line;
			String quest, ans;
			
			public void actionPerformed(ActionEvent event)
			{	f=Generate.fil; //Reference to the "deleted" file
				f1=Generate.filo; //Reference to the "q/a" file 
				num=Generate.serial.getText(); 
				try
				{
					n=Integer.parseInt(num); //Integer equivalent of the entered string
					FileInputStream fi = new FileInputStream(f1); //FileStream containing the q/a file 
					BufferedReader br = new BufferedReader(new InputStreamReader(fi));
					k=0;
					while((line=br.readLine())!=null)
					{
						k++;
					}
					
					k/=2;			 //counts the number of questions entered till now				
					int deleted[]= new int[k];		//Creates and initializes an array of 'k' integers to -1.
					for(int j=0;j<k;j++)
					{
						deleted[j]=-1;
					}
					System.out.println(""+k+" "+ n); //Debugger
					
					br.close();
					
					FileInputStream fdel= new FileInputStream(f); //FileStream holds the "deleted" file
					BufferedReader br1=new BufferedReader(new InputStreamReader(fdel));
					check=0;
					while((line=br1.readLine())!=null)
					{
						deleted[check++]=Integer.parseInt(line);   //deleted[] is initialized with serial of deleted questions and "check" counts the number of deleted questions
						
					}
					
					
					
					
					
					br1.close();
					br.close();
					
					int shuffle[]=new int[(k-check)];  //A shuffle array of the size of number of available quests
					
					
					if(n>(k-check))  //Pops a message if number of questions available isn't sufficient
					{
						Generate.serial.setText("");
						Generate.l2.setVisible(false);
						Generate.l3.setVisible(true);
						
					}
					
					else
						
					{	int z=0;
						for(int i=1;i<=k;i++)
						{
							checkarr=0;
							for(int j=0;j<check;j++)
							{
								if(deleted[j]==i)
									checkarr=1;
							}
							
							if(checkarr==0)
							shuffle[z++]=i;	   //Initialized with question indices present in q/a file and not in "deleted" file
							
						}
						
					    for(int i=0;i<z;i++)
					    {
					    	System.out.print(shuffle[i]);
					    	
					    }
					    System.out.println("");  //Debugger to check array prior to shuffling
						
						try
						{	ArrayList<String>quests= new ArrayList<String>();
							ArrayList<String>answ = new ArrayList<String>();
							fi = new FileInputStream(f1);   //FileStream contains the original q/a file
							br = new BufferedReader(new InputStreamReader(fi));
							String test, ans;
							test=Generate.code.getText();
							test+=".txt";
							ans=Generate.code.getText()+"ans"+".txt";
							FileWriter fw = new FileWriter(test);  //Holds the test-question file
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							
							FileWriter fw1 = new FileWriter(ans); //Holds the test-answer file
							BufferedWriter bw1 = new BufferedWriter(fw1);
							PrintWriter pw1 = new PrintWriter(bw1);
							
							//////////////////////////////////////////////////////////
							//////////////////////////////////////////////////////////
							
							 int index, temp;
							    Random random = new Random();   //Usage of random shuffling
							    for (int i = z - 1; i > 0; i--)
							    {
							        index = random.nextInt(i + 1);
							        temp = shuffle[index];
							        shuffle[index] = shuffle[i];
							        shuffle[i] = temp;
							    }
							    
							   for(int i=0;i<z;i++)   //Debugger to check shuffe[] post shuffling
							    {
							    	System.out.print(shuffle[i]);
							    	
							    }
							    System.out.println(""); 
							    
							    ///////////////////////////////////////////////////////
							    ///////////////////////////////////////////////////////
							    k=0;  //Iterator
							    int qno=0; //Question number container
							    while((line=br.readLine())!=null)
								{
									k++;
									if(k%2!=0)  //Since questions are saved on odd numbered lines
									{
										checkarr=0;
										for(int i=0;i<n;i++)
										{
											if(shuffle[i]==(k+1)/2)  //If the question index is among the first n elements of shuffle[]
												checkarr=1;
												
										}
										
										if(checkarr==1)
										{
											quest=line; //quest contains the question now 
											qno++; //question number
											ans=br.readLine(); //ans contains the answer now 
											System.out.println(k+" "+quest+" "+ans); //Debugger
											
											
											
											String lastword = quest.substring(quest.lastIndexOf(" ")+1);
											System.out.println(lastword); //Checks the type of question
											
											if(lastword.equals("[MCQ]"))
											{
												String str[]=ans.split("   ");
												pw.println("Q"+qno+" "+quest);
												quests.add("Q"+qno+" "+quest);
												pw.println("a)"+str[0]+" "+"b)"+str[1]+" "+"c)"+str[2]+" "+"d)"+str[3]);
												quests.add("a)"+str[0]+" "+"b)"+str[1]+" "+"c)"+str[2]+" "+"d)"+str[3]); //ArrayList populated
												pw.println("");
												pw1.println("Ans"+qno+" "+str[4]);
												answ.add("Ans"+qno+" "+str[4]); //ArrayList populated
												
											}
											
											else
											{
												pw.println("Q"+qno+" "+quest);
												quests.add("Q"+qno+" "+quest);
												pw.println("");
												pw1.println("Ans"+qno+" "+ans);
												answ.add("Ans"+qno+" "+ans);
											}
											
											k++;
												
											
										}
											
										
									}
								}
							    
							    br.close();
							    pw.close();
							    pw1.close();
							   new DisplayQ(quests); //Calls the DisplayQ frame to display questions
							   new DisplayA(answ);  //Calls the DisplayA frame to display answers 
							 
							 
						}
						
						catch(IOException e)
						{
							System.out.println("Exception Caught" + e );
						}
						
						
						Generate.serial.setText("");
						Generate.l3.setVisible(false);
						Generate.l2.setVisible(true);
						
							
						}
						
					}
						

				
				catch(Exception e)
				{
					System.out.println("Invalid Argument "+e);
				}
				
				
			}
				
			
		
			
		});
		
		
		b2=new Button("GO BACK");
		b2.addActionListener(new closeGenerate(this));
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		
		add(b1);
		add(b2);
		FTerminator t1 = new FTerminator();
		addWindowListener(t1);
		
		
		
		
		
	}
	
	
	
}

///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

class Delete extends Frame
{	Label l1;
	static Label l2,l3;
	static String fil,filo;
	static TextField serial;
	Button b1, b2;
	Delete(String s, String t)
	{	fil=s; //Reference to the "deleted" file
		filo=t; //Reference to the q/a file 
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("Online Examination Management System");
		setLocationRelativeTo(null);
		
		l1 = new Label("Please enter the serial number of question you want to delete.");
		l1.setBounds(125 ,100 , 400, 30);
		add(l1);
		l2= new Label("Question Deleted. Delete another or Go Back ?");
		l2.setBounds(175, 200, 400, 30);
		l2.setVisible(false);
		add(l2);
		l3=new Label("Question doesn't exist. Try again.");
		l3.setBounds(200, 200, 400, 30);
		l3.setVisible(false);
		add(l3);
		
		
				
		
		serial= new TextField(100);
		serial.setBounds(250,150,100,30);
		add(serial);
		
		//Button b1,b2;
		b1=new Button("SUBMIT");
		b1.addActionListener(new ActionListener() {
			String f,num,f1;
			int n,k=0,check=0;
			String line;
			
			public void actionPerformed(ActionEvent event)
			{	f=Delete.fil; //reference to the "deleted" file 
				f1=Delete.filo; //reference to the q/a file
				num=Delete.serial.getText();
				try
				{
					n=Integer.parseInt(num);  //Integer equivalent of the requested serial number
					FileInputStream fi = new FileInputStream(f1);   //FileStream containing the q/a file
					BufferedReader br = new BufferedReader(new InputStreamReader(fi));
					k=0;
					while((line=br.readLine())!=null)
					{
						k++;
					}
					
					k/=2;   //k contains the number of questions entered till now
				//	System.out.println(""+k+" "+ n);
					
					br.close();
					
					FileInputStream fdel= new FileInputStream(f);
					BufferedReader br1=new BufferedReader(new InputStreamReader(fdel));
					check=0;
					while((line=br1.readLine())!=null) //checks if the requested question has already been deleted
					{
						if(line.equals(num))
							check=1;
					}
					
					br1.close();
					
					
					if(n>k||check==1) //Pops a message if question isn't available
					{
						Delete.serial.setText("");
						Delete.l2.setVisible(false);
						Delete.l3.setVisible(true);
						
					}
					
					else
						
					{
						try {
							FileWriter fw = new FileWriter(f, true);    //FileStream containing the "deleted" file 
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							
							pw.println(num);											//Puts in the requested question in the list of deleted questions
							pw.close();
							
						}
						
						catch(IOException e)
						{
							System.out.println("Exception Caught" + e);
						}
						
						Delete.serial.setText("");
						Delete.l3.setVisible(false);
						Delete.l2.setVisible(true);
						
							
						}
						
					}
						

				
				catch(Exception e)
				{
					System.out.println("Not a valid input "+ e);
				}
				
				
			}
				
			
		
			
		});
		
		
		b2=new Button("GO BACK");
		b2.addActionListener(new closeDelete(this));
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		
		add(b1);
		add(b2);
		FTerminator t1 = new FTerminator();
		addWindowListener(t1);
		
		
		
		
		
	}
}

////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

class Modify extends Frame
{	static String fil, filo;
	static Label l1, l2, l3;
	static TextField serial;
	Button b1, b2;
	Modify(String s, String t)
	{
		fil=s;					//Holds reference for the "deleted" file
		filo=t;					//Holds reference for the q/a file
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("Online Examination Management System");
		setLocationRelativeTo(null);
		
		l1 = new Label("Please enter the serial number of question you want to modify.");
		l1.setBounds(125 ,100 , 400, 30);
		add(l1);
		l2= new Label("Question Modified. Modify another or Go Back ?");
		l2.setBounds(175, 200, 400, 30);
		l2.setVisible(false);
		add(l2);
		l3=new Label("Question doesn't exist. Try again.");
		l3.setBounds(200, 200, 400, 30);
		l3.setVisible(false);
		add(l3);
		
		serial= new TextField(100);
		serial.setBounds(250,150,100,30);
		add(serial);
		
		//Button b1,b2;
		b1=new Button("SUBMIT");
		b1.addActionListener(new ActionListener() {
			String f,num,f1;
			int n,k=0,check=0,i;
			String line,line2,lastword;
			
			public void actionPerformed(ActionEvent event)
			{	f=Modify.fil;	//Reference for the "deleted" file
				f1=Modify.filo;	//Reference for the q/a file
				num=Modify.serial.getText();
				try
				{
					n=Integer.parseInt(num);	//Integer conversion of the serial number given
					FileInputStream fi = new FileInputStream(f1); //FileStream holding the q/a file
					BufferedReader br = new BufferedReader(new InputStreamReader(fi));
					k=0;
					while((line=br.readLine())!=null)
					{
						k++;
					}
					
					k/=2;
					//System.out.println(""+k+" "+ n);			//Prints number of questions and user input. Debugger.
					
					br.close();
					
					FileInputStream fdel= new FileInputStream(f); //FileStream holding the "deleted" file
					BufferedReader br1=new BufferedReader(new InputStreamReader(fdel));
					check=0;
					while((line=br1.readLine())!=null)		//Checks if the user input question is deleted
					{
						if(line.equals(num))
							check=1;
					}
					
					br1.close();
					
					
					if(n>k||check==1)			//If question doesn't exist, pop a message
					{
						Modify.serial.setText("");
						Modify.l2.setVisible(false);
						Modify.l3.setVisible(true);
						
					}
					
					else					//Else start on modification
						
					{
						try {
						FileInputStream fi2 = new FileInputStream(f1);  //FileStream holding the q/a file
						BufferedReader br2 = new BufferedReader(new InputStreamReader(fi2));
						
						FileWriter fw = new FileWriter("temp.txt", false);  //FileStream holding the temp file 
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						
						i=1;
						while(i< 2*n-1)			//Iterations to print all questions preceding the user input into temp.
						{
							line=br2.readLine();
							//System.out.println(line +"inside loop");
							pw.println(line);
							i++;
						}
						
						line=br2.readLine(); //Reads the to-be-modified question
						line2=br2.readLine();//Reads the to-be-modified answer
						
						lastword = line.substring(line.lastIndexOf(" ")+1); //Determines the type of question
						//System.out.println(lastword);
						
						if(lastword.equals("[MCQ]"))   //Calling appropriate functions
							new ModifyMCQ(line, line2,f1);
						else if(lastword.equals("[T/F]"))
							new ModifyN(line, line2, f1);
						else if(lastword.equals("[FILL]"))
							new ModifyN(line, line2, f1);
						
						br2.close();
						pw.close();
						
					
							
						}
						
						catch(IOException e)
						{
							System.out.println("Exception Caught" + e);
						}
						
						Modify.serial.setText("");     //Pops the message of Question Modified
						Modify.l3.setVisible(false);
						Modify.l2.setVisible(true);
						
							
						}
						
					}
						

				
				catch(Exception e)
				{
					System.out.println("Not a valid Input "+e);
				}
				
				
			}
				
			
		
			
		});
		
		
		b2=new Button("GO BACK");
		b2.addActionListener(new closeModify(this));
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		
		add(b1);
		add(b2);
		FTerminator t1 = new FTerminator();
		addWindowListener(t1);
		
		
		
		
	}
}

/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////

class ModifyMCQ extends Frame{
	
	static TextField question, op1, op2, op3, op4, ans;
	static String fil, check;
	Button b1, b2;
	static File del, ren;
	static String checkline, checkline2;

	
	ModifyMCQ(String line, String line2, String fname)
	{	fil=fname; //Contains the reference to the original q/a file
		del = new File(fil); //File object containing the original q/a file
		ren = new File("temp.txt"); //File object containing the temp file created by Modify
		checkline = line; //Contains the to-be-modified MCQ
		checkline2 = line2; //Contains the to-be-modified MCQ answer
		
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("Question Modification");
		setLocationRelativeTo(null);
		question = new TextField(200);
		question.setText(line);
		
		Button b1 = new Button("SUBMIT");
		Button b2 =new Button("MODIFY ANOTHER/GO BACK");
		b2.setBounds(250, 450, 100, 30);
		b2.addActionListener(new closeModifyMCQ(this));
		b1.setBounds(250,400,100,30);
		b2.setBounds(200, 430, 200, 30);
		String str[]=line2.split("   "); //Splits the "answer" string on basis of "   "
		
		
		op1 = new TextField(200);
		op1.setText(str[0]); //Option 1
		op2=  new TextField(200);
		op2.setText(str[1]); //Option 2
		op3 = new TextField(200);
		op3.setText(str[2]); // Option 3
		op4=  new TextField(200);
		op4.setText(str[3]); //Option 4
		ans = new TextField(200);
		ans.setText(str[4]); //Ans
		
		Label l1 = new Label("Please modify the details below");
		l1.setBounds(50,170, 200, 30);
		question.setBounds(50,200,500,30);
		Label l2, l3, l4, l5, l6;
		l2= new Label("A");
		l3 =new Label("B");
		l4= new Label("C");
		l5 =new Label("D");
		l6 =new Label("Ans");
		l2.setBounds(25,230,25,30);
		op1.setBounds(50,230, 100, 30);
		l3.setBounds(25,260,25,30);
		op2.setBounds(50,260,100,30);
		l4.setBounds(25,290,25,30);
		op3.setBounds(50,290,100,30);
		l5.setBounds(25,320,25,30);
		op4.setBounds(50,320,100,30);
		l6.setBounds(25,350,25,30);
		ans.setBounds(50,350,100,30);
		add(question);
		add(l1); 
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(op1);
		add(op2);
		add(op3);
		add(op4);
		add(ans);
		
		
		
		b1.addActionListener(
				new ActionListener(){
					
					String q,o1,o2,o3,o4,a,check;
					public void actionPerformed(ActionEvent event)
					{
						q=ModifyMCQ.question.getText(); //Reads input from all the modified TextFields
						o1=ModifyMCQ.op1.getText();
						o2=ModifyMCQ.op2.getText();
						o3=ModifyMCQ.op3.getText();
						o4=ModifyMCQ.op4.getText();
						a=ModifyMCQ.ans.getText();
						
						/////////////////////////////////////////////////////////
						
						try { FileInputStream fin = new FileInputStream(fil); 
						BufferedReader br = new BufferedReader(new InputStreamReader(fin));
						
						FileWriter fw = new FileWriter("temp.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						
						
						while(!((check=br.readLine()).equals(ModifyMCQ.checkline))) //Brings file pointer to the end of to-be-modified question
						{
							
							//System.out.println(line +"inside loop");
						}
						
						br.readLine(); //Brings file pointer to the end of to-be-modified answer
						pw.println(q); //Prints modified question onto temp
						pw.println(o1+"   "+o2+"   "+o3+"   "+o4+"   "+a); //Prints the modified answer onto temp
						
						
						while((check=br.readLine())!=null)
						{
							pw.println(check);   //Prints all remaining lines of q/a file onto temp
							
						}
						
									
						br.close();
						pw.close();
						
						del.delete(); //Deletes the original q/a file
						ren.renameTo(del);} //Renames the temp file as the q/a file 
						
						catch (Exception e)
						{
							System.out.println("Exception Caught" +e);
						}
						
						
						
						
					}
				});
		
		
		
		add(b1); add(b2);
		FTerminator t1 = new FTerminator();
		addWindowListener(t1);	
	}
	
	
}

////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

class ModifyN extends Frame{
	
	static TextField question, ans;
	Button b1, b2;
	static String fil;
	static File del, ren;
	static String checkline, checkline2;
	
	ModifyN(String line, String line2, String fname)
	{	fil=fname; //Contains the reference to the original q/a file
		//del = new File(fil);  //File object containing the original q/a file
		del = new File(fil); //File object containing the original q/a file
		
		ren = new File("temp.txt"); //File object containing the temp file created by Modify
		checkline = line;  //Contains the question
		checkline2 = line2; //Contains the answer
		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("Question Modification");
		setLocationRelativeTo(null);
		
		Button b1 = new Button("SUBMIT");
		b1.setBounds(250,400,100,30);
		Button b2 = new Button("MODIFY ANOTHER / BACK");
		b2.setBounds(200, 450, 200, 30);
		b2.addActionListener(new closeModifyN(this));
		
		question = new TextField(200);
		question.setText(line);
		
		ans= new TextField(200);
		ans.setText(line2);
		
		Label l1 = new Label("Please modify the details below");
		Label l6 = new Label("Ans");
		
		l1.setBounds(50,170, 200, 30);
		question.setBounds(50,200,500,30);
		l6.setBounds(25,250,25,30);
		ans.setBounds(50,250,100,30);
		
		add(l1); add(l6); add(question); add(ans);
		
		b1.addActionListener(new ActionListener(){
			
			String q,a,check;
			public void actionPerformed(ActionEvent event)
			{
				q=ModifyN.question.getText(); //contains modified question
				a=ModifyN.ans.getText(); //contains modified answer
				
				/////////////////////////////////////////////////////////
				
				try { FileInputStream fin = new FileInputStream(fil);  //FileStream containing the original q/a file 
				BufferedReader br = new BufferedReader(new InputStreamReader(fin)); 
				
				FileWriter fw = new FileWriter("temp.txt", true); //FileStream containing the temp file
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				
				while(!((check=br.readLine()).equals(ModifyN.checkline)))  //Puts file pointer at the end of desired question
				{
					
					//System.out.println(line +"inside loop");
				}
				
				br.readLine(); //Puts the file pointer at the end of the needed answer
				pw.println(q); //Prints modified question onto temp file
				pw.println(a); //Prints modified answer onto temp file
				
				
				while((check=br.readLine())!=null)
				{
					pw.println(check);  //Copies remaining lines from original to temp file 
					
				}
				
							
				br.close();
				pw.close();
				
				del.delete();  //Deletes the original file 
				ren.renameTo(del); } //Renames the temp file as the original file 
				
				catch (Exception e)
				{
					System.out.println("Exception Caught" +e);
				}
				
				
				
				
			}
		});
		
		add(b1);
		add(b2);
		
		
		
		FTerminator t1 = new FTerminator();
		addWindowListener(t1);	
	}
	
}


////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

 
class Menu extends Frame
{
	Menu()
	{	setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("Online Examination Management System");
		setLocationRelativeTo(null);
		
		
		Label l1,l2,l3;
		
		l2 = new Label("What would you like to do ?");
		l2.setBounds(125, 130, 400, 30);
		l3= new Label(" Please click the appropriate button.");
		l3.setBounds(125, 160, 400, 30);
		
		add(l2);
		add(l3);
		
		addWindowListener(new FTerminator());
		
		Button b5 = new Button("GO BACK");
		
		b5.setBounds(225,390,150,30);
		
		add(b5);
		
		b5.addActionListener(new CloseMenu(this));
	}
}



////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

class f213 extends Menu{
	
	f213()
	{
		super();
		Button b1, b2, b3, b4;
		b1 = new Button("INSERT QUESTION");
		b2 = new Button("MODIFY QUESTION");
		b3 = new Button("DELETE QUESTION");
		b4 = new Button("GENERATE TEST");		
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		b3.setBounds(225,310,150,30);
		b4.setBounds(225,350,150,30);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Insert("f213.txt");  //Calls upon Insertion Request
				
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Modify("f213del.txt", "f213.txt");  //Calls upon Modification Request
				
			}
		});
		
		b3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					new Delete("f213del.txt", "f213.txt"); //Calls upon Deletion Request
				}
			});
		
		
		b4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					new Generate("f213del.txt", "f213.txt"); //Calls upon Generate Request
				}
			});
		
		
		
		
		
		
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		
		Label l1 = new Label("CS F213 - OBJECT ORIENTED PROGRAMMING");
		l1.setBounds(150, 440, 300, 30);
		add(l1);
		
		
		
	}
	
}

/////////////////////////////////////////////////////////////////////////
//////////////Following 5 classes do the same function as f213 but for separate subjects///////

class f214 extends Menu{
	
	f214()
	{
		super();
		Button b1, b2, b3, b4;
		b1 = new Button("INSERT QUESTION");
		b2 = new Button("MODIFY QUESTION");
		b3 = new Button("DELETE QUESTION");
		b4 = new Button("GENERATE TEST");		
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		b3.setBounds(225,310,150,30);
		b4.setBounds(225,350,150,30);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Insert("f214.txt");
				
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Modify("f214del.txt", "f214.txt");
				
			}
		});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Delete("f214del.txt", "f214.txt");
			}
		});
		
		
		b4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					new Generate("f214del.txt", "f214.txt");
				}
			});
		
		
		
		
		
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		Label l1 = new Label("CS F214 - LOGIC IN COMPUTER SCIENCE");
		l1.setBounds(150, 440, 300, 30);
		add(l1);
		
	}
	
}

////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

class f215 extends Menu{
	
	f215()
	{
		super();
		Button b1, b2, b3, b4;
		b1 = new Button("INSERT QUESTION");
		b2 = new Button("MODIFY QUESTION");
		b3 = new Button("DELETE QUESTION");
		b4 = new Button("GENERATE TEST");		
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		b3.setBounds(225,310,150,30);
		b4.setBounds(225,350,150,30);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Insert("f215.txt");
				
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Modify("f215del.txt", "f215.txt");
				
			}
		});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Delete("f215del.txt","f215.txt");
			}
		});
		
		
		b4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					new Generate("f215del.txt", "f215.txt");
				}
			});
		
		
		
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		Label l1 = new Label("CS F215 - DIGITAL DESGIN");
		l1.setBounds(150, 440, 300, 30);
		add(l1);
		
	}
	
}

/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////

class f222 extends Menu{
	
	f222()
	{
		super();
		Button b1, b2, b3, b4;
		b1 = new Button("INSERT QUESTION");
		b2 = new Button("MODIFY QUESTION");
		b3 = new Button("DELETE QUESTION");
		b4 = new Button("GENERATE TEST");		
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		b3.setBounds(225,310,150,30);
		b4.setBounds(225,350,150,30);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Insert("f222.txt");
				
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Modify("f222del.txt", "f222.txt");
				
			}
		});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Delete("f222del.txt","f222.txt");
			}
		});
		
		
		b4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					new Generate("f222del.txt", "f222.txt");
				}
			});
		
		
		
		
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		Label l1 = new Label("CS F222 - DISCRETE STRUCTURES IN CS");
		l1.setBounds(150, 440, 300, 30);
		add(l1);
		
	}
	
}

///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////

class f211 extends Menu{
	
	f211()
	{
		super();
		Button b1, b2, b3, b4;
		b1 = new Button("INSERT QUESTION");
		b2 = new Button("MODIFY QUESTION");
		b3 = new Button("DELETE QUESTION");
		b4 = new Button("GENERATE TEST");		
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		b3.setBounds(225,310,150,30);
		b4.setBounds(225,350,150,30);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Insert("f211.txt");
				
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Modify("f211del.txt", "f211.txt");
				
			}
		});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Delete("f211del.txt","f211.txt");
			}
		});
		
		
		b4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					new Generate("f211del.txt", "f211.txt");
				}
			});
		
		
		
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		Label l1 = new Label("MATH F211- DIFFERENTIAL CALCULUS");
		l1.setBounds(150, 440, 300, 30);
		add(l1);
		
	}
	
}

//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////

class f231 extends Menu{
	
	f231()
	{
		super();
		Button b1, b2, b3, b4;
		b1 = new Button("INSERT QUESTION");
		b2 = new Button("MODIFY QUESTION");
		b3 = new Button("DELETE QUESTION");
		b4 = new Button("GENERATE TEST");		
		b1.setBounds(225,230,150,30);
		b2.setBounds(225,270,150,30);
		b3.setBounds(225,310,150,30);
		b4.setBounds(225,350,150,30);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Insert("f231.txt");
				
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Modify("f231del.txt", "f231.txt");
				
			}
		});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Delete("f231del.txt","f231.txt");
			}
		});
		
		
		b4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					new Generate("f231del.txt", "f231.txt");
				}
			});
		
		
		
		
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		Label l1 = new Label("GS F231 - DYNAMICS OF SOCIAL CHANGE");
		l1.setBounds(150, 440, 300, 30);
		add(l1);
		
	}
	
}

/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////

class SubSelect extends Frame{
	
	SubSelect()
	{	setSize(600,600);
		setLayout(null);
		setVisible(true);
		setTitle("Online Examination Management System");
		setLocationRelativeTo(null);
		
		
		Label l1,l2,l3;
		l1 = new Label("You now have access to the system functionality.");
		l1.setBounds(125 ,100 , 400, 30);
		l2 = new Label("What subject would you like access to ?");
		l2.setBounds(125, 130, 400, 30);
		l3= new Label(" Please click the appropriate button.");
		l3.setBounds(125, 160, 400, 30);
		add(l1);
		add(l2);
		add(l3);
		addWindowListener(new FTerminator());
		
		Button b1, b2, b3, b4, b5, b6;
		b1 = new Button("CS F213");
		b2 = new Button("CS F214");
		b3 = new Button("CS F215");
		b4 = new Button("CS F222");
		b5 = new Button("MATHS F211");
		b6 = new Button("GS F231");
		b1.setBounds(225,220,150,30);
		b2.setBounds(225,260,150,30);
		b3.setBounds(225,300,150,30);
		b4.setBounds(225,340,150,30);
		b5.setBounds(225,380,150,30);
		b6.setBounds(225,420,150,30);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
/////////////////////////////////////////////////////////////////////		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new f213();  //Calls the f213 class upon selection 
				
			}
		});
///////////Similar action for the other actionListener, for different subjects //////////////////////////////////////
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new f214();
				
			}
		});
//////////////////////////////////////////////////////////////////////
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new f215();
				
			}
		});
//////////////////////////////////////////////////////////////////////
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new f222();
				
			}
		});
//////////////////////////////////////////////////////////////////////
		b5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new f211();
				
			}
		});
//////////////////////////////////////////////////////////////////////
		b6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new f231();
				
			}
		});
		
	}
}



////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

class Dial
{
	private static Dialog d;
	Dial()
	{
		Frame f = new Frame();
		d = new Dialog(f,"Online Examination Management System",true);
		Button b1 = new Button("YES");
		Button b2= new Button("NO");
		
		d.setLayout(new FlowLayout());
		d.setLocationRelativeTo(null);
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false);   //closes dialog
				System.exit(0); //closes program
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false); //just closes dialog
			}
		});
		
		d.add(new Label("Are you sure you want to quit ? ANY unsaved data will be permanently lost."));
		d.add(b1);
		d.add(b2);
		d.setSize(450, 200);
		d.setVisible(true);
	//	d.setLocationRelativeTo(null);
	
		
		
	}
	
	
}

////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////

class newDial
{
	private static Dialog d;
	newDial()
	{
		Frame f = new Frame();
		d = new Dialog(f,"INVALID CREDENTIALS!!",true);
		Button b1 = new Button("EXIT");
		Button b2= new Button("TRY AGAIN");
		d.setLocationRelativeTo(null);
		
		d.setLayout(new FlowLayout());
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false); //closes dialog
				System.exit(0); //closes program
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				d.setVisible(false);  //closes dialog
			}
		});
		
		d.add(new Label("Invalid Credentials Entered. Please retry or exit."));
		d.add(b1);
		d.add(b2);
		d.setSize(450, 200);
		d.setVisible(true);
	//	d.setLocationRelativeTo(null);
		
}
}


//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////

class FTerminator extends WindowAdapter
{
	public void windowClosing(WindowEvent event)
	{
		new Dial(); //calls Dial when X button is pressed on any Window
		
	}
}

////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////

class textInputListener implements ActionListener
{	String name, pass;
	public void actionPerformed(ActionEvent event)
	{
		name=First.name.getText();
		pass=First.pass.getText();
		if(name.equals("ansuman")&&pass.equals("f20160043"))
		{
			new SubSelect();  //If username-password authenticated 
		}
		
		else
		{
			new newDial(); // If not, pops dialog
		}
	}
			
}
/////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
class CloseMenu implements ActionListener   //To Close Menu Frame 
{	Menu m1;
	CloseMenu(Menu m)
	{
		m1=m;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		m1.setVisible(false);
	}
}
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
class CloseInsert implements ActionListener   //To Close Insert Frame 
{
	Insert i1;
	CloseInsert(Insert i)
	{
		i1=i;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		i1.setVisible(false);
	}
	
}
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
class CloseInsertFill implements ActionListener  //To Close insertfill Frame 
{
	insertfill i1;
	CloseInsertFill(insertfill i)
	{
		i1=i;
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		i1.setVisible(false);
	}
}
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
class CloseInsertMCQ implements ActionListener   //To Close insertmcq Frame
{
	insertmcq i1;
	CloseInsertMCQ(insertmcq i)
	{
		i1=i;
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		i1.setVisible(false);
	}
}
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
class CloseInsertTF implements ActionListener	//To Close inserttf Frame
{
	inserttf i1;
	CloseInsertTF(inserttf i)
	{
		i1=i;
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		i1.setVisible(false);
	}
}

///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
class closeDelete implements ActionListener	//To Close Delete Frame
{
	Delete d1;
	closeDelete(Delete d)
	{
		d1=d;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		d1.setVisible(false);
	}
}

///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
class closeModify implements ActionListener	//To Close Modify Frame
{
	Modify d1;
	closeModify(Modify m)
	{
		d1=m;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		d1.setVisible(false);
	}
}
/////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
class closeModifyN implements ActionListener	//To Close ModifyN Frame
{
	ModifyN n1;
	closeModifyN(ModifyN n)
	{
		n1=n;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		n1.setVisible(false);
	}
}

///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
class closeModifyMCQ implements ActionListener	//To Close ModifyMCQ Frame
{
	ModifyMCQ n1;
	closeModifyMCQ(ModifyMCQ n)
	{
		n1=n;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		n1.setVisible(false);
	}
}
////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
class closeGenerate implements ActionListener	//To close the Generate Frame 
{
	Generate d1;
	closeGenerate(Generate d)
	{
		d1=d;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		d1.setVisible(false);
	}
}
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
class closeDisplayQ implements ActionListener		//To close the DisplayQ Frame
{
	DisplayQ d1;
	closeDisplayQ(DisplayQ d)
	{
		d1=d;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		d1.setVisible(false);
	}
}
//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
class closeDisplayA implements ActionListener  //To close the DisplayA Frame
{
	DisplayA d1;
	closeDisplayA(DisplayA d)
	{
		d1=d;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		d1.setVisible(false);
	}
}
////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

class DisplayQ extends Frame			//Displays Questions after Test Generation
{
	DisplayQ(ArrayList<String>q)
	{	int n = q.size();
		setSize(600,600);
		setLayout(new GridLayout(n+1,1));
		setVisible(true);
		setLocationRelativeTo(null);
		
		Label l[]= new Label[n];
		for(int i=0;i<n;i++)
			l[i]=new Label(q.get(i));
		
		
		for(int i=0;i<n;i++)
			add(l[i]);
		
		Button b = new Button("CLOSE");
		b.addActionListener(new closeDisplayQ(this));
		Panel p = new Panel();
		p.add(b);
		add(p);
		FTerminator t = new FTerminator();
		addWindowListener(t);
	}
}
/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
class DisplayA extends Frame		//Displays answers after Test Generation
{
	DisplayA(ArrayList<String>a)
	{	int n = a.size();
		setSize(600,600);
		setLayout(new GridLayout(n+1,1));
		setVisible(true);
		
		Label l[]= new Label[n];
		for(int i=0;i<n;i++)
			l[i]=new Label(a.get(i));
		
		
		
		for(int i=0;i<n;i++)
			add(l[i]);
		Panel p = new Panel();
		
		Button b = new Button("CLOSE");
		b.addActionListener(new closeDisplayA(this));
		p.add(b);
		add(p);
		
		FTerminator t = new FTerminator();
		addWindowListener(t);
	}
}
