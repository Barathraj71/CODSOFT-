import java.util.Scanner;
public class RuleBasedChatbot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Chatbot: Hello! Before we start, what's your name?");
        System.out.print("You: ");
        String userName = sc.nextLine();
        System.out.println(" Chatbot: Nice to meet you, " + userName + "! ");
        System.out.println(" Chatbot: Ask me anything. Type 'bye' to exit.\n");
        while (true) {
            System.out.print(userName + ": ");
            String userInput = sc.nextLine().toLowerCase();

            if(userInput.equals("bye")) {
                System.out.println(" Chatbot: Goodbye, " + userName + "! Have a great day.");
                break;
            }
            if(userInput.contains("hello") || userInput.contains("yeah hi tony")){
                System.out.println(" Chatbot: Hello " + userName + "! How can I help you today?");
            }
            else if(userInput.contains("how are you")) {
                System.out.println(" Chatbot: I'm doing great! How about you, " + userName + "?");
            }
            else if(userInput.contains("your name")) {
                System.out.println(" Chatbot: I am a simple rule-based chatbot, named Tony; created using Java programming.");
            }
            else if(userInput.contains("time")) {
                System.out.println(" Chatbot: Sorry " + userName + ", I cannot check the time yet.");
            }
            else if(userInput.contains("who was the creator of you?") || userInput.contains("who made you?")) {
                System.out.println(" Chatbot: I was created by a Java programmer and his name is Barathraj!");
            }
            else if(userInput.contains("help")) {
                System.out.println(" Chatbot: Sure " + userName + ", tell me what you need help with.");
            }
            else if(userInput.contains("java")) {
                System.out.println(" Chatbot: Java is a powerful programming language used for many applications.");
            }
            else if(userInput.contains("codsoft company")){
                System.out.println(" Chatbot: Codsoft is an company which is known for innovative IT services and consultancy.");
            }
            else {
                System.out.println(" Chatbot: Sorry " + userName + ", I don't understand that.");
            }
        }
        sc.close();
    }
}
