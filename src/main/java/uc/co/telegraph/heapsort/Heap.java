package uc.co.telegraph.heapsort;

import java.util.*;

public class Heap extends ArrayList<Integer> {

    public Heap(Integer... values) {
        this.addAll(Arrays.asList(values));
    }

    public Integer getRoot(){
        return (this.size() == 0) ? null : this.get(0);
    }

    public Integer getRightChild(int i){
        int c = 2*(i + 1);
        return c > 0 && c < this.size() ? c : null;
    }

    public Integer getLeftChild(int i){
        int c = 2*i + 1;
        return c > 0 && c < this.size() ? c : null;
    }

    public Integer getParent(int i){
        return i <= 0 ? null : i/2;
    }

    public static Heap buildMaxHeap(Integer... values) {
        Heap heap = new Heap(values);
        int k = heap.size()/2;
        for (; k >= 0; k--) {
            maxHeapify(heap, k);
        }
        return heap;
    }

    public static void maxHeapify(Heap heap){
        maxHeapify(heap, 0);
    }

    public static void maxHeapify(Heap heap, int from) {
        if (heap.size() <= 1){
            return;
        }
        if (from < 0 || from >= heap.size()){
            throw new IllegalArgumentException("from: out of range " + from);
        }
        Integer leftChild = heap.getLeftChild(from);
        if (leftChild == null) {
            return;
        }
        Integer rightChild = heap.getRightChild(from);
        Integer fromValue = heap.get(from);
        Integer max;
        boolean leftMax = true;
        if (rightChild == null || heap.get(leftChild) > heap.get(rightChild)){
            max = heap.get(leftChild);
        } else {
            max = heap.get(rightChild);
            leftMax = false;
        }
        if (max <= fromValue){
            return;
        }
        heap.set(from, max);
        Integer swap = leftMax ? leftChild : rightChild;
        heap.set(swap, fromValue);
        maxHeapify(heap, swap);
    }

    public static List<Integer> heapSort(Integer... values) {
        if (values.length == 0){
            return new ArrayList<Integer>();
        }
        Heap heap = buildMaxHeap(values);
        LinkedList<Integer> queue = new LinkedList<Integer>();
        do{
            queue.addFirst(heap.get(0));
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            maxHeapify(heap);
        }while(heap.size() > 0);
        return queue;
    }

}
