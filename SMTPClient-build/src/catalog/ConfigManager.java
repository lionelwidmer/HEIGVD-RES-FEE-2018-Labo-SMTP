package catalog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    // Instance variables
    private String configpath;
    private List<Group> groups;
    private List<Prank> pranks;
    private String smtpServer;
    private int smtpPort;

    // Constructor
    public ConfigManager(String configpath) {
        // Initialize some variables
        String groupsfile = configpath + "/groups.csv";
        String pranksfile = configpath + "/pranks.csv";
        String configfile = configpath + "/config.csv";
        String cvsSplitBy = ";";
        BufferedReader br = null;
        String line = "";

        // Set some instance variables
        this.groups = new ArrayList<>();
        this.pranks = new ArrayList<>();
        this.configpath = configpath;

        // Load the groups from the CSV file
        try {
            br = new BufferedReader(new FileReader(groupsfile));
            while ((line = br.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                Group g = new Group(row[0]);
                for (int i = 1; i < row.length; i++) {
                    g.addPerson(new Person(row[i]));
                }
                groups.add(g);
            }

            // Get list of pranks
            br = new BufferedReader(new FileReader(pranksfile));
            while ((line = br.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                pranks.add(new Prank(row[0], row[1]));
            }

            // Get configuration
            br = new BufferedReader(new FileReader(configfile));
            while ((line = br.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                smtpServer = row[1];
                smtpPort = Integer.parseInt(row[2]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Methods
    public List<Group> getGroups() {
        return this.groups;
    }
    public List<Prank> getPranks() {
        return this.pranks;
    }
    public String getSmtpServer() {
        return this.smtpServer;
    }
    public int getSmtpPort() {
        return this.smtpPort;
    }
}
