


package calculator1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



/**
 *
 * @author Zalmay
 */
public class Calculator1 extends JFrame{
    
    
    private JTextField tfDisplay;
    private JTextArea taHistory;
    private JCheckBox ch;
    
    
    private Font f = new Font("arial", Font.BOLD, 20);
    
    JMenuBar menuBar;
    JMenu fileMenu, editMenu;
    JMenuItem setting, about, Author, exit;
    
    private  JScrollPane js;
    
    
    
    private JPanel panelDisplay = new JPanel(new GridLayout(2, 1));
    private JPanel panelOpration = new JPanel(new GridLayout(5, 1));
    private JPanel panelNumBtms = new JPanel(new GridLayout(5, 3));
    
   // private JButton b1,b2,b3;
    
    private JButton[] btnNumbers = new JButton[15];
    private String[] numberText = {"C", "x", "P", "7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "+/-"};
    private JButton[] btnOperation = new JButton[5];
    private String[] OperationText = {"/", "*", "-", "+", "="};
    
    double firstNumber, secondNumber, result;
    String operation;
    
    
    public Calculator1 (){
      
      setupMenuBar();
      setupMainDisplay();
      setupMainFrame();
      setupOperationBtn();
      setupNumberBtns();
      
       
       
    }
    
    private void setupNumberBtns(){
        
      /*  b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        
        
        panelNumBtms.add(b1);
        panelNumBtms.add(b2);
        panelNumBtms.add(b3);
        
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String s = tfDisplay.getText();
              tfDisplay.setText(s + b1.getText());
            }
        });
        
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tfDisplay.getText();
                tfDisplay.setText(s + b2.getText());
            }
        });
        
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = tfDisplay.getText();
                tfDisplay.setText(s + b3.getText());
               
            }
        });  */
      
     //  panelNumBtms.setBackground(Color.decode("#e6e6e6"));
      
      for(int i = 0; i < btnNumbers.length; i++){
          
          btnNumbers[i] = new JButton(numberText[i]);
          btnNumbers[i].setBackground(Color.WHITE);
          btnNumbers[i].setBorder(BorderFactory.createLineBorder(Color.decode("#e6e6e6")));
          btnNumbers[i].setFont(f);
          panelNumBtms.add(btnNumbers[i]);
      }
      
      for(int i = 0; i < 3; i++){
          btnNumbers[i].setBackground(Color.decode("#f0f0f0"));
          btnNumbers[i].setFont(new Font("arial", Font.PLAIN, 25));
          btnNumbers[i].setForeground(Color.GRAY);
      }
      
      for(int i = 3; i < btnNumbers.length - 1; i++){
        
        int index = i;
        btnNumbers[i].addActionListener(new ActionListener() {
           // @Override Method actionPerformed had been overrideen;
            public void actionPerformed(ActionEvent e) {
                double d  = Double.parseDouble(tfDisplay.getText());
                
                if(d == 0 || d == firstNumber || d == result){
                    tfDisplay.setText("");
                }
                
                tfDisplay.setText(tfDisplay.getText() + btnNumbers[index].getText());
            }
        });
        
    }
         
      btnNumbers[0].addActionListener(new ActionListener() {

          public void actionPerformed(ActionEvent e) {
            if(!tfDisplay.equals("0")){
                tfDisplay.setText("0");
                taHistory.setText("");
            }
          }
      });
      
      btnNumbers[1].addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
            String s = tfDisplay.getText();
            
            if(s.length()== 1){
                tfDisplay.setText("0");
                
            }
            else{
                s = s.substring(0, s.length() - 1);
                tfDisplay.setText(s);
            }
          }
      });
      
      btnNumbers[2].addActionListener(new ActionListener() {
          
          public void actionPerformed(ActionEvent e) {
         
              double d = Double.parseDouble(tfDisplay.getText());
              tfDisplay.setText(Math.pow(d, 2) + "");
          }
      });
      
      btnNumbers[btnNumbers.length -1].addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              double d = Double.parseDouble(tfDisplay.getText());
              d *= -1; // d = d * -1
              tfDisplay.setText(d + "");
          }
      });
    }

    
    private  void setupMenuBar(){
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        setting = new JMenuItem("Setting");
        about = new JMenuItem("About");
        Author = new JMenuItem("Author");
        exit = new JMenuItem("Exit");
        ch = new JCheckBox("Show History");
        
        editMenu.add(ch);
        fileMenu.add(about);
        fileMenu.add(Author);
        fileMenu.add(exit);
        
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        
        menuBar.setBackground(Color.decode("#e6e6e6"));
        menuBar.setBorder(BorderFactory.createLineBorder(Color.decode("#e6e6e6")));
        
        taHistory = new JTextArea(3, 3);
        js = new JScrollPane(taHistory);
        panelDisplay.add(js);
        
        taHistory.setEditable(false);
        taHistory.setBackground(Color.decode("#e6e6e6"));
        taHistory.setBorder(BorderFactory.createLineBorder(Color.decode("#e6e6e6")));
        js.setBorder(BorderFactory.createLineBorder(Color.decode("#e6e6e6")));
        panelDisplay.setBackground(Color.decode("#e6e6e6"));
        js.setVisible(false);
        
       ch.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
              
              if(ch.isSelected()){
                  js.setVisible(true);
              }
              else
                  js.setVisible(false);
            }
        });
        
        
        exit.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
          }
        });
        
        
        about.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
               
                new AboutFrame();
            }
        });
        Author.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              new AuthorFrame(); 
            }
        });
       
    }
    
    private void setupMainDisplay(){
        
        tfDisplay = new JTextField("0", 9);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        tfDisplay.setBackground(Color.decode("#e6e6e6"));
        tfDisplay.setBorder(BorderFactory.createLineBorder(Color.decode("#e6e6e6")));
        tfDisplay.setEditable(false);
        tfDisplay.setFont(new Font("arial", Font.BOLD, 30));
        panelDisplay.add(tfDisplay);
    }
    
    private void setupMainFrame(){
        
         setLayout(new BorderLayout());
        setTitle("Zalmay Yusofi Calculator");
      
   
       
        
        add(panelDisplay, BorderLayout.NORTH);
        add(panelOpration, BorderLayout.EAST);
        add(panelNumBtms, BorderLayout.CENTER);
        
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }

    private void setupOperationBtn() {
        
        for(int i = 0; i < btnOperation.length - 1; i++){
            
            btnOperation[i] = new JButton(OperationText[i]);
            btnOperation[i].setBackground(Color.decode("#f0f0f0"));
            btnOperation[i].setForeground(Color.GRAY);
            btnOperation[i].setFont(new Font("arial", Font.PLAIN, 25));
            btnOperation[i].setBorder(BorderFactory.createLineBorder(Color.decode("#e6e6e6")));
            panelOpration.add(btnOperation[i]);
            
            int index = i;
            
            btnOperation[i].addActionListener(new ActionListener() {
               
                public void actionPerformed(ActionEvent e) {
                   operation = "";
                   operation = btnOperation[index].getText();
                   firstNumber = Double.parseDouble(tfDisplay.getText());
                   taHistory.append(firstNumber + " " + operation);
                   
                   
                  
                }
            });
            
        }
        
        JButton equalbtn = btnNumbers[btnOperation.length -1];
        
        equalbtn = new JButton("=");
        equalbtn.setBackground(Color.decode("#1c577c"));
        equalbtn.setForeground(Color.WHITE);
        equalbtn.setFont(new Font("arial", Font.PLAIN, 25));
        panelOpration.add(equalbtn);
        
        
        equalbtn.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
               secondNumber = Double.parseDouble(tfDisplay.getText());
               
               switch(operation){
                   case "+":
                       result = firstNumber + secondNumber;
                       break;
                   case "-":
                       result = firstNumber - secondNumber;
                       break;
                   case "*":
                       result = firstNumber * secondNumber;
                       break;
                   case "/":
                       result = firstNumber / secondNumber;
                       break;
                     
               }
               tfDisplay.setText("" + result);
               taHistory.append(secondNumber + "=" + result +"\n");
            }
        });
    }
    
    
 
           class AuthorFrame extends JFrame{
        
              AuthorFrame(){
                  ImageIcon image = new ImageIcon(getClass().getResource("/calculator1/zalmay1.jpg"));
                  JLabel j2 = new JLabel(image);
                  add(j2);
                  
                  setSize(230, 200);
                  setTitle("Author");
                  setResizable(false);
                  setLocationRelativeTo(null);
                  setVisible(true);
                  
             }
       
        }
    
    class AboutFrame extends JFrame{
        
        AboutFrame(){
            ImageIcon image = new ImageIcon(getClass().getResource("/calculator1/HHu.jpg"));
            JLabel jl = new JLabel(image);
            add(jl);
            
            setSize(230, 200);
            setTitle("About");
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
        }
        
  
    }
    
   
    
    public static void main(String[] args) {
        
        new Calculator1();
        
     
    }
    
}
