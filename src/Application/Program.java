package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Lesson;
import Entities.Task;
import Entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		System.out.println();
		for(int i=1; i<=n; i++) {
			System.out.println("Dados da " + i + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			sc.nextLine();
			char ch = sc.next().charAt(0);
			if(ch=='c') {
				System.out.print("Título: ");
				String title = sc.next();
				System.out.println("URL do vídeo: ");
				String url = sc.next();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				list.add(new Video(title, url, seconds));
			}
			else {
				System.out.print("Título: ");
				String title = sc.next();
				System.out.print("Descrição: ");
				String description = sc.next();
				System.out.println("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				list.add(new Task(title, description, questionCount));
			}
		}
		
		System.out.println();
		int sum = 0;
		for(Lesson lesson : list) {
			sum += lesson.duration();
		}
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + sum);
	}

}
