/**
 * Created by usersbt on 12.07.2017.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


@Mojo( name = "hello")
public class SimpleMojoClass extends AbstractMojo{

    @Parameter(property = "hello.pathToSourceFolder", defaultValue = "This is default value")
    private String pathToSourceFolder;


    public void execute() throws MojoExecutionException {
        getLog().info(pathToSourceFolder);
        getFileNameFromFolder(pathToSourceFolder);
    }

    public void getFileNameFromFolder(String folderName) {
        File folder = new File(folderName);
        File[] listOfFiles = folder.listFiles();
        for(int i=0; i<listOfFiles.length; i++) {
           Parser.addingAnnotationsToFile(listOfFiles[i]);
        }
    }

}
