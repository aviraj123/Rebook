package mainPack;


import Entities.Book;
import Entities.User;
import Templates.BookTemplate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mp
 */
public class BranchPage extends javax.swing.JFrame {

    /**
     * Creates new form branchPage
     */
    private String selected_category;
    private String selected_programme;
    private String ip;
    
    private static String[] branches={"Applied Mechanics","Biotechnology","Chemical Engineering","Civil Engineering","Computer Science and Engineering","Electrical Engineering","Electronics and Communiation Engineering","Mechanical Engineering","Others"};    
    private static String[] courses={"BTech","MTech","PhD"};
    private ArrayList<Book> books;
    public User user;
    private ArrayList<String> selectedItems = new ArrayList<>();
    private int selected;
    private ArrayList<Book>selectedBooks=new ArrayList<>();
    
    public BranchPage() {
       
    }
    public BranchPage(int selected,User user1) throws IOException
    {
        initComponents();
        DefaultListModel dm= new DefaultListModel(); 
        for(int i=0;i<branches.length;i++)
        dm.addElement(branches[i]);
        if(user1!=null)
            login_signup_button.setText(user1.getName());
       this.user=user1;
       this.selected=selected;
      
        category_list.setModel(dm);
        category_list.setSelectedIndex(selected);

          
//         jList2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        prog_list.setVisibleRowCount(1);  

        selected_category=branches[selected].toString();
         
        DefaultListModel dm2= new DefaultListModel();
        dm2.clear();
        for(int i=0;i<courses.length;i++)
          dm2.addElement(courses[i]);

        prog_list.setModel(dm2);
        prog_list.setSelectedIndex(0);
        selected_programme=courses[0].toString();
        prog_list.addListSelectionListener(new ListSelectionListener() {
              @Override
              public void valueChanged(ListSelectionEvent e) {
                  if(!e.getValueIsAdjusting()){
//                      selected_category=category_list.getSelectedValuesList().toString();
                      selected_programme=prog_list.getSelectedValue().toString();
                      try {
                          //String values=prog_list.getSelectedValuesList()+" "+category_list.getSelectedValuesList();
                          //values=selected_branch+" "+selected_course;
                          //System.out.println(values);
                          loadBooks();
                      } catch (IOException ex) {
                          Logger.getLogger(BranchPage.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              }
          });
        category_list.addListSelectionListener(new ListSelectionListener() {
              @Override
              public void valueChanged(ListSelectionEvent e) {
                  if(!e.getValueIsAdjusting()){
                      prog_list.setSelectedIndex(0);
                      selected_category=category_list.getSelectedValue().toString();
                      selected_programme=prog_list.getSelectedValue().toString();
//                      System.out.println(selected_category+" "+selected_programme);
                      try {
                          //String values=prog_list.getSelectedValuesList()+" "+category_list.getSelectedValuesList();
                          //System.out.println(values);
                          loadBooks();
                          
                      } catch (IOException ex) {
                          Logger.getLogger(BranchPage.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              }
          });
        loadBooks();
    }  
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        category_list = new javax.swing.JList<String>();
        jScrollPane2 = new javax.swing.JScrollPane();
        prog_list = new javax.swing.JList<String>();
        toHomePage_button = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        book_list = new javax.swing.JList();
        sell = new javax.swing.JButton();
        login_signup_button = new javax.swing.JButton();
        cart = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        category_list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        category_list.setPreferredSize(new java.awt.Dimension(100, 250));
        jScrollPane1.setViewportView(category_list);

        prog_list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        prog_list.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jScrollPane2.setViewportView(prog_list);

        toHomePage_button.setText("Back to HomePage");
        toHomePage_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toHomePage_buttonActionPerformed(evt);
            }
        });

        book_list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(book_list);

        sell.setText("Sell Book");
        sell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellActionPerformed(evt);
            }
        });

