public class Main {
    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();
        threadExample.run(); // bu zaman biz burada start metodunun olmadigini goruruk. Bunu duzeltmek ucun
        //ThreadExample classini Threadden extends etmek lazimdir.

        RunnableExample runnableExample = new RunnableExample();
        runnableExample.run(); // eynen yuxaridaki thread ucun yazdigim hell yolu bu thread ucun de kecerlidir

    }
}