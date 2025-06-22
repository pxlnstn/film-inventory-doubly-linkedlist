import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToFront(Movie movie) {
        Node newNode = new Node(movie);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
    }

    public void addToEnd(Movie movie) {
        Node newNode = new Node(movie);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
    }

    public void addInOrder(Movie movie) {
        if (isEmpty()) {
            addToFront(movie);
        } else {
            Node newNode = new Node(movie);
            Node current = head;
            while (current != null) {
                if (movie.getYear() < current.getMovie().getYear()) {
                    if (current == head) {
                        addToFront(movie);
                        return;
                    } else {
                        newNode.setNext(current);
                        newNode.setPrevious(current.getPrevious());
                        current.getPrevious().setNext(newNode);
                        current.setPrevious(newNode);
                        return;
                    }
                } else if (movie.getYear() == current.getMovie().getYear()) {
                    if (movie.getTitle().compareTo(current.getMovie().getTitle()) < 0) {
                        if (current == head) {
                            addToFront(movie);
                            return;
                        } else {
                            newNode.setNext(current);
                            newNode.setPrevious(current.getPrevious());
                            current.getPrevious().setNext(newNode);
                            current.setPrevious(newNode);
                            return;
                        }
                    }
                }

                if (current.getNext() == null) {
                    addToEnd(movie);
                    return;
                }
                current = current.getNext();
            }
        }
    }

    public void removeFromList(String movieTitle) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.getMovie().getTitle().equalsIgnoreCase(movieTitle)) {
                Node previousNode = current.getPrevious();
                Node nextNode = current.getNext();

                if (previousNode != null) {
                    previousNode.setNext(nextNode);
                } else {
                    head = nextNode;
                }

                if (nextNode != null) {
                    nextNode.setPrevious(previousNode);
                } else {
                    tail = previousNode;
                }

                System.out.println("Movie '" + movieTitle + "' has been removed from the list.");
                return;
            }

            current = current.getNext();
        }

        System.out.println("Movie '" + movieTitle + "' is not found in the list.");
    }

    public void printListFromHead() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println(current.getMovie());
                current = current.getNext();
            }
        }
    }

    public void printListFromTail() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            Node current = tail;
            while (current != null) {
                System.out.println(current.getMovie());
                current = current.getPrevious();
            }
        }
    }

    public void printMoviesBeforeYear(int year) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            Node current = head;
            while (current != null) {
                if (current.getMovie().getYear() < year) {
                    System.out.println(current.getMovie());
                }
                current = current.getNext();
            }
        }
    }

    public void saveToFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (isEmpty()) {
                bufferedWriter.write("The list is empty.");
            } else {
                Node current = head;
                while (current != null) {
                    bufferedWriter.write(current.getMovie().toString());
                    bufferedWriter.newLine();
                    current = current.getNext();
                }
            }

            bufferedWriter.close();
            System.out.println("The list has been saved to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the list to file: " + e.getMessage());
        }
    }
}
