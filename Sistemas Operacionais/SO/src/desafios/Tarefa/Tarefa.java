package desafios.Tarefa;


public class Tarefa extends Thread {
	static int numeroThread = 1;
	String nome = "Thread " + numeroThread;
	public Tarefa() {
		numeroThread++;
    	System.out.println("Criando thread... " +nome);
	}
    @Override
    public void run() {
        System.out.println("Executando thread... " + nome);
    }
}
