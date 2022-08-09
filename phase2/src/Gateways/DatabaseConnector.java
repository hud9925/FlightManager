package Gateways;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;

abstract public class DatabaseConnector {
    protected String filepath;

    /**
     * Connect to the database.
     * <p>
     * This constructor will search for the database file in the working directory first. If not found, it
     * will search the 'phase1/' subdirectory of the working directory for that file. If the file is not found in either
     * place, it will create this file in the working directory.
     *
     * @throws IOException when the file is not found in either place, and cannot be created.
     */
    public DatabaseConnector() throws IOException{
        String filename = getDatabaseName();
        String preferredPath = getAbsolutePath(filename);

        if (fileExists(preferredPath)) {
            this.filepath = preferredPath;
            return;
        }

        String altPath = getAbsolutePath("Databases/" + filename);
        if (fileExists(altPath)) {
            this.filepath = altPath;
            return;
        }

        this.filepath = preferredPath;
        File preferredFile = new File(preferredPath);
        if (!preferredFile.createNewFile()) {
            throw new IOException();
        }
    }

    /**
     * Get the name of this database.
     *
     * @return The database name.
     */
    abstract protected String getDatabaseName();

    /**
     * Get the absolute path from a relative path.
     *
     * @param relPath The relative path to the working directory.
     * @return The absolute path.
     */
    private String getAbsolutePath (String relPath) {
        return String.valueOf(Paths.get(relPath).toAbsolutePath());
    }

    /**
     * Check if the file of a given path exists.
     *
     * @param path The path of the file to check.
     * @return A boolean indicating whether the file exists.
     */
    private boolean fileExists (String path) {
        File file = new File(path);
        return file.isFile();
    }

    /**
     * Perform the save operation on this database.
     */
    abstract public void save() throws IOException;

    /**
     * Perform the load operation on this database.
     */
    abstract public void load() throws IOException, ParseException;

    /**
     * Check if this database is empty of not.
     *
     * @return A boolean indicating whether the database is empty.
     */
    public boolean checkEmpty() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(this.filepath));
        return file.readLine() == null;
    }
}
