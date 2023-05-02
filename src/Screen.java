import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class Screen {

    public void initialMessageDialog() {
        JLabel label = new JLabel("Pense em um prato que gosta");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(250,35));
        JOptionPane.showMessageDialog(null, label,
                "Jogo Gourmet", JOptionPane.PLAIN_MESSAGE);
    }

    public String getNewDishType(String message) {
        return JOptionPane.showInputDialog(null, message,
                "Complete", JOptionPane.QUESTION_MESSAGE);
    }

    public String getNewDish() {
        return JOptionPane.showInputDialog(null,
                "Qual o prato você pensou?", "Desisto", JOptionPane.QUESTION_MESSAGE);
    }

    public int getOption(Node node) {
        Object[] options = {"Sim", "Não"};
        return JOptionPane.showOptionDialog(null,
                "O prato que você pensou é " + node.getValue() + "?",
                "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
    }

    public void getDialogMessage() {
        JOptionPane.showMessageDialog(
                null, "Acertei de novo!",
                "Jogo Gourmet",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
