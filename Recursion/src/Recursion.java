public class Recursion {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println("the sum form 6 to 1 = " + recursion.sum(6));
        System.out.println("The result of 6 factorial = " + recursion.factorial(6));
        System.out.println("THe power of Ten to the eight = "+ powerTen(8,10));
        System.out.println("7 to the power of 6 = " + powerOf(6, 7));
        System.out.println("Bunnies have how many ears? " + recursion.bunnyEars(2));
    }


    int sum(int n) {
        if (n >= 1) {
            return sum(n - 1) + n;
        }
        return n;
    }

    public int factorial(int n) {
        if (n != 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    static int powerTen(int n, int ten) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return 10 * powerTen(n - 1,10);
        }
        return 1 / powerTen(1-n,10);
    }

    static int powerOf(int n, int x) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return x * powerOf(n - 1, 7);
        }
        return 1 / powerOf(-n, x);
    }

    public int bunnyEars(int n) {
        if (n == 0) return 0;
        return n;
    }
}

//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//import static java.lang.Integer.parseInt;
//
//enum Priority {
//    URGENT,
//    HIGH,
//    NORMAL,
//    LOW
//}
//
//enum Status {
//    NOT_STARTED,
//    IN_PROGRESS,
//    WAITING,
//    DEFERRED
//}
//
//class Task implements Comparable<Task> {
//    int taskId;
//    String subject;
//    Priority priority;
//    Status status;
//    LocalDateTime startDate;
//    LocalDateTime dueDate;
//
//
//    public Task(int taskId, String subject, Priority priority, Status status, LocalDateTime startDate, LocalDateTime dueDate) {
//        this.taskId = taskId;
//        this.subject = subject;
//        this.priority = priority;
//        this.status = status;
//        this.startDate = startDate;
//        this.dueDate = dueDate;
//    }
//
//    public int getTaskId() {
//        return taskId;
//    }
//    public String toString() {
//        return "Id:" + taskId + "; Subject: " + subject + "; Status: " + status + "; Priority: " + priority + "; StartDate: " + startDate.toString() + "; Due date: " + dueDate;
//    }
//
//
//    public Priority getPriority() {
//        return priority;
//    }
//
//    @Override
//    public int compareTo(Task task) {
//        return this.getPriority().compareTo(task.getPriority());
//    }
//}
//
//public class ToDoList {
//
//
//    PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>();
//    Scanner scanner = new Scanner(System.in);
//
//
//    public static void main(String[] args) {
//        ToDoList app = new ToDoList();
//        app.testPriorityQueue();
//    }
//
//    public void displayNextTask() {
//        Task task = taskPriorityQueue.peek();
//        System.out.println(task);
//        System.out.println("Would you like this task as complete.");
//        String ans = scanner.nextLine();
//        if (ans.equals("y")) {
//            taskPriorityQueue.poll();
//        }
//
//    }
//
//    private Priority scanForPriority() {
//        System.out.println("Enter priority abbreviation Normal=n,Low=l,High=h,Urgent=u): ");
//
//        Scanner scanner = new Scanner(toString());
//        String abbrev = scanner.nextLine();
//        Priority priority = Priority.NORMAL;
//        switch (abbrev) {
//            case "n":
//                priority = Priority.NORMAL;
//                break;
//            case "l":
//                priority = Priority.LOW;
//                break;
//            case "h":
//                priority = Priority.HIGH;
//                break;
//            case "u":
//                priority = Priority.URGENT;
//                break;
//        }
//        return priority;
//    }
//
//    void addTask() {
//        System.out.println("Adding new Task...");
//        System.out.println("Enter subject:");
//        Scanner scanner = new Scanner(System.in);
//        String subject = scanner.nextLine();
//        System.out.println("Enter due date (yyyy-MM-dd):");
//        String input = scanner.nextLine();
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime dueDate = LocalDateTime.parse(input);
//        Priority priority = scanForPriority();
//        Status status = Status.NOT_STARTED;
//        LocalDateTime date = LocalDateTime.from(LocalDate.now());
//        LocalDateTime startDate = LocalDateTime.now();
//        Task task = new Task(taskPriorityQueue.size() + 1, subject, priority, status, startDate, dueDate);
//        taskPriorityQueue.add(task);
//    }
//
//    public void showTaskList() {
//        if (taskPriorityQueue.size() == 0) {
//            System.out.println("No items in list.");
//            return;
//        } else {
//            for (Task t : taskPriorityQueue) {
//                System.out.println(t);
//            }
//        }
//
//    }
//
//
//    public void testPriorityQueue() {
//        System.out.println("Welcome to My Task List\n");
//        System.out.println("Choose action (Add(a),Next(n),List(l),Detail(d),Edit(e),Remove(r),Quit(q): ");
//        String menuItem = scanner.nextLine();
//        do {
//            switch (menuItem) {
//                case "a":
//                    addTask();
//                    break;
//                case "n":
//                    displayNextTask();
//                    break;
//                case "l":
//                    showTaskList();
//                    break;
//                case "e":
//                    System.out.println("Enter taskId: ");
//                    int taskId = parseInt(scanner.nextLine());
//                    Task task = getTaskById(taskId);
//                    editTask(task);
//                    break;
//                case "d":
//                    System.out.println("Enter taskId: ");
//                    taskId = parseInt(scanner.nextLine());
//                    showTaskDetail(taskId);
//                    break;
//                case "r":
//                    System.out.println("Enter taskId: ");
//                    taskId = parseInt(scanner.nextLine());
//                    removeTask(taskId);
//                case "q":
//                    break;
//            }
//            System.out.println("Choose action (Add(a),Next(n),List(l),Detail(d),Edit(e),Remove(r),Quit(q): ");
//            menuItem = scanner.nextLine();
//            if (menuItem.equals("q"))
//                break;
//        }
//        while (menuItem != "q");
//        System.out.println("Goodbye");
//    }
//
//    //public void editTask(Task task) {}
//
//    public void showTaskDetail(int taskid) {
//        Task task = getTaskById(taskid);
//        System.out.println(task);
//    }
//
//    public void removeTask(int taskid) {
//        Task task = getTaskById(taskid);
//        taskPriorityQueue.remove(task);
//
//    }
//
//    public Task getTaskById(int taskId) {
//        for (Task task : taskPriorityQueue) {
//            if (task.getTaskId() == taskId)
//                return task;
//        }
//        System.out.println("Task id not found.");
//        return null;
//    }
//}