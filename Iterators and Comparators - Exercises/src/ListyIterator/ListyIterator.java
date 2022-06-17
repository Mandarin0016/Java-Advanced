package ListyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data){
        this.data = data;
        if (data.isEmpty()){
            this.index = -1;
        }else {
            this.index = 0;
        }
    }
    public boolean move(){
        if (hasNext()){
            this.index++;
            return true;
        }else {
            return false;
        }
    }

    public boolean hasNext(){
        if (this.index >= 0 && this.index < this.data.size() - 1){
            return true;
        }
        return false;
    }

    public void print() throws Exception {
        if (this.data.isEmpty()){
            throw new Exception("Invalid Operation!");
        }else {
            System.out.println(this.data.get(this.index));
        }
    }
}
