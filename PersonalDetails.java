package semIV;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("removal")
public class PersonalDetails extends Applet implements ActionListener {
    Label nameLabel, ageLabel, genderLabel, occupationLabel;
    TextField nameField, ageField, occupationField;
    CheckboxGroup genderGroup;
    Checkbox maleCheckbox, femaleCheckbox;
    Button submitButton;

    public void init() {
        // Set layout for the applet
        setLayout(new GridLayout(5, 2));

        // Add labels and text fields for name, age, and occupation
        nameLabel = new Label("Name: ");
        add(nameLabel);
        nameField = new TextField();
        add(nameField);

        ageLabel = new Label("Age: ");
        add(ageLabel);
        ageField = new TextField();
        add(ageField);

        occupationLabel = new Label("Occupation: ");
        add(occupationLabel);
        occupationField = new TextField();
        add(occupationField);

        // Add radio buttons for gender
        genderLabel = new Label("Gender: ");
        add(genderLabel);
        genderGroup = new CheckboxGroup();
        maleCheckbox = new Checkbox("Male", genderGroup, true);
        add(maleCheckbox);
        femaleCheckbox = new Checkbox("Female", genderGroup, false);
        add(femaleCheckbox);

        // Add submit button and set action listener
        submitButton = new Button("Submit");
        add(submitButton);
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // Get user input from text fields
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String occupation = occupationField.getText();

        // Get selected gender from radio buttons
        String gender = "";
        if (maleCheckbox.getState()) {
            gender = "Male";
        } else if (femaleCheckbox.getState()) {
            gender = "Female";
        }

        // Display user input in applet window
        String message = "Name: " + name + "\nAge: " + age + "\nOccupation: " + occupation + "\nGender: " + gender;
        showStatus(message);
    }
}
