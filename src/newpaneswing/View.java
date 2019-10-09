package newpaneswing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import net.iharder.dnd.FileDrop;

public class View extends JFrame {
    Integer k = 0;
    JFrame f;
    JTabbedPane tp;
    JPanel jp;
    Integer count = 0;
    JLabel lab;
    
    View(){
        
        f = new JFrame();
        tp = new JTabbedPane(JTabbedPane.LEFT);
        tp.setSize(500, 500);
        
        jp = new JPanel();
        JButton bb = new JButton("Add Tab");
        bb.setPreferredSize(new Dimension(75, 50));
        bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTab();
            }
        });
        
        tp.add("New Flight", jp);
        tp.setTabComponentAt(0, bb);
        f.add(tp);  
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);   
    }
    
    public void newTab(){

        jp = new JPanel();
        
        String[] list = {"bla", "foo", "bar", "fooBar"};
        JComboBox comboBox = new JComboBox(list);
        jp.add(comboBox);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tp.setTitleAt(tp.getSelectedIndex(), comboBox.getSelectedItem().toString());
            }
        });
        new  FileDrop( jp, new FileDrop.Listener(){   
            public void  filesDropped( java.io.File[] files ) {   
                  for(File file : files){
                      System.out.println(file.toString());
                  }
              }
          });
        
        tp.addTab("New Flight", jp);
    }
}