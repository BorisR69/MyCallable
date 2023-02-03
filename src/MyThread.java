import java.util.concurrent.Callable;

public class MyThread implements Callable <String>{
    @Override
    public String call() throws Exception {
            int count = 5;
            try {
                for (int i = 1; i <= count; i ++){
                    Thread.sleep(500);
                    System.out.println(i + " Я поток " + Thread.currentThread().getName() + ". Всем привет!" );
                }
            } catch (InterruptedException err) {
                System.out.println("Поток " + Thread.currentThread().getName() + " прерван");
            } finally{
                System.out.println("Поток " + Thread.currentThread().getName() + " завершен.");
            }
        return "Результат: Поток " + Thread.currentThread().getName() + " выводов в консоль: " + count;
    }
}
