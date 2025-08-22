class MyArrayList<T> {
    T arr[];
    int size = 0;
    public MyArrayList() {
        arr = (T[])new Object[3];
    }

    void ensureCapacity() {//check capacity and increase array size
        if (arr.length == size) {
            Object[] temp= (T[]) new Object[arr.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = (T[])temp;
        }
    }

    void add(T val) {
        ensureCapacity();
        arr[size] = val;
        size++;
    }

    void addbyindex(int index, T val) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index =" + index);
        }
        ensureCapacity();
        for (int i = size; i >= index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = val;
        size++;
    }

    boolean addall(MyArrayList<T> a) {
        for (int i = 0; i < a.size; i++) {
            add(a.get(i));
        }
        return true;
    }

    boolean addAllbyindex(int index, MyArrayList<T> a) {
        for (int i = 0; i < a.size; i++) {
            addbyindex(index + i, a.get(i));
        }
        return true;
    }

    T get(int index) {
        if (index >= 0 && index < size) {
            return arr[index];
        }
        return null;
    }

    T set(int index, T val) {
        T oldval = arr[index];
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index11 =" + index);
        }
        arr[index] = val;
        return oldval;
    }

    int lastindexof(T val) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    void shiftLeft(int index) {
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size]=null;
        size--;
    }

    T removebyindex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index =" + index);
        }
        T oldval = arr[index];
        shiftLeft(index);
        return oldval;
    }

    boolean remove(T value) {
        if (!contains(value)) {
            return false;
        }
        int index = indexof(value);
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
         arr[size] = null;
        size--;
        return true;
    }

    void clear() {
        size = 0;
    }

    boolean equal(MyArrayList a) {
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(arr[i])) {
                return false;
            }
        }
        return true;
    }

    boolean contains(T val) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(val)) {
                return true;
            }
        }
        return false;
    }

    int indexof(T val) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    int size() {
        int c = 0;
        for (int i = 0;i<size; i++) {
          c++;
        }
        return c;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += arr[i];
            if (i < size - 1) {
                s += ",";
            }
        }
        s += "]";
        return s;
    }

}