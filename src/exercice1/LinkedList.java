import java.util.Optional;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    /**
     *Constructeur pour la classe LinkedList. Initialise la tête à null et la taille à 0.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**

    * Ajoute un élément à la fin de la liste chainée.
     * @param valeur La valeur à ajouter à la liste chainée.
     */
    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value);
        }
        size++;
    }

    /**
     * Récupère l'élément à un index donné dans la liste chainée.
     *
     * @param index L'index de l'élément à récupérer.
     * @return La valeur de l'élément à l'index donné, enveloppée dans un Optional.
     */
    public Optional<T> get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return Optional.of(current.value);
    }

    /**
     * Supprime l'élément à un index donné dans la liste chainée.
     *
     * @param index L'index de l'élément à supprimer.
     * @return La valeur de l'élément supprimé, emballée dans un Optional.
     */
    public Optional<T> remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (size - 1));
        }
        Optional<T> removedValue = Optional.empty();
        if (index == 0) {
            removedValue = Optional.of(head.value);
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedValue = Optional.of(current.next.value);
            current.next = current.next.next;
        }
        size--;
        return removedValue;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}
