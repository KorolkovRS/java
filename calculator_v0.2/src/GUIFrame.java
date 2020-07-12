import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUIFrame extends JFrame {
    private final String DEFAULT_VALUE = String.valueOf(0);
    private StringBuilder expression = new StringBuilder(DEFAULT_VALUE);
    private boolean waitingValue = true;
    private boolean waitingCalculation = false;

    public GUIFrame() throws HeadlessException {
        setTitle("calc_v0.1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(1, 60));
        textField.setFont(new Font("Tahoma", Font.BOLD, 40));
        textField.setText(DEFAULT_VALUE);
        add(textField, BorderLayout.NORTH);
        add(setKeyboard(textField), BorderLayout.CENTER);

        String[] strings = ("123\u00F71".toString()).split("[\u00F7\\+\\*\\-]");

        setVisible(true);
    }

    public boolean getWaitingValue() {
        return waitingValue;
    }

    void setWaitingValue(boolean waitingValue) {
        this.waitingValue = waitingValue;
    }

    private String[] split(String expression) {
      return expression.split("[\\+\\*\\-d]");
    }

//    private double calculationDouble(String expression) {
//
//    }

    public JPanel setKeyboard(JTextField textField) {
        JPanel grid = new JPanel();
        GridLayout gridLayout = new GridLayout(5, 4);
        grid.setLayout(gridLayout);

        JButton[] buttons = new JButton[20];

        buttons[0] = new JButton("AC");
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(DEFAULT_VALUE);
                waitingValue = true;
                waitingCalculation = false;
            }
        });

        buttons[1] = new JButton("\u232B");
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current = textField.getText();
                if (current.length() == 1) {
                    textField.setText(DEFAULT_VALUE);
                } else {
                    String substring = textField.getText().substring(current.length() - 1, current.length());
                    Pattern pattern = Pattern.compile("[\\+\\*\\-d]");
                    Matcher matcher = pattern.matcher(substring);
                    if (matcher.find()) {
                        waitingValue = true;
                        waitingCalculation = false;
                    }
                    textField.setText(current.substring(0, current.length() - 1));
                }
            }
        });

        buttons[2] = new JButton("%");
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double current = Integer.valueOf(textField.getText()) / 100.0;
                    textField.setText(String.valueOf(current));
                } catch (NumberFormatException exception) {
                    double current = Double.valueOf(textField.getText()) / 100.0;
                    current *= 1_000_000_000;
                    int result = (int)Math.round(current);
                    current = (double) result / 1_000_000_000;
                    textField.setText(String.valueOf(current));
                }
                waitingValue = false;
            }
        });

        buttons[3] = new JButton("\u00F7");
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder(textField.getText());

                if (waitingCalculation) {
                }
                else {
                    try {
                        Integer.parseInt(sb.toString());
                        sb.append("\u00F7");
                        textField.setText(sb.toString());
                        waitingCalculation = true;
                    } catch (NumberFormatException e5) {
                        try {
                            Double.parseDouble(sb.toString());
                            sb.append("\u00F7");
                            textField.setText(sb.toString());
                            waitingCalculation = true;
                        } catch (NumberFormatException e2) {
                            sb.setLength(sb.length() - 1);
                            sb.append("\u00F7");
                            textField.setText(sb.toString());
                            waitingCalculation = true;
                        }
                    }
                    waitingValue = true;
                }
                sb.setLength(0);
            }
        });

        buttons[7] = new JButton("X");
        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder(textField.getText());

                if (waitingCalculation) {
                }
                else {
                    try {
                        Integer.parseInt(sb.toString());
                        sb.append("*");
                        textField.setText(sb.toString());
                        waitingCalculation = true;
                    } catch (NumberFormatException e5) {
                        try {
                            Double.parseDouble(sb.toString());
                            sb.append("*");
                            textField.setText(sb.toString());
                            waitingCalculation = true;
                        } catch (NumberFormatException e2) {
                            sb.setLength(sb.length() - 1);
                            sb.append("*");
                            textField.setText(sb.toString());
                            waitingCalculation = true;
                        }
                    }
                    waitingValue = true;
                }
                sb.setLength(0);
            }
        });

        buttons[11] = new JButton("-");
        buttons[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder(textField.getText());

                if (waitingCalculation) {
                }
                else {
                    try {
                        Integer.parseInt(sb.toString());
                        sb.append("-");
                        textField.setText(sb.toString());
                        waitingCalculation = true;
                    } catch (NumberFormatException e5) {
                        try {
                            Double.parseDouble(sb.toString());
                            sb.append("-");
                            textField.setText(sb.toString());
                            waitingCalculation = true;
                        } catch (NumberFormatException e2) {
                            sb.setLength(sb.length() - 1);
                            sb.append("-");
                            textField.setText(sb.toString());
                            waitingCalculation = true;
                        }
                    }
                    waitingValue = true;
                }
                sb.setLength(0);
            }
        });

        buttons[15] = new JButton("+");
        buttons[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder(textField.getText());

                if (waitingCalculation) {
                }
                else {
                    try {
                        Integer.parseInt(sb.toString());
                        sb.append("+");
                        textField.setText(sb.toString());
                        waitingCalculation = true;
                    } catch (NumberFormatException e5) {
                        try {
                            Double.parseDouble(sb.toString());
                            sb.append("+");
                            textField.setText(sb.toString());
                            waitingCalculation = true;
                        } catch (NumberFormatException e2) {
                            sb.setLength(sb.length() - 1);
                            sb.append("+");
                            textField.setText(sb.toString());
                            waitingCalculation = true;
                        }
                    }
                    waitingValue = true;
                }
                sb.setLength(0);
            }
        });

        buttons[16] = new JButton("\u00B1");
        buttons[18] = new JButton(",");
        buttons[19] = new JButton("=");
        buttons[19].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (waitingCalculation) {
                    String op = null;
                    String[] strings = (textField.getText().split("[\u00F7\\+\\*\\-]"));
                    Pattern pattern = Pattern.compile("[\u00F7\\+\\*\\-]");
                    Matcher matcher = pattern.matcher(textField.getText());
                    if (matcher.find()) {
                        op = textField.getText().substring(matcher.start(), matcher.end());
                    }
                    try {
                        int num1 = Integer.parseInt(strings[0]);
                        int num2 = Integer.parseInt(strings[1]);

                        switch (op) {
                            case "*":
                                textField.setText(String.valueOf(num1 * num2));
                                break;
                            case "\u00F7":
                                textField.setText(String.valueOf(num1 / num2));
                                break;
                            case "+":
                                textField.setText(String.valueOf(num1 + num2));
                                break;
                            case "-":
                                textField.setText(String.valueOf(num1 - num2));
                                break;
                        }
                        waitingCalculation = false;
                        waitingValue = false;
                    } catch (NumberFormatException e1) {
                        System.out.println("Not number");
                    } catch (ArrayIndexOutOfBoundsException e2) {
                        System.out.println("Parse error");
                    }
                }
            }
        });

        ValueButtonListener valueButtonListener = new ValueButtonListener(textField, this);

        buttons[17] = new JButton(String.valueOf(0));
        buttons[17].addActionListener(valueButtonListener);

        for (int i = 4, j = 1, k = 0; i < 15; j++) {
            buttons[i] = new JButton(String.valueOf(j));
            buttons[i].addActionListener(valueButtonListener);
            i++;

            if (++k == 3) {
                k = 0;
                i++;
            }
        }

        for (int i = 0; i < buttons.length; i++) {
            grid.add(buttons[i]);
        }

        return grid;
    }
}