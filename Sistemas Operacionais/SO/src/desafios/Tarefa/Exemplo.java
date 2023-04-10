package desafios.Tarefa;

public class Exemplo {

    public static void main(String[] args) throws InterruptedException {
        //cria duas tarefas
        Tarefa t1 = new Tarefa();
        Tarefa t2 = new Tarefa();
        Tarefa t3 = new Tarefa();
        Tarefa t4 = new Tarefa();
        t3.setPriority(1);
        t4.setPriority(10);

		t1.sleep(3000);
        //Executa as duas tarefas em paralelo
        t1.start();
        t2.start();
		t2.sleep(2000);

        System.out.println("As duas primeiras foram executadas juntas, e como a prioridade ta padrao,\neh usado o sistema FIFO, prioridades: ");
        System.out.println("Da thread 1: " + t1.getPriority());
        System.out.println("Da thread 2: " + t2.getPriority());
		t2.sleep(5000);
        System.out.println("Serao executadas as threads 3 e 4, mas a prioridade da 4 sera \nde 10 e a thread 3 tera prioridade 1 para ser observado \nqual thread foi executada primeiro.");
		t2.sleep(8000);
		
        System.out.println("Prioridades:");
        System.out.println("Thread 3: " + t3.getPriority());
        System.out.println("Thread 4: " + t4.getPriority());
        t3.start();
        t4.start();
        System.out.println("Note no codigo fonte que a thread 3 está na linha 30 \ne a thread 4 esta na linha 31, mas a thread 4 foi executada primeiro \npor causa da sua prioridade superior à da thread 3.");
    }
}
