import java.awt.event.*;

/**
 * This class handles the events on the window
 * @author RedNeath
 */
public class AppListener implements ActionListener {
    /**
     * This attribute contain the main program. It is used to see what the source of the trigger is.
     */
    private Main main;

    /**
     * This contructor takes a main to work.
     * 
     * @param main The main that launched the code.
     */
    public AppListener(Main main) {
        this.main = main;
    }
    
    /**
     * This method tells what the program should do if the listener is triggered by the user.
     * 
     * @param e The event that triggered the listener.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(this.main.getComputeButton())) {
            computeMagicPower();
        }
    }

    /**
     * This method retrieves the infos given by the user in the gui
     * and uses them to compute the magic power of the character.
     */
    private void computeMagicPower() {
        try {
            double potential;
            double age;
            double firstMagicPower;
            double secondMagicPower;

            potential = Double.parseDouble(this.main.getPotentialField().getText());
            age = Double.parseDouble(this.main.getAgeField().getText());
            //compute the magic powers
            firstMagicPower = magicFunction(age) * potential;
            secondMagicPower = firstMagicPower / 2;

            //convert it to string and print it in the corresponding text fields.
            this.main.getFirstMagicPowerField().setText(String.valueOf(firstMagicPower));
            this.main.getSecondMagicPowerField().setText(String.valueOf(secondMagicPower));

        } catch (Exception e) { //catch any kind of exception and signal it to the user
            this.main.getFirstMagicPowerField().setText("ERR");
            this.main.getSecondMagicPowerField().setText("ERR");
        }
    }

    /**
     * This method computes the magic power at a given age to send it bakc to computeMagicPower.
     * 
     * @param x The abs index of the function
     * @return The y ord of the function at the index x.
     * @throws IllegalArgumentException if x is below 0.
     */
    private double magicFunction(double x) throws IllegalArgumentException {
        double y;
        if (x < 0) {
            throw new IllegalArgumentException("x can't be below 0.");
            
        } else if (x < 20) {
            y = 0.1 + (0.9 / Math.sqrt(20)) * Math.sqrt(x) * (-x / 40 + 1.5);
        } else if (x < 25) {
            y = 1;
        } else {
            y = (625 * (Math.log(x) - Math.log(25)) + 25 * x) / (x * x);
        }

        return y;
    }
}
