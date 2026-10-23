
import java.util.*;
import java.util.regex.*;

abstract class Question {
    String text, correctAnswer, studentAnswer;
    double points;

    Question(String text, String correctAnswer,
             String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();
}

class MCQQuestion extends Question {
    MCQQuestion(String text, String correct, String student, double points) {
        super(text, correct, student, points);
    }

    double grade() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String text, String correct, String student,
                      double points) {
        super(text, correct, student, points);
    }

    double grade() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String text, String correct, String student, double points) {
        super(text, correct, student, points);
    }

    double grade() {
        String[] keywords = correctAnswer.split(",");
        int matched = 0;
        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            String word = keyword.trim().toLowerCase();
            if (!word.isEmpty() && answer.contains(word)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            List<String> tokens = new ArrayList<>();

            while (matcher.find()) {
                tokens.add(matcher.group(1) != null
                    ? matcher.group(1) : matcher.group(2));
            }

            String type = tokens.get(0);
            String text = tokens.get(1);
            String correct = tokens.get(2);
            String student = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQQuestion(text, correct, student, points);
                    break;
                case "TF":
                    question = new TrueFalseQuestion(
                        text, correct, student, points
                    );
                    break;
                default:
                    question = new EssayQuestion(
                        text, correct, student, points
                    );
            }

            double score = question.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}

