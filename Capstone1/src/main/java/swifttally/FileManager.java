// Handles reading and writing to files

package swifttally;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Transaction> readFile() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            // inventory holds the list of games we read from the videogame_product_inventory psv file
            FileReader fileReader = new FileReader("src/main/resources/transactions.psv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String row;

            bufferedReader.readLine();
            while ((row = bufferedReader.readLine()) != null) {
                String[] brokenUpRow = row.split("\\|");
                LocalDate localDate = LocalDate.parse(brokenUpRow[0]);
                LocalTime localTime = LocalTime.parse(brokenUpRow[1]);
                String description = brokenUpRow[2];
                String vendor = brokenUpRow[3];
                double amount = Double.parseDouble(brokenUpRow[4]);

                Transaction transaction = new Transaction(localDate, localTime, description,
                        vendor, amount);

                transactions.add(transaction);
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
        return transactions;
    }

    public static void writeToFile(Transaction transaction){
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.psv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String newLine = String.format("%s|%s|%s|%s|%.2f",
                    transaction.getTransactionDate(),
                    transaction.getTransactionTime(),
                    transaction.getTransactionDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());

            bufferedWriter.flush();
            bufferedWriter.newLine();
            bufferedWriter.write(newLine);
            System.out.println("New transaction added to transaction.psv\n");

            bufferedWriter.close();
            fileWriter.close();
        }catch(IOException ex){
            System.out.println("Error opening file to write to");
            ex.printStackTrace();
        }catch(Exception ex){
            System.out.println("Error handling file to write to");
            ex.printStackTrace();
        }
    }
}



