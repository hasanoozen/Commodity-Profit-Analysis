import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    // CONSTANTS: defined in the project description
    public static final int MONTHS = 12;
    public static final int DAYS = 28;
    public static final int COMMS = 5;

    public static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};

    // data structure decision:
    // I chose a 3D Array because our data has exactly 3 dimensions:
    // 1. Time (Months), 2. Time (Days), 3. Category (Commodities).
    // Structure: [Month Index][Day Index][Commodity Index]
    public static int[][][] allData = new int[MONTHS][DAYS][COMMS];

    public static void main(String[] args) {
        //load all text files into the memory (3D Array)
        loadData();

        // self-check: Printing a sample value to verify data loading works.
        // Expected result for Jan 1st Gold: 2312
        System.out.println("Data Loading Test - Result: " + allData[0][0][0]);
    }

    // method: loadData
    // Purpose: Reads 12 text files and populates the 'allData' array.
    public static void loadData() {
        // Loop through each month to find the corresponding file
        for (int m = 0; m < MONTHS; m++) {
            String filePath = "Data_Files/" + months[m] + ".txt";
            File file = new File(filePath);

            try {
                // robustness: Using try-catch because file operations might fail (e.g., file not found).
                Scanner scanner = new Scanner(file);

                // fix: The text files contain a header line ("Day,Commodity,Profit").
                // I must skip this line, otherwise Integer.parseInt() will throw an error.
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // Skipping the header
                }

                // reading process: Go through the file line by line
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    // Safety check: Skip empty lines to prevent errors
                    if (line.trim().isEmpty()) continue;

                    // parsing: Split the line by comma (CSV format)
                    // Example Line: "1, Gold, 2312"
                    String[] parts = line.split(",");

                    int day = Integer.parseInt(parts[0].trim());
                    String commodityName = parts[1].trim();
                    int profit = Integer.parseInt(parts[2].trim());

                    //Convert String commodity name (e.g., "Gold") to an Index (0)
                    int commodityIndex = -1;
                    for (int c = 0; c < COMMS; c++) {
                        if (commodities[c].equals(commodityName)) {
                            commodityIndex = c;
                            break;
                        }
                    }

                    // storage: Save the profit into the 3D array.
                    // Note: Using 'day - 1' because array indices start at 0, but days start at 1.
                    if (commodityIndex != -1) {
                        allData[m][day - 1][commodityIndex] = profit;
                    }
                }
                scanner.close(); // Closing the scanner to release resources
            } catch (FileNotFoundException e) {
                // if a file is missing, we ignore it to keep the program running.
            }
        }
    }

    // --- analytics methods (To be implemented) ---
    public static String mostProfitableCommodityInMonth(int month) {
        // Validation: Check if month is valid (0-11)
        if (month < 0 || month >= MONTHS) {
            return "INVALID_MONTH";
        }

        int maxProfit = Integer.MIN_VALUE; // Start with the smallest possible number
        String bestCommodity = "";

        // Loop through all 5 commodities
        for (int c = 0; c < COMMS; c++) {
            int totalProfitForCommodity = 0;

            // Sum profit across all 28 days for this specific commodity
            for (int d = 0; d < DAYS; d++) {
                totalProfitForCommodity += allData[month][d][c];
            }

            // Is this the best one so far?
            if (totalProfitForCommodity > maxProfit) {
                maxProfit = totalProfitForCommodity;
                bestCommodity = commodities[c];
            }
        }

        // Expected Format: "Gold 12500"
        return bestCommodity + " " + maxProfit;
    }
    public static int totalProfitOnDay(int month, int day) {
        // Validation: Month 0-11, Day 1-28
        if (month < 0 || month >= MONTHS || day < 1 || day > DAYS) {
            return -99999;
        }

        int total = 0;
        // Sum profits of all 5 commodities for that specific day
        // Note: day - 1 is used because array index starts at 0
        for (int c = 0; c < COMMS; c++) {
            total += allData[month][day - 1][c];
        }

        return total;
    }
    public static int commodityProfitInRange(String commodity, int fromDay, int toDay) { return 0; }
    public static int bestDayOfMonth(int month) {
        // validation
        if (month < 0 || month >= MONTHS) {
            return -1;
        }

        int maxProfit = Integer.MIN_VALUE;
        int bestDay = -1;

        // check each of the 28 days
        for (int d = 0; d < DAYS; d++) {
            int dailyTotal = 0;

            // Calculate total profit for day 'd' (Sum of all commodities)
            for (int c = 0; c < COMMS; c++) {
                dailyTotal += allData[month][d][c];
            }

            // Update best day if current day is better
            if (dailyTotal > maxProfit) {
                maxProfit = dailyTotal;
                bestDay = d + 1; // Convert index (0-27) to real day (1-28)
            }
        }
        return bestDay;
    }
    public static String bestMonthForCommodity(String commodity) { return "DUMMY"; }
    public static int consecutiveLossDays(String commodity) { return 0; }
    public static int daysAboveThreshold(String commodity, int threshold) { return 0; }
    public static int biggestDailySwing(int month) { return 0; }
    public static String compareTwoCommodities(String c1, String c2) { return "DUMMY"; }
    public static String bestWeekOfMonth(int month) { return "DUMMY"; }
}