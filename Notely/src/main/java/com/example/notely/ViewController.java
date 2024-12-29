package com.example.notely;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Label textLabel;
    @FXML
    Button viewButton;
    private String file = "";
    private NoteCard noteCard = new NoteCard();
    private ArrayList<NoteCard> currentStudySet = new ArrayList<>();
    @FXML public void SwitchToHomeScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void SwitchToViewScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ViewScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.show();
    }
    public void readFile(){ //Reads a txt file to fill arraylists with words to be guessed.
        String term = "";
        String definition = "";
        String currentLine;
        String title = "";
        String folder = "";
        int priority = 3;
        try
        {
            if(new File("./CommonCations.txt").exists()){ // ./  for MACOS and ../ for Windows
                file = "./CommonCations.txt";
            }
            else if (new File("../CommonCations.txt").exists()){
                file = "../CommonCations.txt";
            }
            else{
                return;
            }
            FileReader fr = new FileReader(file);
            BufferedReader brin = new BufferedReader(fr);
            int index = 0;
            while((currentLine = brin.readLine()) != null)
            {
                String line = currentLine;
                if(index == 0){
                    title = currentLine;
                    index++;
                }
                else if(index == 1){
                    folder = currentLine;
                    index++;
                }
                else if(index > 1) {
                    int tokenNumber = 0;
                    StringTokenizer tokens = new StringTokenizer(line, "@");
                    while (tokens.hasMoreTokens()) {
                        String token = tokens.nextToken();
                        term = token;
                        token = tokens.nextToken();
                        definition = token;
                        tokenNumber++;
                        noteCard = new NoteCard(term, definition, priority, tokenNumber);
                        currentStudySet.add(noteCard);
                    }
                }
            }
            brin.close();
            //System.out.println(currentStudySet.get(0).getTerm() + "|" + currentStudySet.get(0).getDefinition());
            //textLabel.setText(currentStudySet.get(0).getTerm());
        }
        catch(IOException io)
        {
            System.out.println(io.toString() + " could not open file.");
        }
    }

}
