package quiz_Application;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/*

1.Quiz Questions and Options: Store quiz questions along with multiple-choice options and correct
answers.

2.Timer: Implement a timer for each question to limit the time to answer.
3.Question Display: Present one question at a time with multiple-choice options.
4.Answer Submission: Allow users to select an option and submit their answer within the given
time.

5.Score Calculation: Keep track of the user's score based on correct answers.
Result Screen: Display the final score and a summary of correct/incorrect answers.
*/


class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class Quiz_Application{
	static int seconds = 0;
	static Timer timer = new Timer();
	static double score = 0;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {       
        startQuiz();    
    }

public static void startQuiz() {
	TimerTask task = new TimerTask() {
		public void run() {
			seconds++;
			
		}
		System.out.println("Time Escaped: "+seconds+"seconds");
	};
	timer.schedule(task,1000,1000);
	
	List<QuizQuestion> questions = new ArrayList<>();
    questions.add(new QuizQuestion("Number of primitive data types in Java are?",
            List.of("6", "7", "8", "9"), 2));
    questions.add(new QuizQuestion("Who invented Java Programming?",
    		List.of("Guido van Rossum","James Gosling","Dennis Ritchie","Bjarne Strroustrup"),1));
    questions.add(new QuizQuestion("Which component is used to compile, debug and execute the java programs?",
    		List.of("JRE","JIT","JDK","JVM"),2));
    questions.add(new QuizQuestion("Which one of the following is not a Java feature?",
    		List.of("Object-oriented","Use of pointer","Portable","Dynamic and Extensible"),1));
    questions.add(new QuizQuestion("What is the extension of java code files?",
    		List.of(".js",".txt",".class",".java"),3));
    
    
    
    for (QuizQuestion question : questions) {
        System.out.println(question.getQuestion());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        System.out.print("Enter your option: ");
        int userAnswer = sc.nextInt();
        
        

        if (userAnswer == question.getCorrectOption() + 1) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was: " +
                    options.get(question.getCorrectOption()));
            score -= 0.25;
        }
    }
    timer.cancel();
    sc.close();

    System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());

}
}
