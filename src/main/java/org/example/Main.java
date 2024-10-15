package org.example;

import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Exercise 1");
        exercise1();

        System.out.println("\n\nExercise 3");
        exersice3();

        System.out.println("\n\nExercise 4");
        exersice4();

        System.out.println("\nExersice 5");

        LinkedHashMap <String, Integer> mapSwap = new LinkedHashMap<>();
        mapSwap.put("Polina", 3);
        mapSwap.put("Dan", 2);
        mapSwap.put("Alex", 1);
        mapSwap.put("Topakova", 4);
        System.out.println(mapSwap);
        System.out.println(swap(mapSwap));

    }

    static void exercise1(){
        System.out.print("a) ");
        Integer[] array = new Integer[100];
        Random genetaror = new Random();

        for(int i=0; i<100; i++) {
            array[i] = genetaror.nextInt(101);
        }

        for(Integer element:array){
            System.out.print(element + ", ");
        }

        System.out.print("\nb) ");
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);

        System.out.print("c) ");
        Collections.sort(list);
        System.out.println(list);

        System.out.print("d) ");
        Collections.reverse(list);
        System.out.println(list);

        System.out.print("e) ");
        Collections.shuffle(list);
        System.out.println(list);

        System.out.print("f) ");
        Collections.rotate(list,1);
        System.out.println(list);

        System.out.print("g) ");
        Set<Integer> set = new LinkedHashSet<>(list);
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(set);
        System.out.println(list2);

        System.out.print("h) ");
        HashMap<Integer, Integer> map = new HashMap<>();
        list2.clear();
        for(Integer element: list){
            if(map.containsKey(element)){
                map.put(element,map.get(element)+1);
            } else{
                map.put(element, 1);
            }
        }

        for(Map.Entry<Integer,Integer> element: map.entrySet()){
            if(element.getValue()!=1){
                list2.add(element.getKey());
            }
        }
        System.out.println(list2);
        //System.out.println(map);

        System.out.print("i) ");
        Integer[] array2 = list.toArray(new Integer[0]);
        for(Integer element:array2){
            System.out.print(element + ", ");
        }

        System.out.print("\nj) ");
        for(Map.Entry<Integer,Integer> element: map.entrySet()){
            System.out.print("key: " + element.getKey() + " value: " + element.getValue() + ", ");
        }
    }

    static void exersice3(){
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Polina", "Topakova", 20));
        humans.add(new Human("Udunix", "UUUUUU", 15));
        humans.add(new Human("Karina", "Jlsflms", 34));
        humans.add(new Human("Dan", "Petfdjjd", 1));
        humans.add(new Human("Alex", "Mjsjjsd", 24));

        System.out.print("a) ");
        HashSet<Human> set2 = new HashSet<>(humans);
        for(Human element:set2){
            System.out.println("name: " + element.getName()+ " ,last name: " + element.getLastName()+ ",age: " + element.getAge()+"; ");
        }

        System.out.print("b) ");
        LinkedHashSet<Human> set3 = new LinkedHashSet<>(humans);
        for(Human element:set3){
            System.out.println("name: " + element.getName()+ " ,last name: " + element.getLastName()+ ",age: " + element.getAge()+"; ");
        }

        System.out.print("c) ");
        TreeSet<Human> set4 = new TreeSet<>(humans);
        for(Human element:set4){
            System.out.println("name: " + element.getName()+ " ,last name: " + element.getLastName()+ ",age: " + element.getAge()+"; ");
        }

        System.out.print("d) ");
        HumanComparatorByLastName comparator = new HumanComparatorByLastName();
        TreeSet<Human> set5 = new TreeSet<>(comparator);
        set5.addAll(humans);
        for(Human element:set5){
            System.out.println("name: " + element.getName()+ " ,last name: " + element.getLastName()+ ",age: " + element.getAge()+"; ");
        }

        System.out.print("e) ");
        TreeSet<Human> set6 = new TreeSet<>((h1, h2 ) -> Integer.compare(h1.getAge(), h2.getAge()));
        set6.addAll(humans);
        for(Human element:set6){
            System.out.println("name: " + element.getName()+ " ,last name: " + element.getLastName()+ ",age: " + element.getAge()+"; ");
        }
    }

    static void exersice4(){
        String str = "Polina return flag Polina return Java polina java Dan Alex dan alex";
        String[] arr = str.split(" ");
        List<String> list = Arrays.asList(arr);

        for(int i=0; i<list.size() ;i++){
            list.set(i, list.get(i).substring(0).toLowerCase());
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String element: list){
            if(map.containsKey(element)){
                map.put(element,map.get(element)+1);
            } else{
                map.put(element, 1);
            }
        }

        System.out.println(map);
    }

    static LinkedHashMap<Integer, String> swap(LinkedHashMap <String, Integer> mapSwap){
        LinkedHashMap<Integer, String> newSwap = new LinkedHashMap<>();
        for (Map.Entry<String,Integer> element: mapSwap.entrySet()){
            newSwap.put(element.getValue(), element.getKey());
        }
        return newSwap;
    }


}

class Human implements Comparable<Human>{
    private final String name;
    private final String lastName;
    private final int age;

    public Human(String name, String lastName, int age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getAge(){
        return this.age;
    }

    @Override
    public int compareTo(Human h) {
        return this.getLastName().compareTo(h.getLastName());
    }
}

class HumanComparatorByLastName implements Comparator<Human>{
    @Override

    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}


