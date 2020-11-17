/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.NhanVienDAO;
import utils.DialogHelper;
import entity.NhanVien;
import java.awt.event.KeyEvent;
import javafx.scene.input.KeyCode;
import utils.Auth;
import utils.ImageHelper;


/**
 *
 * @author ADMIN
 */
public class LoginJDialog extends javax.swing.JDialog {

    /**
     * Creates new form LoginJDialog
     */
    public LoginJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }
    NhanVienDAO dao = new NhanVienDAO();

    private void login() {
        String manv = txtUserName.getText();
        String pass = new String(txtPassword.getPassword());
        try {
            NhanVien nhanvien = dao.selectById(manv);
            if (nhanvien != null) {
                if (pass.equals(nhanvien.getMatKhau())) {                   
                    Auth.user = nhanvien;                    
//                    new EdusysJFrame().setVisible(true);
                    this.dispose();
                } else {
                    DialogHelper.alert(this, "Sai mật khẩu!");
                }
            } else {
                DialogHelper.alert(this, "Sai tên đăng nhập");
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    private void exit() {
        if (DialogHelper.confirm(this, "Bạn có muốn thoát khỏi ứng dụng không?")) {
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblImageLogo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblhiddenpass = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 0));

        jPanel2.setBackground(new java.awt.Color(195, 199, 198));

        lblImageLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblImageLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login-now.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(247, 198, 0));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(48, 70, 0), 3, true));

        lblhiddenpass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhiddenpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-show-password-20.png"))); // NOI18N
        lblhiddenpass.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblhiddenpassMouseMoved(evt);
            }
        });
        lblhiddenpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblhiddenpassMouseExited(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.setSelectionColor(new java.awt.Color(48, 70, 0));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUserName.setCaretColor(new java.awt.Color(48, 70, 0));
        txtUserName.setSelectionColor(new java.awt.Color(48, 70, 0));

        lblPassword.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(113, 95, 147));
        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-key-20.png"))); // NOI18N
        lblPassword.setText("Password");

        lblUserName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(113, 95, 147));
        lblUserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-user-20.png"))); // NOI18N
        lblUserName.setText("Username");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addComponent(txtUserName))
                .addGap(18, 18, 18)
                .addComponent(lblhiddenpass, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUserName))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lblhiddenpass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnLogin.setBackground(new java.awt.Color(247, 198, 0));
        btnLogin.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        btnLogin.setText("Sign in");
        btnLogin.setToolTipText("");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblImageLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(lblImageLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblhiddenpassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhiddenpassMouseExited
        // TODO add your handling code here:
        txtPassword.setEchoChar('*');
    }//GEN-LAST:event_lblhiddenpassMouseExited

    private void lblhiddenpassMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhiddenpassMouseMoved
        // TODO add your handling code here:
        txtPassword.setEchoChar((char) 0);
    }//GEN-LAST:event_lblhiddenpassMouseMoved

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        // TODO add your handling code here:
        txtPasswordKeyPressed(evt);
    }//GEN-LAST:event_btnLoginKeyPressed

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
            java.util.logging.Logger.getLogger(LoginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginJDialog dialog = new LoginJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblImageLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblhiddenpass;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);
        this.setTitle("ĐĂNG NHẬP");
        this.setIconImage(ImageHelper.getAppIcon());
    }
}