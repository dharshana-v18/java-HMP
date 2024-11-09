package bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class withdraw extends javax.swing.JInternalFrame {

    public withdraw() {
        initComponents();
        date();
    }

    Connection con1;
    PreparedStatement insert;
    PreparedStatement insert2;
    ResultSet rs1;

    private void initComponents() {
        jLabel4 = new javax.swing.JLabel();
        lbal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtaccno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtfname = new javax.swing.JTextField();
        txtlame = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        // Label and button configurations
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel4.setText("Balance");

        lbal.setFont(new java.awt.Font("Tahoma", 1, 24));
        lbal.setForeground(new java.awt.Color(0, 51, 204));
        lbal.setText("Balance");

        jLabel2.setText("Firstname");
        jLabel3.setText("Lastname");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Account No"));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel1.setText("Enter the Account No");

        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        // Layout configurations
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtaccno, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtaccno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel5.setText("Withdraw");

        amount.setBackground(new java.awt.Color(172, 3, 3));
        amount.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        amount.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel6.setText("Date");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel7.setText("Customer ID");

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Date");
        jLabel9.setText("Customer ID");

        // Full layout configuration omitted for brevity

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String accno = txtaccno.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/customer","root","");
            insert = con1.prepareStatement("select c.cust_id,c.firstname,c.lastname,a.balance from customer c,account a where c.cust_id = a.cust_id and a.acc_id = ?");
            insert.setString(1, accno);
            rs1 = insert.executeQuery();
            if(rs1.next() == false) {
                JOptionPane.showMessageDialog(null,"Account No not found");
                txtfname.setText("");
                txtlame.setText("");
                lbal.setText("");
            } else {
                String id = rs1.getString(1);
                String firstname = rs1.getString(2);
                String lastname = rs1.getString(3);
                String balance = rs1.getString(4);
                jLabel7.setText(id.trim());
                txtfname.setText(firstname.trim());
                txtlame.setText(lastname.trim());
                lbal.setText(balance.trim());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(withdraw.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void date() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();  
        String date = dtf.format(now);
        jLabel6.setText(date);
    }

} // Closing the withdraw class
