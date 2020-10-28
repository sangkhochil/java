
public class InterThreadCommunication {
	void MultiThreadCommunication() {
		Chat chat = new Chat();
		new T1(chat);
		new T2(chat);
	}
}

class T1 implements Runnable{
	Chat chat;
	String[] s1 = { "Robin: Hi John!", "Robin: How are you ?", "Robin: Great!" };
	public T1(Chat chat){
		this.chat = chat;
		new Thread(this, "Question").start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < s1.length; i++) {
			chat.Question(s1[i]);
		}
	}	
}

class T2 implements Runnable{
	Chat chat;
	String[] s1 = { "John: Hi Robin!", "John: I am good, what about you?", "John: I am also doing fine!" };
	public T2(Chat chat){
		this.chat = chat;
		new Thread(this, "Answer").start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < s1.length; i++) {
			chat.Answer(s1[i]);
		}
	}	
}

class Chat {
	boolean flag = false;

	synchronized void Question(String mgs) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		flag = true;
		System.out.println(mgs);
		notify();
	}

	synchronized void Answer(String mgs) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		flag = false;
		System.out.println(mgs);
		notify();
	}
}
