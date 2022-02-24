import javax.swing.*;
import java.awt.*;

/**
 * This class is the class that contains the main part of the code.
 * @author RedNeath
 */
public class Main extends JFrame {
    /**
     * This label will be displayed centered at the top of the window.
     */
    private JLabel dataLabel;
    /**
     * This label contains the text to display at the top left corner of the data section.
     */
    private JLabel potentialLabel;
    /**
     * This label is to be displayed just under the previous one.
     */
    private JLabel ageLabel;
    /**
     * This label contains the result of the execution.
     */
    private JLabel resultLabel;
    /**
     * This label is to be displayed at the top left corner of the result section.
     */
    private JLabel firstMagicPowerLabel;
    /**
     * This label is to be displayed just under the previous one, in the same section.
     */
    private JLabel secondMagicPowerLabel;

    /**
     * This field will be modified by the user to determine the magic potential of the character.
     */
    private JTextField potentialField;
    /**
     * This field will be modified by the user to determine the age of the character.
     */
    private JTextField ageField;
    /**
     * This field will display the result of the calculation for the first magic.
     */
    private JTextField firstMagicPowerField;
    /**
     * This field will display the result of the calculation for the second magic.
     */
    private JTextField secondMagicPowerField;

    /**
     * This button will start the calculation with the numbers entered by the user.
     */
    private JButton computeButton;

    /**
     * This listener will be triggered when the <i>playButton</i> or <i>languageButton</i> will be activated.
     */
    private AppListener appLis;

    /**
     * This panel will be a <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/GridLayout.html">GridLayout</a> that will contain
     * the potentialLabel and potentialField on one and only line.
     */
    private JPanel potentialPanel;
    /**
     * This panel will be a <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/GridLayout.html">GridLayout</a> that will contain
     * the ageLabel and ageField on one and only line.
     */
    private JPanel agePanel;
    /**
     * This panel will be a <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/GridLayout.html">GridLayout</a> that will contain
     * the firstMagicPowerLabel and firstMagicPowerField on one and only line.
     */
    private JPanel firstMagicPowerPanel;
    /**
     * This panel will be a <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/GridLayout.html">GridLayout</a> that will contain
     * the secondMagicPowerLabel and secondMagicPowerField on one and only line.
     */
    private JPanel secondMagicPowerPanel;

    /**
     * This attribute is the minimum size for the window.
     */
    private Dimension minSize;

    /**
     * This builder creates an instance of a Main object and initialises its content.
     */
    public Main() {
        setTitle("Magic Power Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.appLis = new AppListener(this);

        this.dataLabel              = new JLabel("Donnees");
        this.potentialLabel         = new JLabel("Potentiel magique");
        this.ageLabel               = new JLabel("Age");
        this.resultLabel            = new JLabel("Puissances");
        this.firstMagicPowerLabel   = new JLabel("Premiere magie");
        this.secondMagicPowerLabel  = new JLabel("Seconde magie");
        
        //Text alignment
        this.dataLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.potentialField         = new JTextField();
        this.ageField               = new JTextField();
        this.firstMagicPowerField   = new JTextField();
        this.secondMagicPowerField  = new JTextField();

        this.computeButton          = new JButton("Calculer");

        this.computeButton.addActionListener(appLis);

        //potentielPanel
        this.potentialPanel        = new JPanel(new GridLayout(1, 2));
        this.potentialPanel.add(potentialLabel);
        this.potentialPanel.add(potentialField);

        //agePanel
        this.agePanel               = new JPanel(new GridLayout(1, 2));
        this.agePanel.add(ageLabel);
        this.agePanel.add(ageField);

        //firstMagicPowerPanel
        this.firstMagicPowerPanel   = new JPanel(new GridLayout(1, 2));
        this.firstMagicPowerPanel.add(firstMagicPowerLabel);
        this.firstMagicPowerPanel.add(firstMagicPowerField);

        //secondMagicPowerPanel
        this.secondMagicPowerPanel  = new JPanel(new GridLayout(1, 2));
        this.secondMagicPowerPanel.add(secondMagicPowerLabel);
        this.secondMagicPowerPanel.add(secondMagicPowerField);

        //Main frame
        getContentPane().setLayout(new GridLayout(7, 1));
        add(this.dataLabel);
        add(this.potentialPanel);
        add(this.agePanel);
        add(this.resultLabel);
        add(this.firstMagicPowerPanel);
        add(this.secondMagicPowerPanel);
        add(this.computeButton);

        //Frame settings
        this.minSize = new Dimension();
        this.minSize.setSize(310, 245);
        setMinimumSize(this.minSize);
    }

    /**
     * This is the heart of the RNG app. Igniting it will start up the program.
     * 
     * @param args Arguments entered in the terminal (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main aChrono = new Main();
                aChrono.pack();
                aChrono.setVisible(true);
            }
        });
    }

    /**
     * This getter returns the magic potential field attribute.
     * 
     * @return potentialField.
     */
    public JTextField getPotentialField() {
        return this.potentialField;
    }

    /**
     * This getter returns the age field attribute.
     * 
     * @return ageField.
     */
    public JTextField getAgeField() {
        return this.ageField;
    }

    /**
     * This getter returns the first magic power field attribute.
     * 
     * @return firstMagicPowerField.
     */
    public JTextField getFirstMagicPowerField() {
        return this.firstMagicPowerField;
    }

    /**
     * This getter returns the second magic power field attribute.
     * 
     * @return secondMagicPowerField.
     */
    public JTextField getSecondMagicPowerField() {
        return this.secondMagicPowerField;
    }

    /**
     * This getter returns the compute button attribute.
     * 
     * @return computeButton.
     */
    public JButton getComputeButton() {
        return this.computeButton;
    }
}