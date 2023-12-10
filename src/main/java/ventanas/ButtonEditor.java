package ventanas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import controlador.Controlador;

public class ButtonEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JButton botonEditar;
    private JButton botonBorrar;
    private JTable tabla;
    private Controlador controlador;
    private JFrame ventanaAnadirEditarContacto;

    public ButtonEditor(JTable tabla, Controlador controlador, JFrame ventanaAnadirEditarContacto) {
        
        this.tabla = tabla;
        this.controlador = controlador;
        this.ventanaAnadirEditarContacto = ventanaAnadirEditarContacto;

        this.botonEditar = new JButton("Editar");
        this.botonEditar.addActionListener(this);

        this.botonBorrar = new JButton("Borrar");
        this.botonBorrar.addActionListener(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (column == 4) {
            return botonEditar;
        } else if (column == 5) {
            return botonBorrar;
        }
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (column == 4) {
            return botonEditar;
        } else if (column == 5) {
            return botonBorrar;
        }
        return null;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonEditar) {
            int filaSeleccionada = tabla.getSelectedRow();
            String numero = tabla.getValueAt(filaSeleccionada, 3).toString();
            new VentanaAnadirEditarContacto(numero, controlador, this.ventanaAnadirEditarContacto);
        } else if (e.getSource() == botonBorrar) {
            int filaSeleccionada = tabla.getSelectedRow();
            String numero = tabla.getValueAt(filaSeleccionada, 3).toString();
            new VentanaConfirmacionBorrado(numero, controlador, this.ventanaAnadirEditarContacto); // Abre la ventana de confirmación de borrado
        }
    }
}
