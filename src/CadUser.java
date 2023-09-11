import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CadUser {
    public static void main(String[] args) {
        //Janela
        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setLayout(null);

        //Painel
        JPanel panel = new JPanel();
        panel.setSize(500, 300);

        //label e input name
        JLabel name = new JLabel();
        name.setText("Nome: ");

        Dimension sized = new Dimension(60, 20);
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(sized);

        //label e input phone
        JLabel phone = new JLabel();
        phone.setText("Telefone: ");

        JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(sized);

        //label e input email
        JLabel email = new JLabel();
        email.setText("Email: ");

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(sized);

        //label e input salary
        JLabel salary = new JLabel();
        salary.setText("Salário: ");

        JTextField salaryField = new JTextField();
        salaryField.setPreferredSize(sized);

        //Adiciona os botões
        JButton register = new JButton("Gravar");
        JButton show = new JButton("Mostrar");

        //evento de gravar o arquivo
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getName = nameField.getText();
                String getEmail = emailField.getText();
                String getPhone = phoneField.getText();
                String getSalary = salaryField.getText();

                String[] info = {"nome: " + getName,"email: " + getEmail,
                        "Telefone: " + getPhone, "Salário: " + getSalary};
                try {
                    File clientReader = new File("client");

                    if(clientReader.length() == 0){
                        // Cria um FileWriter para o arquivo
                        FileWriter clientWriter = new FileWriter("client");

                        // Escreve o texto no arquivo
                        clientWriter.write(Arrays.toString(info));

                        clientWriter.close();

                        System.out.println("Texto gravado com sucesso no arquivo " + "client");
                    } else {
                        FileWriter clientWriter = new FileWriter("client", true);

                        clientWriter.write(Arrays.toString(info));
                        clientWriter.close();

                        System.out.println("adicionado com sucesso!");
                    }
                } catch (IOException ex) {
                    System.err.println("Erro ao gravar no arquivo: " + ex.getMessage());
                }
            }
        });

        //evento de mostrar o arquivo
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader clientReader = new FileReader("client");

                    int caractere;
                    StringBuilder fullText = new StringBuilder();

                    while ((caractere = clientReader.read()) != -1) {
                        // Converte o caractere lido em char e o exibe na tela
                        fullText.append((char) caractere);
                    }

                    // Fecha o FileReader
                    clientReader.close();


                    String fullTextStr = fullText.toString();
                    String[] fullTextArray = fullTextStr.split("[,;\\[\\]:]");

                    nameField.setText(fullTextArray[2]);
                    emailField.setText(fullTextArray[4]);
                    phoneField.setText(fullTextArray[6]);
                    salaryField.setText(fullTextArray[8]);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        panel.add(name);
        panel.add(nameField);
        panel.add(phone);
        panel.add(phoneField);
        panel.add(email);
        panel.add(emailField);
        panel.add(salary);
        panel.add(salaryField);
        panel.add(register);
        panel.add(show);

        frame.add(panel);
        frame.setVisible(true);
    }
}
