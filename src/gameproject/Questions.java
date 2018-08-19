package gameproject;

/**
 *This class is for Questions, options and answer
 * @author Amritpal Kaur
 * 14865526
 */
public class Questions {

    private String question;
    private String[] options;
    private String answer;

    public Questions(String q, String[] o, String a) {
        this.question = q;
        this.options = o;
        this.answer = a;
    }

    /**
     * Method for setting the question 
     * @param inputQuestion 
     */
    public void setQuestion(String inputQuestion) {
        this.question = inputQuestion;
    }

    /**
     * Method for storing the options from the text file
     * @param inputOption 
     */
    public void setOptions(String[] inputOption) {
        this.options = new String[inputOption.length];
        if (inputOption != null) {                                                                           // ensures the input is not null
            for (int i = 0; i < inputOption.length; i++) {

                for (int j = 0; j < options.length; j++) {
                    if (i == j) {
                        try {
                            options[i] = inputOption[j];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Error: You are trying to access an illegal integer in the array");
                        }
                    }
                }

            }
        }
    }

    /**
     * method for setting the answer
     * @param answer 
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return this.question;
    }

    /**
     * method for getting the options, ensure no null value is returned
     * @return 
     */
    public String[] getOptions() {
        String[] alternatives = new String[this.options.length];
        for (int i = 0; i < options.length; i++) {
            for (int j = 0; j < alternatives.length; j++) {
                if (i == j && options[i] != null) {
                    try{
                    alternatives[j] = options[i];
                    } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Error: You are trying to access an illegal integer in the array");
                        }
                }
            }
        }
        return alternatives;
    }

    public String getAnswer() {
        return this.answer;
    }

    /**
     * To string method displays the question and options
     * @return a string
     */
    public String toString() {
        String output = "\nYour question is: \n" + this.getQuestion() + "\n";
        for (String choice : this.getOptions()) {
            output += choice + "\n";
        }
        return output;
    }
}
