package endava;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by tvasile on 7/20/2016.
 */
public class PrimeNumbers extends Thread {

    int start, end;
    ArrayList<Integer> inputList, outputList;

    public PrimeNumbers(Integer start, Integer end, ArrayList<Integer> inputList, ArrayList<Integer> outputList) {
        this.start = start;
        this.end = end;
        this.inputList = inputList;
        this.outputList = outputList;
    }

    public static boolean isPrime(Integer number) {
        if(number <= 1) return false;
        for(int j = 2; j * j < number; j++) {
            if(number % j == 0)
                return false;
        }
        return true;
    }

    @Override
    public void run() {
        for(int i = start; i < end; i++) {
            Integer number = inputList.get(i);
            if(isPrime(number))
                outputList.add(number);
        }
    }

    public static void main(String[] args) {
        int numbers = 1000000;
        ArrayList<Integer> randomNumbersList = new ArrayList<>();
        ArrayList<Integer> primeNumbersList = new ArrayList<>();
        Random rand = new Random();
        PrimeNumbers []threads;
        int numberOfThreads = 1;
        int start, end, size;

        for(int i = 0; i < numbers; i++) {
            Integer random = rand.nextInt(10000);
            randomNumbersList.add(random);
        }

        //for(int i = 0; i < randomNumbersList.size(); i++)
          //  System.out.println(randomNumbersList.get(i));

        Long startTime = System.currentTimeMillis();
        threads = new PrimeNumbers[numberOfThreads];

        end = 0;
        size = numbers/numberOfThreads;
        for(int i = 0; i < numberOfThreads; i++) {
            start = end;
            end = (i+1) * size;
            threads[i] = new PrimeNumbers(start, end, randomNumbersList, primeNumbersList);
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        Long endTime = System.currentTimeMillis();

        System.out.println("Result Time: " + (endTime - startTime));
        //for(int i = 0; i < primeNumbersList.size(); i++)
        //    System.out.println(primeNumbersList.get(i));

    }

}
