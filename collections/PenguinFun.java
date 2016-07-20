package training.collections;

import java.util.*;

public class PenguinFun {

	public static void main(String [] args){

        List<Penguin> penguinList = new ArrayList<>();
        Set<Penguin> penguinSet = new HashSet<>();

        PenguinHatchery penguinHatchery = new PenguinHatchery();

        /*
        for(int i = 0; i < 10; i++) {
            penguinList.add(penguinHatchery.hatchPenguin());
        }

        penguinSet.addAll(penguinList);

        Collections.sort(penguinList);

        System.out.println("List:");
        penguinList.forEach(penguin -> System.out.println(penguin));

        System.out.println("Set:");
        penguinSet.forEach(penguin -> System.out.println(penguin));
        */

        List<Penguin> newPenguinList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            Penguin penguin = penguinHatchery.hatchPenguin();
            penguin.setMatingPartners(penguinHatchery.randomPenguinList());
            newPenguinList.add(penguin);
        }

        System.out.println("Before:");
        newPenguinList.forEach(penguin -> System.out.println(penguin));

        Comparator<Penguin> penguinComparator =  Comparator.comparing(Penguin::getNumberOfMates).
                                                                        thenComparing(Penguin::getMatesAverageAge).
                                                                            thenComparing(Penguin::getName);

        newPenguinList.sort(penguinComparator);

        System.out.println("After:");
        newPenguinList.forEach(penguin -> System.out.println(penguin));


        Map<PenguinRace, ArrayList<Penguin>> penguinMap = new HashMap<>();

        for(PenguinRace race: PenguinRace.values()) {
            penguinMap.putIfAbsent(race, new ArrayList<>());
        }

        newPenguinList.forEach(penguin -> penguinMap.get(penguin.getRace()).add(penguin));

        System.out.println("Map:");
        penguinMap.forEach((k, v) -> System.out.println("Key: " + k + " value: " + v));

        /* HashTable implementation */

        HashTable<String, Penguin> myHashTable = new HashTable<>(180000);

        for(int i = 0; i < 150000; i++) {
            Penguin p = penguinHatchery.hatchPenguin();
            p.setMatingPartners(penguinHatchery.randomPenguinList());
            myHashTable.put(p.getName(), p);
        }

        Penguin pingu = new Penguin("Pingu", PenguinRace.AFRICAN, 14.2);
        pingu.setMatingPartners(penguinHatchery.randomPenguinList());

        myHashTable.put(pingu.getName(), pingu);

        Long start = System.currentTimeMillis();

        System.out.println(myHashTable.get(pingu.getName()));

        Long finish = System.currentTimeMillis();

        System.out.println(finish - start);

    }
}	
