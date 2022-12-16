import entity.AdditionEntity;
import entity.DivitionEntity;
import entity.MultiplicationEntity;
import entity.SubtractionEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class    Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("hej");
        System.out.println("tja");
        boolean quit = false;
        printMenu();
        while(!quit) {
            System.out.println("\nVälj (8 för att visa val):");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nStänger ner...");
                    quit = true;
                    break;

                case 1:
                    addNumbers();
                    break;
                case 2:
                    //showBookByAuthor();
                    break;
                case 3:
                    //countBooksQuery();
                    break;
                case 4:
                    //newBookInput();
                    break;
                case 5:
                    updateBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    showBooksQuery();
                    //showBooksNamedQuery();
                    break;
                case 8:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nVälj:\n");
        System.out.println("0  - Stäng av\n" +
                "1  - Lägg till tal\n" +
                "2  - Öva på tal\n" +
                "3  - Prov\n" +
                "4  - \n" +
                "5  - \n" +
                "6  - \n" +
                "7  - \n" +
                "8  - Visa en lista över alla val.");
    }
    private static void addNumbers(){
        System.out.println("\nVälj tal typ:\n");
        System.out.println(
                "1  - Addition\n" +
                "2  - Subtraktion\n" +
                "3  - Multiplikation\n" +
                "4  - Division");
        int userChoose = scanner.nextInt();

        switch (userChoose) {
            case 1:
                addAddition();
                break;
            case 2:
                addSubtraction();
                break;
            case 3:
                addMultiplication();
                break;
            case 4:
                addDivision();
                break;
        }
    }

    private static void addAddition(){
        System.out.println("Additionsuppgift ?");
        scanner.nextLine();
        String inputAnswer = scanner.nextLine();

        System.out.println("Svar ?: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer,inputQuestion,1);
        scanner.nextLine();

    }
    private static void addSubtraction(){
        System.out.println("Subtraktionsuppgift ?");
        scanner.nextLine();
        String inputAnswer = scanner.nextLine();

        System.out.println("Svar ?: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer,inputQuestion,2);
        scanner.nextLine();

    }
    private static void addMultiplication(){
        System.out.println("Multiplikationsuppgift ?");
        scanner.nextLine();
        String inputAnswer = scanner.nextLine();

        System.out.println("Svar ?: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer,inputQuestion,3);
        scanner.nextLine();
    }
    private static void addDivision(){
        System.out.println("divitionsuppgift ?");
        scanner.nextLine();
        String inputAnswer = scanner.nextLine();

        System.out.println("Svar ?: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer,inputQuestion,4);
        scanner.nextLine();
    }

    private static void newNumber(String question, int answer, int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if (id == 1) {
            AdditionEntity addition = new AdditionEntity();
            addition.setAdditionQuestion(question);
            addition.setAdditionAnswer(answer);
            entityManager.persist(addition);

        } else if (id == 2) {
            SubtractionEntity subtraction = new SubtractionEntity();
            subtraction.setSubtractionQuestion(question);
            subtraction.setSubtractionAnswer(answer);
            entityManager.persist(subtraction);

        } else if (id == 3) {

            MultiplicationEntity multiplication = new MultiplicationEntity();
            multiplication.setMultiplicationQuestion(question);
            multiplication.setMultiplicationAnswer(answer);
            entityManager.persist(multiplication);

        } else if (id ==4)
        {
            DivitionEntity divition = new DivitionEntity();
            divition.setDivitionQuestion(question);
            divition.setDivitionAnswer(answer);
            entityManager.persist(divition);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("Du har lagt till ett nytt tal");
    }

    /*private static void newNumberInput(){
        System.out.println("");
        System.out.println("Skriv tals frågan: ");
        String inputAnswer = scanner.nextLine();
        System.out.println("Skriv in svaret: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer,inputQuestion,);
        scanner.nextLine();
    }

   /* private static void showBook(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BokEntity bok = entityManager.find( BokEntity.class, 1 );
        System.out.println("Bok ID = " + bok.getBokId( ));
        System.out.println("Bok Titel = " + bok.getBokTitel( ));
    }

    private static void updateBook(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        BokEntity bok = entityManager.find( BokEntity.class, 1 );
        bok.setBokTitel("Vi på Saltkråkan");
        bok.setBokForfattare("Astrid Lindgren");
        entityManager.persist(bok);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Du har uppdaterat boken");

    }

    private static void deleteBook(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        BokEntity bok = entityManager.find( BokEntity.class, 3 );

        entityManager.remove( bok );
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Du har tagit bort boken");
    }

    private static void showBookByAuthor(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("bokForfattareQuery");

        query.setParameter("forfattare", "Astrid Lindgren");
        List<BokEntity> list = query.getResultList( );

        for( BokEntity b:list ){
            System.out.print("Bok ID :" + b.getBokTitel());
            System.out.println("\t Bok Titel :" + b.getBokForfattare());
        }
    }

    private static void showBooksNamedQuery(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("bokQuery");

        List<BokEntity> list = query.getResultList( );

        for( BokEntity b:list ){
            System.out.print("Bok ID :" + b.getBokTitel());
            System.out.println("\t Bok Titel :" + b.getBokForfattare());
        }
    }

    private static void showBooksQuery(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT b FROM BokEntity b");

        List<BokEntity> list = query.getResultList( );

        for( BokEntity b:list ){
            System.out.print("Bok ID :" + b.getBokTitel());
            System.out.println("\t Bok Titel :" + b.getBokForfattare());
        }
    }

    private static void countBooksQuery(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT COUNT(b.bokId) FROM BokEntity b");

        System.out.println(query.getSingleResult());
    }
*/
}

