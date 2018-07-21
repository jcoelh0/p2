
import java.util.*;

public class Link {

    public String bookName;
    public int millionsSold;

    public Link next;

    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display() {
        System.out.println(bookName + millionsSold);
    }

    public String toString() {
        return bookName;
    }
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        LinkList theLinkedList = new LinkList();
        theLinkedList.insertFirstLink("Don Quixote", 500);
        theLinkedList.insertFirstLink("Os Mais", 1000);
        theLinkedList.insertFirstLink("HarryPotter", 20);
        theLinkedList.insertFirstLink("O Bando dos Quatro", 700);
        theLinkedList.display();
    }
}

class LinkList {

    public Link firstLink;

    LinkList() {
        firstLink = null;
    }

    public boolean isEmpty() {
        return (firstLink == null);
    }

    public void insertFirstLink(String bookName, int millionsSold) {
        Link newLink = new Link(bookName, millionsSold);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public Link removeFIrst() {
        Link linkReference = firstLink;
        if (!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("Empty LinkedList");
        }
        return linkReference;
    }

    public void display() {
        Link theLink = firstLink;
        while (theLink != null) {
            theLink.display();
            System.out.println("Next Link :" + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public Link find(String bookName) {
        Link theLink = firstLink;
        if (!isEmpty()) {
            while (theLink.bookName != bookName) {
                if (theLink.next == null) {
                    return null;
                } else {
                    theLink = theLink.next;
                }

            }
        } else {
            System.out.println("Empty LinkedList");
        }
        return theLink;
    }

    public Link remoLink(String bookName) {
        Link currentLink = firstLink;
        Link previousLink = firstLink;
        while (currentLink.bookName != bookName) {
            if (currentLink.next == null) {
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if (currentLink == firstLink) {
            firstLink = firstLink.next;
        } else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }
}
