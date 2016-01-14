package com.exercise.part1;

/**
 * Created by Dennis on 2016-01-13.
 */
public class Main {

    public static void main(String[] args)
    {
        String inputFilePath = getInputFilePath(args);
        try
        {
            new CircuitAssembler().assemblyCircuit(inputFilePath);
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }

    private static String getInputFilePath(String[] args)
    {
        if(args != null && args.length > 0)
        {
            System.out.print("Process will analyze following input file: " + args[0]);
            return args[0];
        }
        System.out.println("Process will analyze default input file");
        return null;
    }
}
