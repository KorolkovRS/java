import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValueButtonListener implements ActionListener {
    private final JTextField textField;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final GUIFrame currentFrame;

    public ValueButtonListener(JTextField textField, GUIFrame currentFrame) {
        this.textField = textField;
        this.currentFrame = currentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton currentButton = (JButton) e.getSource();
        String currentText = textField.getText();
        if (currentFrame.getWaitingValue()) {
            if (currentText.length() == 1 && currentText.equals("0")) {
                stringBuilder.append(currentButton.getText());
            } else {
                stringBuilder.append(currentText + currentButton.getText());
            }
        }
        else {
            stringBuilder.setLength(0);
            stringBuilder.append(currentButton.getText());
        }
        currentFrame.setWaitingValue(true);
        this.textField.setText(stringBuilder.toString());
        stringBuilder.setLength(0);
    }
}
