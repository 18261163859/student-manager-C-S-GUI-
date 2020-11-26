package com.smx.sm.frame;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import com.smx.sm.entity.*;
import com.smx.sm.factory.ServiceFactory;
import com.smx.sm.utils.AliOSSUtil;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author moses
 * @Date 2020/11/26
 **/
public class MainFrame extends  JFrame{
    private int departmentId=1;
    private JPanel mainPanel;
    private JPanel navPanel;
    private JButton 院系管理Button;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JButton 奖惩管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPanel;
    private JPanel leftPanel;
    private JPanel addDepPanel;
    private JTextField depNameField;
    private JButton 选择图片Button;
    private JLabel logoLabel;
    private JPanel toolBarPanel;
    private JButton 新增院系Button;
    private JButton 切换显示Button;
    private JPanel contentPanel;
    private JButton 新建院系Button;
    private JComboBox<Department> depComboBox;
    private JTextField searchField;
    private JButton 新增班级Button;
    private JPanel treePanel;
    private JPanel classContentPanel;

    private String uploadFileUrl;
    private File file;

    private final CardLayout c;

    public MainFrame(){
        init();
        c=new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1",departmentPanel);
        centerPanel.add("2",classPanel);
        centerPanel.add("3",studentPanel);
        centerPanel.add("4",rewardPanel);
        院系管理Button.addActionListener(x->{
            c.show(centerPanel,"1");
        });
        班级管理Button.addActionListener(x->{
            c.show(centerPanel,"2");
            showClazz();
        });
        学生管理Button.addActionListener(x->{
            c.show(centerPanel,"3");
        });
        奖惩管理Button.addActionListener(x->{
            c.show(centerPanel,"4");
        });

        showDepartments();

        新增院系Button.addActionListener(e -> {
            boolean visible = addDepPanel.isVisible();
            if (!visible) {
                leftPanel.setPreferredSize(new Dimension(180, this.getHeight() - 100));
                addDepPanel.setVisible(true);
            } else {
                leftPanel.setPreferredSize(new Dimension(60, this.getHeight() - 100));
                addDepPanel.setVisible(false);
            }
            leftPanel.revalidate();
        });

        depNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                depNameField.setText("");
            }
        });

        选择图片Button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            //默认打开路径
            fileChooser.setCurrentDirectory(new File("/Users/Moses/"));
            //对话框显示的范围在centerPanel内
            int result = fileChooser.showOpenDialog(centerPanel);
            if (result == JFileChooser.APPROVE_OPTION) {
                //选中文件
                file = fileChooser.getSelectedFile();
                String name = file.getAbsolutePath();
                //创建icon对象
                ImageIcon icon = new ImageIcon(name);
                logoLabel.setPreferredSize(new Dimension(150, 150));
                //图片强制缩放成和JLabel一样大小
                icon = new ImageIcon(icon.getImage().getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_AREA_AVERAGING));
                logoLabel.setIcon(icon);
            }
        });

        新建院系Button.addActionListener(e ->{
            //上传文件到OSS并返回url
            uploadFileUrl= AliOSSUtil.ossUpload(file);
            //创建Department对象，并设置相关属性
            Department department=new Department();
            department.setDepartmentName(depNameField.getText().trim());
            department.setLogo(uploadFileUrl);
            //调用service实现新增功能
            int n=ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
            if(n==1){
                JOptionPane.showMessageDialog(centerPanel,"新建院系成功");
                //新增院系成功后将侧边隐藏
                leftPanel.setPreferredSize(new Dimension(68,this.getHeight()-100));
                addDepPanel.setVisible(false);
                //刷新页面数据
                showDepartments();
                //清空文本框
                depNameField.setText("");
                logoLabel.setIcon(null);
            }else {
                JOptionPane.showMessageDialog(centerPanel,"新建院系失败");
            }
        });

        //获得下拉框选中院系的id
        depComboBox.addActionListener(e -> {
            //得到选项中的索引
            int index = depComboBox.getSelectedIndex();
            //按照索引项 出现，就是一个department对象，然后取出其id
            departmentId = depComboBox.getItemAt(index).getId();
        });

        //新增班级
        新增班级Button.addActionListener(e -> {
            Clazz clazz = new Clazz();
            clazz.setDepartmentId(departmentId);
            clazz.setClassName(searchField.getText().trim());
            int n = ServiceFactory.getClazzServiceInstance().addClazz(clazz);
            if (n == 1) {
                JOptionPane.showMessageDialog(centerPanel, "新增班级成功");
                searchField.setText("");
                showClazz();
            } else {
                JOptionPane.showMessageDialog(centerPanel, "新增班级失败");
            }
        });


    }

    private void init() {
        setTitle("MainFrame");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1280, 760);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        MainFrame mainFrame=new MainFrame();

    }

    private void showClazz(){
        List<Department> departments=ServiceFactory.getDepartmentServiceInstance().selectAll();
        showCombobox(departments);
        showTree(departments);
        showClazz(departments);

    }

    private void showClazz(List<Department> departments) {
        classContentPanel.removeAll();
        classContentPanel.setLayout(new GridLayout(0, 5, 15, 15));
        Font titleFont = new Font("微软雅黑", Font.PLAIN, 16);
        for (Department department : departments) {
            JPanel depPanel = new JPanel();
            depPanel.setPreferredSize(new Dimension(120, 150));
            depPanel.setBackground(new Color(63, 98, 131));
            depPanel.setLayout(new BorderLayout());
            JLabel depNameLabel = new JLabel(department.getDepartmentName());
            depNameLabel.setFont(titleFont);
            depNameLabel.setForeground(new Color(255, 255, 255));
            depPanel.add(depNameLabel, BorderLayout.NORTH);
            List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClazzByDepId(department.getId());
            DefaultListModel<Clazz> listModel = new DefaultListModel<>();
            for (Clazz clazz : clazzList) {
                listModel.addElement(clazz);
            }
            JList<Clazz> jList = new JList<>(listModel);
            jList.setBackground(new Color(181, 134, 184));
            JScrollPane scrollPane = new JScrollPane(jList);
            depPanel.add(scrollPane, BorderLayout.CENTER);
            classContentPanel.add(depPanel);

            //对每个Jlist增加弹出菜单
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem modifyItem = new JMenuItem("修改");
            JMenuItem deleteItem = new JMenuItem("删除");
            jPopupMenu.add(modifyItem);
            jPopupMenu.add(deleteItem);
            jList.add(jPopupMenu);
            jList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //选中项对下标
                    int index=jList.getSelectedIndex();
                    //点击鼠标右键
                    if(e.getButton()==3){
                        jPopupMenu.show(jList,e.getX(),e.getY());
                        //取出选中项的班级对象数据
                        Clazz clazz=jList.getModel().getElementAt(index);
                        //对删除菜单增加监听
                        deleteItem.addActionListener(e1->{
                            int choice=JOptionPane.showConfirmDialog(depPanel,"确定删除吗?");
                            //点击了确定
                            if(choice==0){
                                //根据当前班级id删除
                                int n=ServiceFactory.getClazzServiceInstance().deleteClazz(clazz.getId());
                                if(n==1){
                                    //让list数据模型中移除当前项，先从视觉上看到删除效果
                                    listModel.remove(index);
                                    //走后端重新调用下数据
                                    showTree(ServiceFactory.getDepartmentServiceInstance().selectAll());
                                }
                            }
                        });

                    }
                }
            });


        }


    }

    private void showCombobox(List<Department> departments){
        for(Department department:departments){
            depComboBox.addItem(department);
        }
    }
    private void showTree(List<Department> departments){
        treePanel.removeAll();
        //左侧树组件到根节点
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("南京工业职业技术大学");
        for(Department department :departments){
            //院系名称作为一级叶子节点
            DefaultMutableTreeNode group=new DefaultMutableTreeNode(department.getDepartmentName());
            //加入根节点，构成一棵树
            root.add(group);
            List<Clazz> clazzList=ServiceFactory.getClazzServiceInstance().getClazzByDepId(department.getId());
            for(Clazz clazz:clazzList){
                //班级节点加入对应院系节点
                DefaultMutableTreeNode node=new DefaultMutableTreeNode(clazz.getClassName());
                group.add(node);
            }
        }
        //以root为根生成树
        final JTree tree=new JTree(root);
        tree.setRowHeight(30);
        tree.setFont(new Font("微软雅黑",Font.PLAIN,14));
        treePanel.add(tree,BorderLayout.CENTER);
        treePanel.revalidate();
    }

    /**
     *显示所有院系信息
     */
    private void showDepartments(){
        //移除原有数据
        contentPanel.removeAll();
        //从sevice层获取到所有院系列表
        List<Department> departmentList= ServiceFactory.getDepartmentServiceInstance().selectAll();
        //获取总数
        int len=departmentList.size();
        //根据院系总数算出行数(每行放四个)
        int row=len%4==0?len/4:len/4+1;
        //创建一个网格布局,每行4列，指定水平和垂直间距
        GridLayout gridLayout=new GridLayout(row,4,15,15);
        contentPanel.setLayout(gridLayout);
        for(Department department:departmentList){
            //给每个院系对象创建一个面板
            JPanel depPanel=new JPanel();
            //设置合适大小
            depPanel.setPreferredSize(new Dimension(220,298));
            // 将院系名称设置面板标题
            depPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,10));
            //depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            JLabel nameable=new JLabel(department.getDepartmentName());
            //新建一个JLlabel标签，用来放置院系logo，并指定大小
            JLabel logoLabel=new JLabel("<html> <img src= '"+department.getLogo()+"'mode='widthFix'/> <html>");
            //图标标签加入院系面板
            JLabel blankLabel = new JLabel();
            blankLabel.setPreferredSize(new Dimension(200,200));
            JButton delBtn=new JButton("删除");
            depPanel.add(nameable);
            //图标标签加入院系面板
            depPanel.add(logoLabel);
            depPanel.add(delBtn);
            //院系面板加入主体内容面板
            contentPanel.add(depPanel);
            //刷新主体内容面板
            contentPanel.revalidate();
            delBtn.addActionListener(e->{
                String abc=nameable.getText();
                ServiceFactory.getDepartmentServiceInstance().remove(abc);
                showDepartments();
            });
        }

    }


}
