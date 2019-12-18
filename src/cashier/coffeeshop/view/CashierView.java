/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashier.coffeeshop.view;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import cashier.coffeeshop.controller.CashierController;
import cashier.coffeeshop.model.CashierModel;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author muchlas
 */
public class CashierView extends JFrame {

    private JLabel label;
    private JLabel productId;
    private JLabel productName;
    private JLabel productPrice;
    private JLabel productQty;
    private JLabel totalSales;
    private JLabel validationNotif;
    private JTextField prId;
    private JTextField prNm;
    private JTextField prPrice;
    private JTextField prQty;
    private JTextField toS;
    private JButton btnClear;
    private JButton btnPrint;
    private JButton btnAdd;
    private JButton btnBuy;
    private JTable cashTable;
    private JScrollPane pane;

    public CashierView() {
        JPanel mainPanel = new JPanel();

        label = new JLabel("Coffee Shop Cashier");
        productId = new JLabel("Product ID");
        productName = new JLabel("Product Name");
        productPrice = new JLabel("Price");
        productQty = new JLabel("Quantity");
        totalSales = new JLabel("Total Sales");
        validationNotif = new JLabel();

        prId = new JTextField();
        prNm = new JTextField();
        prPrice = new JTextField();
        prQty = new JTextField();
        toS = new JTextField();

        btnClear = new JButton("Clear Field");
        btnPrint = new JButton("Print Struct");
        btnAdd = new JButton("Add New Product");
        btnBuy = new JButton("Buy Product");

        cashTable = new JTable();
        Object[] columns = {"ID", "Name", "Price", "Stock"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);

        // Set the model to table
        cashTable.setModel(tableModel);

        // Create ScrollPane
        pane = new JScrollPane(cashTable);
        pane.setBounds(10, 100, 620, 150);

        // Set Label 
        label.setBounds(240, 30, 500, 40);
        label.setFont(new Font("Ubuntu", Font.BOLD, 20));

        productId.setBounds(10, 350, 200, 14);
        productId.setFont(new Font("FreeSans", Font.BOLD, 14));

        productName.setBounds(10, 400, 200, 14);
        productName.setFont(new Font("FreeSans", Font.BOLD, 14));

        productPrice.setBounds(10, 450, 200, 14);
        productPrice.setFont(new Font("FreeSans", Font.BOLD, 14));

        productQty.setBounds(380, 350, 200, 14);
        productQty.setFont(new Font("FreeSans", Font.BOLD, 14));

        totalSales.setBounds(380, 400, 200, 14);
        totalSales.setFont(new Font("FreeSans", Font.BOLD, 14));

        validationNotif.setBounds(100, 345, 250, 25);
        validationNotif.setFont(new Font("FreeSans", Font.PLAIN, 11));
        validationNotif.setForeground(Color.red);

        // Set TextField
        prId.setBounds(10, 370, 250, 25);
        prId.setFont(new Font("FreeSans", Font.PLAIN, 13));
        prId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    int field = Integer.parseInt(prId.getText());
                    validationNotif.setText("");
                } catch (NumberFormatException ex) {
                    validationNotif.setText("Inputan harus angka!");
                }
            }
        });

        prNm.setBounds(10, 420, 250, 25);
        prNm.setFont(new Font("FreeSans", Font.PLAIN, 13));

        prPrice.setBounds(10, 470, 250, 25);
        prPrice.setFont(new Font("FreeSans", Font.PLAIN, 13));

        prQty.setBounds(380, 370, 250, 25);
        prQty.setFont(new Font("FreeSans", Font.PLAIN, 13));

        toS.setBounds(380, 420, 250, 25);
        toS.setFont(new Font("FreeSans", Font.PLAIN, 13));
        toS.setEditable(false);

        // Set Button
        btnClear.setBounds(10, 550, 200, 30);
        btnClear.setFont(new Font("FreeSans", Font.BOLD, 14));
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                prId.setText("");
                prNm.setText("");
                prPrice.setText("");
                prQty.setText("");
            }
        });

        btnPrint.setBounds(225, 550, 200, 30);
        btnPrint.setFont(new Font("FreeSans", Font.BOLD, 14));
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "\nProduct Id\t: " + prId.getText()
                        + "\nProduct Name\t: " + prNm.getText()
                        + "\nPrice\t: " + prPrice.getText() 
                        + "\nQuantity\t: " + prQty.getText() 
                        + "\nTotal Harga\t: " + toS.getText(), "Struct Detail", JOptionPane.PLAIN_MESSAGE);
            }
        });

        btnAdd.setBounds(440, 550, 190, 30);
        btnAdd.setFont(new Font("FreeSans", Font.BOLD, 14));
        Object[] row = new Object[4];
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                row[0] = prId.getText();
                row[1] = prNm.getText();
                row[2] = prPrice.getText();
                row[3] = prQty.getText();

                tableModel.addRow(row);
            }
        });

        cashTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = cashTable.getSelectedRow();

                prId.setText(tableModel.getValueAt(i, 0).toString());
                prId.setEditable(false);
                prNm.setText(tableModel.getValueAt(i, 1).toString());
                prNm.setEditable(false);
                prPrice.setText(tableModel.getValueAt(i, 2).toString());
                prPrice.setEditable(false);
                prQty.setText("");
                toS.setEditable(true);

            }
        });

        btnBuy.setBounds(440, 500, 190, 30);
        btnBuy.setFont(new Font("FreeSans", Font.BOLD, 14));
        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = cashTable.getSelectedRow();

                if (i > 0) {
                    int toSAmount = Integer.parseInt(prQty.getText()) * Integer.parseInt(prPrice.getText());
                    toS.setText(String.valueOf(toSAmount));
                    int qtyUp = Integer.parseInt((String) tableModel.getValueAt(i, 3)) - Integer.parseInt(prQty.getText());
                    tableModel.setValueAt(String.valueOf(qtyUp), i, 3);
                } else {
                    System.out.println("Belum ada data!");
                }

            }
        });
        

        mainPanel.setLayout(null);
        this.setTitle("Coffee Shop Cashier");
        this.setSize(650, 630);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.add(label);
        mainPanel.add(pane);
        mainPanel.add(productId);
        mainPanel.add(prId);
        mainPanel.add(productName);
        mainPanel.add(prNm);
        mainPanel.add(productPrice);
        mainPanel.add(prPrice);
        mainPanel.add(productQty);
        mainPanel.add(prQty);
        mainPanel.add(totalSales);
        mainPanel.add(toS);
        mainPanel.add(btnClear);
        mainPanel.add(btnPrint);
        mainPanel.add(btnAdd);
        mainPanel.add(btnBuy);
        mainPanel.add(validationNotif);

        this.add(mainPanel);

    }
}