        login_signup_button.setText("Login/SignUp");
        login_signup_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_signup_buttonActionPerformed(evt);
            }
        });

        cart.setText("Proceed To Cart");
        cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(toHomePage_button)
                        .addGap(104, 104, 104)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(login_signup_button))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cart)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(sell)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toHomePage_button)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_signup_button, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cart)
                        .addGap(26, 26, 26)
                        .addComponent(sell)))
                .addGap(25, 85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toHomePage_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toHomePage_buttonActionPerformed
        // TODO add your handling code here:
        if(user!=null)
            new HomePage(user).setVisible(true);
        else
            new HomePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_toHomePage_buttonActionPerformed

    private void sellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellActionPerformed
        // TODO add your handling code here:
        if(login_signup_button.getText()=="Login/SignUp")
        {
            JOptionPane.showMessageDialog(null, "Login First",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            new AddBook(selected_category,selected_programme,user).setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_sellActionPerformed

    private void login_signup_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_signup_buttonActionPerformed
        // TODO add your handling code here:
        if(login_signup_button.getText()=="Login/SignUp"){
            new LoginPage().setVisible(true);
            this.setVisible(false);
        }
        else{
            new UserProfile(user).setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_login_signup_buttonActionPerformed

    private void cartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartActionPerformed
        // TODO add your handling code here:
        if(user==null)
        {
          JOptionPane.showMessageDialog(null, "Login First",
                "Error", JOptionPane.ERROR_MESSAGE);
          new LoginPage().setVisible(true);
            this.setVisible(false);
//            System.exit(0);
          
        }
        else{
            if (selectedItems.size() == 0) {
                new KartPage(user, ip).setVisible(true);
                this.setVisible(false);
            } else {
                String[] buttons = {"Yes", "No"};
                int returnValue = JOptionPane.showOptionDialog(null, "Are you sure?", "Select books will be added to your cart!",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        buttons,
                        buttons[0]);
                // Database se delete krna hai aur
                System.out.println("Selected value is " + buttons[returnValue]);
                if (returnValue == 0) {
                    try {
                        ServerConnection conn = ServerConnection.getInstance(ip);
                        conn.addToCart(user, selectedBooks);
                        new KartPage(user, ip).setVisible(true);
                        this.setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(BranchPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        new BranchPage(selected, user).setVisible(true);
                        this.setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(BranchPage.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }
    }//GEN-LAST:event_cartActionPerformed
    
   
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BranchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BranchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BranchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BranchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BranchPage().setVisible(true);
               
                
                
            }
        });
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList book_list;
    private javax.swing.JButton cart;
    private javax.swing.JList<String> category_list;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton login_signup_button;
    private javax.swing.JList<String> prog_list;
    private javax.swing.JButton sell;
    private javax.swing.JButton toHomePage_button;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Book> getBooks() throws IOException, ClassNotFoundException {
    
        //Set books from the Database using Selected Programme and Category;
        ServerConnection conn=ServerConnection.getInstance("192.168.0.7");
        System.out.println(selected_category+" "+ selected_programme);
        return conn.getList(selected_category, selected_programme);
    }

    private void populateBookList(ArrayList<Book> books) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        
        DefaultListModel<Book> dlm = new DefaultListModel<Book>(){
            {
//                Iterator it=books.iterator();
//                while(it.hasNext())
//                    addElement((Book)it.next());
                if(books.size()!=0)
                    for(Book book:books)
                        addElement(book);
                
                
//                addElement(new Book("isbn","name",150,"date",2,"supplierId",selected_category,selected_programme,2018,null,null,null));
//                addElement(new Book("dsfsfs","ffdsf",100,"dfsds",151,"supplierId",selected_category,selected_programme,2018,null,null,null));
//                addElement(new Book("dfgfdgg","vfv",201,"sacvcxdasd",551,"supplierId",selected_category,selected_programme,2018,null,null,null));
            }  
        };
        
        
        book_list.setModel(dlm);
        book_list.setCellRenderer(new BookTemplate());
        book_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        book_list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    int index=book_list.getSelectedIndex();
                    System.out.println(index+" is Clicked");
                    
                    for(int i = 0;i<selectedItems.size();++i){
                            System.out.print(selectedItems.get(i)+" ");
                        }
                    System.out.println();

                    if(!selectedItems.contains(index+""))
                        selectedItems.add(book_list.getSelectedIndex()+"");
                    else{
                        selectedItems.remove(index+"");
                        System.out.println("Index Removed  "+index);
                    }

                    int size = selectedItems.size();
                    System.out.println("List: ");
                    for(int i = 0;i<selectedItems.size();++i){
                            System.out.print(selectedItems.get(i)+" ");
                        }
                    System.out.println();
                    
                    int select[];
                    select=null;
                    if(size == 0){
                        System.out.println("Empty");
                        select = null;
                    }else{
                    
                     select = new int[selectedItems.size()];

                        for(int i = 0;i<size;++i){
                            select[i] = Integer.parseInt(selectedItems.get(i));
                            selectedBooks.add(books.get(Integer.parseInt(selectedItems.get(i))));
                        }

                }
                    book_list.removeListSelectionListener(this);
                    book_list.setSelectedIndices(select);
                    book_list.addListSelectionListener(this);
            }
        } 
        });
    }
    
    private void loadBooks() throws IOException{
        try{
            books = getBooks();
        }catch(Exception e){
            ;//Error getting books from the Database
        }
        
        
        //Populate the book_list using the Books received
        
        populateBookList(books);
    }
    
}
