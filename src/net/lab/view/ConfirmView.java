package net.lab.view;

import javax.swing.*;

import static net.lab.utils.ViewUtils.SURE;
import static net.lab.utils.ViewUtils.TROUBLE_WHICH_SCHEME;

public class ConfirmView extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel mes;

    public ConfirmView() {
        super(TROUBLE_WHICH_SCHEME);
        inflateView();
    }

    private void inflateView() {
        setContentPane(contentPane);
        setSize(250, 200);
        setLocationRelativeTo(null);
        mes.setText(SURE);
        setVisible(true);
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }
}
