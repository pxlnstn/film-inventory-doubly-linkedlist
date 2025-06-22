public class Node {
    private Movie movie;
    private Node previous;
    private Node next;

    public Node(Movie movie) {
        this.movie = movie;
        this.previous = null;
        this.next = null;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

