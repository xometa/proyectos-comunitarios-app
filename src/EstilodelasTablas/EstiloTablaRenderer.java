/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstilodelasTablas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Sony
 */
public class EstiloTablaRenderer extends DefaultTableCellRenderer {

    private Component componenete;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.       
        this.setHorizontalAlignment(0);
        this.setBorder(null);
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(26,187,156)));/*color para el border
        de la tabla*/
        if (row % 2 == 0) {
            componenete.setForeground(new Color(26,187,156));/*color de las letras*/
            componenete.setBackground(new Color(255, 255, 255));
        } else {
            componenete.setForeground(new Color(26,187,156));/*color de las letras*/
            componenete.setBackground(new Color(255, 255, 255));
        }
        if (isSelected) {
            componenete.setForeground(Color.white);
            componenete.setBackground(new Color(26,187,156));/*color de seleccion de las filas*/
            componenete.setFont(new Font("Tahoma", Font.BOLD, 14));
        }

        return componenete;

    }

}
