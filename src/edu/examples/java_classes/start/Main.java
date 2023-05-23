package edu.examples.java_classes.start;

import java.util.List;

import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.input.ConsoleMenu;
import edu.examples.java_classes.logic.LogicException;

import edu.examples.java_classes.logic.impl.NotebookLogicImpl;
import edu.examples.java_classes.output.NotebookOutput;

public class Main {

	public static void main(String[] args) throws LogicException {
        ConsoleMenu menu = new ConsoleMenu();
        NotebookLogicImpl logic = new NotebookLogicImpl();
        List<Note> myNotes = logic.allNotes();
        NotebookOutput output = new NotebookOutput();
        output.print("all notes", myNotes);
		menu.execute();
		
		
		
	}

}
