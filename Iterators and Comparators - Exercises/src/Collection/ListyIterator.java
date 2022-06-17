package Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        if (data.isEmpty()) {
            this.index = -1;
        } else {
            this.index = 0;
        }
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNext() {
        if (this.index >= 0 && this.index < this.data.size() - 1) {
            return true;
        }
        return false;
    }

    public void print() throws Exception {
        if (this.data.isEmpty()) {
            throw new Exception("Invalid Operation!");
        } else {
            System.out.println(this.data.get(this.index));
        }
    }
    public void printAll(){
     myListyIterator myIterator = new myListyIterator();
     while (myIterator.hasNext()){
         System.out.print(myIterator.next() + " ");
     }
        System.out.println();
    }
    @Override
    public Iterator<String> iterator() {
        return null;
    }

    private class myListyIterator implements Iterator<String> {
        int count = 0;

        @Override
        public boolean hasNext() {
            return count >= 0 && count < data.size();
        }

        @Override
        public String next() {
            return data.get(count++);
        }
    }
}
