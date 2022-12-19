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

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        printMenu();
        while (!quit) {
            System.out.println("\nVälj (9 för att visa val):");
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
                    practiceNumbersMenu();
                    break;
                case 3:
                    break;
                case 4:
                    updateNumbers();
                    break;
                case 5:
                    deleteNumbers();
                    break;

                case 6:
                    showAllNumbers();
                    break;
                case 9:
                    printMenu();
                    break;
            }
        }
    }

    private static void showAllNumbers() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query queryAddition = entityManager.createQuery("SELECT COUNT(b.additionId) FROM AdditionEntity b");
        Query querySubstraction = entityManager.createQuery("SELECT COUNT(b.subtractionId) FROM SubtractionEntity b");
        Query queryMultiplication = entityManager.createQuery("SELECT COUNT(b.multiplicationId) FROM MultiplicationEntity b");
        Query queryDivition = entityManager.createQuery("SELECT COUNT(b.divitionId) FROM DivitionEntity b");

        System.out.println("Antal additionstal: " + queryAddition.getSingleResult() + " st");
        System.out.println("Antal subtraktionstal: " + querySubstraction.getSingleResult() + " st");
        System.out.println("Antal multiplikationstal: " + queryMultiplication.getSingleResult() + " st");
        System.out.println("Antal divisionstal: " + queryDivition.getSingleResult() + " st");

    }


    private static void printMenu() {
        System.out.println("\nVälj:\n");
        System.out.println("0  - Stäng av\n" +
                "1  - Lägg till tal\n" +
                "2  - Öva på tal\n" +
                "3  - Prov \n" +
                "4  - Uppdatera ett tal\n" +
                "5  - Ta bort ett tal\n" +
                "6  - Antal tal i databasen \n" +
                "9  - Visa en lista över alla val");
    }

    private static void deleteNumbers() {
        System.out.println(
                "1 - Ta bort ett tal i addition\n" +
                        "2 - Ta bort ett tal i subtraktion\n" +
                        "3 - Ta bort ett tal i Multiplikation\n" +
                        "4 - Ta bort ett tal i division");

        int userChoose = scanner.nextInt();

        switch (userChoose) {
            case 1:
                deleteAddtitionNumber();
                break;
            case 2:
                deleteSubtractionNumber();
                break;
            case 3:
                deleteMultiplicationNumber();
                break;
            case 4:
                deleteDivisionNumber();
                break;
        }
    }

    private static void deleteAddtitionNumber() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT b FROM AdditionEntity b");
        List<AdditionEntity> list = query.getResultList();

        for (AdditionEntity b : list) {
            System.out.print(b.getAdditionId() + ". Fråga:" + b.getAdditionQuestion());
            System.out.println("\t Svar:" + b.getAdditionAnswer());
        }

        System.out.println("\nVilket ID vill du radera? ");
        int userInputID = scanner.nextInt();
        scanner.nextLine();
        AdditionEntity deleteAddition = entityManager.find(AdditionEntity.class, userInputID);
        entityManager.remove(deleteAddition);
        entityManager.getTransaction().commit();
        List<AdditionEntity> listUpdated = query.getResultList();
        for (AdditionEntity b : listUpdated) {
            System.out.print(b.getAdditionId() + ". Fråga:" + b.getAdditionQuestion());
            System.out.println("\t Svar:" + b.getAdditionAnswer());
        }
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("\nDu har raderat ett tal");
    }

    private static void deleteSubtractionNumber() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT b FROM SubtractionEntity b");
        List<SubtractionEntity> list = query.getResultList();

        for (SubtractionEntity b : list) {
            System.out.print(b.getSubtractionId() + ". Fråga:" + b.getSubtractionQuestion());
            System.out.println("\t Svar:" + b.getSubtractionAnswer());
        }

        System.out.println("\nVilket ID vill du radera? ");
        int userInputID = scanner.nextInt();
        scanner.nextLine();
        SubtractionEntity deleteSubtraction = entityManager.find(SubtractionEntity.class, userInputID);
        entityManager.remove(deleteSubtraction);
        entityManager.getTransaction().commit();
        List<SubtractionEntity> listUpdated = query.getResultList();
        for (SubtractionEntity b : listUpdated) {
            System.out.print(b.getSubtractionId() + ". Fråga:" + b.getSubtractionQuestion());
            System.out.println("\t Svar:" + b.getSubtractionAnswer());
        }
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("\nDu har raderat ett tal");
    }


    private static void deleteMultiplicationNumber() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT b FROM MultiplicationEntity b");
        List<MultiplicationEntity> list = query.getResultList();

        for (MultiplicationEntity b : list) {
            System.out.print(b.getMultiplicationId() + ". Fråga:" + b.getMultiplicationQuestion());
            System.out.println("\t Svar:" + b.getMultiplicationAnswer());
        }

        System.out.println("\nVilket ID vill du radera? ");
        int userInputID = scanner.nextInt();
        scanner.nextLine();
        MultiplicationEntity deleteMultiplication = entityManager.find(MultiplicationEntity.class, userInputID);
        entityManager.remove(deleteMultiplication);
        entityManager.getTransaction().commit();
        List<MultiplicationEntity> listUpdate = query.getResultList();
        for (MultiplicationEntity b : listUpdate) {
            System.out.print(b.getMultiplicationId() + ". Fråga:" + b.getMultiplicationQuestion());
            System.out.println("\t Svar:" + b.getMultiplicationAnswer());
        }
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("\nDu har raderat ett tal");
    }


    private static void deleteDivisionNumber() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT b FROM DivitionEntity b");
        List<DivitionEntity> deleteDivitionList = query.getResultList();

        for (DivitionEntity b : deleteDivitionList) {
            System.out.print(b.getDivitionId() + ". Fråga:" + b.getDivitionQuestion());
            System.out.println("\t Svar:" + b.getDivitionAnswer());
        }

        System.out.println("\nVilket ID vill du radera? ");
        int userInputID = scanner.nextInt();
        scanner.nextLine();
        DivitionEntity deleteDivition = entityManager.find(DivitionEntity.class, userInputID);
        entityManager.remove(deleteDivition);
        entityManager.getTransaction().commit();
        List<DivitionEntity> listUpdated = query.getResultList();
        for (DivitionEntity b : listUpdated) {
            System.out.print(b.getDivitionId() + ". Fråga:" + b.getDivitionQuestion());
            System.out.println("\t Svar:" + b.getDivitionAnswer());
        }
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("\nDu har raderat ett tal");
    }


    private static void practiceNumbersMenu() {
        System.out.println(
                "1 - Öva på addition\n" +
                        "2 - Öva på subtraktion\n" +
                        "3 - Öva på multiplikation\n" +
                        "4 - Öva på division");

        int userChoose = scanner.nextInt();

        switch (userChoose) {
            case 1:
                practiceAddtition();
                break;
            case 2:
                practiceSubtraction();
                break;
            case 3:
                practiceMultiplication();
                break;
            case 4:
                practiceDivision();
                break;
        }
    }

    private static void updateNumbers() {
        System.out.println(
                "1 - Uppdatera ett tal i addition\n" +
                        "2 - Uppdatera ett tal i subtraktion\n" +
                        "3 - Uppdatera ett tal i multiplikation\n" +
                        "4 - Uppdatera ett tal i division");

        int userChoose = scanner.nextInt();

        switch (userChoose) {
            case 1:
                updateAddtition();
                break;
            case 2:
                updateSubtraction();
                break;
            case 3:
                updateMultiplication();
                break;
            case 4:
                updateDivision();
                break;
        }
    }

    private static void updateAddtition() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AdditionEntity addition = entityManager.find(AdditionEntity.class, 1);
        Query query = entityManager.createQuery("SELECT b FROM AdditionEntity b");
        List<AdditionEntity> list = query.getResultList();

        for (AdditionEntity b : list) {
            System.out.print(b.getAdditionId() + ". Fråga:" + b.getAdditionQuestion());
            System.out.println("\t Svar:" + b.getAdditionAnswer());
        }

        System.out.println("Vilket ID vill du uppdatera? ");
        int userInputID = scanner.nextInt();
        scanner.nextLine();
        AdditionEntity updateAddition = entityManager.find(AdditionEntity.class, userInputID);
        System.out.println("Skriv in din fråga ");
        String userUpdateQuestion = scanner.nextLine();
        updateAddition.setAdditionQuestion(userUpdateQuestion);
        System.out.println("Skriv svaret ");
        int userUpdateAnswer = scanner.nextInt();
        scanner.nextLine();
        updateAddition.setAdditionAnswer(userUpdateAnswer);

        entityManager.persist(addition);
        entityManager.getTransaction().commit();
        List<AdditionEntity> listUpdated = query.getResultList();
        for (AdditionEntity b : listUpdated) {
            System.out.print(b.getAdditionId() + ". Fråga:" + b.getAdditionQuestion());
            System.out.println("\t Svar:" + b.getAdditionAnswer());
            entityManager.close();
            entityManagerFactory.close();


        }
        System.out.println("Du har uppdaterat ett tal");

    }

    private static void updateSubtraction() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        SubtractionEntity subtraction = entityManager.find(SubtractionEntity.class, 1);
        Query query = entityManager.createQuery("SELECT b FROM SubtractionEntity b");
        List<SubtractionEntity> list = query.getResultList();

        for (SubtractionEntity b : list) {
            System.out.print(b.getSubtractionId() + ". Fråga:" + b.getSubtractionQuestion());
            System.out.println("\t Svar:" + b.getSubtractionAnswer());
        }

        System.out.println("Vilket ID vill du uppdatera? ");
        int userInputID = scanner.nextInt();
        scanner.nextLine();
        SubtractionEntity updateSubtraction = entityManager.find(SubtractionEntity.class, userInputID);
        System.out.println("Skriv in din fråga ");
        String userUpdateQuestion = scanner.nextLine();
        updateSubtraction.setSubtractionQuestion(userUpdateQuestion);
        System.out.println("Skriv svaret ");
        int userUpdateAnswer = scanner.nextInt();
        scanner.nextLine();
        updateSubtraction.setSubtractionAnswer(userUpdateAnswer);

        entityManager.persist(subtraction);
        entityManager.getTransaction().commit();
        List<SubtractionEntity> listUpdated = query.getResultList();
        for (SubtractionEntity b : listUpdated) {
            System.out.print(b.getSubtractionId() + ". Fråga:" + b.getSubtractionQuestion());
            System.out.println("\t Svar:" + b.getSubtractionAnswer());
        }
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Du har uppdaterat ett tal");

    }

    private static void updateMultiplication() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        MultiplicationEntity multiplication = entityManager.find(MultiplicationEntity.class, 1);
        Query query = entityManager.createQuery("SELECT b FROM MultiplicationEntity b");
        List<MultiplicationEntity> list = query.getResultList();

        for (MultiplicationEntity b : list) {
            System.out.print(b.getMultiplicationId() + ". Fråga:" + b.getMultiplicationQuestion());
            System.out.println("\t Svar:" + b.getMultiplicationAnswer());
        }

        System.out.println("Vilket ID vill du uppdatera? ");
        int userInputID = scanner.nextInt();
        scanner.nextLine();
        MultiplicationEntity updateMultiplication = entityManager.find(MultiplicationEntity.class, userInputID);
        System.out.println("Skriv in din fråga ");
        String userUpdateQuestion = scanner.nextLine();
        updateMultiplication.setMultiplicationQuestion(userUpdateQuestion);
        System.out.println("Skriv svaret ");
        int userUpdateAnswer = scanner.nextInt();
        scanner.nextLine();
        updateMultiplication.setMultiplicationAnswer(userUpdateAnswer);

        entityManager.persist(multiplication);
        entityManager.getTransaction().commit();
        List<MultiplicationEntity> listUpdated = query.getResultList();
        for (MultiplicationEntity b : listUpdated) {
            System.out.print(b.getMultiplicationId() + ". Fråga:" + b.getMultiplicationQuestion());
            System.out.println("\t Svar:" + b.getMultiplicationAnswer());
        }
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Du har uppdaterat ett tal");
    }

    private static void updateDivision() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        DivitionEntity divition = entityManager.find(DivitionEntity.class, 1);
        Query query = entityManager.createQuery("SELECT b FROM DivitionEntity b");
        List<DivitionEntity> list = query.getResultList();

        for (DivitionEntity b : list) {
            System.out.print(b.getDivitionId() + ". Fråga:" + b.getDivitionQuestion());
            System.out.println("\t Svar:" + b.getDivitionAnswer());
        }
        System.out.println("Vilket ID vill du uppdatera? ");
        int userInputID = scanner.nextInt();
        scanner.nextLine();
        DivitionEntity updateDivition = entityManager.find(DivitionEntity.class, userInputID);
        System.out.println("Skriv in din fråga ");
        String userUpdateQuestion = scanner.nextLine();
        updateDivition.setDivitionQuestion(userUpdateQuestion);
        System.out.println("Skriv svaret ");
        int userUpdateAnswer = scanner.nextInt();
        scanner.nextLine();
        updateDivition.setDivitionAnswer(userUpdateAnswer);

        entityManager.persist(divition);
        entityManager.getTransaction().commit();
        List<DivitionEntity> updatedDvitionlist = query.getResultList();

        for (DivitionEntity b : updatedDvitionlist) {
            System.out.print(b.getDivitionId() + ". Fråga:" + b.getDivitionQuestion());
            System.out.println("\t Svar:" + b.getDivitionAnswer());
        }
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Du har uppdaterat ett tal");
    }

    private static void practiceAddtition() {
        boolean avsluta = true;
        while (avsluta) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT COUNT(b.additionId) FROM AdditionEntity b");
            System.out.println("Antal additionsrader: " + query.getSingleResult());
            double randomID = Math.floor(Math.random() * Double.parseDouble(query.getSingleResult().toString())) + 1;
            AdditionEntity addition = entityManager.find(AdditionEntity.class, randomID);
            System.out.println("vill du avsluta övningen skriv: 00");
            System.out.println("Uppgiften = " + addition.getAdditionQuestion());
            int userInput = scanner.nextInt();
            if (userInput == 00) {
                avsluta = false;
                break;
            }
            if (userInput == addition.getAdditionAnswer())
                System.out.println("Rätt");
            else
                System.out.println("Fel, rätt svar är: " + addition.getAdditionAnswer());
        }
    }

    private static void practiceSubtraction() {
        boolean avsluta = true;
        while (avsluta) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT COUNT(b.subtractionId) FROM SubtractionEntity b");
            System.out.println("Antal subtraktionsrader: " + query.getSingleResult());
            double randomID = Math.floor(Math.random() * Double.parseDouble(query.getSingleResult().toString())) + 1;
            SubtractionEntity subtraction = entityManager.find(SubtractionEntity.class, randomID);
            System.out.println("vill du avsluta övningen skriv: 00");
            System.out.println("Uppgiften = " + subtraction.getSubtractionQuestion());
            int userInput = scanner.nextInt();
            if (userInput == 00) {
                avsluta = false;
                break;
            }
            if (userInput == subtraction.getSubtractionAnswer())
                System.out.println("Rätt");
            else
                System.out.println("Fel, rätt svar är: " + subtraction.getSubtractionAnswer());
        }
    }

    private static void practiceMultiplication() {
        boolean avsluta = true;
        while (avsluta) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT COUNT(b.multiplicationId) FROM MultiplicationEntity b");
            System.out.println("Antal multiplikationsrader: " + query.getSingleResult());
            double randomID = Math.floor(Math.random() * Double.parseDouble(query.getSingleResult().toString())) + 1;
            MultiplicationEntity multiplication = entityManager.find(MultiplicationEntity.class, randomID);
            System.out.println("vill du avsluta övningen skriv: 00");
            System.out.println("Uppgiften = " + multiplication.getMultiplicationQuestion());
            int userInput = scanner.nextInt();
            if (userInput == 0) {
                avsluta = false;
                break;
            }
            if (userInput == multiplication.getMultiplicationAnswer())
                System.out.println("Rätt");
            else
                System.out.println("Fel, rätt svar är: " + multiplication.getMultiplicationAnswer());

        }
    }

    private static void practiceDivision() {
        Boolean avsluta = true;
        while (avsluta) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT COUNT(b.divitionId) FROM DivitionEntity b");
            System.out.println("Antal divisionsrader: " + query.getSingleResult());
            double randomID = Math.floor(Math.random() * Double.parseDouble(query.getSingleResult().toString())) + 1;
            DivitionEntity division = entityManager.find(DivitionEntity.class, randomID);
            System.out.println("vill du avsluta övningen skriv: 00");
            System.out.println("Uppgiften = " + division.getDivitionQuestion());
            int userInput = scanner.nextInt();
            if (userInput == 00) {
                avsluta = false;
                break;
            }
            if (userInput == division.getDivitionAnswer())
                System.out.println("Rätt");
            else
                System.out.println("Fel, rätt svar är: " + division.getDivitionAnswer());
        }
    }


    private static void addNumbers() {
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

    private static void addAddition() {
        System.out.println("Additionsuppgift ?");
        scanner.nextLine();
        String inputAnswer = scanner.nextLine();

        System.out.println("Svar ?: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer, inputQuestion, 1);
        scanner.nextLine();

    }

    private static void addSubtraction() {
        System.out.println("Subtraktionsuppgift ?");
        scanner.nextLine();
        String inputAnswer = scanner.nextLine();

        System.out.println("Svar ?: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer, inputQuestion, 2);
        scanner.nextLine();

    }

    private static void addMultiplication() {
        System.out.println("Multiplikationsuppgift ?");
        scanner.nextLine();
        String inputAnswer = scanner.nextLine();

        System.out.println("Svar ?: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer, inputQuestion, 3);
        scanner.nextLine();
    }

    private static void addDivision() {
        System.out.println("divitionsuppgift ?");
        scanner.nextLine();
        String inputAnswer = scanner.nextLine();

        System.out.println("Svar ?: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer, inputQuestion, 4);
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

        } else if (id == 4) {
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

    private static void deleteBook() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AdditionEntity addition = entityManager.find(AdditionEntity.class, 3);

        entityManager.remove(addition);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Du har tagit bort talet");
    }


    /*private static void newNumberInput(){
        System.out.println("");
        System.out.println("Skriv tals frågan: ");
        String inputAnswer = scanner.nextLine();
        System.out.println("Skriv in svaret: ");
        int inputQuestion = scanner.nextInt();
        newNumber(inputAnswer,inputQuestion,);
        scanner.nextLine();
    }*/

   /* private static void showBook(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BokEntity bok = entityManager.find( BokEntity.class, 1 );
        System.out.println("Bok ID = " + bok.getBokId( ));
        System.out.println("Bok Titel = " + bok.getBokTitel( ));
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
*/
}

