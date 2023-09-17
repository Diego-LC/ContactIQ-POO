import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ContactIQ {
    private ArrayList<String> contactos = new ArrayList<>();
    private ArrayList<String> favoritos = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContactIQ app = new ContactIQ();
            app.iniciarApp();
        });
    }

    private void iniciarApp() {
        crearInterfazUsuario();
    }

    private void crearInterfazUsuario() {
        JFrame frame = new JFrame("ContactIQ");
        configurarVentanaPrincipal(frame);
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        agregarBotones(panel);
        frame.add(panel);
        frame.setVisible(true);
    }

    private void configurarVentanaPrincipal(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
    }

    private void agregarBotones(JPanel panel) {
        String[] buttonLabels = {
                "Ver Lista de Contactos",
                "Añadir Contacto",
                "Contactos Favoritos",
                "Configuración",
                "Ayuda",
                "Salir"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            panel.add(button);
            button.addActionListener(this::manejarAccionBoton);
        }
    }

    private void manejarAccionBoton(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "Ver Lista de Contactos":
                manejarVerListaContactos();
                break;
            case "Añadir Contacto":
                manejarAgregarContacto();
                break;
            case "Contactos Favoritos":
                manejarMostrarFavoritos();
                break;
            case "Configuración":
                manejarEditarPerfil();
                break;
            case "Ayuda":
                manejarMostrarAyuda();
                break;
            case "Salir":
                manejarSalir();
                break;
        }
    }

    private void manejarVerListaContactos() {
        JTextArea listaContactosTextArea = crearListaContactosTextArea();
        JScrollPane scrollPane = new JScrollPane(listaContactosTextArea);
        mostrarVentanaEmergente(scrollPane, "Lista de Contactos");
    }

    private JTextArea crearListaContactosTextArea() {
        JTextArea listaContactosTextArea = new JTextArea();
        listaContactosTextArea.setEditable(false);

        for (int i = 0; i < contactos.size(); i++) {
            listaContactosTextArea.append((i + 1) + ". " + contactos.get(i) + "\n");
        }

        return listaContactosTextArea;
    }

    private void manejarAgregarContacto() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del contacto:");

        if (nombre != null && !nombre.isEmpty()) {
            contactos.add(nombre);
            preguntarAgregarFavorito(nombre);
            JOptionPane.showMessageDialog(null, "Contacto agregado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de contacto no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void preguntarAgregarFavorito(String nombre) {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar este contacto a favoritos?", "Agregar a Favoritos", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            agregarFavorito(nombre);
        }
    }

    private void agregarFavorito(String nombre) {
        favoritos.add(nombre);
    }

    private void manejarMostrarFavoritos() {
        JTextArea favoritosTextArea = crearFavoritosTextArea();
        JScrollPane scrollPane = new JScrollPane(favoritosTextArea);
        mostrarVentanaEmergente(scrollPane, "Contactos Favoritos");
    }

    private JTextArea crearFavoritosTextArea() {
        JTextArea favoritosTextArea = new JTextArea();
        favoritosTextArea.setEditable(false);

        for (String favorito : favoritos) {
            favoritosTextArea.append(favorito + "\n");
        }

        return favoritosTextArea;
    }

    private void manejarEditarPerfil() {
        String nuevoNombre = JOptionPane.showInputDialog(null, "Nuevo nombre:");
        String nuevoCorreo = JOptionPane.showInputDialog(null, "Nuevo correo:");

        if (nuevoNombre != null && nuevoCorreo != null) {
            JOptionPane.showMessageDialog(null, "Perfil actualizado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos no válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void manejarMostrarAyuda() {
        JOptionPane.showMessageDialog(null, "** Ayuda **\nProporciona información y asistencia sobre el uso de la aplicación.", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }

    private void manejarSalir() {
        System.exit(0);
    }

    private void mostrarVentanaEmergente(Component component, String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(component, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(null, panel, title, JOptionPane.PLAIN_MESSAGE);
    }
}
