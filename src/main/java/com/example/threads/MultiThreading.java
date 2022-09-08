package com.example.threads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MultiThreading implements Runnable{

    List<Integer> integers;

    public Collection<Integer> getGetVialIntegers() {
        return getVialIntegers;
    }

    public Collection<Integer> getGetSelectionIntegers() {
        return getSelectionIntegers;
    }

    public Collection<Integer> getGetInsertIntegers() {
        return getInsertIntegers;
    }

    private final List<Integer> getVialIntegers = new ArrayList<>();
    private final List<Integer> getSelectionIntegers = new ArrayList<>();
    private final List<Integer> getInsertIntegers = new ArrayList<>();

    public MultiThreading(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        vialSort();
        insertSort();
        selectionSort();
    }

    private void vialSort(){
        Vial vial = new Vial(integers);
        vial.start();
        while (true){
            if (!vial.isAlive()){
                getVialIntegers.addAll(vial.getIntegers);
                break;
            }

        }
    }

    private void insertSort(){
        Selection selection = new Selection(integers);
        selection.start();
        while (true){
            if (!selection.isAlive()){
                getSelectionIntegers.addAll(selection.getIntegers);
                break;
            }

        }
    }

    private void selectionSort(){
        Insert insert = new Insert(integers);
        insert.start();
        while (true){
            if (!insert.isAlive()){
                getInsertIntegers.addAll(insert.getIntegers);
                break;
            }

        }
    }
}
class Insert extends Thread //вставка
{
    List<Integer> integers;
    List<Integer> getIntegers = new ArrayList<>();
    public Insert(List<Integer> integers) {
        this.integers = integers;
    }

    public void run()
    {
        System.out.println("Допустим тут сортировка №1");
        getIntegers.addAll(integers);
    }

    public List<Integer> getGetIntegers() {
        return getIntegers;
    }
}

class Vial extends Thread  //пузырек
{
    List<Integer> integers;
    List<Integer> getIntegers = new ArrayList<>();
    public Vial(List<Integer> integers) {
        this.integers = integers;
    }

    public void run()
    {
        System.out.println("Допустим тут сортировка №2");
        for (int i: integers
        ) {
            getIntegers.add(i);
        }
    }
    public List<Integer> getGetIntegers() {
        return getIntegers;
    }
}

class Selection extends Thread  //Выбор
{
    List<Integer> integers;
    List<Integer> getIntegers = new ArrayList<>();
    public Selection(List<Integer> integers) {
        this.integers = integers;
    }

    public void run()
    {
        System.out.println("Допустим тут сортировка №3");
        for (int i: integers
             ) {
            getIntegers.add(i);
        }
    }
    public List<Integer> getGetIntegers() {
        return getIntegers;
    }
}
