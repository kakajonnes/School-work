
package com.mycompany.assignment2;


import javax.swing.*;
import java.awt.*;

public class Assignment2 extends JFrame {

    private JLabel imageLabel;

    public Assignment2() {
        setTitle("RadioButton");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(20, 10));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(
            new GridLayout(5, 1, 5, 5)
        );

        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");
        JRadioButton pigButton = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        buttonPanel.add(birdButton);
        buttonPanel.add(catButton);
        buttonPanel.add(dogButton);
        buttonPanel.add(rabbitButton);
        buttonPanel.add(pigButton);

        imageLabel = new JLabel(
            "Select a pet",
            SwingConstants.CENTER
        );

        add(buttonPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        birdButton.addActionListener(e ->
            showPet("bird.png", "Bird"));

        catButton.addActionListener(e ->
            showPet("cat.png", "Cat"));

        dogButton.addActionListener(e ->
            showPet("dog.png", "Dog"));

        rabbitButton.addActionListener(e ->
            showPet("rabbit.png", "Rabbit"));

        pigButton.addActionListener(e ->
            showPet("pig.png", "Pig"));

        pigButton.setSelected(true);
        showPet("pig.png", "Pig");
    }

    private void showPet(String filename, String petName) {
        ImageIcon icon = new ImageIcon(filename);

        if (icon.getIconWidth() == -1) {
            imageLabel.setIcon(null);
            imageLabel.setText(
                petName + " image not found: " + filename
            );
        } else {
            Image image = icon.getImage().getScaledInstance(
                250, 200, Image.SCALE_SMOOTH
            );

            imageLabel.setIcon(new ImageIcon(image));
            imageLabel.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Assignment2 app;
                app = new Assignment2();
                app.setVisible(true);
            }
        });
    }
}
