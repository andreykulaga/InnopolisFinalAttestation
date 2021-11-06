public class Logger {

    //статическое поле, хранящее единственный экземпляр класса
    private static final Logger instance;

    //статический инициализатор, который создает единственный объект класса
    static {
        instance = new Logger();
    }

    //приватный конструктор
    private Logger() {
    }

    //статический метод для получения единственного экземпляра объекта
    public static Logger getInstance() {
        return instance;
    }

    private String message;


    //метод для сохранения сообщения
    public void log(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
