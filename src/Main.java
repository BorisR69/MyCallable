import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Создание задач
        MyThread task1 = new MyThread();
        MyThread task2 = new MyThread();
        MyThread task3 = new MyThread();
        MyThread task4 = new MyThread();
        // Создание списка задач
        final List <MyThread> taskList = List.of(task1, task2, task3, task4);
        // Создание пула потоков
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        // Выполнение пула потоков с получением результата от самого быстрой задачи
        String result = threadPool.invokeAny(taskList);
        System.out.println(result);
        // Выполнение пула потоков с получением результата от всех запущенных задач
        List<Future <String>> results = threadPool.invokeAll(taskList);
        for (Future<String> resultOne: results ){System.out.println(resultOne.get());}
        // Закрытие пула потоков
        threadPool.shutdown();
    }
}