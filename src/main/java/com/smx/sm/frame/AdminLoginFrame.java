package com.smx.sm.frame;

import com.smx.sm.factory.ServiceFactory;
import com.smx.sm.utils.ResultEntity;

import javax.swing.*;

/**
 * @ClassName AdminLoginFrame
 * @Description TODO
 * @Author moses
 * @Date 2020/11/26
 **/
public class AdminLoginFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton resetBtn;

    public AdminLoginFrame(){
        init();

        loginBtn.addActionListener(e ->{
            //获得输入的账号和密码，注意密码框组件的使用方法
            String account = accountField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account,
                    password);
            JOptionPane.showMessageDialog(mainPanel,resultEntity.getMessage());
            if(resultEntity.getCode()==0){
                //关闭登录界面，进入主界面
                this.dispose();
                new MainFrame();
            }else{
                accountField.setText("");
                passwordField.setText("");
            }
        });

        resetBtn.addActionListener(e->{
            accountField.setText("");
            passwordField.setText("");
        });
    }

    private void init() {
        setTitle("AdminLoginFrame");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1280, 960);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        AdminLoginFrame adminLoginFrame = new AdminLoginFrame();

    }


}
