import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MDICadastro {

    public static void main(String[] args) {
        JFrame window = new JFrame();

        JMenuBar bar = new JMenuBar();
        JMenu addRegister = new JMenu("Cadastro");
        JMenu addEdit = new JMenu("Edit");
        JMenu addHelp = new JMenu("Help");
        JMenuItem cadClient = new JMenuItem("Cliente");
        JMenuItem cadProduct = new JMenuItem("Produto");
        JMenuItem cadSupplier = new JMenuItem("Fornecedor");
        JMenuItem exit = new JMenuItem("Exit");

        window.setSize(400, 500);

        bar.add(addRegister);
        bar.add(addEdit);
        bar.add(addHelp);

        addRegister.add(cadClient);
        addRegister.add(cadProduct);
        addRegister.add(cadSupplier);
        addRegister.add(exit);

        cadClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame client = new JFrame("Cadastro de cliente");
                JLabel message = new JLabel();
                message.setText("Cliente cadastrado com sucesso!");
                client.add(message);
                client.setSize(400, 500);
                client.setVisible(true);
            }
        });

        cadProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Product = new JFrame("Cadastro de produtos");
                JLabel message = new JLabel();
                message.setText("Produto cadastrado com sucesso!");
                Product.add(message);
                Product.setSize(400, 500);
                Product.setVisible(true);
            }
        });

        cadSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame supplier = new JFrame("Cadastro de fornecedor");
                JLabel message = new JLabel();
                message.setText("Forncedor cadastrado com sucesso!");
                supplier.add(message);
                supplier.setSize(400, 500);
                supplier.setVisible(true);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });

        window.setJMenuBar(bar);

        window.setVisible(true);
    }
}
