package ca.etsmtl.log240.financej;
/*
 * AccountDialog.java
 *
 * Created on March 5, 2008, 11:08 PM
 */

import java.sql.*;
import javax.swing.table.*;
import javax.swing.*;

/**
 *
 * @author  rovitotv
 */
public class AccountDialog extends javax.swing.JDialog {

	private AccountTableModel dataModel;

	/** Creates new form Account */
	public AccountDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		AccountListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public void SetDBConnection(Connection DBConn) {
		dataModel = new AccountTableModel(DBConn);
		AccountListTable.setModel(dataModel);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		JButton closeButton = new JButton();
		JScrollPane jScrollPane1 = new JScrollPane();
		AccountListTable = new javax.swing.JTable();
		JButton deleteAccountButton = new JButton();
		JPanel jPanel1 = new JPanel();
		JButton addAccountButton = new JButton();
		NameTextField = new javax.swing.JTextField();
		NameTextField.setName("NAME_TEXT_FIELD"); //TEST AUTOMATISES
		DescriptionTextField = new javax.swing.JTextField();
		DescriptionTextField.setName("DESCRIPTION_TEXT_FIELD");// TEST AUTOMATISES
		jLabel1 = new javax.swing.JLabel();
		JLabel jLabel2 = new JLabel();

		setTitle("Accounts");
		setModal(true);
		setName("AccountDialog"); // NOI18N

		closeButton.setText("Close");
		closeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CloseButtonActionPerformed();
			}
		});

		AccountListTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
						{null, null}
				},
				new String [] {
						"Name", "Description"
				}
		) {
			Class[] types = new Class [] {
					java.lang.String.class, java.lang.String.class
			};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}
		});
		jScrollPane1.setViewportView(AccountListTable);
		AccountListTable.getColumnModel().getColumn(0).setPreferredWidth(25);

		deleteAccountButton.setText("Delete Account");
		deleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteAccountButtonActionPerformed();
			}
		});

		addAccountButton.setText("Add Account");
		addAccountButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddAccountButtonActionPerformed();
			}
		});

		jLabel1.setText("Name:");

		jLabel2.setText("Description:");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(addAccountButton))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGap(117, 117, 117)
												.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel1)
														.addComponent(jLabel2))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(NameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
																.addComponent(DescriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))))
																.addGap(24, 24, 24))
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel1)
								.addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(DescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(addAccountButton)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
						.addContainerGap())
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(279, Short.MAX_VALUE)
								.addComponent(deleteAccountButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(closeButton)
								.addGap(31, 31, 31))
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(deleteAccountButton)
								.addComponent(closeButton))
								.addContainerGap())
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents
	private void CloseButtonActionPerformed() {//GEN-FIRST:event_CloseButtonActionPerformed
		setVisible(false);
	}//GEN-LAST:event_CloseButtonActionPerformed

	private void DeleteAccountButtonActionPerformed() {//GEN-FIRST:event_DeleteAccountButtonActionPerformed
		if (AccountListTable.getSelectionModel().getLeadSelectionIndex() >= 0) {
			System.out.println("delete row:" + AccountListTable.getSelectionModel().getLeadSelectionIndex());
			dataModel.DeleteAccount(AccountListTable.getSelectionModel().getLeadSelectionIndex());
		} else { //nothing selected give error messge
			JOptionPane.showMessageDialog(this,
					"No account selected to delete, please select an account then click the delete button.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_DeleteAccountButtonActionPerformed

	private void AddAccountButtonActionPerformed() {//GEN-FIRST:event_AddAccountButtonActionPerformed
		int ReturnCode;

//************** ken
//		public class Test {
//			public static void main (String [] args) {
//				String regExpression = "[a-zA-Z_0-9]*";
//				String sample = "abcde";
//
//				boolean b = sample.matches(regExpression);
//
//				System.out.println (b);
//			}
//		}
		String regExpression = "[a-zA-Z_0-9]*";
		String nom=NameTextField.getText();
		String desc=DescriptionTextField.getText();
		boolean entreesValides=true;

		//verifier si les valeurs entrer c'est des valeurs alphanumerique
		//taille nom superieur ou egale 3
		if(nom.length()<=3){
			entreesValides=false;
			JOptionPane.showMessageDialog(this,
					"nom valide est un de valeur alphanumerique et contient au mois 3 caracteres ",
					"Error", JOptionPane.ERROR_MESSAGE);

		}
		//taille description superieur ou egale 5
		if(desc.length()<=5){
			entreesValides=false;
			JOptionPane.showMessageDialog(this,
					"Description valide: alphanumerique et contient au mois 5 caracteres ",
					"Error", JOptionPane.ERROR_MESSAGE);

		}
		//valeur alphanumerique
		if(!nom.matches(regExpression) || !desc.matches(regExpression) ){
			entreesValides=false;
			JOptionPane.showMessageDialog(this,
					"le nom et description doivent etre des valeurs alphanumerique",
					"Error", JOptionPane.ERROR_MESSAGE);


		}
		//ajouter le compte si les valeurs d'entreés sont valide
		if(entreesValides){
				ReturnCode = dataModel.AddAccount(NameTextField.getText(), DescriptionTextField.getText());
				if (ReturnCode == 0) {
					NameTextField.setText("");
					DescriptionTextField.setText("");
				} else {
					JOptionPane.showMessageDialog(this,
							"Error Adding account to database.  Make sure the account name you specified does not already exist.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

	}//GEN-LAST:event_AddAccountButtonActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				AccountDialog dialog = new AccountDialog(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {

					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTable AccountListTable;
	private javax.swing.JTextField DescriptionTextField;
	private javax.swing.JTextField NameTextField;
	private javax.swing.JLabel jLabel1;
	// End of variables declaration//GEN-END:variables
}
