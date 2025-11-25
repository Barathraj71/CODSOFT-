import java.util.*;
class Item {
    String name;
    String category;
    String type; 

    Item(String n, String c, String t){
        name = n;
        category = c;
        type = t;
    }
}
public class RecommendationSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Simple Recommendation System");

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("The Avengers-2012", "Action", "Movie"));
        items.add(new Item("Iron Man-2008", "Action", "Movie"));
        items.add(new Item("Interstellar-2014", "Sci-Fi", "Movie"));
        items.add(new Item("Inception-2010", "Sci-Fi", "Movie"));
        items.add(new Item("Titanic-1997", "Romance", "Movie"));
        items.add(new Item("The Fast & The Furious-2001", "Crime", "Movie"));
        items.add(new Item("The Exorcist-1973", "Horror", "Movie"));
        items.add(new Item("Avatar-2009", "Sci-Fi", "Movie"));
        items.add(new Item("La La Land-2016", "Romance", "Movie"));
        items.add(new Item("The Shawshank Redeption-1994", "Thriller", "Movie"));


        items.add(new Item("The Martian-2011", "Sci-Fi", "Book"));
        items.add(new Item("Harry Potter-1997", "Fantasy", "Book"));
        items.add(new Item("Atomic Habits-2018", "Self-Help", "Book"));
        items.add(new Item("Pride and Prejudice-1813", "Romance", "Book"));
        items.add(new Item("Rich Dad Poor Dad-1997", "Finance", "Book"));
        items.add(new Item("War and Peace-1869", "Social", "Book"));
        items.add(new Item("Dune-1965", "Sci-Fi", "Book"));
        items.add(new Item("Frankenstein-1818", "Horror", "Book"));
        items.add(new Item("Dracula-1897", "Horror", "Book"));
        items.add(new Item("The intelligent investor-1949", "Finance", "Book"));

        items.add(new Item("Laptop", "Technology", "Product"));
        items.add(new Item("PlayStation 5", "Gaming", "Product"));
        items.add(new Item("MacBook Air", "Technology", "Product"));
        items.add(new Item("Yoga Mat", "Fitness", "Product"));
        items.add(new Item("LED Study Lamp", "Study", "Product"));
        items.add(new Item("Wireless Earbuds", "Technology", "Product"));
        items.add(new Item("Sofa", "Furniture", "Product"));
        items.add(new Item("Dumbbell", "Fitness", "Product"));
        items.add(new Item("Men T-shirt", "Fashion", "Product"));
        items.add(new Item("Men shoes", "Fashion", "Product"));
        items.add(new Item("Study table", "Study", "Product"));

        items.add(new Item("Free Fire", "Shooting", "Game"));
        items.add(new Item("BGMI", "Shooting", "Game"));
        items.add(new Item("Real racing 3", "Racing", "Game"));
        items.add(new Item("Clash of clans", "build and battle", "Game"));
        items.add(new Item("Real cricket 2024", "Sports", "Game"));
        items.add(new Item("Dr.driving", "Racing", "Game"));
        items.add(new Item("eFootball", "Sports", "Game"));
        items.add(new Item("UNO", "Multiplayer", "Game"));
        items.add(new Item("Chess.com", "Board games", "Game"));
        items.add(new Item("Ludo king", "Multiplayer", "Game"));

        System.out.print("Enter a category you like: ");
        String pref = in.nextLine();
        System.out.println();
        System.out.println("Recommendations for : " + pref);
        boolean any = false;
        for(Item x : items) {
            if(x.category.equalsIgnoreCase(pref)) {
                System.out.println(x.type + " : " + x.name);
                any = true;
            }
        }
        if(!any) {
            System.out.println("No matching items found.");
        }
    }
}
