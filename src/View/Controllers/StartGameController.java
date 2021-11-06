package View.Controllers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class StartGameController {

    public int getNumOfPlayers(JFrame frame) {
        JPanel panel = new JPanel(new GridLayout(4,1));
        AtomicInteger num = new AtomicInteger(2);
        ButtonGroup group = new ButtonGroup();
        JRadioButton players2 = new JRadioButton("2 players");
        JRadioButton players3 = new JRadioButton("3 players");
        JRadioButton players4 = new JRadioButton("4 players");
        JRadioButton players5 = new JRadioButton("5 players");
        players2.setSelected(true);
        group.add(players2);
        group.add(players3);
        group.add(players4);
        group.add(players5);
        players2.addActionListener(e -> num.set(2));
        players3.addActionListener(e -> num.set(3));
        players4.addActionListener(e -> num.set(4));
        players5.addActionListener(e -> num.set(5));
        panel.add(players2);
        panel.add(players3);
        panel.add(players4);
        panel.add(players5);
        JOptionPane.showConfirmDialog(frame, panel,
                "Enter Info", JOptionPane.DEFAULT_OPTION);
        return num.get();
    }

    public ArrayList<String> getNameOfPlayers(int num, JFrame frame) {
        ArrayList<JTextField> names = new ArrayList<>();
        ArrayList<String> nameText = new ArrayList<>();
        JPanel myPanel = new JPanel(new GridLayout(num,2));
        for (int i = 0; i<num; i++){
            myPanel.add(new JLabel("Name " + (i+1) + ":"));
            names.add(new JTextField());
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(names.get(i));
        }
        while (true){
            boolean stay = true;
            int result = JOptionPane.showConfirmDialog(frame, myPanel,
                    "Enter Info", JOptionPane.DEFAULT_OPTION);
            if (result == 0){
                for (int i = 0; i < num; i++) {
                    if (names.get(i).getText().equals("")){
                        nameText.clear();
                        break;
                    }
                    nameText.add(names.get(i).getText());
                }
                if (nameText.size() == num)
                    stay = false;
                if (!stay)
                    break;
            }
        }
        return nameText;
    }
}