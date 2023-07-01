package emailvalidation;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class EmailVal extends javax.swing.JFrame {

    public EmailVal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubmit = new javax.swing.JButton();
        lblEnterEmail = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lblmessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(153, 0, 153));
        btnSubmit.setText(" Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblEnterEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEnterEmail.setText("Enter Email");

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtemailKeyPressed(evt);
            }
        });

        lblmessage.setBackground(new java.awt.Color(153, 255, 255));
        lblmessage.setText("Message");
        lblmessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnSubmit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblEnterEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(lblmessage, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblmessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnterEmail)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
       String email = txtemail.getText();
        for (int j = 0; j < email.length() - 1; j++) {
            char ch = email.charAt(j);
            if (ch == ' ') {
                lblmessage.setText(" ");
                JOptionPane.showMessageDialog(rootPane, "Space is in Entrees");
                txtemail.requestFocusInWindow();
                return;
            }
        }
        boolean validate = valideateEmail(email);
     
        if (validate) {
            lblmessage.setOpaque(true);
            lblmessage.setBackground(Color.red);
            lblmessage.setFont(new Font("Verdana", Font.PLAIN, 18));
            lblmessage.setText("Email is Valid");
        } else {
            lblmessage.setText(" ");
            JOptionPane.showMessageDialog(rootPane, "Not a Valide email address");
        }
       
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyPressed

        if (evt.getKeyChar()==KeyEvent.VK_ENTER){
           String email = txtemail.getText();
        for (int j = 0; j < email.length() - 1; j++) {
            char ch = email.charAt(j);
            if (ch == ' ') {
                lblmessage.setText(" ");
                JOptionPane.showMessageDialog(rootPane, "Space is in Entrees");
               
                txtemail.requestFocusInWindow();
                return;
            }
        } 
        
        boolean validate=valideateEmail(email);
        if (validate) {
            lblmessage.setOpaque(true);
            lblmessage.setBackground(Color.red);
            lblmessage.setFont(new Font("Verdana", Font.PLAIN, 18));
            lblmessage.setText("Email is Valid");
        } else {
            lblmessage.setText(" ");
            JOptionPane.showMessageDialog(rootPane, "Not a Valide email address");
        }
        
        }//if evt
    
    }//GEN-LAST:event_txtemailKeyPressed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

//Function to validate Email
    boolean valideateEmail(String str){
      String email=str;
        boolean validate = false;
        String domain = "";
        System.out.println(" Email is : " + email);
        for (int i = 0; i < email.length(); i++) {
            char onechar = email.charAt(i);
            if (onechar == '@') {
                
                for (int x = 0; x < email.length(); x++) {
                    char onechar1 = email.charAt(x);
                    if (onechar1 == '.') {
                        
                        for (int k = x + 1; k < email.length(); k++) {
                            domain = domain + email.charAt(k);
                        }
                        if (domain.equals("info") || domain.equals("com")
                                || domain.equals("net")) {
                            
                            validate = true;
                        }
                    }
                }

            }

        }
        return validate;
}// End Function
   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmailVal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblEnterEmail;
    private javax.swing.JLabel lblmessage;
    private javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables
}
