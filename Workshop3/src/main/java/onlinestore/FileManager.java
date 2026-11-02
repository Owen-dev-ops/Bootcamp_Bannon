package onlinestore;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Game> readFile() {
        List<Game> inventory = new ArrayList<>();
        try {
            // inventory holds the list of games we read from the videogame_product_inventory psv file
            FileReader fileReader = new FileReader("src/main/resources/videogame_product_inventory.psv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String row;

            bufferedReader.readLine();
            while ((row = bufferedReader.readLine()) != null) {
                String[] brokenUpRow = row.split("\\|");
                String sku = brokenUpRow[0];
                String name = brokenUpRow[1];
                float price = Float.parseFloat(brokenUpRow[2]);

                Game game = new Game(sku, name, price);

                inventory.add(game);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ex) {
            System.out.println("Error opening file to read");
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Error handling file to read");
            ex.printStackTrace();
        }
        return inventory;
    }

    public static void writeToFile(Game game){
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/videogame_product_inventory.psv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String newLine = String.format("%s|%s|%.2f",
                    game.getSku(),
                    game.getName(),
                    game.getPrice());

            bufferedWriter.flush();
            bufferedWriter.newLine();
            bufferedWriter.write(newLine);
            System.out.println("New game added to inventory\n");

            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException ex){
            System.out.println("Error opening file to write to");
        }catch(Exception ex){
            System.out.println("Error handling file to write to");
        }
    }
}
