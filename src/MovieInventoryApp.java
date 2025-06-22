import java.util.Scanner;

public class
MovieInventoryApp {
    public static void main(String[] args) {
        DoublyLinkedList movieList = new DoublyLinkedList();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("1. Yeni film ekle");
            System.out.println("2. Film sil");
            System.out.println("3. Filmleri baştan yazdır");
            System.out.println("4. Filmleri sondan yazdır");
            System.out.println("5. 2000 yılından önceki filmleri yazdır");
            System.out.println("6. Çıkış");

            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter'ı tüketmek için

            switch (choice) {
                case 1:
                    System.out.print("Film yapım yılı: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Enter'ı tüketmek için

                    System.out.print("Film adı: ");
                    String title = scanner.nextLine();

                    System.out.print("Film türü: ");
                    String genre = scanner.nextLine();

                    System.out.print("Yönetmenin adı soyadı: ");
                    String director = scanner.nextLine();

                    Movie movie = new Movie(year, title, genre, director);

                    System.out.print("Oyuncu sayısı: ");
                    int actorCount = scanner.nextInt();
                    scanner.nextLine(); // Enter'ı tüketmek için

                    for (int i = 0; i < actorCount; i++) {
                        System.out.print("Oyuncu adı soyadı: ");
                        String actorName = scanner.nextLine();

                        System.out.print("Oyuncu cinsiyeti: ");
                        String gender = scanner.nextLine();

                        System.out.print("Oyuncunun vatandaşı olduğu ülke: ");
                        String nationality = scanner.nextLine();

                        Actor actor = new Actor(actorName, gender, nationality);
                        movie.addActor(actor);
                    }

                    movieList.addInOrder(movie);
                    break;
                case 2:
                    System.out.print("Silmek istediğiniz film adı: ");
                    String movieTitle = scanner.nextLine();
                    movieList.removeFromList(movieTitle);
                    break;
                case 3:
                    System.out.println("Filmler (Baştan):");
                    movieList.printListFromHead();
                    break;
                case 4:
                    System.out.println("Filmler (Sondan):");
                    movieList.printListFromTail();
                    break;
                case 5:
                    System.out.println("2000 yılından önceki filmler:");
                    movieList.printMoviesBeforeYear(2000);
                    break;
                case 6:
                    movieList.saveToFile("bilgiler.txt");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }

            System.out.println();
        }
    }
}
