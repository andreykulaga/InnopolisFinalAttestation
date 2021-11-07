public class Main {

    public static void main(String[] args) {
	Logger logger1 = Logger.getInstance();
    Logger logger2 = Logger.getInstance();

    logger1.log("First message");
    logger2.log("Second message");

    // так как объект класса Logger в единственном экземпляре, то logger1 вернет последнее собщение, которое добавил через logger2
    System.out.println(logger1.getMessage());
    }
}
