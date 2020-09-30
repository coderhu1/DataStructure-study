package tree;

import java.util.ArrayList;

/**
 * @author coderhu1
 * @create 2020-09-08 10:58
 */
public class Test {

    public static void main(String[] args) {
        //ArrayList 维护了数组 transient Object[] elementData
        ArrayList<Object> objects = new ArrayList<>();
        /*
        底层依然进行了数组扩容
        private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//按1.5倍扩容
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
         */
    }
}
