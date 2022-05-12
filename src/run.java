public class run {




    public static void main(String[] args) {
        user user = new user();
        user.start();


        book book1 = new book (1, 112233, "Horror book", 1998, "Horror" );
        book1.addItem(book1);

        book book2 = new book (1, 112233, "Horror book", 1998, "Horror" );
        book1.addItem(book2);


    }


}
