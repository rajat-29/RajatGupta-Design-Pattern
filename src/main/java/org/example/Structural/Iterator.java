package org.example.Structural;

interface IteratorDemo{
    public boolean hasNext();
    public Object next();
}

interface Container{
    public IteratorDemo getIterator();
}

class NameCollection implements Container {
    public String name[] = {"Rajat", "Rishabh", "Arihant", "Rahul", "Ridhav"};

    @Override
    public IteratorDemo getIterator() {
        return new IterateNamesCollection();
    }

    private class IterateNamesCollection implements IteratorDemo {
        int x;

        @Override
        public boolean hasNext() {
            if(x < name.length) {
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return name[x++];
            }
            else {
                return null;
            }
        }
    }
}
public class Iterator {
    public static void main(String[] args) {
        NameCollection companyRepository = new NameCollection();

        for(IteratorDemo iterator = companyRepository.getIterator(); iterator.hasNext();){
            String name = (String)iterator.next();
            System.out.println("NAME IS : " +name);
        }
    }
}