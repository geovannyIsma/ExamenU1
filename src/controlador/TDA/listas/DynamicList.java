package controlador.TDA.listas;

import controlador.TDA.listas.Exception.EmptyException;


public class DynamicList<E> {

    private Node<E> header;
    private Node<E> last;
    private Integer lenght;

    public DynamicList() {
        header = null;
        last = null;
        lenght = 0;
    }

    public Node<E> getHeader() {
        return header;
    }

    public void setHeader(Node<E> header) {
        this.header = header;
    }

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    public Integer getLenght() {
        return lenght;
    }

    public void setLenght(Integer lenght) {
        this.lenght = lenght;
    }
    
    public Boolean isEmpty() {
        return header == null || getLenght() == 0;
    }

    private void addFirst(E info) {
        Node<E> help;
        if (isEmpty()) {
            help = new Node<>(info);
            header = help;
            last = help;
            
        } else {
            Node<E> headHelp = header;
            help = new Node<>(info, headHelp);
            header = help;
            
        }
        lenght++;
    }

    private void addLast(E info) {
        Node<E> help;
        if (isEmpty()) {
            addFirst(info);
        } else {
            help = new Node<>(info, null);
            last.setNext(help);
            last = help;
            lenght++;
        }
    }

    public void add(E info) {
        addLast(info);
    }

    public void add(E info, Integer index) throws EmptyException, IndexOutOfBoundsException {
        if (index.intValue() == 0) {
            addFirst(info);
        } else if (index.intValue() == lenght.intValue()) {
            addLast(info);
        } else {
            Node<E> search_preview = getNode(index - 1);
            Node<E> search = getNode(index);
            Node<E> help = new Node<>(info, search);
            search_preview.setNext(help);
            setLenght((Integer) (getLenght()+1));
        }
    }

    private E getFirst() throws EmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyException("Error. Lista vacia");
        }
        return header.getInfo();
    }

    public E getInfo(Integer index) throws EmptyException {
        return getNode(index).getInfo();
    }

    private Node<E> getNode(Integer index) throws EmptyException{
        if (isEmpty()) {
            throw new EmptyException("Error. Lista vacia");
        } else if (index < 0 || index >= lenght) {
            throw new IndexOutOfBoundsException("Error. Fuera de rango");
        } else if (index == 0) {
            return header;
        } else if (index== (lenght - 1)) {
            return last;
        } else {
            Node<E> search = header;
            Integer cont = 0;
            while (cont < index) {
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }

    public E merge(E data, Integer index) throws EmptyException, IndexOutOfBoundsException {
        Node<E> search = getNode(index);
        E help = search.getInfo();
        search.setInfo(data);
        return help;
    }
    
     public E extractFirst() throws EmptyException{
        if(isEmpty()){
            throw new EmptyException("Lista vacia");
        }else{
            E element = header.getInfo();
            Node<E> help = header.getNext();
            header = null;
            header = help;
            if(lenght == 1)
                last = null;
            lenght--;
            return element;
        }
    }
    
    public E extractLast() throws EmptyException {
        if(isEmpty()){
            throw new EmptyException("Lista vacia");
        }
        else{
            E element = last.getInfo();
            Node<E> help = getNode(lenght-2);
            if(help == null){
                last =null;
                if(lenght == 2){
                    last = header;
                }
                else{
                    header = null;
                }
            }
            else{
               last = null;
               last = help;
               last.setNext(null);
            }
            lenght--;
            return element;
        }
    }
    
    public E extract(Integer index) throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Error. Lista vacia");
        } else if (index.intValue() < 0 || index.intValue() >= lenght) {
            throw new IndexOutOfBoundsException("Error. Fuera de rango");
        } else if (index == 0) {
            return extractFirst();
        } else if (index == (lenght - 1)) {
            return extractLast();
        } else {
            Node<E> node_preview = getNode(index - 1);
            Node<E> node_actually = getNode(index);
            E info = node_actually.getInfo();
            Node<E> help_next = node_actually.getNext();
            node_actually = null;
            node_preview.setNext(help_next);
            lenght--;
            return info;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista Data\n");
        try {
            Node<E> help = header;
            while (help != null) {
                sb.append(help.getInfo()).append("\n");
                help = help.getNext();
            }
        } catch (Exception e) {
            sb.append(e.getMessage());
        }
        return sb.toString();
    }
}
