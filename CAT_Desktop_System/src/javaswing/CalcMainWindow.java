package javaswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcMainWindow extends JFrame{
    public static void main(String[] args) {
        // 创建窗口
        CalcMainWindow win = new CalcMainWindow();
        // 显示窗口
        win.setVisible(true);
    }

    public CalcMainWindow() {
        // 窗口初始化
        init();
    }

    /**
     * 数字显示标签
     */
    private JLabel numbersLabel;

    /**
     * 实时显示结果的标签
     */
    private JLabel smallResultLabel;

    /**
     * 窗口初始化
     */
    private void init() {
        // 窗口设置
        setTitle("简易计算器");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        // 创建 数字显示面板
        JPanel numbersPanel = createNumbersPanel();
        // 创建 按钮面板
        JPanel keyPanel = createKeyPanel();

        // 创建 窗口内容面板, 使用边框布局
        JPanel contentPanel = new JPanel(new BorderLayout());

        // 北边 数字显示面板
        contentPanel.add(numbersPanel, BorderLayout.NORTH);
        // 中间 添加一个高度为10px大小的空白填充物
        contentPanel.add(Box.createVerticalStrut(10), BorderLayout.CENTER);
        // 南边 按钮面板
        contentPanel.add(keyPanel, BorderLayout.SOUTH);

        // 内容面板设置一个空白边框, 上右下左四边设置指定大小的间隔(内边距)
        contentPanel.setBorder(BorderFactory.createEmptyBorder(12, 8, 8, 8));

        // 把内容面板设置到窗口
        setContentPane(contentPanel);
        // 包裹内容 (自动计算窗口尺寸)
        pack();
        // 把窗口位置设置到屏幕中心, 必须在调用完 pack() 方法后才设置 (因此此时窗口的宽高才被确定)
        setLocationRelativeTo(null);
    }

    /**
     * 创建 数字显示 面板
     */
    private JPanel createNumbersPanel() {
        // 创建 显示输入的标签, 后面需要获取输入的数字, 所以保存为类属性
        numbersLabel = new JLabel("0");
        numbersLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        numbersLabel.setForeground(Color.BLACK);
        resetNumbersLabelFontSize();

        // 创建 实时显示结果显示标签 (使用空格占位)
        smallResultLabel = new JLabel(" ");
        smallResultLabel.setFont(new Font(null, Font.PLAIN, 14));
        smallResultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        smallResultLabel.setForeground(Color.BLACK);

        // 把两个显示标签组合成显示框面板 (透明背景)
        JPanel numbersPanel = new JPanel(new BorderLayout());
        numbersPanel.setOpaque(false);
        numbersPanel.add(numbersLabel, BorderLayout.CENTER);
        numbersPanel.add(smallResultLabel, BorderLayout.SOUTH);
        numbersPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        // 另外再创建一个面板, 用来包装显示框
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(numbersPanel, BorderLayout.CENTER);
        // 面板设置为不透明, 背景设置为白色
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);
        // 设置面板首选尺寸, 这里必须设置首选尺寸才有效, 只需要设置高度, 宽度在 pack() 布局时会自动适配
        panel.setPreferredSize(new Dimension(0, 80));
        // 设置一个有颜色的线性边框, 线宽1px, true表示有一点点圆角
        panel.setBorder(BorderFactory.createLineBorder(Color.decode("#D0D0D0"), 1, true));

        return panel;
    }

    /**
     * 创建按钮面板
     */
    private JPanel createKeyPanel() {
        // 按钮的行列数量
        final int ROW_BTN_COUNT = 5;
        final int COL_BTN_COUNT = 4;

        // 按钮面板使用网格布局
        GridLayout layout = new GridLayout(ROW_BTN_COUNT, COL_BTN_COUNT);
        layout.setHgap(5);
        layout.setVgap(5);
        JPanel panel = new JPanel(layout);

        // 网格按钮中各按钮显示的文本
        String[][] texts = {
                {"C", "÷", "×", "<-"},
                {"7", "8", "9", "-"},
                {"4", "5", "6", "+"},
                {"1", "2", "3", "%"},
                {"00", "0", ".", "="}
        };

        // 按钮点击监听器
        ActionListenerImpl actionListener = new ActionListenerImpl();

        // 遍历行列, 给每个网格点创建并添加按钮
        for (int r = 0; r < ROW_BTN_COUNT; r++) {
            for (int c = 0; c < COL_BTN_COUNT; c++) {
                String text = texts[r][c];
                JButton btn = new JButton(text);
                btn.setFont(new Font(null, Font.PLAIN, 20));
                btn.setForeground(Color.BLACK);
                btn.setActionCommand(text);             // 把按钮文本设置为动作命令, 用于在点击事件回调时区分是哪个按钮按下
                btn.addActionListener(actionListener);  // 添加点击事件监听器
                btn.setFocusable(false);                // 设置按钮不可聚焦。如果可聚集, 在点击后, 按钮上会有一个聚焦选框。
                panel.add(btn);                         // 把按钮添加到面板, 会自动按顺序放到对应网格上
            }
        }

        // 给按钮面板设置一个首选大小
        panel.setPreferredSize(new Dimension(300, 300));

        return panel;
    }

    /**
     * 根据数字显示标签内显示的内容设置字体大小
     */
    private void resetNumbersLabelFontSize() {
        String expression = numbersLabel.getText();
        if (expression.length() <= 11) {
            numbersLabel.setFont(new Font(null, Font.PLAIN, 40));
        } else if (expression.length() <= 14) {
            numbersLabel.setFont(new Font(null, Font.PLAIN, 30));
        }  else if (expression.length() <= 17) {
            numbersLabel.setFont(new Font(null, Font.PLAIN, 25));
        } else {
            numbersLabel.setFont(new Font(null, Font.PLAIN, 20));
        }
    }

    /**
     * 按钮点击监听器
     */
    private class ActionListenerImpl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // 获取被点击按钮绑定的 动作命令 (也就是上面创建按钮时设置的按钮文本)
            String actionCommand = e.getActionCommand();
            // 在单独的方法中去处理按钮被点击
            handleButtonClick(actionCommand);
            // 根据数字显示标签内显示的内容重新设置字体大小
            resetNumbersLabelFontSize();
        }
    }

    /**
     * 处理按钮的点击
     */
    private void handleButtonClick(String btnText) {
        /*
        {"C", "÷", "×", "<-"},
        {"7", "8", "9", "-"},
        {"4", "5", "6", "+"},
        {"1", "2", "3", "%"},
        {"00", "0", ".", "="}
        */
        // 获取当前已输入部分
        String expression = numbersLabel.getText();

        if ("C".equals(btnText) || "error".equals(expression)) {
            // 按下归零 或 屏幕上显示上一次计算出错的结果, 则 清屏(归零)
            numbersLabel.setText("0");
            smallResultLabel.setText(" ");
            return;
        }

        if ("<-".equals(btnText)) {
            // 退格 (删除最右边一个字符, 保留归零)
            if (expression.length() > 0) {
                expression = expression.substring(0, expression.length() - 1);
            }
            if (expression.length() == 0) {
                // 如果是空白, 则设置为归0
                expression = "0";
            }
            numbersLabel.setText(expression);

        } else if ("+".equals(btnText) || "-".equals(btnText) || "×".equals(btnText) || "÷".equals(btnText)) {
            // 按下的运算符, 则已输入部分的末尾不能是运算符 (即不能有连续的两个运算符)
            if (expression.endsWith("+") || expression.endsWith("-") || expression.endsWith("×") || expression.endsWith("÷")) {
                return;
            }
            if ("0".equals(expression)) {
                // 如果屏幕中显示的是0, 则不允许输入 "+", "×" 和 "÷",
                if ("+".equals(btnText) || "×".equals(btnText) || "÷".equals(btnText)) {
                    return;
                }
                // 输入的是 "-", 则直接显示为 "-" (因为可能当前正在输入负数)
                expression = "-";
            } else {
                // 其他情况, 直接把运算符平均在末尾
                expression = expression + btnText;
            }
            numbersLabel.setText(expression);

        } else if (btnText.matches("[0-9]+")) {
            // 按下的是 数字, 数字前面不能是百分号
            if (expression.endsWith("%")) {
                return;
            }

            expression = expression + btnText;

            // 移除掉前面无意义的 "0" (如果存在), 只有1个"0"不移除, 不能移除 "0." 和 "0%"
            while (!"0".equals(expression) && expression.startsWith("0") && !expression.startsWith("0.") && !expression.startsWith("0%")) {
                expression = expression.substring(1);
            }

            // 移除掉最后1个数字前面无意义的0
            for (String operator : new String[]{"+", "-", "×", "÷"}) {
                int addIndex = expression.lastIndexOf(operator);
                if (addIndex >= 0) {
                    String prefix = expression.substring(0, addIndex);
                    String lastNum = expression.substring(addIndex + 1);
                    while (!"0".equals(lastNum) &&lastNum.startsWith("0") && !lastNum.startsWith("0.") && !lastNum.startsWith("0%")) {
                        lastNum = lastNum.substring(1);
                    }
                    expression = prefix + operator + lastNum;
                }
            }

            numbersLabel.setText(expression);

        } else if ("%".equals(btnText)) {
            // 按下的是 百分号, 百分号前面必须是数字或小数点
            // 已输入部分末尾不是数字或点, 则不处理
            if (!expression.matches(".*[0-9.]$")) {
                return;
            }
            expression = expression + btnText;
            numbersLabel.setText(expression);

        }  else if (".".equals(btnText)) {
            // 按下的是 小数点, 小数点前面必须是一个数字, 并且一个有效数字只能包含一个小数点
            if (!expression.matches(".*[0-9]$")) {
                return;
            }
            // 用正则表达式找出最后一个数字
            Pattern p = Pattern.compile("[0-9.]+$");
            Matcher m = p.matcher(expression);
            if (m.find()) {
                String lastNum = m.group();
                // 数组已包含 . 则忽略
                if (lastNum.contains(".")) {
                    return;
                }
                expression = expression + btnText;
                numbersLabel.setText(expression);
            }
        }
        // "=" 按键不做特殊判断, 后面实时计算结果后才根据是否按下 "=" 来做结果显示区分

        // 实时显示结果
        try {
            // 把屏幕上显示的表达式转换为代码表达式, 即把 "×" 替换为 "*", 把 "÷" 替换为 "/"
            String codeExpression = expression.replace("×", "*").replace("÷", "/");
            // 解析表达式
            double value = parseExpression(codeExpression);
            String valueString = String.valueOf(value);
            // 删除结果值后面无意义的0和".", 如 "2.000" -> "2"
            while (valueString.contains(".") && (valueString.endsWith(".") || valueString.endsWith("0"))) {
                valueString = valueString.substring(0, valueString.length() - 1);
            }

            if ("=".equals(btnText)) {
                // 按了等号键, 把结果设置到屏幕上, 并把实时显示结果清空
                numbersLabel.setText(valueString);
                smallResultLabel.setText(" ");
            } else {
                // 表达式包含运算符, 则实时显示结果
                if (expression.contains("+") || expression.contains("-") || expression.contains("×") || expression.contains("÷")) {
                    smallResultLabel.setText(valueString);
                } else {
                    smallResultLabel.setText(" ");
                }
            }

        } catch (Exception e) {
            if ("=".equals(btnText)) {
                // 按了等号键计算出错, 屏幕上显示为 "error"
                numbersLabel.setText("error");
            }
            // 出错时清空实时显示结果
            smallResultLabel.setText(" ");
        }
    }

    /**
     * 解析数学表达式的值, 只解析 加减乘除 表达式 (不包括括号)
     * 如:
     *      "1 + 2 * 3 - 4" 返回 3
     *      "100 * 10%" 返回 10
     *      "5 / 2" 返回 2.5
     */
    private static double parseExpression(String expression) throws Exception {
        // 表达式中的空格一般没什么意义, 先去掉空格
        expression = expression.replace(" ", "");
        // 百分号相当于除以100, 把百分号替换为除法形式
        if (expression.contains("%")) {
            expression = expression.replace("%", "/100");
        }

        // 把连续的 ++, --, +-, -+ 约去省略为等价的一个 + 或 - 符号 (输入时也可以做控制, 为了程序尽量通用, 顺便处理)
        while (expression.contains("++") || expression.contains("--") || expression.contains("+-") || expression.contains("-+")) {
            expression = expression.replace("++", "+");
            expression = expression.replace("--", "+");
            expression = expression.replace("+-", "-");
            expression = expression.replace("-+", "-");
        }

        // 如果是 + 或 - 开头的, 前面加上 0 补全为完整的双目表达式, 如 "-1" -> "0-1"
        if (expression.startsWith("+") || expression.startsWith("-")) {
            expression = "0" + expression;
        }
        // 开头是 * 和 /, 因为无意义, 直接返回解析错误
        if (expression.startsWith("*") || expression.startsWith("/")) {
            throw new Exception("parse expression error: " + expression);
        }

        try {
            // 先尝试解析为数字, 如果能解析, 说明表达式是简单的数字, 直接返回数字值
            return Double.parseDouble(expression);
        } catch (NumberFormatException e) {
            // 解析抛出异常, 说明可能包含 加减乘除 符号表达式, 后面继续拆分表达式, 直到拆分为简单的一个数字
        }

        /*
        下面是拆分表达式:

        例如一个 X + Y 的表达式, 可以拆分为 X 和 Y 两个子表达式, 然后分别解析出 X 和 Y 表达式的值再相加即可。
        X 或 Y 也可以是一个表达式, 例如 X = A * B, 为了计算 X 的值, 可以继续把 X 拆分为 A 和 B 两个子表达式,
        如果拆分到 A 和 B 是一个数字, 则直接把数字字符串转换为数字, 然后直接做数学运算即可。

        也就是说如果表达式中的一个运算符两边的子表达式也包含加减乘除运算符, 则继续递归拆分子表达式, 直到运算符两边的表达式是简单的数字。

        数学表达式中的运算符有高低优先级之分, *和/ 的优先级更高, +和- 优先级较低, 优先级高的表达式部分需要一起运算,
        因此必须优先用 + 或 - 操作符去拆分表达式, 然后再用 * 或 / 拆分表达式。
        */

        // 找出表达式中第1个 "+" 符号的位置索引, 不存在会返回 -1
        int addIndex = expression.indexOf("+");
        if (addIndex >= 0) {
            // 根据 "+" 符号位置, 把原表达式拆分为 左边 和 右边 两个子表达式
            String leftExpression = expression.substring(0, addIndex);
            String rightExpression = expression.substring(addIndex + 1);
            // 然后分别解析出 左边子表达式 和 右边子表达式 的值, 再返回相加结果
            return parseExpression(leftExpression) + parseExpression(rightExpression);
        }

        int subIndex = expression.indexOf("-");
        if (subIndex >= 0) {
            String leftExpression = expression.substring(0, subIndex);
            String rightExpression = expression.substring(subIndex + 1);
            return parseExpression(leftExpression) - parseExpression(rightExpression);
        }

        int mulIndex = expression.indexOf("*");
        if (mulIndex >= 0) {
            String leftExpression = expression.substring(0, mulIndex);
            String rightExpression = expression.substring(mulIndex + 1);
            return parseExpression(leftExpression) * parseExpression(rightExpression);
        }

        int divIndex = expression.indexOf("/");
        if (divIndex >= 0) {
            String leftExpression = expression.substring(0, divIndex);
            String rightExpression = expression.substring(divIndex + 1);
            return parseExpression(leftExpression) / parseExpression(rightExpression);
        }

        // 表达式不是简单的数字, 也不包含 加减乘除 符号, 直接抛出解析错误
        throw new Exception("parse expression error: " + expression);
    }

}
