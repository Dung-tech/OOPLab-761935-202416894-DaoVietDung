package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen parent) {
        super(store, parent);
        setTitle("Add Compact Disc (CD) to Store");

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        form.add(new JLabel("Title:"));
        JTextField tfTitle = new JTextField(20);
        form.add(tfTitle);

        form.add(new JLabel("Cost:"));
        JTextField tfCost = new JTextField(20);
        form.add(tfCost);

        form.add(new JLabel("Category:"));
        JTextField tfCategory = new JTextField(20);
        form.add(tfCategory);

        form.add(new JLabel("Artist:"));
        JTextField tfArtist = new JTextField(20);
        form.add(tfArtist);

        JButton btnAdd = new JButton("Add to Store");
        form.add(new JLabel(""));
        form.add(btnAdd);

        getContentPane().add(form, BorderLayout.CENTER);
        setVisible(true);
    }
}